package util

import java.io.File

object FileWrapper {
  implicit class FileWrapper(val file: File) extends AnyVal {
    def asOpt: Option[File] = Option(file).filter(_.exists())
  }

}
