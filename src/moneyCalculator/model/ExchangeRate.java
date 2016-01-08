package moneyCalculator.model;

public class ExchangeRate {

    private final Currency currency_from;
    private final Currency currency_to;
    private final double rate;

    public Currency getCurrency_from() {
        return currency_from;
    }

    public Currency getCurrency_to() {
        return currency_to;
    }

    public double getRate() {
        return rate;
    }

    public ExchangeRate(Currency currency_from, Currency currency_to, double rate) {
        this.currency_from = currency_from;
        this.currency_to = currency_to;
        this.rate = rate;
    }
     
    

    
}
