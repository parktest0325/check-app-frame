package lol.dongkim.checkstatus

data class CheckItem(
    val name: String,
    val checkFunction: (Int) -> Boolean,
    var status: CheckStatus? = null
)

enum class CheckStatus {
    PASS, FAIL
}