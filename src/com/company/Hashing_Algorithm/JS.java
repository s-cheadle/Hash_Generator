package com.company.Hashing_Algorithm;

import java.io.File;

public class JS extends HashFunction {

    private static final JS js = new JS();
    private byte[] bytes;
    private final long OFFSET = 1315423911;

    public static JS getInstance() {
        return js;
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

        bytes = getBytesFromFile(file);

        for (int i = 0; i < bytes.length; ++bytes[i], ++i) {
            hash ^= ((hash << 5) + (bytes[i]) + (hash >> 2));
        }
        return hash;
    }


    /**
     * Returns a hash value for the specified directory and its subdirectories. This hash value is created by including the metadata of the file in the hash function.
     *
     * @param directory is the File object of the specified directory.
     * @return the hash value as a long.
     * @throws FailedToHashException if the hash would return 0.
     */
    @Override
    public long produceDirMetaHash(File directory) throws FailedToHashException {

        long hash = OFFSET;
        byte[] bytes;

        File[] array = directory.listFiles();

        if (array != null) {

            for (File file : array) {

                if (file.isFile()) {
                    bytes = file.getName().getBytes();
                    hash += file.lastModified();

                    for (int i = 0; i < bytes.length; ++bytes[i], ++i) {
                        hash ^= ((hash << 5) + (bytes[i]) + (hash >> 2));
                    }
                } else if (file.isDirectory()) {
                    hash += produceDirMetaHash(file);
                }
            }
        } else {
            throw new FailedToHashException(directory.getName());
        }

        if (hash == 0)
            throw new FailedToHashException(directory.getName());

        return hash;
    }
}
