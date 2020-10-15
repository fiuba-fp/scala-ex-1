package fiuba.fp

case class Person(name: String, lastname: String, age: Int)

class Office{

  private val toby = Person("Toby","F.",50)
  
  private val officeDb: Map[String, Person] = Map("boss" -> Person("Michael","Scott",55), 
                                                  "reception" -> Person("Pam","Beasly",40), 
                                                  "sales1" -> Person("Jim","Halpert",42))

  def getPerson(id: String): Option[Person] = officeDb.get(id)

  def age(id: String): Option[Int] = ???
  
  def coolOrToby(id: String): Person = ???

  def oldestOf(id1: String, id2: String): Option[Person] = ???
  
}