// !CHECK_TYPE
// !WITH_NEW_INFERENCE
// FILE: Outer.java

public class Outer<T> {
    public class Inner<E> {
        public <F extends E, G extends T> Inner(E x, java.util.List<F> y, G z) {}
    }
}

// FILE: main.kt
fun test(x: List<Int>, y: List<String>) {
    Outer<Int>().Inner("", y, 1) checkType { _<Outer<Int>.Inner<String>>() }
    Outer<Int>().Inner<CharSequence, String, Int>("", y, 1) checkType { <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!><!UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!DEBUG_INFO_UNRESOLVED_WITH_TARGET!>_<!><!><!><!><Outer<Int>.Inner<CharSequence>>() }

    Outer<Int>().Inner("", x, 1) checkType { <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!><!UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!DEBUG_INFO_UNRESOLVED_WITH_TARGET!>_<!><!><!><!><Outer<Int>.Inner<Any>>() }
    Outer<Int>().Inner<CharSequence, String, Int>("", x, 1)
}
