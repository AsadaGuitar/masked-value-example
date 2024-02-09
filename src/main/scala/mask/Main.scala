package mask

import cats.Show
import cats.syntax.show.*
import mask.given
import mask.showBoxed
import types.*

@main def main(): Unit = 
  import `instances`.given

  println(Address.from("address").toOption.get.showBoxed) 
  // Address(***)
  println(ProductName.from("product_name").toOption.get.showBoxed)
  // ProductName(product_name)


object instances:
  inline given showString[A <: String]: Show[A] = new Show:
    def show(t: A): String = t 

  inline given showSecretValue[A <: SecretValue]: Show[A] = new Show:
    def show(t: A): String = "***"

    
object types:
  
  opaque type SecretValue <: String = String

  opaque type Address <: SecretValue = SecretValue

  object Address:
    def from(value: String): Either[Throwable, Address] = Right(value)
    
  opaque type ProductName <: String = String

  object ProductName:
    def from(value: String): Either[Throwable, ProductName] = Right(value)
