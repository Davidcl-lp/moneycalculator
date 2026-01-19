package software.ulpgc.moneycalculator.ui;

import software.ulpgc.moneycalculator.model.Currency;
import javax.swing.*;
import java.util.List;

public class SwingCurrencyDialog implements CurrencyDialog {

    private final JComboBox<Currency> currencyBox;

    public SwingCurrencyDialog(List<Currency> currencies) {
        currencyBox = new JComboBox<>(currencies.toArray(new Currency[0]));
    }

    @Override
    public Currency get() {
        return (Currency) currencyBox.getSelectedItem();
    }

    public JPanel panel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Moneda destino:"));
        panel.add(currencyBox);
        return panel;
    }
}

