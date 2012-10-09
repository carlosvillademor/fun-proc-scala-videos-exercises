object insets {
  val empty = new Empty                           //> empty  : Empty = .
  val nonemp = new NonEmpty(3, new Empty, new Empty)
                                                  //> nonemp  : NonEmpty = {.3.}
  val firstAddition = nonemp includes 4           //> firstAddition  : InSet = {.3{.4.}}
  val secondAddition = firstAddition includes 25  //> secondAddition  : InSet = {.3{.4{.25.}}}
  val thirdAddition = secondAddition includes 1   //> thirdAddition  : InSet = {{.1.}3{.4{.25.}}}
  val union1 = empty union thirdAddition          //> union1  : InSet = {{.1.}3{.4{.25.}}}
  val union2 = secondAddition union thirdAddition //> union2  : InSet = {{.1.}3{.4{.25.}}}
  val union3 = firstAddition union secondAddition //> union3  : InSet = {.3{.4{.25.}}}
  
  val newSet = new NonEmpty(50, new NonEmpty(40, new Empty, new Empty), new NonEmpty(60, new Empty, new Empty))
                                                  //> newSet  : NonEmpty = {{.40.}50{.60.}}
  val newSetDouble = new NonEmpty(100, new NonEmpty(80, new Empty, new Empty), new NonEmpty(120, new Empty, new Empty))
                                                  //> newSetDouble  : NonEmpty = {{.80.}100{.120.}}
                                                  
  val union4 = firstAddition union newSet         //> union4  : InSet = {{{{.3.}4.}40.}50{.60.}}
  val union5 = newSet union newSetDouble          //> union5  : InSet = {{{.40{{.50.}60.}}80.}100{.120.}}
}

abstract class InSet{
  def contains(x: Int): Boolean
  def includes(x: Int): InSet
  def union(other: InSet): InSet
}

class Empty extends InSet {
  def contains(x: Int): Boolean = false
  def includes(x: Int): InSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: InSet): InSet = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: InSet, right: InSet) extends InSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  
  def includes(x: Int): InSet =
    if (x < elem) new NonEmpty(elem, left includes x, right)
    else if (x > elem) new NonEmpty(elem, left, right includes x)
    else this
  
  def union(other: InSet): InSet = ((left union right) union other) includes elem
  
  override def toString = "{" + left + elem + right + "}"
}