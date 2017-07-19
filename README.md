# Shopping-Cart-Repo
A simple Shopping Cart teller machine

Step 1: Shopping cart

You are building a checkout system for a shop which only sells apples and
oranges.

Apples cost 60p and oranges cost 25p.

Build a checkout system which takes a list of items scanned at the till and outputs
the total cost

For example: [ Apple, Apple, Orange, Apple ] => £2.05


Make reasonable assumptions about the inputs to your solution; for example, many
candidates take a list of strings as input


Step 2: Simple offers

The shop decides to introduce two new offers

buy one, get one free on Apples

3 for the price of 2 on Oranges

Update your checkout functions accordingly
------------------------------------------------------------------------------------------------------------------

The above is an excersice with a teller machine.
Imagine you have a super market with a teller machine.

You can easily add or remove everyday offers(that is you can easily add a new offer or remove existing ones very handy by just:
creating your own offer ==> following the following manifesto:

Your_Function_Offer(cart: List[String]): (Double, List[String])

Note your discount function can change the cart items if you wish! e.g: discount_Apples

Then you just add it in the checkout(List(Your_Function_Offer)) as in the example.
