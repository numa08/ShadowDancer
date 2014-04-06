package net.numa08

import java.io.File

import util.FileWrapper._
import scala.io.Source
import com.twitter.util.Eval
import net.numa08.dsl.DancerText

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
    val retval = new File("DancerText")
      .asOpt
      .map { f =>
        val code = Source.fromFile(f).mkString("import net.numa08.dsl._\n", "", "")
        new Eval()[DancerText](code)
        0
      }.getOrElse {
        sys.error("DancerText is not exist")
        1
      }
    retval
  }
  /** Standard runnable class entrypoint */
  def main(args: Array[String]) {
    System.exit(run(args))
  }
}

case class Exit(val code: Int) extends xsbti.Exit
