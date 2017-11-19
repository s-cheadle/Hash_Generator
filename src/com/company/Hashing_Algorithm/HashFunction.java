package com.company.Hashing_Algorithm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class HashFunction implements HashingAlgorithm {

    /**
     * Produces a single hash value for an individual file.     The File argument is the file to be hashed. The method will return a MyAlgorithm hash value as a long.
     *
     * @param file is the File object of the file to be hashed.
     * @return the hash value in long format.
     */
    @Override
    public abstract long produceFileHash(File file) throws FailedToHashException;

    /**
     * Produces a hash value for a directory.   Takes a File object that indicates which directory to run the hash function on. This method includes any subdirectories of the given directory.
     *
     * @param directory is the path to the directory to be hashed.
     * @return the hash value as a long.
     * @throws FailedToHashException
     */
    @Override
    public long produceDirHash(File directory) throws FailedToHashException {
        long hash = 0;
        File[] array = directory.listFiles();

        if (array == null) {
            throw new FailedToHashException(directory.getName());
        } else {

            for (File file : array) {

                if (file.isDirectory()) {
                    hash += produceDirHash(file);
                } else if (file.isFile()) {
                    hash += produceFileHash(file);
                }
            }

            if (hash == 0)
                throw new FailedToHashException(directory.getAbsolutePath());


            return hash;
        }
    }

    /**
     * Returns a hash value for the specified directory and its subdirectories. This hash value is created by including the metadata of the file in the hash function.
     *
     * @param directory is the File object of the specified directory.
     * @return the hash value as a long.
     * @throws FailedToHashException if the hash would return 0
     */
    @Override
    public abstract long produceDirMetaHash(File directory) throws FailedToHashException;

    byte[] getBytesFromFile(File file) throws FailedToHashException {

        if (file != null) {
            try {

                return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else throw new FailedToHashException(file.getName());

        return null;
    }
}
