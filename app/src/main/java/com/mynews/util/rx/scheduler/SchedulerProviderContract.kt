package com.mynews.util.rx.scheduler

import io.reactivex.rxjava3.core.Scheduler

interface SchedulerProviderContract {
    fun ui(): Scheduler?
    fun computation(): Scheduler?
    fun io(): Scheduler?
}