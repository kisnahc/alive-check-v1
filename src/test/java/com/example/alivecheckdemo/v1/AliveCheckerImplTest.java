package com.example.alivecheckdemo.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class AliveCheckerImplTest {

    Caller callback = new Caller();

    AliveCheckerImplV1 aliveChecker = new AliveCheckerImplV1(callback);

    List<HostInfo> hostList = new ArrayList<>();

    @BeforeEach
    public void init() {
        String hostName = "google.com";
        hostList.add(new HostInfo(hostName));
        for (int i = 0; i < 5000; i++) {
            hostList.add(new HostInfo(hostName + i));
        }
    }

    @Test
    public void alive_checker_check_test() throws IOException {
        aliveChecker.check(hostList.get(0).getHostName());
    }

    @Test
    public void alive_checker_check_all_test() throws IOException {
        aliveChecker.check(hostList);
    }

    @Test
    public void alive_checker_callback_get_test() {
        aliveChecker.callback.get(hostList.get(0).getHostName());
    }

    @Test
    public void alive_checker_callback_getAll_test() {
        List<HostInfo> list = aliveChecker.callback.getAll(hostList);
//        System.out.println("=========== 리턴 된 리스트 =========== " + list);
    }

}