package org.bejond.designpattern.bridgepattern.client;

import org.bejond.designpattern.bridgepattern.ServerInterfaces;

public abstract class MainClient {

    protected ServerInterfaces serverInterfaces;

    protected MainClient(ServerInterfaces serverInterfaces) {

        this.serverInterfaces = serverInterfaces;
    }

    public abstract String getServerStatus();

}
