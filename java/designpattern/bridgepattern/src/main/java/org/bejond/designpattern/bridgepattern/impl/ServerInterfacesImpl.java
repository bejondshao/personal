package org.bejond.designPattern.bridgePattern.impl;

import org.bejond.designPattern.bridgePattern.ServerInterfaces;

public class ServerInterfacesImpl implements ServerInterfaces {

    public String serverName() {

        return "server1";
    }

    public String serverInformation() {

        return "server1, good.";
    }

    public String greeting(String name) {

        return "Welcome, " + name + ".";
    }
}
