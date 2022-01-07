package com.example.alivecheckdemo.v1;

import java.util.List;

public class Caller implements Callback {

    public Caller() {
    }

    @Override
    public void get(String hostName) {
        System.out.println(" ====== 데이터 조회 시작 =====");
        System.out.println(hostName);
        System.out.println(" ====== 데이터 조회 종료 =====");
    }

    @Override
    public List<HostInfo> getAll(List<HostInfo> hostList) {
        System.out.println("===== 데이터 리스트 조회 시작 =====");
        System.out.println(hostList);
        System.out.println("===== 데이터 리스트 조회 종료 =====");
        return hostList;
    }

}
