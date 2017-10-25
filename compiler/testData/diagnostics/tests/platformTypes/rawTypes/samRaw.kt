// !DIAGNOSTICS: -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE
// FILE: A.java

import java.util.List;

public interface A<T> {
    boolean value(T t);
}

// FILE: B.java

class B {
    void foo(Runnable runnable, A x);

    static A bar() {}
}

// FILE: main.kt

fun main() {
    fun println() {}
    // All parameters in SAM adapter of `foo` have functional types
    B().foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!><!TYPE_MISMATCH!>{ println() }<!><!><!><!>, B.bar())
    // So you should use SAM constructors when you want to use mix lambdas and Java objects
    B().foo(Runnable { println() }, B.bar())
    B().foo({ println() }, { it: Any? -> it == null } )
}
