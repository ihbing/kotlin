// !CHECK_TYPE
// WITH_NEW_INFERENCE
val x get() = null
val <!IMPLICIT_NOTHING_PROPERTY_TYPE!>y<!> get() = null!!

fun foo() {
    <!DEBUG_INFO_CONSTANT!>x<!> checkType { _<Nothing?>() }
    y <!UNREACHABLE_CODE!>checkType { _<Nothing>() }<!>
}
