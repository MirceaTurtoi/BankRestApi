package api.utils;


import java.util.HashMap;
import java.util.Map;

public class Fees {

    private Map<Pair, Double> fees;

    public Fees() {
        fees = new HashMap<>();
        fees.put(new Pair(Currency.RON, Currency.EUR), 4.95);
        fees.put(new Pair(Currency.EUR, Currency.RON), 0.2);
        fees.put(new Pair(Currency.RON, Currency.USD), 4.71);
        fees.put(new Pair(Currency.USD, Currency.RON), 0.21);
        fees.put(new Pair(Currency.EUR, Currency.USD), 0.95);
        fees.put(new Pair(Currency.USD, Currency.EUR), 1.05);
        fees.put(new Pair(Currency.EUR, Currency.EUR), 1.0);
        fees.put(new Pair(Currency.USD, Currency.USD), 1.0);
        fees.put(new Pair(Currency.RON, Currency.RON), 1.0);
    }

    public Double getFee(Currency currency1, Currency currency2){

       return fees.get(new Pair(currency1, currency2));
    }
}
