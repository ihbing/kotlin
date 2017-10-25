// !DIAGNOSTICS: -UNUSED_PARAMETER
// !CHECK_TYPE
// WITH_NEW_INFERENCE
// FILE: A.java

public class A<E> {
    public <T extends E> A(E x, java.util.List<T> y) {}
}

// FILE: main.kt

class B1(x: List<String>) : A<CharSequence>("", x)
class B2(x: List<Int>) : A<CharSequence>("", x)

class C : A<CharSequence> {
    constructor(x: List<String>) : super("", x)
    constructor(x: List<Int>, y: Int) : super("", x)
}
