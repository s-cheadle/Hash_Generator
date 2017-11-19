package com.company;

import com.company.GUI.GuiDriver;

import javax.swing.*;
import java.io.IOException;

/**
 * This program is my submission for the Software Systems
 * Development assignment at Leeds Beckett University.
 * <p>
 *
 * @author Scott Cheadle
 * @version %I%, %G%
 * @uniID c3469518
 * @since 1.0
 */
public class Main {

    /**
     * Calls SwingUtilities to create the application GUI and sets it to visible.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new GuiDriver().setVisible(true));
    }
}
