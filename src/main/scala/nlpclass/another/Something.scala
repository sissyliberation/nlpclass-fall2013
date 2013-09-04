package nlpclass.another

import dhg.util.FileUtil._

object Something {

  def main(args: Array[String]): Unit = {

    val filename =
      args.toSeq match {
        case Seq(filename) => filename
        case Seq() => sys.error("no filename specified")
        case _@ stuff => sys.error(f"too many things: $stuff")
      }

    println(f"reading $filename")

    val lines = File(filename).readLines.toVector
    lines.take(10).foreach(line => println(line))

  }

}
