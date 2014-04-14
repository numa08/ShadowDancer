package net.numa08.kagemai

import scala.xml.{ Text, Elem }

case class Report(id: Int, email: String, title: String, body: String, status: Report.Status.Status)

object Report {

  def byXml(elem: Elem): Report = {
    val idValue = try {
      (elem \\ "report" headOption).map(_.attribute("id").map(_.text.toInt).getOrElse(-1))
    } catch {
      case e: Exception => Option(-1)
    }

    val reportInitData = List("email", "title", "body").map { id =>
      val value = (elem \\ "message" headOption).map(_ \ "element").map(_ filter (_ \ "@id" contains (Text(id)))).map(_.headOption.map(_.text).getOrElse("")).getOrElse("")
      (id, value)
    }

    val reportLasData = List("status").map { id =>
      val value = (elem \\ "message" lastOption).map(_ \ "element").map(_ filter (_ \ "@id" contains (Text(id)))).map(_.lastOption.map(_.text).getOrElse("")).getOrElse("")
      (id, value)
    }

    val values = (reportInitData ++ reportLasData).toMap

    (for {
      id <- idValue
      email <- values.get("email")
      title <- values.get("title")
      body <- values.get("body")
      statusName <- values.get("status")
    } yield {
      Report(id, email, title, body, Status.withJAName(statusName))
    }).get
  }

  object Status extends Enumeration {
    type Status = Value
    val New, Accepted, Reservation, Fixed, Deferred, Resolved = Value

    private val jaNames = Map("新規" -> New, "受付済" -> Accepted, "保留" -> Reservation, "修正済" -> Fixed, "却下" -> Deferred, "完了" -> Resolved)

    def withJAName(name: String): Status = {
      val status = jaNames.get(name)
      status match {
        case None => throw new NoSuchElementException(s"${name} is not Status")
        case _    => status.get
      }
    }

    def active: ValueSet = {
      ValueSet(New, Accepted, Reservation)
    }

    def inactive: ValueSet = {
      ValueSet(Fixed, Deferred, Resolved)
    }
  }
}