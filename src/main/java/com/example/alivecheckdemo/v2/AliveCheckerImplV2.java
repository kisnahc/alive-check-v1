package com.example.alivecheckdemo.v2;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.CompletionHandler;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AliveCheckerImplV2 implements AliveCheckerV2 {

    private final ExecutorService executorService;

    public AliveCheckerImplV2() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    CompletionHandler<Boolean, Void> callback = new CompletionHandler<>() {
        @Override
        public void completed(Boolean result, Void attachment) {
            System.out.println(result);
        }

        @Override
        public void failed(Throwable exc, Void attachment) {
            System.out.println(exc.getMessage());
        }
    };

    @Override
    public void check(String hostName) {
        boolean status = isAlive(hostName);
        callback.completed(status, null);
    }

    @Override
    public void check(List<HostInfo> hostList) {
        Runnable task = () -> {
            for (HostInfo hostInfo : hostList) {
                boolean status = isAlive(hostInfo.getHostName());
                hostInfo.setStatus(status);
                callback.completed(hostInfo.getStatus(), null);
            }
        };
        executorService.submit(task);
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
