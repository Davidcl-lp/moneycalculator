package software.ulpgc.moneycalculator.ui;

import software.ulpgc.moneycalculator.model.Money;
import javax.swing.*;

public class SwingMoneyDisplay implements MoneyDisplay {

    private final JLabel resultLabel = new JLabel("Resultado:");

    @Override
    public void show(Money money) {
        resultLabel.setText("Resultado: " + money.amount() + " " + money.currency().code());
    }

    public JPanel panel() {
        JPanel panel = new JPanel();
        panel.add(resultLabel);
        return panel;
    }
}
