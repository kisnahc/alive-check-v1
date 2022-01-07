package com.example.alivecheckdemo.v2;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AliveSchedulerImplV2 implements AliveSchedulerV2 {

    AliveCheckerImplV2 aliveChecker;

    private ExecutorService executorService;

    public AliveSchedulerImplV2() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public void run(List<HostInfo> hostList, int initialDelay, int delay, int nThreads, TimeUnit timeUnit) {

        Runnable task = () -> {
            for (HostInfo hostInfo : hostList) {
                aliveChecker.isAlive(hostInfo.getHostName());
            }
        };

        ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor(nThreads);

        se.scheduleWithFixedDelay(task, initialDelay, delay, timeUnit);

    }

    @Override
    public void stop() {
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
