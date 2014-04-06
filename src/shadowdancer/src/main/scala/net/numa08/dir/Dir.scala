package net.numa08.dir

import java.io.File

trait Dir {}

object Dir {
  def apply(dir: File): Dir = {
    dir match {
      case d if d.exists() && d.isDirectory => ValidDir(d)
      case _                                => InvalidDir(dir)
    }
  }
}

case class ValidDir(dir: File) extends Dir {
  override def toString = dir.getPath
}
case class InvalidDir(dir: File) extends Dir {
  override def toString = dir.getPath
}