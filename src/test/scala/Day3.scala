import Day3.findMaxN

class Day3Suite extends munit.FunSuite {
  test("it should capture the max number at the front of the bank") {
    val bank = "991111"
    assertEquals(findMaxN(bank, 2), 99L)
  }
  test("it should capture the max number at the end of the bank") {
    val bank = "111199"
    assertEquals(findMaxN(bank, 2), 99L)
  }
  test("it should capture the max number by leaving numbers inbetween") {
    val bank = "191191"
    assertEquals(findMaxN(bank, 2), 99L)
  }

  test("it should capture the max number with 9's at either end") {
    val bank = "9111119"
    assertEquals(findMaxN(bank, 2), 99L)
  }

  test("it should return early if the digits left match the length of the bank") {
        val bank = "999"
    assertEquals(findMaxN(bank, 3), 999L)
  }
}
