package net.numa08

import java.io.File

import util.FileWrapper._
import scala.io.Source
import com.twitter.util.Eval
import net.numa08.dsl.DancerText
import net.numa08.dir.{ InvalidDir, ValidDir, Dir }

/** The launched conscript entry point */
class App extends xsbti.AppMain {
  def run(config: xsbti.AppConfiguration) = {
    Exit(App.run(config.arguments))
  }
}

object App {
  /**
   * Shared by the launched version and the runnable version,
   * returns the process status code
   */
  def run(args: Array[String]): Int = {
    val dancerText = new File("DancerText")
      .asOpt
      .map { f =>
        val code = Source.fromFile(f).mkString("")
        new Eval()[DancerText](code)
      }.getOrElse {
        sys.error("DancerText is not exist")
        sys.exit(1)
      }

    val paths = dancerText
      .xmlPats
      .map(_.dir)
      .map(Dir(_))

    paths.filter(_.isInstanceOf[InvalidDir])
      .foreach { d =>
        println(s"$d is invalid xml dir path")
      }

    paths.collect { case d: ValidDir => d }
    0
  }
  /** Standard runnable class entrypoint */
  def main(args: Array[String]) {
    System.exit(run(args))
  }
}

case class Exit(val code: Int) extends xsbti.Exit
