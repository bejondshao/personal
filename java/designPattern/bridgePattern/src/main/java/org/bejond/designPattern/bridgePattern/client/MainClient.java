package org.bejond.designPattern.bridgePattern.client;

import org.bejond.designPattern.bridgePattern.ServerInterfaces;

public abstract class MainClient {

    protected ServerInterfaces serverInterfaces;

    protected MainClient(ServerInterfaces serverInterfaces) {

        this.serverInterfaces = serverInterfaces;
    }

    public abstract String getServerStatus();

}
