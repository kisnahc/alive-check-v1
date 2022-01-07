package com.example.alivecheckdemo.v3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AliveSchedulerImplV3Test {
    AliveCaller callback = new AliveCaller();
    AliveSchedulerImplV3 aliveScheduler = new AliveSchedulerImplV3(callback);

    List<HostInfo> hostList = new ArrayList<>();

    @BeforeEach
    public void init() {

        String hostName = "google.com";
        hostList.add(new HostInfo(hostName));
        for (int i = 0; i < 10; i++) {
            hostList.add(new HostInfo(hostName + i));
        }
    }

    @Test
    public void alive_scheduler_run_test() {
        aliveScheduler.run(hostList, 1, 3000, 5000);
    }

    @Test
    public void alive_scheduler_callback_get_test() {
        aliveScheduler.callback.get(hostList.get(0).getHostName());
    }

    @Test
    public void alive_scheduler_callback_getAll_test() {
        aliveScheduler.callback.getAll(hostList);
    }

}