package com.example.alivecheckdemo.v1;

import java.util.List;

public interface Callback {
    /**
     * alive 상태 체크된 호스트를 조회.
     */
    void get(String hostName);

    /**
     * alive 상태 체크된 호스트의 리스트 조회.
     */
    List<HostInfo> getAll(List<HostInfo> hostList);
}
