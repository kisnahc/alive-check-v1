package com.example.alivecheckdemo.v3;

import java.util.List;

public interface AliveCallback {
    /**
     * alive 상태 체크된 호스트를 조회.
     */
    void get(String hostName);

    /**
     * alive 상태 체크된 호스트의 리스트 조회.
     */
    List<HostInfo> getAll(List<HostInfo> hostList);
}
