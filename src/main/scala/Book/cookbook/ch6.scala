package Book.cookbook

object ch6 extends App {
  val books =
    <books>
      <book id="b1615">Don Quixote</book>
      <book id="b1867">War and Peace</book>
    </books>
  val titles = (books \ "book").map(book => book.text).toList
  println(titles)
}
