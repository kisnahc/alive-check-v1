package com.example.alivecheckdemo.v1;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AliveSchedulerV1 {

    /**
     * 등록된 호스트 리스트의 alive 상태를 모니터링 실행.
     */
    void run(List<HostInfo> hostList, int initialDelay, int delay, int nThreads, TimeUnit timeUnit);

    /**
     * 등록된 호스트 리스트의 alive 상태를 모니터링 종료.
     */
    void stop();

    /**
     * 실행중인 alive 상태 모니터링이 동작 중인지 확인하는 메서드.
     */
    boolean isRunning();



}
