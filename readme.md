# HookGradle

描述了如何通过hook gradle来做些在编译期间的事情。参考自：[https://github.com/didi/VirtualAPK/tree/master/virtualapk-gradle-plugin/src/main/groovy/com.didi.virtualapk/aapt](https://github.com/didi/VirtualAPK/tree/master/virtualapk-gradle-plugin/src/main/groovy/com.didi.virtualapk/aapt)


另外补充gradle里面的源码：

## Reflect库

一个很好的反射库，并且还做了反射缓存。

[https://github.com/gradle/gradle/tree/master/subprojects/base-services/src/main/java/org/gradle/internal/reflect](https://github.com/gradle/gradle/tree/master/subprojects/base-services/src/main/java/org/gradle/internal/reflect)


## ApkVariant的架构关系

这里可以看得到ApkVariant的架构关系。

[https://android.googlesource.com/platform/tools/build/+/6d7fd0d2eff092abf1aaf44d03756b24570b390c/gradle/src/main/groovy/com/android/build/gradle/api/](https://android.googlesource.com/platform/tools/build/+/6d7fd0d2eff092abf1aaf44d03756b24570b390c/gradle/src/main/groovy/com/android/build/gradle/api/)
