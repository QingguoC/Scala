package demo

object demo {
  def add (x:Int, y:Int):Int = {
    x+y
  }
  def add (x:Int, y:Int, z:Int):Int = {
    x+y+z
  }
  object Math {
    def multiply(x:Int, y:Int) = x * y;
    def sumN(n:Int):Int = {
      var res = 0
      for(i <- 1 to n) {
        res += i
      }
      res
    }
  }
  def math(x:Double,y:Double,f:(Double,Double)=>Double):Double =  f(x,y)
  def math(x:Double,f:(Double)=>Double):Double =  f(x)
  def main(args: Array[String]){
    val name = "Qingguo"
    var age = 36
    //print string statements
    println("Hello Scala!")
    println(s"Hello $name, age $age Scala!")
    println(f"Hello $name%s, age $age%d Scala!")
    println(s"Hello \nScala!")
    println(raw"Hello \nScala!")

    if (age == 36){
      println("age == 36")
    } else {
      println("age != 36")
    }

    val res = if(age == 20) "age == 20" else "age !=20"
    println(res)

    while( age > 30) {
      println("age = " + age)
      age -= 1
    }

    do {
      println("age = " + age)
      age += 1
    } while (age < 36)

    for ( i <- 1 to 5){
      println(i + "i")
    }

    for ( i <- 1.to(5)){
      println(i + "i .to")
    }
    for ( i <- 1.until(5)){
      println(i + "i .until")
    }
    for ( i <- 1 until 5){
      println(i + "i until")
    }

    val li = List(2,9,1,8,5)
    for( i <-li; if i > 5){
      println(i + "filter")
    }

    val resli = for { i <- li; if i > 5} yield {
      i * i
    }
    println("resli: "+ resli)
    println("add: 2,3 " + add(2,3))
    println("mul: 2,3 " + Math.multiply(2,3))
    println("sum 1 to 100 " + (Math sumN 100))


    var divide = (x:Int, y:Int) => {
      x-y
    }
    println("divide: " + divide(3,1))
    println("anonymous math 1: " + math(3,4, (x,y)=>x+y))
    println("anonymous math 2: " + math(3, (x)=>x*2))
    println("short hand anonymous math 1: " + math(5, 6, _+_))

    val f = add(20,10,_:Int)
    println("partially applied function "+f(10))
    def add2 (x:Int) = (y:Int) => x+y
    println("currying function : " + add2(2)(3))
    def add3 (x:Int)(y:Int) = x+y
    println("currying function 2 : " + add3(2)(9))
    val add4 = add3(2)_
    println("currying function 3 : " + add4(9))
  }

}
