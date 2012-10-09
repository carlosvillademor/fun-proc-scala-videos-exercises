object rationals {
  val x = new RationalNumber(1,2)                 //> x  : RationalNumber = 1/2
  x.numerator                                     //> res0: Int = 1
  x.denominator                                   //> res1: Int = 2
  x + new RationalNumber(1,2)                     //> res2: RationalNumber = 1/1
  -x                                              //> res3: RationalNumber = 1/-2
  new RationalNumber(4,3) - (new RationalNumber(2,3))
                                                  //> res4: RationalNumber = 2/3
                                                  
  val x1 = new RationalNumber(1,3)                //> x1  : RationalNumber = 1/3
  val x2 = new RationalNumber(5,7)                //> x2  : RationalNumber = 5/7
  val x3 = new RationalNumber(3,2)                //> x3  : RationalNumber = 3/2
  x1 - x2 - x3                                    //> res5: RationalNumber = -79/42
  x + x                                           //> res6: RationalNumber = 1/1
  x < x1                                          //> res7: Boolean = false
  x max x1                                        //> res8: RationalNumber = 1/2
  new RationalNumber(2)                           //> res9: RationalNumber = 2/1
  val y1 = new RationalNumber(2,4)                //> y1  : RationalNumber = 1/2
  val y2 = new RationalNumber(1,2)                //> y2  : RationalNumber = 1/2
  y1 + y2                                         //> res10: RationalNumber = 1/1
  
  val z1 = new RationalNumber(30,40)              //> z1  : RationalNumber = 3/4
  val z2 = new RationalNumber(50,30)              //> z2  : RationalNumber = 5/3
  z1 + z2                                         //> res11: RationalNumber = 29/12
 
}

class RationalNumber(x: Int, y: Int){
  require(y!=0, "denominator must be nonzero")

  def this(x: Int) = this(x,1)

  private def gdc(a: Int, b: Int): Int = if(b==0) a else gdc(b, a%b)

  def numerator = x
  def denominator = y

  def +(that: RationalNumber) =
    new RationalNumber(
      this.numerator * that.denominator + that.numerator * this.denominator,
      this.denominator * that.denominator)
  
  def unary_- = new RationalNumber(-numerator, denominator)
  
  def -(that: RationalNumber) = this + (-that)
  
  def <(that: RationalNumber): Boolean = this.numerator * that.denominator < that.numerator * this.denominator
  
  def max(that: RationalNumber): RationalNumber = if(this<that) that else this
  
  override def toString = {
      val g = gdc(numerator,denominator)
      this.numerator/g + "/" + this.denominator/g
  }
  
}