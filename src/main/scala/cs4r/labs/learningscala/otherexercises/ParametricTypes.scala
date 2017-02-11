package cs4r.labs.learningscala.otherexercises

/**
  * Created by cs4r on 5/02/17.
  */
object ParametricTypes extends App {

  import scala.language.implicitConversions

  class TernaryThen(predicate: => Boolean) {
    def ?[A](thenClause: => A) = new TernaryEval(thenClause)

    class TernaryEval[A](thenClause: => A) {
      def |(elseClause: => A): A = if (predicate) thenClause else elseClause
    }
  }

  implicit def toTernaryThen(predicate: => Boolean): TernaryThen = new TernaryThen(predicate)

  print((3 < 1) ? "YES" | "NO")

  print((true != false) ? "YES" | "NO")

}



