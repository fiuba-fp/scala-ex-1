package fiuba.fp

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OfficeSpec extends AnyFlatSpec with Matchers {

    private val office = new Office

    "An office" should "have a Boss" in {
        val boss = office.getPerson("boss")

        boss shouldBe defined
    }

    "An office" should "give the age of a know person" in {
        val age = office.age("boss")

        age shouldBe defined
    }

    "An office" should "not give the age of an unknow person" in {
        val age = office.age("bozz")

        age shouldBe None
    }

    "An office" should "give you a Toby if no one is cool" in {
        val toby = office.coolOrToby("accounting1")

        toby.name shouldBe "Toby" 
    }

    "An office" should "give you the oldest of two know coworkers" in {
        val oldest = office.oldestOf("boss","sales1")

        oldest should contain (Person("Michael","Scott",55))
    }

    "An office" should "give you none the oldest of two unknow coworkers" in {
        val oldest = office.oldestOf("hr1","sales2")

        oldest shouldBe None
    }

    "An office" should "give you the oldest of the only know coworkers" in {
        val oldest = office.oldestOf("sales3", "boss")

        oldest should contain (Person("Michael","Scott",55))
    }

}