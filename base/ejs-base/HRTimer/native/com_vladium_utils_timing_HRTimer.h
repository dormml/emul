/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_vladium_utils_timing_HRTimer */

#ifndef _Included_com_vladium_utils_timing_HRTimer
#define _Included_com_vladium_utils_timing_HRTimer
#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     com_vladium_utils_timing_HRTimer
 * Method:    getTime
 * Signature: ()D
 */
JNIEXPORT jdouble JNICALL
Java_com_vladium_utils_timing_HRTimer_getTime (JNIEnv *, jclass);

JNIEXPORT jlong JNICALL
Java_com_vladium_utils_timing_HRTimer_getTimerFrequency (JNIEnv *, jclass);

JNIEXPORT jlong JNICALL
Java_com_vladium_utils_timing_HRTimer_getTimerReading(JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif