package workshop3.assignments

case class Postcard(msg: String)

object PostcardAssignment extends App {

	val cities = List(
		"San Francisco", "Los Angeles",
		"Las Vegas", "San Diego",
		"Dallas", "Houston",
		"Chicago", "New York City",
		"Philadelphia")
	val relatives = List("Grandma", "Grandpa", "Aunt Dottie", "Dad")
	val travellers = List("Alice", "Bob")

	def sendPostcardsImperative: List[Postcard] = {
		var postcardList: List[Postcard] = List()

		for (h <- 0 until travellers.length) {
			val traveller = travellers(h)
			val sender = s"$traveller (your favorite)"
			for (i <- 0 until relatives.length) {
				val relative = relatives(i)
				if (relative.startsWith("G")) {
					for (j <- 0 until cities.length) {
						val theCity = cities(j)
						postcardList ::= Postcard(s"Dear $relative, Wish you were here in $theCity! Love, $sender")
					}
				}
			}
		}

		postcardList
	}

	def sendPostcardsFunctional: List[Postcard] = ???

	def sendPostcardsForComprehension: List[Postcard] = ???

	// tests:
	println(
		"""
			|======================
			| Imperative postcards
			|======================
			|""".stripMargin)
	sendPostcardsImperative.foreach(println)

	println(
		"""
			|======================
			| Functional postcards
			|======================
			|""".stripMargin)
	sendPostcardsFunctional.foreach(println)

	println(
		"""
			|=============================
			| For Comprehension postcards
			|=============================
			|""".stripMargin)
	sendPostcardsForComprehension.foreach(println)

	println(
		"""
			|=============
			| Equivalence
			|=============
			|""".stripMargin)
	println(s"imperative and functional have the same set of postcards: ${sendPostcardsImperative.toSet == sendPostcardsFunctional.toSet}")
	println(s"imperative and for comprehension have the same set of postcards: ${sendPostcardsImperative.toSet == sendPostcardsForComprehension.toSet}")
}
