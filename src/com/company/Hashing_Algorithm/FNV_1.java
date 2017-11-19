package com.company.Hashing_Algorithm;

import java.io.File;

public class FNV_1 extends HashFunction {

    private static FNV_1 fnv = new FNV_1();

    private final int FNV_PRIME = 16777619;
    private final long OFFSET_BASIS = 2166136261l;

    private FNV_1() {
    }

    public static FNV_1 getInstance() {
        return fnv;
    }


    /**
     * Produces a single hash value for an individual file.     The File argument is the file to be hashed. The method will return a MyAlgorithm hash value as a long.
     *
     * @param file is the File object of the file to be hashed.
     * @return the hash value in long format.
     */
    @Override
    public long produceFileHash(File file) throws FailedToHashException {
        long hash = OFFSET_BASIS;

        byte[] bytes = getBytesFromFile(file);

        for (int i = 0; i < bytes.length; i++) {
            hash = (hash * FNV_PRIME) ^ bytes[i];
        }

        if (hash == 0)
            throw new FailedToHashException(file.getName());

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
        long lastMod = 0, hash = 0;
        String names = "";
        byte[] bytes;
        File[] dirArray = directory.listFiles();

        if (dirArray == null) {
            throw new FailedToHashException(directory.getName());
        } else {
            for (File file : dirArray) {
                if (file.isDirectory()) {
                    hash += produceDirMetaHash(file);
                } else if (file.isFile()) {
                    names += file.getName();
                    lastMod += file.lastModified();
                }

                bytes = names.getBytes();

                for (int i = 0; i < bytes.length; i++) {
                    hash = (hash * FNV_PRIME) ^ bytes[i];
                }

                hash *= hash ^ lastMod;
            }
        }

        if (hash == 0)
            throw new FailedToHashException(directory.getName());

        return hash;
    }
}
