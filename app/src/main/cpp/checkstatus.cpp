#include <jni.h>
#include <string>
#include <android/log.h>

#define LOG_TAG "CheckStatus"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" {

JNIEXPORT jboolean JNICALL
Java_lol_dongkim_checkstatus_NativeLib_checkStatus1(JNIEnv *env, jobject thiz, jint index) {
    // TODO: implement checkStatus1()
    return true;
}

JNIEXPORT jboolean JNICALL
Java_lol_dongkim_checkstatus_NativeLib_checkStatus2(JNIEnv *env, jobject thiz, jint index) {
    // TODO: implement checkStatus2()
    return false;
}

JNIEXPORT jboolean JNICALL
Java_lol_dongkim_checkstatus_NativeLib_checkStatus3(JNIEnv *env, jobject thiz, jint index) {
    // TODO: implement checkStatus3()
    return true;
}

JNIEXPORT jboolean JNICALL
Java_lol_dongkim_checkstatus_NativeLib_checkStatus4(JNIEnv *env, jobject thiz, jint index) {
    // TODO: implement checkStatus4()
    return false;
}

} // extern "C"