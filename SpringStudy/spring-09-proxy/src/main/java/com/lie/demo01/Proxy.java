package com.lie.demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        doHouse();
        fare();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void doHouse(){
        System.out.println("签租赁合同");
    }

    public void fare(){
        System.out.println("收中介费");
    }
}
