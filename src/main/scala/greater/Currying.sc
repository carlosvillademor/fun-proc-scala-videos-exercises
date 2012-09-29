object Currying {
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, default: Int) (a: Int, b: Int): Int =
    if(a>b) default
    else combine(f(a), mapReduce(f, combine, default) (a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, default: Int)(a: Int,
                                                  //|  b: Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1) (a,b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
    
  product(x => x) (1,6)                           //> res0: Int = 720
  
  def factorial(n: Int): Int = product(x=>x)(1,n) //> factorial: (n: Int)Int
  
  factorial(6)                                    //> res1: Int = 720
  
}