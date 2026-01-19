package software.ulpgc.moneycalculator.ui;

import software.ulpgc.moneycalculator.application.WebService;
import software.ulpgc.moneycalculator.control.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MoneyCalculatorFrame extends JFrame {

    public MoneyCalculatorFrame() {
        List<Currency> currencies = new WebService.CurrencyLoader().loadAll();

        SwingMoneyDialog moneyDialog = new SwingMoneyDialog(currencies);
        SwingCurrencyDialog currencyDialog = new SwingCurrencyDialog(currencies);
        SwingMoneyDisplay moneyDisplay = new SwingMoneyDisplay();

        JButton convertButton = new JButton("Convertir");

        ExchangeMoneyCommand command = new ExchangeMoneyCommand(
                moneyDialog,
                currencyDialog,
                new WebService.ExchangeRateLoader(),
                moneyDisplay
        );

        convertButton.addActionListener(e -> command.execute());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(moneyDialog.panel());
        mainPanel.add(currencyDialog.panel());
        mainPanel.add(moneyDisplay.panel());
        mainPanel.add(convertButton);

        add(mainPanel);

        setTitle("Money Calculator");
        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
