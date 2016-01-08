package moneyCalculator.ui;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneyCalculator.model.Currency;
import moneyCalculator.model.Money;

public class Display extends JPanel implements CurrencyDialog, MoneyDisplay, MoneyDialog{

    private Money money;
    private final JComboBox<Currency> currenciesFrom;
    private final JComboBox<Currency> currenciesTo;
    private final JTextField moneyFrom;
    private final JTextField moneyTo;

    public Display(JComboBox<Currency> currenciesFrom, JComboBox<Currency> currenciesTo, JTextField moneyFrom, JTextField moneyTo) {
        this.currenciesFrom = currenciesFrom;
        this.currenciesTo = currenciesTo;
        this.moneyFrom = moneyFrom;
        this.moneyTo = moneyTo;
    }

    
    @Override
    public Currency getCurrency() {
        return (Currency) currenciesTo.getSelectedItem();
    }

    @Override
    public void show(Money money) {
        this.money = money;
        moneyTo.setText(money.getAmount()+"");
    }

    @Override
    public Money getMoney() {
        String textMoney = moneyFrom.getText().replace(',', '.');
        double resultMoney;
        if (textMoney.matches("\\d+[\\.]?\\d*")){
            resultMoney = Double.parseDouble(textMoney);
        } else {
            moneyFrom.setText("0.0");
            resultMoney = 0;
        }
        return new Money(resultMoney, (Currency) currenciesFrom.getSelectedItem());
    }

    
}
