package org.bejond.designpattern.bridgepattern.impl;

import org.bejond.designpattern.bridgepattern.ServerInterfaces;

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
