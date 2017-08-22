package org.bejond.designpattern.bridgepattern.impl;

import org.bejond.designpattern.bridgepattern.ServerInterfaces;

public class ServerInterfacesComplexImpl implements ServerInterfaces {

    public String serverName() {

        return "complex server1";
    }

    public String serverInformation() {

        return "complex server1, good.";
    }

    public String greeting(String name) {

        return "Welcome home, lovely " + name + "!";
    }
}
