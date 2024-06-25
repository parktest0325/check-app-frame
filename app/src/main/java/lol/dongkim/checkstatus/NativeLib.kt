package lol.dongkim.checkstatus

class NativeLib {
    companion object {
        init {
            System.loadLibrary("checkstatus")
        }
    }

    external fun checkStatus1(index: Int): Boolean
    external fun checkStatus2(index: Int): Boolean
    external fun checkStatus3(index: Int): Boolean
    external fun checkStatus4(index: Int): Boolean
    // 필요한 만큼 함수를 추가합니다.
}