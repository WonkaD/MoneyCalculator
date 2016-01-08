package moneyCalculator.command;

import moneyCalculator.model.ExchangeRate;
import moneyCalculator.model.Money;
import moneyCalculator.persistence.ExchangeRateReaderDataBase;
import moneyCalculator.process.MoneyExchanger;
import moneyCalculator.ui.Display;

public class ExecuteCommand implements Command{
    private final Display display;
    
    public ExecuteCommand(Display display) {
        this.display = display;
    }
   
    @Override
    public void execute() {
        Money money = display.getMoney();
        ExchangeRateReaderDataBase base = new ExchangeRateReaderDataBase();
        ExchangeRate exchangeRate = base.show(money.getCurrency(), display.getCurrency());
        display.show( new MoneyExchanger().exchange(exchangeRate, money));
    }
    
}
