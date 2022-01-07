package com.example.alivecheckdemo.test_app;

import com.example.alivecheckdemo.v1.HostInfo;

import java.util.List;

public interface TestRepository {

    HostInfo findHostByName(String hostName);

    List<HostInfo> findAll(List<HostInfo> hosts);
}
