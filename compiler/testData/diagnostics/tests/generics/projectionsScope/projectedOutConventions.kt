// !DIAGNOSTICS: -UNUSED_PARAMETER
// WITH_NEW_INFERENCE

class A<T> {
    operator fun plus(x: T): A<T> = this
    operator fun set(x: Int, y: T) {}
    operator fun get(x: T) = 1
}

fun test(a: A<out CharSequence>) {
    a <!MEMBER_PROJECTED_OUT(public final operator fun plus\(x: T\): A<T> defined in A; A<out CharSequence>)!>+<!> <!NI;TYPE_MISMATCH!>""<!>
    <!MEMBER_PROJECTED_OUT(public final operator fun set\(x: Int, y: T\): Unit defined in A; A<out CharSequence>)!>a[1]<!> = <!NI;TYPE_MISMATCH!>""<!>
    <!MEMBER_PROJECTED_OUT(public final operator fun get\(x: T\): Int defined in A; A<out CharSequence>)!>a[<!NI;TYPE_MISMATCH!>""<!>]<!>
}
