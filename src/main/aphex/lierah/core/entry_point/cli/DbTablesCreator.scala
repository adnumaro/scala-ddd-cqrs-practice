package aphex.lierah.core.entry_point.cli

import java.io.File
import java.sql.{Connection, DriverManager}

import scala.io.Source._
import scala.util.Try
import scala.util.matching.Regex

import com.typesafe.config.ConfigFactory

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig

// scalastyle:off
/**
  * View usage: runMain aphex.lierah.core.entry_point.cli.DbTablesCreator --usage
  * Execute: runMain aphex.lierah.core.entry_point.cli.DbTablesCreator
  */
object DbTablesCreator {
  private val databaseNameFromUrlRegex = new Regex("""\w+:\w+:\/\/\d+.\d+.\d+.\d+(?::\w+)?\/(\w+)""")

  def main(args: Array[String]): Unit = {
    val parser = new scopt.OptionParser[CommandConfig]("DbTablesCreator") {
      head("Build needed environment to run tests", "1.0")
      opt[String]('f', "tablesFolder")
        .action((tablesFolder, currentConfig) => currentConfig.copy(tablesFolder = tablesFolder))
        .text("Folder containing all the `.sql` files with the `CREATE TABLE` definitions.")

      opt[String]('c', "configFile")
        .action((configFile, currentConfig) => currentConfig.copy(configFile = configFile))
        .text("Configuration file to use while searching for the DB connection parameters.")

      opt[String]('k', "dbConfigKey")
        .action((dbConfigKey, currentConfig) => currentConfig.copy(dbConfigKey = dbConfigKey))
        .text("The configuration key inside the configuration file where we'll find the DB connection parameters.")
    }

    parser
      .parse(args, CommandConfig())
      .fold(println("[ERROR] Invalid parameters")) { commandConfig =>
        val dbConfig = DbConfig(ConfigFactory.load("application").getConfig("database"))
        val dbNameOption = for (grouped <- databaseNameFromUrlRegex findFirstMatchIn dbConfig.host)
          yield grouped group 1

        dbNameOption.fold(
          println(s"[ERROR] We couldn't extract the DB name from the DB URL configuration parameter: ${dbConfig.host}")
        ) { _ =>
          Try(Class.forName(dbConfig.driver)).toOption.fold(
            println(s"[ERROR] Invalid driver specified in the database config: ${dbConfig.driver}")
          ) { _ =>
            val connection = DriverManager.getConnection(dbConfig.host, dbConfig.user, dbConfig.password)

            createTables(commandConfig.tablesFolder, connection)

            connection.close()
          }
        }
      }
  }

  private def createTables(tablesFolder: String, connection: Connection): Unit = {
    val tablesFolderFile = new File(tablesFolder)
    val tablesFiles      = tablesFolderFile.listFiles()

    println(s"[INFO] Creating the following tables: ${tablesFiles.mkString(", ")}…")

    val createTablesQueries = tablesFiles.map(fromFile(_).getLines.mkString)

    val applySchemaStatement = connection.createStatement

    // Add specific query before for each create table query
    applySchemaStatement.executeUpdate(s"")
    createTablesQueries.foreach(applySchemaStatement.executeUpdate)
  }

  case class CommandConfig(
      tablesFolder: String = "database",
      configFile: String = "application",
      dbConfigKey: String = "database"
  )
}
// scalastyle:on
