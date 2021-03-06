//
// Created by focus on 2017/8/14.
//
#include "com_yang_focus_keeplivedemo_MyNdk.h"
#include <android/log.h>
#include <jni.h>

#define  LOG_TAG    "native-dev"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

JNIEXPORT jstring JNICALL Java_com_yang_focus_keeplivedemo_MyNdk_getString
    (JNIEnv * env, jobject obj) {
    LOGI("Java_com_yang_focus_keeplivedemo_MyNdk_getString");
     return (*env).NewStringUTF("this is mylibrary");
    }


JNIEXPORT void JNICALL Java_com_yang_focus_keeplivedemo_MyNdk_displaySomething
  (JNIEnv * env, jobject obj) {
    LOGI("Java_com_yang_focus_keeplivedemo_MyNdk_displaySomething");
    jclass ClassCJM = (*env).FindClass("com/yang/focus/keeplivedemo/MyNdk");
    jmethodID MethodDisplayMessage = (*env).GetMethodID(ClassCJM, "displayMessage", "(Ljava/lang/String;)V");
    jstring value = (*env).NewStringUTF("Hello World!");
    (*env).CallVoidMethod(obj, MethodDisplayMessage, value);
  }