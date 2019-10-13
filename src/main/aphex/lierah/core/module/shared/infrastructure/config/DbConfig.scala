package aphex.lierah.core.module.shared.infrastructure.config

import com.typesafe.config.Config

object DbConfig {
  def apply(dbConfig: Config): DbConfig = DbConfig(
    driver = dbConfig.getString("driver"),
    host = dbConfig.getString("host"),
    user = dbConfig.getString("user"),
    password = dbConfig.getString("password")
  )
}

final case class DbConfig(driver: String, host: String, user: String, password: String)
