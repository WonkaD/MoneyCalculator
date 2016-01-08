package moneyCalculator.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CurrencySetDataBase {

    public CurrencySet read() throws Exception {
        CurrencySet currencySet = new CurrencySet();

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:currencies.db");

        Statement stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM CURRENCIES");
        while (rs.next()) {
            currencySet.add(new Currency(rs.getString("code"), rs.getString("name"), rs.getString("symbol")));
        }
        
        stmt.close();
        c.close();
        return currencySet;
    }
}
