package software.ulpgc.moneycalculator.ui;

import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.Money;

import javax.swing.*;
import java.util.List;

public class SwingMoneyDialog implements MoneyDialog {

    private final JTextField amountField = new JTextField(10);
    private final JComboBox<Currency> currencyBox;

    public SwingMoneyDialog(List<Currency> currencies) {
        currencyBox = new JComboBox<>(currencies.toArray(new Currency[0]));
        currencyBox.setPrototypeDisplayValue(
                new Currency("XXXX", "XXXXXXXXXXXXXXXX")
        );

    }

    @Override
    public Money get() {
        String text = amountField.getText().trim();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Introduce una cantidad",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            throw new IllegalStateException("Cantidad vacía");
        }

        double amount;
        try {
            amount = Double.parseDouble(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "La cantidad debe ser un número válido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            throw new IllegalStateException("Cantidad inválida");
        }

        Currency currency = (Currency) currencyBox.getSelectedItem();
        return new Money(amount, currency);
    }


    public JPanel panel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Cantidad:"));
        panel.add(amountField);
        panel.add(currencyBox);
        return panel;
    }
}
