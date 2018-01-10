package demo
class Info (
  var name:String="",
  var age:Int=3,
  private var score:Int=4
           )
object collectionDemos {
  def main(args: Array[String]): Unit = {
    val a = Array(3,5,7,9,11)
    println("a(2): " + a(2))
    a(2) = 50
    println("a(2): " + a(2) + " length: " + a.length)
    println("demo: " + demo.add(3,10))
    val a2d = Array.ofDim[Int](2,4)
    a2d(1)(3) = 3
    println("a2d : " + a2d(1)(3))
    var r = Range(1,102,10)
    var lr = for { i <- r} yield i
    println(lr)

    val cap = Map("us" -> "DC", "China" -> "Bj")
    println(cap.keys)
    println(cap.get("us"))
    val cap2 = cap - ("us")
    println(cap)
    println(cap2)
    r = Range(1,22,10)
    println(lr)
    var dc = new Info()
    println(dc.age)
  }

}
