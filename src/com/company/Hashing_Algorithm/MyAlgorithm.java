package com.company.Hashing_Algorithm;

import java.io.File;

public class MyAlgorithm extends HashFunction {

    private static final MyAlgorithm myAlgorithm = new MyAlgorithm();
    private final int PRIME_NUMBER = 735632797;
    private final int OFFSET = 982451653;

    private MyAlgorithm() {
    }

    /**
     * Returns the MyAlgorithm object.
     *
     * @return Returns this instance of the MyAlgorithm class when called.
     */
    public static MyAlgorithm getInstance() {
        return myAlgorithm;
    }

    /**
     * Produces a single hash value for an individual file.     The File argument is the file to be hashed. The method will return a MyAlgorithm hash value as a long.
     *
     * @param file is the File object of the file to be hashed.
     * @return the hash value in long format.
     */
    @Override
    public long produceFileHash(File file) throws FailedToHashException {
        long hash = OFFSET;
        byte[] bytes = getBytesFromFile(file);
        if (bytes == null) {
            throw new FailedToHashException(file.getAbsolutePath());
        }
        for (byte aByte : bytes) {

            hash ^= (((hash << 7) ^ (hash >> 11)) * ((aByte + 1) * PRIME_NUMBER) ^ bytes.length);
        }
        //multiply by the prime
        hash *= PRIME_NUMBER;
        return hash << 5;
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
        long hash = 0;
        byte[] bytes;

        File[] array = directory.listFiles();

        if (array != null) {

            for (File file : array) {

                if (file.isFile()) {

                    String name = file.getName();
                    hash *= file.lastModified();
                    bytes = name.getBytes();

                    for (byte aByte : bytes) {

                        hash ^= (((hash << 7) ^ (hash >> 11)) * ((aByte + 1) * PRIME_NUMBER) ^ bytes.length);
                    }
                } else if (file.isDirectory()) {
                    hash += produceDirMetaHash(file);
                }
            }
        } else {
            throw new FailedToHashException(directory.getAbsolutePath());
        }

        if (hash == 0) {
            throw new FailedToHashException(directory.getAbsolutePath());
        }
        return hash << 5;
    }
}
