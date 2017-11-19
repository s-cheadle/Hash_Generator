package com.company.Hashing_Algorithm;

import java.io.IOException;

public class FailedToHashException extends IOException {

    public FailedToHashException(String file) {
        super("Failed to hash: " + file + " has not been hashed.");
    }

}
