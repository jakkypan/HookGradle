package com.demo.plugin

import com.android.build.gradle.api.ApkVariant
import com.android.build.gradle.tasks.MergeSourceSetFolders
import org.gradle.api.Project

class MergeAssetsHooker extends GradleTaskHooker<MergeSourceSetFolders> {

    public MergeAssetsHooker(Project project, ApkVariant apkVariant) {
        super(project, apkVariant)
    }

    @Override
    String getTaskName() {
        return scope.getTaskName('merge', 'Assets')
    }

    @Override
    void beforeTaskExecute(MergeSourceSetFolders task) {
//        Log.e '111', "beforeTaskExecute==========="
        System.out.println(task.name + " / beforeTaskExecute===========")
    }

    @Override
    void afterTaskExecute(MergeSourceSetFolders task) {
//        Log.e '111', "afterTaskExecute==========="
        System.out.println(task.name + " / afterTaskExecute===========")
    }
}