package sum

import java.util.*
fun sum(a : IntArray) : Int {
    // Write your solution here
    <!UNRESOLVED_REFERENCE!>res<!> = 0
    for (e in a)
        res +=<!SYNTAX!><!>
}
fun main(args : Array<String>) {
    test(0)
    test(1, 1)
    test(-1, -1, 0)
    test(6, 1, 2, 3)
    test(6, 1, 1, 1, 1, 1, 1)
}
// HELPER FUNCTIONS
fun test(expectedSum : Int, vararg data : Int) {
    val actualSum = sum(data)
    assertEquals(actualSum, expectedSum, "\ndata = ${Arrays.toString(data)}\n" +
    "sum(data) = ${actualSum}, but must be $expectedSum ")
}
fun assertEquals<T: Any>(actual : T?, expected : T?, message : Any? = null) {
    if (actual != expected) {
        if (message == null)
            throw AssertionError()
        else
            throw AssertionError(message)
    }
}