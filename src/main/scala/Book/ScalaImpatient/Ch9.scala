package Book.ScalaImpatient

import java.io.PrintWriter

import scala.io.Source

import collection.mutable._
import java.io._

class Person(val name: String) extends Serializable {
    private val friends = new ArrayBuffer[Person]
    // some kind of DSL :-)
    def friend(f : Person) = friends += f
    override def toString = "%s {%s}".format(name, friends.map(_.name).mkString(", "))
}

object Person {
    def apply(name : String) = new Person(name)
}

object Ch9 extends App {
    // ex1
    val source = Source.fromFile("src/main/resources/ch9_01.txt", "UTF-8")
    assert("best" equals source.getLines.toArray.reverse(0))

    //ex2
    val sourceWithTab = Source.fromFile("src/main/resources/ch9_02.txt", "UTF-8")
    val out = new PrintWriter("src/main/resources/ch9_02.out")
    val pattern = "\t".r
    for (line <- sourceWithTab.getLines) {
        assert(line.contains("\t"))
        out.println(pattern.replaceAllIn(line, " "))
    }
    assert(!out.toString.contains("\t"))
    out.close()

    //ex3
    Source.fromFile("src/main/resources/ch9_03.txt").mkString.split("""[\s"\.,\)\()/]+""").filter(_.length > 12)
      .distinct.foreach(println(_))

    //ex4
    val numbers = Source.fromFile("src/main/resources/ch9_04.txt").mkString.split("""\s+""").map(_.toDouble)

    println("Sum: " + numbers.sum)
    println("Avg: " + numbers.sum / numbers.length)
    println("Min: " + numbers.min)
    println("Max: " + numbers.max)

    //ex5
    val ex5Out = new java.io.PrintWriter("src/main/resources/ch9_05.out")
    for(i <- 0 to 20) ex5Out.println("%8.0f    %f".format(math.pow(2.0, i), math.pow(2.0, -i)))
    ex5Out.close()

    //ex6
    val p = """"([^"\\]*([\\]+"[^"\\]*)*)"""".r
    val ex6inputSource = Source.fromFile("src/main/resources/ch9_06.txt", "UTF-8")
    for (line <- ex6inputSource.getLines) {
        p findFirstIn line match {
            case Some(s: String) => println(s)
            case None =>
        }
    }

    //ex7
    val tokens = Source.fromFile("src/main/resources/ch9_07.txt").mkString.split("\\s+").filter(
        "^[0-9]*(\\.[0-9]*)?$".r findFirstIn _ match {
            case Some(_) => false
            case None => true
        }
    )

    println("Tokens: " + tokens.mkString(", "))

    //ex8
    //val html = Source.fromURL("http://horstmann.com", "UTF-8").mkString
    //val srcPattern = """(?is)<\s*img[^>]*src\s*=\s*['"\s]*([^'"]+)['"\s]*[^>]*>""".r
    //for(srcPattern(s) <- srcPattern findAllIn html) println(s)

    //ex9
    import java.io.File
    import scala.util.matching.Regex

    def countMatchFiles(dir: File, pattern: Regex): Int = {
        val subdirs = dir.listFiles.filter(_.isDirectory)
        val fileNames = dir.listFiles.filter(!_.isDirectory).map(_.getName)

        subdirs.map(countMatchFiles(_, pattern)).sum +
          (for(f <- fileNames; s <- pattern findFirstIn f) yield s).size
    }

    println("Count of *.scala files: %d".format(countMatchFiles(new File("../"), "\\.scala$".r)))

    // more elegant solution
    def getFileTree(f: File): Stream[File] =
        f #:: (if (f.isDirectory) f.listFiles().toStream.flatMap(getFileTree) else Stream.empty)

    println("More elegant solution: %d".format(getFileTree(new File("../")).filter(_.getName.endsWith(".scala")).size))

    //ex10
    val anna = Person("Anna")
    val boris = Person("Boris")
    val clair = Person("Clair")

    anna friend boris
    boris friend anna
    anna friend clair
    clair friend boris

    val all = Array(anna, boris, clair)

    println("Original objects: " + all.mkString(", "))

    val outSerialized = new ObjectOutputStream(new FileOutputStream("src/main/resources/ch9_10.out"))
    outSerialized.writeObject(all)
    outSerialized.close()

    val inSerialized = new ObjectInputStream(new FileInputStream("src/main/resources/ch9_10.out"))
    val res = inSerialized.readObject().asInstanceOf[Array[Person]]
    inSerialized.close()

    println("Restored objects: " + res.mkString(", "))
}
