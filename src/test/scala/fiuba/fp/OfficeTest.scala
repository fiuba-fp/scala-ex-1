package fiuba.fp

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.EitherValues

class OfficeSpec extends AnyFlatSpec with Matchers with EitherValues {

    private val office = new Office

    private val michaelScott =  Person("Michael","Scott",55)

    "An office" should "have a Boss" in {
        val boss = office.getPerson("boss")

        boss.right.value shouldBe michaelScott
    }

    "An office" should "give the age of a know person" in {
        val age = office.age("boss")

        age.right.value shouldBe michaelScott.age
    }

    "An office" should "not give the age of an unknow person" in {
        val age = office.age("bozz")

        age shouldBe ('left)
        age.left.value shouldBe NoContent
    }

    "An office" should "give you a Toby if no one is cool" in {
        val toby = office.coolOrToby("accounting1")

        toby.name shouldBe "Toby" 
    }

    "An office" should "give you the oldest of two know coworkers" in {
        val oldest = office.oldestOf("boss","sales1")

        oldest.right.value shouldBe michaelScott
    }

    "An office" should "give you none the oldest of two unknow coworkers" in {
        val oldest = office.oldestOf("hr1","sales2")

        oldest shouldBe ('left)
        oldest.left.value shouldBe NoContent
    }

    "An office" should "give you the oldest of the only know coworkers" in {
        val oldest = office.oldestOf("sales3", "boss")

        oldest.right.value shouldBe michaelScott
    }

}