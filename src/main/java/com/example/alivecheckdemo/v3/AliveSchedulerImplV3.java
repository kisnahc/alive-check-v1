package com.example.alivecheckdemo.v3;

import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AliveSchedulerImplV3 implements AliveSchedulerV3 {

    AliveCheckerImplV3 aliveChecker;

    AliveCallback callback;

    public AliveSchedulerImplV3(AliveCallback callback) {
        this.callback = callback;
    }

    @Override
    public void run(List<HostInfo> hostList, int initialDelay, int delay, int nThreads) {

        Runnable task = () -> {
            for (HostInfo hostInfo : hostList) {
                aliveChecker.isAlive(hostInfo.getHostName());
                callback.get(hostInfo.getHostName());
                System.out.println("모니터링 실행 중 = " + hostList);
            }
        };

        ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor(nThreads);
        se.scheduleWithFixedDelay(task, initialDelay, delay, TimeUnit.MILLISECONDS);
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
