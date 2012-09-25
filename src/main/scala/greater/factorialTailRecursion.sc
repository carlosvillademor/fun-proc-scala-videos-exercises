object factorialTailRecursion {
  def factorial(number: Int): Int = {
    def loop(accumulator: Int, number: Int): Int = {
      if(number==0) accumulator
      else loop(accumulator*number, number-1)
    }
    loop(1, number)
  }                                               //> factorial: (number: Int)Int
  factorial(5)                                    //> res0: Int = 120
}