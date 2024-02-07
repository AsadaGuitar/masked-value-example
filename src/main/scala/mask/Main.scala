package mask

import cats.Show
import cats.syntax.show.*
import mask.given
import mask.showBoxed

@main def main(): Unit = {
  println(Address.from("Address").toOption.get.showBoxed) 
  // Address(***)
}

opaque type SecretValue <: String = String

opaque type Address <: SecretValue = SecretValue

object Address:
  def from(value: String): Either[Throwable, Address] = Right(value)

inline given Show[SecretValue] = (_:SecretValue)=> "***"
