package com.example.alivecheckdemo.v1;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AliveSchedulerImplV1 implements AliveSchedulerV1 {

    AliveCheckerImplV1 aliveChecker;

    Callback callback;

    public AliveSchedulerImplV1(Callback callback) {
        this.callback = callback;
    }

    public AliveSchedulerImplV1() {
    }

    @Override
    public void run(List<HostInfo> hostList, int initialDelay, int delay, int nThreads, TimeUnit timeUnit) {

        Runnable task = () -> {
            for (HostInfo hostInfo : hostList) {
                aliveChecker.isAlive(hostInfo.getHostName());
                callback.get(hostInfo.getHostName());
            }
        };

        ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor(nThreads);
        se.scheduleWithFixedDelay(task, initialDelay, delay, timeUnit);
        callback.getAll(hostList);
    }

    @Override
    public void stop() {
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
