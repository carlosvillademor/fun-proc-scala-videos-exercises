package coursera.funprog.video.week4

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  def nth(position: Int, list: List[T]): Nothing = throw new NoSuchElementException("Nil.nth(position)")
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}