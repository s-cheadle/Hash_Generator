package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HashChooser extends JPanel {

    private ButtonGroup algorithmButtonGroup;
    private JRadioButton MDHARadioButton, DJBRadioButton, FNV1RadioButton, JSRadioButton, MyAlgorithimRadioButton;

    public HashChooser() {
        AlgoButtonListener listener = new AlgoButtonListener();
        setLayout(new GridLayout());
        MDHARadioButton = new JRadioButton("MDHA");
        MDHARadioButton.addActionListener(listener);
        MDHARadioButton.setSelected(true);

        DJBRadioButton = new JRadioButton("DJB");
        DJBRadioButton.addActionListener(listener);

        JSRadioButton = new JRadioButton("JS");
        JSRadioButton.addActionListener(listener);

        FNV1RadioButton = new JRadioButton("FNV-1");
        FNV1RadioButton.addActionListener(listener);

        MyAlgorithimRadioButton = new JRadioButton("My Algorithm");
        MDHARadioButton.addActionListener(listener);

        algorithmButtonGroup = new ButtonGroup();
        algorithmButtonGroup.add(MDHARadioButton);
        algorithmButtonGroup.add(DJBRadioButton);
        algorithmButtonGroup.add(FNV1RadioButton);
        algorithmButtonGroup.add(JSRadioButton);
        algorithmButtonGroup.add(MyAlgorithimRadioButton);

        add(MDHARadioButton);
        add(DJBRadioButton);
        add(FNV1RadioButton);
        add(JSRadioButton);
        add(MyAlgorithimRadioButton);

    }

    public String getSelectedAlg() {
        if (MDHARadioButton.isSelected())
            return "MDHA";
        else if (DJBRadioButton.isSelected())
            return "DJB";
        else if (FNV1RadioButton.isSelected())
            return "FNV-1";
        else if (JSRadioButton.isSelected())
            return "JS";
        else if (MyAlgorithimRadioButton.isSelected())
            return "MyAlgorithm";

        return null;
    }

    private class AlgoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(MDHARadioButton)) {

            } else if (e.getSource().equals(DJBRadioButton)) {

            } else if (e.getSource().equals(FNV1RadioButton)) {

            } else if (e.getSource().equals(JSRadioButton)) {

            } else if (e.getSource().equals(MyAlgorithimRadioButton)) {

            }
        }
    }
}
