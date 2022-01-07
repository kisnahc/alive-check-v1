package com.example.alivecheckdemo.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class AliveSchedulerImplTest {

    Caller callback = new Caller();
    AliveSchedulerImplV1 aliveScheduler = new AliveSchedulerImplV1(callback);

    List<HostInfo> hostList = new ArrayList<>();

    @BeforeEach
    public void init() {

        String hostName = "google.com";
        hostList.add(new HostInfo(hostName));
        for (int i = 0; i < 2000; i++) {
            hostList.add(new HostInfo(hostName + i));
        }
    }

    @Test
    public void alive_scheduler_run_test() {
        aliveScheduler.run(hostList, 1, 3, 5, TimeUnit.SECONDS);
    }

    @Test
    public void alive_scheduler_callback_get_test() {
        aliveScheduler.callback.get(hostList.get(0).getHostName());
    }

    @Test
    public void alive_scheduler_callback_getAll_test() {
        aliveScheduler.callback.getAll(hostList);
//        System.out.println(list);
    }

}