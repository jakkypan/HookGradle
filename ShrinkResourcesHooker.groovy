package com.demo.plugin

import com.android.build.gradle.api.ApkVariant
import com.android.build.gradle.internal.pipeline.TransformTask
import org.gradle.api.Project

class ShrinkResourcesHooker extends GradleTaskHooker<TransformTask> {
    
    ShrinkResourcesHooker(Project project, ApkVariant apkVariant) {
        super(project, apkVariant)
    }
    
    @Override
    String getTransformName() {
        return "shrinkRes"
    }
    
    @Override
    void beforeTaskExecute(TransformTask task) {

    }

    @Override
    void afterTaskExecute(TransformTask task) {

    }
}