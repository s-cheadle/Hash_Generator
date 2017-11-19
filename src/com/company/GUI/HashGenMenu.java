package com.company.GUI;

import com.company.FileReader.FileReader;

import javax.swing.*;

public class HashGenMenu extends JMenuBar {

    final JMenu menu;
    final JMenuItem i1;
    final JMenuItem i2;

    public HashGenMenu() {
        menu = new JMenu("File");
        i1 = new JMenuItem("Save");
        i2 = new JMenuItem("Load");

        i1.addActionListener(e -> {
            FileReader.getInstance().saveDataFile();
        });

        i2.addActionListener(e -> {
            FileReader.getInstance().loadDataFile();
        });

        menu.add(i1);
        menu.add(i2);
        add(menu);


    }
}