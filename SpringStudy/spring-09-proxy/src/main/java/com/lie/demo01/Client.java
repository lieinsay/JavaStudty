package com.lie.demo01;

public class Client {
    public static void main(String[] args) {
        // 房东要租房子
        Host host = new Host();

        // 代理，中介帮房东租房子，顺带一些附属操作
        Proxy proxy = new Proxy(host);

        // 不面对房东，直接找中介租房
        proxy.rent();
    }
}
