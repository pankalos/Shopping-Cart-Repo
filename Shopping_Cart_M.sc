

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


val myCart = List("Apple","Apple","Orange","Apple")

noOfferCost(myCart)

