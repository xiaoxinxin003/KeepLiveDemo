//
// Created by focus on 2017/8/14.
//
#include "com_yang_focus_keeplivedemo_MyNdk.h"

JNIEXPORT jstring JNICALL Java_com_yang_focus_keeplivedemo_MyNdk_getString
    (JNIEnv * env, jobject obj) {
     return (*env).NewStringUTF("this is mylibrary");
    }
