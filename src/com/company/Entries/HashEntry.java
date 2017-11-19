package com.company.Entries;

import java.io.Serializable;

public class HashEntry implements Serializable {

    private String fileName;
    private String hashValue;
    private String hashFunction;

    public HashEntry(String fileName, String hashValue, String hashFunction) {
        this.fileName = fileName;
        this.hashValue = hashValue;
        this.hashFunction = hashFunction;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(hashValue);
    }

    /**
     * Returns the file name as a string.       This can be used to populate the HashTextArea.
     *
     * @return fileName as a string.        It may or may not include the full path, depending on whether the input was a file or a directory.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns the hash value of the HashEntry.     It can then be compared to another hash value or add to the HashTextArea.
     *
     * @return hashValue as a string./
     */
    public String getHashValue() {
        return hashValue;
    }

    /**
     * Returns the name of the hash function used.
     *
     * @return the name of the function as a string.
     */
    public String getHashFunction() {
        return hashFunction;
    }

    /**
     * Sets the hash value for this hash entry.     This is intended to replace hash values that have changed.
     * The hashValue String argument should be a pre-formatted hexadecimal hash value.
     *
     * @param hashValue is a string.
     */
    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }
}
