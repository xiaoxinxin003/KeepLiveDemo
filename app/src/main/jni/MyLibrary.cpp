//
// Created by focus on 2017/8/14.
//
#include "com_yang_focus_keeplivedemo_MyNdk.h"

JNIEXPORT jstring JNICALL Java_com_yang_focus_keeplivedemo_MyNdk_getString
    (JNIEnv * env, jobject obj) {
     return (*env).NewStringUTF("this is mylibrary");
    }


JNIEXPORT void JNICALL Java_com_yang_focus_keeplivedemo_MyNdk_displaySomething
  (JNIEnv * env, jobject obj) {
    jclass ClassCJM = (*env).FindClass("com/yang/focus/keeplivedemo/MyNdk");
    jmethodID MethodDisplayMessage = (*env).GetMethodID(ClassCJM, "displayMessage", "(Ljava/lang/String;)V");
    jstring value = (*env).NewStringUTF("Hello World!");
    (*env).CallVoidMethod(obj, MethodDisplayMessage, value);
  }