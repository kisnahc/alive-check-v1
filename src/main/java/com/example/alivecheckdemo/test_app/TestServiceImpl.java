package com.example.alivecheckdemo.test_app;

import com.example.alivecheckdemo.v1.AliveSchedulerV1;
import com.example.alivecheckdemo.v1.HostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TestServiceImpl {

    private final TestRepository testRepository;
    AliveSchedulerV1 aliveSchedulerV1;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    private final String hostName = "google.com";

    List<HostInfo> hostList = new ArrayList<>();



    private void hostList() {
        hostList.add(new HostInfo(hostName));
        for (int i = 0; i < 2000; i++) {
            hostList.add(new HostInfo(hostName + i));
        }
    }

    public void scheduler() {
        // 등록된 호스트 리스트 조회.
        List<HostInfo> getHosts = testRepository.findAll(hostList);

        // 등록된 호스트들의 모니터링 실행.
        aliveSchedulerV1.run(getHosts, 0, 5, Runtime.getRuntime().availableProcessors(), TimeUnit.SECONDS);
    }
}
