package lol.dongkim.checkstatus

interface TabInitializer {
    fun getItems(): List<CheckItem>
}

// TODO: Add Tab Initializer Here!! (bind native function)
class Tab1Initializer(private val nativeLib: NativeLib) : TabInitializer {
    override fun getItems(): List<CheckItem> {
        return listOf(
            CheckItem("Check 1", nativeLib::checkStatus1),
            CheckItem("Check 2", nativeLib::checkStatus2)
        )
    }
}

class Tab2Initializer(private val nativeLib: NativeLib) : TabInitializer {
    override fun getItems(): List<CheckItem> {
        return listOf(
            CheckItem("Check 3", nativeLib::checkStatus3),
            CheckItem("Check 4", nativeLib::checkStatus4)
        )
    }
}

class DefaultTabInitializer() : TabInitializer {
    override fun getItems(): List<CheckItem> {
        return listOf(
        )
    }
}