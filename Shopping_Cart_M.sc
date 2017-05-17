
//Total cost of Items without any Offers
def noOfferCost(cart: List[String]): Double = {
  cart match{
    case Nil => 0.0
    case x :: xs => {
      if(x == "Apple")
        0.60 + noOfferCost(xs)
      else if(x == "Orange")
        0.25 + noOfferCost(xs)
      else
        throw new Exception(s"($x) is not valid item in the List!")
    }
  }
}


def discount_Apples(cart: List[String]): (Double, List[String]) = {

  var i = 0
  var count = 0

  while (i < cart.size) {

    if (cart(i) == "Apple")
      count = count + 1

    i = i + 1
  }

  if (count % 2 != 0){
    println("You are entitled one more Apple Free Of Charge!")
    ( ((count + 1) / 2) * 0.60 , cart :+ "Apple" )
  }
  else  //count % 2 == 0
    ( (count / 2) * 0.60 , cart )
}


def discount_Oranges(cart: List[String]): (Double, List[String]) = {

  var i = 0
  var count = 0

  while (i < cart.size) {
    if (cart(i) == "Orange")
      count = count + 1

    i = i + 1
  }

  if(count % 3 == 0)
    ( (count / 3) * 0.25 , cart )
  else if(count % 3 == 1)
    ( ((count - 1) / 3) * 0.25 , cart )
  else{                       //count % 3 == 2
    println("You are entitled with 1 more Orange Free of Charge!")
    ( ((count + 1) / 3) * 0.25 , cart :+ "Orange" )
  }

}


def checkOut(cart: List[String], discounts: List[ List[String] => (Double , List[String]) ]): (Double, List[String]) = {

  val (totalDiscount , updatedCart ) = allDiscounts(cart, 0.0, discounts )

  ( (noOfferCost(updatedCart) - totalDiscount) , updatedCart )

}



def allDiscounts(cart: List[String], totalDiscount: Double , discounts: List[ List[String] => (Double , List[String]) ] ): (Double, List[String] ) = {
  discounts match{
    case Nil => (totalDiscount , cart)
    case f :: fxs => {
      val (discount, newList) = f(cart)

      allDiscounts(newList, totalDiscount + discount, fxs )
    }
  }

}




val myCart = List("Apple","Apple","Orange","Orange","Apple")


val (totalAmount, cart) = checkOut(myCart, List(discount_Apples, discount_Oranges))

println(s"Your Updated Cart is: $cart")
println(s"Your total amount is: $totalAmount")

