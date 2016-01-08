package moneyCalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import moneyCalculator.command.Command;
import moneyCalculator.command.ExecuteCommand;
import moneyCalculator.model.Currency;
import moneyCalculator.model.CurrencySet;
import moneyCalculator.model.CurrencySetDataBase;
import moneyCalculator.model.Money;
import moneyCalculator.ui.Display;

public class Application extends JFrame {

    private final Map<String, Command> commands = new HashMap<>();
    
    private final CurrencySet currencies = new CurrencySetDataBase().read();
    private final JComboBox<Currency> currenciesFrom = new JComboBox<>(currencies.currencies());
    private final JComboBox<Currency> currenciesTo = new JComboBox<>(currencies.currencies());
    private final JTextField moneyFrom = new JTextField("0.0");
    private final JTextField moneyTo = new JTextField();
    
    private final Display display = new Display(currenciesFrom, currenciesTo, moneyFrom, moneyTo);

    public static void main(String[] args) throws Exception {
        new Application().setVisible(true);
    }

    public Application() throws Exception {
        deployUI();
        createCommands();
    }

    private void deployUI() {
        super.setTitle("Money Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(display());
        this.getContentPane().add(menuBar(), BorderLayout.SOUTH);
        this.pack();

    }

    private void createCommands() {
        commands.put("calc", new ExecuteCommand(display));
    }

    private JPanel menuBar() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Calcular");
        button.addActionListener(execute("calc"));
        button.setFocusable(false);
        panel.add(button);
        return panel;
    }

    private JPanel fromPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 2, 2, 2));
        panel.add(moneyFrom, BorderLayout.NORTH);
        panel.add(currenciesFrom, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel toPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 2, 2, 2));
        moneyTo.setEditable(false);
        panel.add(moneyTo, BorderLayout.NORTH);
        panel.add(currenciesTo, BorderLayout.SOUTH);
        return panel;
    }

    private Display display() {
        display.setLayout(new FlowLayout());
        display.show(new Money(0, currenciesFrom.getItemAt(1)));
        display.add(fromPanel());
        display.add(toPanel());
        return display;
    }

    private ActionListener execute(String command) {
        return (ActionEvent e) -> commands.get(command).execute();

    }

}
