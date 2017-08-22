package org.bejond.designpattern.bridgepattern.client.impl;

import org.bejond.designpattern.bridgepattern.ServerInterfaces;
import org.bejond.designpattern.bridgepattern.client.MainClient;

public class ClientImpl extends MainClient {

    protected ClientImpl(ServerInterfaces serverInterfaces) {

        super(serverInterfaces);
    }

    public String getServerStatus() {

        return serverInterfaces.serverInformation();
    }
}
