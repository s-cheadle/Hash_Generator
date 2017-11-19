package com.company.FileReader;

import com.company.Entries.HashEntry;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileReader implements FileAccessor, Serializable {

    private static FileReader thisInstance = new FileReader();
    private File path;
    private ArrayList<HashEntry> entries = new ArrayList<>();

    private FileReader() {
        path = new File("./");
    }

    /**
     * Returns the FileReader object created in this class.
     * The methods of this class refer to the same entries ArrayList object, so only one FileReader is instantiated.
     *
     * @return thisInstance     The instance of the FileReader object.
     */
    public static FileReader getInstance() {
        return thisInstance;
    }

    /**
     * Loads the previously saved hash entries.  Deserialises and loads the serialised entries object.
     */
    @Override
    public void loadDataFile() {
        try {
            JFileChooser chooser = new JFileChooser();
            switch (chooser.showOpenDialog(null)) {
                case JFileChooser.OPEN_DIALOG:
                    FileInputStream fileInputStream = new FileInputStream(chooser.getSelectedFile());
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    entries = (ArrayList) objectInputStream.readObject();
                    objectInputStream.close();
                    fileInputStream.close();
                    System.out.println("Loaded");
                    break;
                case JFileChooser.CANCEL_OPTION:
                    System.out.println("Load canceled");
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDataFile() {
        try {
            JFileChooser chooser = new JFileChooser();
            switch (chooser.showSaveDialog(null)) {
                case JFileChooser.APPROVE_OPTION:
                    FileOutputStream fileOutputStream = new FileOutputStream(chooser.getSelectedFile());
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    objectOutputStream.writeObject(entries);

                    objectOutputStream.close();
                    fileOutputStream.close();
                    System.out.println("Saved");
                    break;
                case JFileChooser.CANCEL_OPTION:
                    System.out.println("Save canceled");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addHashDetails(String fileName, String newHash, String hashFunction) {

        entries.add(new HashEntry(fileName, newHash, hashFunction));
    }

    public void addHashDetails(HashEntry entry) {

        entries.add(entry);
    }

    @Override
    public void replaceHashDetails(String fileName, String newHash) {

        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).equals(fileName)) {
                entries.get(i).setHashValue(newHash);
            }
        }

    }

    @Override
    public void removeDetails(HashEntry entry) {
        entries.remove(entry);
    }

    /**
     * Compares a HashEntry to the existing hashes. If the same file has been added, the hashes are compared.
     * Returns an int that indicates whether the file has been tampered with.
     *
     * @param toCheck
     */
    public int compareHashes(HashEntry toCheck) {

        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getFileName().equals(toCheck.getFileName())) {
                if (entries.get(i).getHashFunction().equals(toCheck.getHashFunction())) {
                    JOptionPane.showMessageDialog(null, "Hashes are identical");
                    return 0;
                } else {
                    // Changes have been made
                    JOptionPane.showMessageDialog(null, toCheck.getFileName() + " has been changed");
                    return 1;
                }
            } else {
                System.out.println("not in the list");//JOptionPane.showMessageDialog(null, toCheck.getFileName()+" is not in the list!");
                return -1;
            }
        }
        return -1;
    }

    /**
     * Returns the ArrayList of hash value entries.
     *
     * @return entries
     */
    public ArrayList<HashEntry> getEntriesArrayList() {
        return entries;
    }
}


