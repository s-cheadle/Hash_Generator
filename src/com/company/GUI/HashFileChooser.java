package com.company.GUI;

import javax.swing.*;
import java.io.File;

public class HashFileChooser extends JFileChooser {

    private static HashFileChooser thisInstance = new HashFileChooser();

    public static HashFileChooser getInstance() {
        return thisInstance;
    }

    private HashFileChooser() {
    }

    public File getFile() {
        setCurrentDirectory(new File(System.getProperty("user.home")));
        setDialogTitle("Select File to hash");
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        int accept = showOpenDialog(null);

        if (accept == JFileChooser.APPROVE_OPTION)
            return getSelectedFile();

        return null;
    }


    public File getDirectory() {
        setCurrentDirectory(new File(System.getProperty("user.home")));
        setDialogTitle("Select Directory to hash");
        setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int accept = showOpenDialog(null);

        if (accept == JFileChooser.APPROVE_OPTION)
            return getSelectedFile();

        return null;
    }
}
