package com.company.Hashing_Algorithm;

import java.io.File;

/**
 * AlgorithmChooser class houses all of the algorithms the application uses.
 */
public class AlgorithmChooser {

    public AlgorithmChooser() {
    }

    /**
     * Returns the hash value of a file as a string.
     *
     * @param alg    is the algorithm to be used to generate the hash.
     * @param toHash is the File object to be hashed.
     * @return is the hexadecimal hash value as a String object.
     */
    public static String getHashString(String alg, File toHash) {
        String hashString = null;
        if (alg.equals("MDHA")) {
            try {
                hashString = String.format("%016x", MDHA.getInstance().produceFileHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("DJB")) {
            try {
                hashString = String.format("%016x", DJB.getInstance().produceFileHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("FNV-1")) {
            try {
                hashString = String.format("%016x", FNV_1.getInstance().produceFileHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("JS")) {
            try {
                hashString = String.format("%016x", JS.getInstance().produceFileHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("MyAlgorithm")) {
            try {
                hashString = String.format("%016x", MyAlgorithm.getInstance().produceFileHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        }
        return hashString;
    }

    /**
     * Returns the hash value of a directory as a string.
     *
     * @param alg    is the algorithm to be used to generate the hash.
     * @param toHash is the File object to be hashed.
     * @return is the hexadecimal hash value as a String object.
     */
    public static String getDirHashString(String alg, File toHash) {
        String hashString = null;
        if (alg.equals("MDHA")) {
            try {
                hashString = String.format("%016x", MDHA.getInstance().produceDirHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("DJB")) {
            try {
                hashString = String.format("%016x", DJB.getInstance().produceDirHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("FNV-1")) {
            try {
                hashString = String.format("%016x", FNV_1.getInstance().produceDirHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("JS")) {
            try {
                hashString = String.format("%016x", JS.getInstance().produceDirHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("MyAlgorithm")) {
            try {
                hashString = String.format("%016x", MyAlgorithm.getInstance().produceDirHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        }
        return hashString;
    }

    /**
     * Returns the metadata hash value of a directory as a string.
     *
     * @param alg    is the algorithm to be used to generate the hash.
     * @param toHash is the File object to be hashed.
     * @return is the hexadecimal hash value as a String object.
     */
    public static String getMetaHashString(String alg, File toHash) {
        String hashString = null;
        if (alg.equals("MDHA")) {
            try {
                hashString = Long.toHexString(MDHA.getInstance().produceDirMetaHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("DJB")) {
            try {
                hashString = Long.toHexString(DJB.getInstance().produceDirMetaHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("FNV-1")) {
            try {
                hashString = Long.toHexString(FNV_1.getInstance().produceDirMetaHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("JS")) {
            try {
                hashString = Long.toHexString(JS.getInstance().produceDirMetaHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        } else if (alg.equals("MyAlgorithm")) {
            try {
                hashString = Long.toHexString(MyAlgorithm.getInstance().produceDirMetaHash(toHash));
            } catch (FailedToHashException e1) {
                e1.printStackTrace();
            }
        }
        return hashString;
    }

}
