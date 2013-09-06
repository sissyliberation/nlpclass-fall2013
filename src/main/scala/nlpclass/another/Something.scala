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
    val first10 = lines.take(10)
    first10.foreach(line => println(line))

    Vector(1, 2, 3)

    val m = Map("dog" -> 2)

    val x: Option[Int] =
      m.get("dog")
        .map(x => x + 1)
        .map(x => x + 3)

    def f(i: Int) = {
      if (i % 2 == 0)
        i + 3
      else
        None
    }

    
    val y = f(3)
    
    
    
    
  }

}
