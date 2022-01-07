package com.example.alivecheckdemo.v3;

import java.io.IOException;
import java.util.List;

public interface AliveCheckerV3 {

    /**
     * 등록된 호스트의 alive 상태 체크.
     */
    void check(String hostName) throws IOException;

    /**
     * 등록된 호스트들의 alive 상태 체크.
     */
    void check(List<HostInfo> hostList) throws IOException;

    void get(AliveCallback aliveCallback);

    void getAll(AliveCallback aliveCallback);
}
