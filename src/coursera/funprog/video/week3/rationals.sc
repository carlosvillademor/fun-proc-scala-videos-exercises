object rationals {
  val x = new RationalNumber(1,2)                 //> x  : RationalNumber = 1/2
  x.numerator                                     //> res0: Int = 1
  x.denominator                                   //> res1: Int = 2
  x.add(new RationalNumber(1,2))                  //> res2: RationalNumber = 4/4
  x.neg                                           //> res3: RationalNumber = -1/2
  new RationalNumber(4,3).sub(new RationalNumber(2,3))
                                                  //> res4: RationalNumber = 6/9
                                                  
  val x1 = new RationalNumber(1,3)                //> x1  : RationalNumber = 1/3
  val x2 = new RationalNumber(5,7)                //> x2  : RationalNumber = 5/7
  val x3 = new RationalNumber(3,2)                //> x3  : RationalNumber = 3/2
  x1.sub(x2).sub(x3)                              //> res5: RationalNumber = -79/42
}

class RationalNumber(x: Int, y: Int){
  def numerator = x
  def denominator = y
  def add(that: RationalNumber) =
    new RationalNumber(
      this.numerator * that.denominator + that.numerator * this.denominator,
      this.denominator * that.denominator)
  
  def neg = new RationalNumber(-numerator, denominator)
  
  def sub(that: RationalNumber) = add(that.neg)
  
  override def toString = this.numerator + "/" + this.denominator
}