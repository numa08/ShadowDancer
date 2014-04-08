package net.numa08.kagemai

import scala.xml.{ Text, Elem }

case class Report(id: Int, email: String, title: String, body: String)

object Report {

  def byXml(elem: Elem): Report = {
    val idValue = try {
      (elem \\ "report" headOption).map(_.attribute("id").map(_.text.toInt).getOrElse(-1))
    } catch {
      case e: Exception => Option(-1)
    }

    val values = List("email", "title", "body").map { id =>
      val value = (elem \\ "message" headOption).map(_ \ "element").map(_ filter (_ \ "@id" contains (Text(id)))).map(_.headOption.map(_.text).getOrElse("")).getOrElse("")
      (id, value)
    }.toMap

    (for {
      id <- idValue
      email <- values.get("email")
      title <- values.get("title")
      body <- values.get("body")
    } yield {
      Report(id, email, title, body)
    }).get
  }
}