package com.company.GUI;

import com.company.Entries.HashEntry;
import com.company.FileReader.FileReader;
import com.company.Hashing_Algorithm.AlgorithmChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class GuiDriver extends JFrame {

    private HashChooser hashChooser;
    private HashTextArea hashTextArea;

    public GuiDriver() {
        super("Scott's Hashgen v1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        setJMenuBar(new HashGenMenu());
        setContentPane(contentPane);

        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints GBC = new GridBagConstraints();
        GBC.gridx = 0;
        GBC.gridy = 0;
        GBC.gridwidth = 3;

        hashChooser = new HashChooser();
        contentPane.add(hashChooser, GBC);

        GBC.fill = GridBagConstraints.HORIZONTAL;
        GBC.gridwidth = 3;
        GBC.gridx = 0;
        GBC.gridy = 1;
        GBC.weighty = 1.0;
        GBC.weightx = 1.0;
        hashTextArea = new HashTextArea();
        JScrollPane scroll = new JScrollPane(hashTextArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(scroll, GBC);


        JButton chooseFileButton = new JButton("Choose FILE to hash");
        GBC.gridheight = 1;
        GBC.gridwidth = 1;
        GBC.gridx = 0;
        GBC.gridy = 2;
        contentPane.add(chooseFileButton, GBC);
        chooseFileButton.addActionListener(new HashButtonListener());

        JButton chooseDirButton = new JButton("Choose DIRECTORY to hash");
        GBC.gridx = 1;
        GBC.gridy = 2;
        contentPane.add(chooseDirButton, GBC);
        chooseDirButton.addActionListener(new DirButtonListener());

        JButton chooseMetaButton = new JButton("Choose DIRECTORY to METADATA hash");
        GBC.gridx = 2;
        GBC.gridy = 2;
        contentPane.add(chooseMetaButton, GBC);
        chooseMetaButton.addActionListener(new MetaDirButtonListener());

        pack();
    }


    private class HashButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File toHash = HashFileChooser.getInstance().getFile();
            if (toHash != null) {
                HashEntry hashEntry = new HashEntry(toHash.getName(), AlgorithmChooser.getHashString(hashChooser.getSelectedAlg(), toHash), hashChooser.getSelectedAlg());
                int compareHash = FileReader.getInstance().compareHashes(hashEntry);

                if (compareHash < 0) {
                    FileReader.getInstance().addHashDetails(hashEntry);
                    hashTextArea.addSingleEntry(hashEntry);
                }
            }
        }
    }

    private class DirButtonListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            File toHash = HashFileChooser.getInstance().getDirectory();
            if (toHash != null) {

                HashEntry hashEntry = new HashEntry(toHash.getName(), AlgorithmChooser.getDirHashString(hashChooser.getSelectedAlg(), toHash), hashChooser.getSelectedAlg());
                int compareHash = FileReader.getInstance().compareHashes(hashEntry);
                System.out.println(compareHash);
                if (compareHash < 0) {
                    FileReader.getInstance().addHashDetails(hashEntry);
                    hashTextArea.addSingleEntry(hashEntry);
                }
            }
        }
    }

    private class MetaDirButtonListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            File toHash = HashFileChooser.getInstance().getDirectory();

            if (toHash != null) {

                HashEntry toEnter = new HashEntry(toHash.getName(), AlgorithmChooser.getMetaHashString(hashChooser.getSelectedAlg(), toHash), hashChooser.getSelectedAlg());

                int comp = FileReader.getInstance().compareHashes(toEnter);

                if (comp < 0) {
                    FileReader.getInstance().addHashDetails(toEnter);
                    hashTextArea.addSingleEntry(toEnter);
                }
            }
        }
    }


}


