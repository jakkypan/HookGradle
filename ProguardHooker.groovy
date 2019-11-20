package com.demo.plugin

import com.android.build.gradle.api.ApkVariant
import com.android.build.gradle.internal.pipeline.TransformTask
import org.gradle.api.Project

class ProguardHooker extends GradleTaskHooker<TransformTask> {

    ProguardHooker(Project project, ApkVariant apkVariant) {
        super(project, apkVariant)
    }

    @Override
    String getTransformName() {
        return "proguard"
    }

    @Override
    void beforeTaskExecute(TransformTask task) {

    }

    @Override
    void afterTaskExecute(TransformTask task) {

    }
}