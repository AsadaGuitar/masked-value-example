package mask

import scala.quoted.*

object TypeName:
  inline def of[A]: String = ${impl[A]}

  def impl[A](using Type[A], Quotes): Expr[String] =
    Expr(Type.show[A].split("\\.").last)
