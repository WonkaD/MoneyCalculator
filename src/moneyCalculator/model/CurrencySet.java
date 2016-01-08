package moneyCalculator.model;

import java.util.ArrayList;
import java.util.List;

public class CurrencySet {
    private final List<Currency> list = new ArrayList();
    
    public void add (Currency currency){
        list.add(currency);
    }
    
    public Currency[] currencies(){
        return list.toArray(new Currency [list.size()]);
    }
    
    public Currency get (String text){
        for (Currency currency : list) {
            if (currency.getCode().equalsIgnoreCase(text) || currency.getName().contains(text) || currency.getSymbol().equalsIgnoreCase(text)) return currency;
        }
        return null;
    }
}
