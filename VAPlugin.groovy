package com.demo.plugin

import com.android.build.gradle.internal.api.ApplicationVariantImpl
import org.gradle.api.Plugin
import org.gradle.api.Project

class VAPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.afterEvaluate {
            VATaskHookerManager taskHookerManager = new VATaskHookerManager(project)
            taskHookerManager.registerTaskHookers()
        }
    }


    static class VATaskHookerManager extends TaskHookerManager {

        VATaskHookerManager(Project project) {
            super(project)
        }

        @Override
        void registerTaskHookers() {
            android.applicationVariants.all { ApplicationVariantImpl appVariant ->
                registerTaskHooker(new MergeAssetsHooker(project, appVariant))
                registerTaskHooker(new DxTaskHooker(project, appVariant))
            }
        }
    }
}
