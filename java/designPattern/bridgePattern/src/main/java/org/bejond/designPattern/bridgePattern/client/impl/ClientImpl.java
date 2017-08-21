package org.bejond.designPattern.bridgePattern.client.impl;

import org.bejond.designPattern.bridgePattern.ServerInterfaces;
import org.bejond.designPattern.bridgePattern.client.MainClient;

public class ClientImpl extends MainClient {

    protected ClientImpl(ServerInterfaces serverInterfaces) {

        super(serverInterfaces);
    }

    public String getServerStatus() {

        return serverInterfaces.serverInformation();
    }
}
