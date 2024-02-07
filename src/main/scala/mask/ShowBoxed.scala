package mask

import cats.Show

trait ShowBoxed[A]:
  def showBoxed(a: A): String

extension [A](a: A) def showBoxed(using bs: ShowBoxed[A]): String = bs.showBoxed(a)

inline given derivedShowBoxed[A](using show: Show[A]): ShowBoxed[A] = 
  new ShowBoxed[A] {
    def showBoxed(a: A): String =
      import TypeName.of
      s"${of[A]}(${show.show(a)})" 
  }

