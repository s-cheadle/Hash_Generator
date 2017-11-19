package com.company.Hashing_Algorithm;

import java.io.File;

interface HashingAlgorithm {

    long produceFileHash(File file) throws FailedToHashException;

    long produceDirHash(File directory) throws FailedToHashException;

    long produceDirMetaHash(File directory) throws FailedToHashException;
}
