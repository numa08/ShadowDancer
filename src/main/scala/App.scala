package net.numa08

import java.io.File

import util.FileWrapper._
import scala.io.Source
import com.twitter.util.Eval
import net.numa08.dir.{ InvalidDir, ValidDir, Dir }
import net.numa08.dsl.{ Gitlab, BtsServices, DancerText }
import scala.xml.XML
import net.numa08.kagemai.Report
import net.numa08.gitlab.Issue
import java.net.URL

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
        val code = Source.fromFile(f).mkString("import net.numa08.dsl.convention._\nimport net.numa08.dsl.BtsServices._\nimport net.numa08.dsl.DancerText\n", "", "")

        new Eval()[DancerText](code)
      }.getOrElse {
        sys.error("DancerText is not exist")
        sys.exit(1)
      }

    dancerText
      .xmlPaths
      .map(_.dir)
      .map(Dir(_))
      .collect { case i: InvalidDir => i }
      .map(d => s"${d} is invalid xml directory path")
      .foreach(println(_))

    dancerText
      .xmlPaths
      .filter(services => Dir(services.dir).isInstanceOf[ValidDir])
      .foreach { paths =>
        paths.dir.listFiles.foreach { xmlFile =>
          val xml = XML.loadFile(xmlFile)
          val report = Report.byXml(xml)
          val task = paths.service match {
            case BtsServices.Gitlab => (Issue(report, new URL(paths.url)), new net.numa08.gitlab.Gitlab(dancerText.services.gitlab.entryPoint, paths.project, dancerText.services.gitlab.token))
          }

          task._2.createTask(task._1)
        }
      }

    0
  }
  /** Standard runnable class entrypoint */
  def main(args: Array[String]) {
    System.exit(run(args))
  }
}

case class Exit(val code: Int) extends xsbti.Exit
