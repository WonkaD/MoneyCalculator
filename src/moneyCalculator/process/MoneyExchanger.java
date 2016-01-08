package moneyCalculator.process;

import moneyCalculator.model.ExchangeRate;
import moneyCalculator.model.Money;

public class MoneyExchanger {
    public Money exchange (ExchangeRate rate, Money from){
        return new Money(from.getAmount() * rate.getRate(), rate.getCurrency_to());
    }
}
