package demo

object parallelCollectionDemo {
  def main(args: Array[String]): Unit = {
    val a = (1 to 100).toArray
    val pa = a.par
    println(pa.map((x:Int)=>x>80))
    println(pa.filter((x:Int)=>x>80))

  }
}
