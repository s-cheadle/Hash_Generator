package com.company.Hashing_Algorithm;

import java.io.File;

/**
 * Mark Dixon's Hashing Algorithm (MDHA) example.
 * Included for demonstration purposes.
 */
public class MDHA extends HashFunction {

    private static final MDHA mdha = new MDHA();
    long hash;
    int length;
    byte[] bytes;

    private MDHA() {
    }

    /**
     * Returns the static MDHA object.
     *
     * @return MDHA
     */
    public static MDHA getInstance() {
        return mdha;
    }


    /**
     * Produces a single hash value for an individual file.     The File argument is the file to be hashed. The method will return a MyAlgorithm hash value as a long.
     *
     * @param file is the File object of the file to be hashed.
     * @return the hash value in long format.
     */
    @Override
    public long produceFileHash(File file) throws FailedToHashException {
        hash = 0;

        bytes = getBytesFromFile(file);
        if (bytes == null)
            throw new FailedToHashException(file.getName());
        length = bytes.length;

        // Dump byte array contents and hash the values.
        for (byte b : bytes) {
            hash += b * 13;
        }

        // create a very simple hash (hash of byte values, each multiplied by a prime number, all of which is multiplied by file size)
        hash *= length * 997;

        return hash;
    }

    /**
     * Returns a hash value for the specified directory and its subdirectories. This hash value is created by including the metadata of the file in the hash function.
     *
     * @param directory is the File object of the specified directory.
     * @return the hash value as a long.
     * @throws FailedToHashException if the hash would return 0
     */
    @Override
    public long produceDirMetaHash(File directory) throws FailedToHashException {
        hash = 0;

        File[] array = directory.listFiles();
        if (array != null) {

            for (File file : array) {

                if (!file.isFile()) {

                    if (file.isDirectory()) {
                        hash += produceDirMetaHash(file);
                    }
                } else {
                    // Add the last modified long to the hash, then perform the hash function, but using the bytes from the file name!
                    hash += file.lastModified();
                    byte[] bytes = file.getName().getBytes();
                    for (byte b : bytes) {
                        hash += b * 13;
                    }
                }
                hash *= bytes.length * 997;
            }
        } else {
            throw new FailedToHashException(directory.getName());
        }

        return hash;
    }
}
