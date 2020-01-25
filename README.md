# Practice related to the CodelyTV course on DDD and CQRS with [Base Skeleton](https://github.com/CodelyTV/scala-basic-skeleton)
 
[![Software License][ico-license]][link-license]
[![Build Status][ico-travis]][link-travis] 

##### [Final CodelyTV course example](https://github.com/CodelyTV/scala-ddd-example) 

## Introduction

This is a repository intended to serve as a starting point if you want to bootstrap a project in Scala.
 
It could be useful if you want to start from scratch a kata or a little exercise or project. The idea is that you don't have to worry about the boilerplate, just clone this repo and there you go:
* Latest versions of Scala, SBT and ScalaTest.

## Preparation

1. You must have the [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html) installed
2. You must have the [SBT](https://www.scala-sbt.org/download.html) installed

## How To Start

1. Clone this repository `git clone https://github.com/adnumaro/scala-ddd-cqrs-practice.git`.
2. Install git hook with: `cd doc/hooks` and run `./install-hooks.sh`.
3. Run [SBT](http://www.scala-sbt.org/) on the project directory `sbt`.
4. Run the [scalatests](http://www.scalatest.org/) with `t`.
5. Check the [scalastyle](http://www.scalastyle.org/) in the production code with `s` and use the `ts` command to check the test code style.
6. Check the [scalaFmt](http://scalafmt.org) with `tf` command to check the code style and apply guidelines with `f`. 
7. Run git hook with `prep`.

## License

The MIT License (MIT). Please see [License File][link-license] for more information.

[ico-license]: https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square
[ico-travis]: https://img.shields.io/travis/CodelyTV/scala_bootstrap/master.svg?style=flat-square

[link-license]: LICENSE
[link-travis]: https://travis-ci.org/CodelyTV/scala_bootstrap
