package com.example.alivecheckdemo.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class AliveCheckerWithCompletionHandlerTest {


    AliveCheckerImplV2 aliveChecker = new AliveCheckerImplV2();
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
    public void alive_checker_check_list_test() throws IOException {
        aliveChecker.check(hostList);

    }

    @Test
    public void alive_checker_check_test() throws IOException {
        aliveChecker.check(hostList.get(0).getHostName());
    }

    @Test
    public void alive_checker_callback_get_test() {
        aliveChecker.callback.completed(hostList.get(0).getStatus(), null);
    }


    @Test
    public void completion_handler_test() {
        aliveChecker.callback.completed(hostList.get(0).getStatus(), null);
    }
}