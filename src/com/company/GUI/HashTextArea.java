package com.company.GUI;

import com.company.Entries.HashEntry;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HashTextArea extends JTextArea {

    private JLabel fileName;
    GridBagConstraints gbc;

    public HashTextArea() {
        super(20, 20);
        setEditable(false);
        setBackground(Color.white);
        setBorder(BorderFactory.createLoweredBevelBorder());
        setAlignmentY(CENTER_ALIGNMENT);
        setVisible(true);
    }

    public void populateTextArea(ArrayList<HashEntry> entries) {
        setText("");
        for (HashEntry entry : entries) {
            addSingleEntry(entry);
        }

    }

    public void addSingleEntry(HashEntry entry) {
        setText(getText() + String.format("%s:\t%s\t%s\n", entry.getFileName(), entry.getHashValue(), entry.getHashFunction()));
        repaint();
    }

    public void addSingleEntry(String filePath, String hashCode, String algorithm) {
        setText(getText() + String.format("%s:\t%s\t%s\n", filePath, hashCode, algorithm));
        repaint();
    }

}
