package moneyCalculator;
import moneyCalculator.model.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CurrencySetFileReader reader = new CurrencySetFileReader();
        CurrencySet currencySet = reader.read("file.txt");
        for (Currency currency : currencySet.currencies()) {
            System.out.println(currency.getCode() + " " + currency.getName());
        }
        
    }

}
