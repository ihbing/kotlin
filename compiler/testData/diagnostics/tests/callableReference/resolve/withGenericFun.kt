// !DIAGNOSTICS: -UNUSED_PARAMETER
// WITH_NEW_INFERENCE

fun <T, R> apply(x: T, f: (T) -> R): R = f(x)

fun foo(i: Int) {}
fun foo(s: String) {}

val x1 = apply(1, ::foo)
val x2 = apply("hello", ::foo)
val <!NI;IMPLICIT_NOTHING_PROPERTY_TYPE!>x3<!> = <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>apply<!>(true, ::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!><!NONE_APPLICABLE!>foo<!><!>)