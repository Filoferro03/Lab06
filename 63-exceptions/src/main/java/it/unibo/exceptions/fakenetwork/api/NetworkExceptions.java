package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkExceptions extends IOException {

    public NetworkExceptions() {
        super("Network error: no response");
    }

    public NetworkExceptions(String message) {
        super("Network error while sending message: "+ message);
    }
    
}