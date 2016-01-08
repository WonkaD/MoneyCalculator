package moneyCalculator.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import moneyCalculator.model.Currency;
import moneyCalculator.model.ExchangeRate;

public class ExchangeRateReaderDataBase implements ExchangeRateReader{

    @Override
    public ExchangeRate show(Currency currency_from, Currency currency_to){
        try {
            ExchangeRate exchangeRate;
        
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:currencies.db");

        Statement stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("Select * FROM EXCHANGE_RATES where currency_from='"+currency_from.getCode()+"' and currency_to='"+currency_to.getCode()+"'");
        if (rs.next()){
            exchangeRate = new ExchangeRate(currency_from, currency_to, rs.getDouble("exchange_rate"));
        } else {
            System.err.println("ERROR NO CURRENCY FOUND");
            System.exit(-1);
            return null;
        }
        
        stmt.close();
        c.close();
        return exchangeRate;
        
        } catch (Exception e) {
            System.err.println("ERROR");
            System.exit(-1);
            return null;
        }
        
    }
    
}
