package com.demo.plugin

import com.android.build.gradle.api.ApkVariant
import com.android.build.gradle.internal.pipeline.TransformTask
import org.gradle.api.Project

class DxTaskHooker extends GradleTaskHooker<TransformTask> {


    public DxTaskHooker(Project project, ApkVariant apkVariant) {
        super(project, apkVariant)
    }

    @Override
    String getTransformName() {
        return "dex"
    }

    @Override
    void beforeTaskExecute(TransformTask task) {
        System.out.println(task.name + " / beforeTaskExecute===========")
    }

    @Override
    void afterTaskExecute(TransformTask task) {
        System.out.println(task.name + " / afterTaskExecute===========")
    }
}