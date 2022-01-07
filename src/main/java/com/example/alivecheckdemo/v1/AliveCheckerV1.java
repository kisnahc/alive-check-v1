package com.example.alivecheckdemo.v1;

import java.io.IOException;
import java.util.List;

public interface AliveCheckerV1 {

    /**
     * 등록된 호스트의 alive 상태 체크.
     */
    void check(String hostName) throws IOException;

    /**
     * 등록된 호스트들의 alive 상태 체크.
     */
    void check(List<HostInfo> hostList) throws IOException;

}
