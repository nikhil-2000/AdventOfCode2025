import day1.Day1


class Day1Suite extends munit.FunSuite {
    var day1 = new Day1();

    test("it doesn't count small turns which don't hit zero with left direction") {
        val lines = List("L1")
        assertEquals(day1.part2(lines, 2), 0)
    }
    test("it does count small turns which hit zero with left direction"){
        val lines = List("L3")
        assertEquals(day1.part2(lines, 2), 1)
    }
    test("it doesn't count small turns which don't hit zero with right direction"){
        val lines = List("R1")
        assertEquals(day1.part2(lines, 98), 0)
    }
    test("it does count small turns which hit zero with right direction"){
        val lines = List("R3")
        assertEquals(day1.part2(lines, 99), 1)
    }
    test("it does count repeated turns twice") {
        val lines = List("R200")
        assertEquals(day1.part2(lines, 50), 2)
    }
    test("it does count landing on 0") {
        val lines = List("R1")
        assertEquals(day1.part2(lines,99), 1)
    }

    test("it returns the correct count for multiple directions") {
        val lines = List("R2", "L2", "R2", "L2")
        assertEquals(day1.part2(lines,99), 4)
    }

    test("it returns the correct count for multiple directions where some land on zero") {
        val lines = List("R2", "L1", "R1", "L2")
        assertEquals(day1.part2(lines,99), 3)
    }

        test("it returns the correct count for multiple directions with big turns") {
        val lines = List("R102", "L102", "R102", "L102")
        assertEquals(day1.part2(lines,99), 8)
    }
}