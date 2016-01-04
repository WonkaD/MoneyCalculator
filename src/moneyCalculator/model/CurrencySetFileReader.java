package moneyCalculator.model;

import moneyCalculator.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CurrencySetFileReader {
    public CurrencySet read (String filename) throws FileNotFoundException, IOException{
        CurrencySet currencySet = new CurrencySet();
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        reader.readLine();
        while(true){
            String line = reader.readLine();
            if (line ==null) break;
            String[]split = line.split(";");
            currencySet.add(new Currency(split[0],split[1],split[2]));
        }
        return currencySet;
    }
}
