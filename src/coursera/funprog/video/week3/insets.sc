object insets {
  val emp = new Empty                             //> emp  : Empty = .
  val nonemp = new NonEmpty(3, new Empty, new Empty)
                                                  //> nonemp  : NonEmpty = {.3.}
  val firstAddition = nonemp includes 4           //> firstAddition  : InSet = {.3{.4.}}
  val secondAddition = firstAddition includes 25  //> secondAddition  : InSet = {.3{.4{.25.}}}
  val thirdAddtion = secondAddition includes 1    //> thirdAddtion  : InSet = {{.1.}3{.4{.25.}}}
}

abstract class InSet{
  def contains(x: Int): Boolean
  def includes(x: Int): InSet
}

class Empty extends InSet{
  def contains(x: Int): Boolean = false
  def includes(x: Int): InSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
}

class NonEmpty(elem: Int, left: InSet, right: InSet) extends InSet{
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  
  def includes(x: Int): InSet =
    if (x < elem) new NonEmpty(elem, left includes x, right)
    else if (x > elem) new NonEmpty(elem, left, right includes x)
    else this
  
  override def toString = "{" + left + elem + right + "}"
}