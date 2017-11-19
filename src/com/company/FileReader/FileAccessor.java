package com.company.FileReader;

import com.company.Entries.HashEntry;

interface FileAccessor {
    void loadDataFile();   // called to load the contents of the data file

    void saveDataFile();   // called to save the contents of the data file

    void addHashDetails(String fileName, String newHash, String hashFunction);

    void replaceHashDetails(String fileName, String newHash);

    void removeDetails(HashEntry entry);
}
