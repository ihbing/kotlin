// !CHECK_TYPE
// !DIAGNOSTICS: -UNUSED_PARAMETER
// WITH_NEW_INFERENCE
data class A(val x: Int, val y: String)
data class B(val u: Double, val w: Short)

fun <T> Iterable<T>.foo(x: (T) -> Unit) {}

fun bar(aList: List<A>) {
    aList.foo { (a, b) ->
        a checkType { _<Int>() }
        b checkType { _<String>() }
    }

    aList.foo { (a: Int, b: String) ->
        a checkType { _<Int>() }
        b checkType { _<String>() }
    }

    aList.foo { (a, b): A ->
        a checkType { _<Int>() }
        b checkType { _<String>() }
    }

    aList.foo { (<!NI;COMPONENT_FUNCTION_RETURN_TYPE_MISMATCH!><!COMPONENT_FUNCTION_RETURN_TYPE_MISMATCH!>a: String<!><!>, b) ->
        a checkType { _<Int>() }
        b checkType { _<String>() }
    }

    aList.<!TYPE_INFERENCE_CONFLICTING_SUBSTITUTIONS!>foo<!> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{ (a, b): B ->
        b checkType { <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!><!TYPE_MISMATCH!>_<!><!><!><Int>() }
        a checkType { <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!><!TYPE_MISMATCH!>_<!><!><!><String>() }
    }<!><!>
}
