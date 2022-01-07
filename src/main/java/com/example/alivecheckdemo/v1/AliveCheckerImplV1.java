package com.example.alivecheckdemo.v1;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AliveCheckerImplV1 implements AliveCheckerV1 {

    private final ExecutorService executorService;

    Callback callback;

    public AliveCheckerImplV1(Callback callback) {
        this.callback = callback;
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        }

    @Override
    public void check(String hostName) {
        isAlive(hostName);
        callback.get(hostName);
    }

    @Override
    public void check(List<HostInfo> hostList) {

        Runnable task = () -> {
            for (HostInfo hostInfo : hostList) {
                boolean alive = isAlive(hostInfo.getHostName());
                hostInfo.setStatus(alive);
            }
        };
        executorService.submit(task);
        callback.getAll(hostList);
    }

    /**
     * ping check method.
     */
    protected boolean isAlive(String hostName) {
        try {
            InetAddress inetAddress = InetAddress.getByName(hostName);
            inetAddress.isReachable(2000);
        } catch (IOException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }


}
