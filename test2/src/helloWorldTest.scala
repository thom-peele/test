/**
  * Created by thom 
  * On 1-11-2016
  */
object helloWorldTest {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    println(1 + 1) // Int = 2
    println((1) .+ (1)) // Int = 2
    println(5 + 4 + 3) // Int = 17
    println(5 .+(4.*(3))) // Double = 17.0
    println((5) .+ ((4) .* (3))) // Int = 17

    println("abc".length) // Int = 3
    println("abc" + 4) // java.lang.String = abc4
    println(4 + "abc") // java.lang.String = 4abc
    println(4 + "1.0") // java.lang.String = 41.0
    println(5 < 6) // Boolean = true
    println(5 <= 8) // Boolean = true
    println(5 <= 2) // Boolean = false
    println(5 >= 2) // Boolean = true
    println(5 != 2) // Boolean = true

    val a = 4 // Klein if/else statement
    val b = 2
    if(a > b) {
      println("true")
    } else {
      println("false")
    }

    var i = 1 // basic while loop
    while(i <= 3) {
      println(i)
      i += 1
    }
  }
}
