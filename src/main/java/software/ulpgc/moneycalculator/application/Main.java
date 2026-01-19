package software.ulpgc.moneycalculator.application;


import software.ulpgc.moneycalculator.ui.MoneyCalculatorFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new MoneyCalculatorFrame().setVisible(true)
        );
    }
}
