package moneyCalculator.persistence;

import moneyCalculator.model.Currency;
import moneyCalculator.model.ExchangeRate;

public interface ExchangeRateReader {
    public ExchangeRate show (Currency currency_from, Currency currency_to);
}
