package com.demo.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.pipeline.TransformTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState

public abstract class TaskHookerManager {

    protected Map<String, GradleTaskHooker> taskHookerMap = new HashMap<>()

    protected Project project
    protected AppExtension android

    public TaskHookerManager(Project project) {
        this.project = project
        android = project.extensions.findByType(AppExtension)
        project.gradle.addListener(new VirtualApkTaskListener())
    }

    public abstract void registerTaskHookers()

    protected void registerTaskHooker(GradleTaskHooker taskHooker) {
        taskHooker.setTaskHookerManager(this)
        taskHookerMap.put(taskHooker.taskName, taskHooker)
    }

    private class VirtualApkTaskListener implements TaskExecutionListener {

        @Override
        void beforeExecute(Task task) {
//            System.out.println(task.name + "=================")
//            Log.i 'TaskHookerManager', "beforeExecute ${task.name} tid: ${Thread.currentThread().id} t: ${Thread.currentThread().name}"
            if (task.project == project) {
                if (task in TransformTask) {
                    taskHookerMap["${task.transform.name}For${task.variantName.capitalize()}".toString()]?.beforeTaskExecute(task)
                } else {
                    taskHookerMap[task.name]?.beforeTaskExecute(task)
                }
            }
        }

        @Override
        void afterExecute(Task task, TaskState taskState) {
//            Log.i 'TaskHookerManager', "afterExecute ${task.name} tid: ${Thread.currentThread().id} t: ${Thread.currentThread().name}"
            if (task.project == project) {
                if (task in TransformTask) {
                    taskHookerMap["${task.transform.name}For${task.variantName.capitalize()}".toString()]?.afterTaskExecute(task)
                } else {
                    taskHookerMap[task.name]?.afterTaskExecute(task)
                }
            }
        }
    }

}