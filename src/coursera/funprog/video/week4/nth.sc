import coursera.funprog.video.week4._

object nth {
  def nth[T](index: Int, list: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (index == 0) list.head
    else nth(index -1, list.tail)
  }                                               //> nth: [T](index: Int, list: coursera.funprog.video.week4.List[T])T
  
  val list1 = new Cons(1, new Nil)                //> list1  : coursera.funprog.video.week4.Cons[Int] = coursera.funprog.video.wee
                                                  //| k4.Cons@7b2be1bd
  nth(3, list1)                                   //> java.lang.IndexOutOfBoundsException
                                                  //| 	at nth$$anonfun$main$1.nth$1(nth.scala:5)
                                                  //| 	at nth$$anonfun$main$1.apply$mcV$sp(nth.scala:11)
                                                  //| 	at scala.runtime.WorksheetSupport$$anonfun$$execute$1.apply$mcV$sp(Works
                                                  //| heetSupport.scala:75)
                                                  //| 	at scala.runtime.WorksheetSupport$.redirected(WorksheetSupport.scala:64)
                                                  //| 
                                                  //| 	at scala.runtime.WorksheetSupport$.$execute(WorksheetSupport.scala:74)
                                                  //| 	at nth$.main(nth.scala:3)
                                                  //| 	at nth.main(nth.scala)
}