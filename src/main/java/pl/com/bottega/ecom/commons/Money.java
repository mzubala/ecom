package pl.com.bottega.ecom.commons;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Embeddable
public class Money implements Serializable, Comparable<Money> {

    public static final Currency DEFAULT_CURRENCY = Currency.getInstance("EUR");

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    private BigDecimal value;

    private String currencyCode;

    protected Money() {
    }

    public Money(BigDecimal value, Currency currency) {
        this(value, currency.getCurrencyCode());
    }

    private Money(BigDecimal value, String currencyCode) {
        this.value = value.setScale(2, RoundingMode.HALF_EVEN);
        this.currencyCode = currencyCode;
    }

    public static Money valueOf(double value) {
        return new Money(new BigDecimal(value), "USD");
    }

    public static Money valueOf(int value, String currencyCode) {
        return new Money(new BigDecimal(value), currencyCode);
    }

    public Money(BigDecimal value) {
        this(value, DEFAULT_CURRENCY);
    }

    public Money(double value, Currency currency) {
        this(new BigDecimal(value), currency.getCurrencyCode());
    }

    public Money(double value) {
        this(value, DEFAULT_CURRENCY);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money money = (Money) obj;
            return compatibleCurrency(money) && value.equals(money.value);
        }
        return false;
    }

    public Money mul(double multiplier) {
        return mul(new BigDecimal(multiplier));
    }

    public Money mul(BigDecimal multiplier) {
        return new Money(value.multiply(multiplier), currencyCode);
    }

    public Money add(Money money) {
        checkCurrencies(money);

        return new Money(value.add(money.value), determineCurrencyCode(money));
    }

    public Money sub(Money money) {
        checkCurrencies(money);

        return new Money(value.subtract(money.value), determineCurrencyCode(money));
    }

    /**
     * Currency is compatible if the same or either money object has zero value.
     */
    private boolean compatibleCurrency(Money money) {
        return isZero(value) || isZero(money.value) || currencyCode.equals(money.currencyCode());
    }

    private boolean isZero(BigDecimal testedValue) {
        return BigDecimal.ZERO.compareTo(testedValue) == 0;
    }

    /**
     * @return currency from this object or otherCurrencyCode. Preferred is the
     * one that comes from Money that has non-zero value.
     */
    private Currency determineCurrencyCode(Money otherMoney) {
        String resultingCurrenctCode = isZero(value) ? otherMoney.currencyCode : currencyCode;
        return Currency.getInstance(resultingCurrenctCode);
    }

    public String currencyCode() {
        return currencyCode;
    }

    public Currency currency() {
        return Currency.getInstance(currencyCode);
    }

    public boolean gt(Money other) {
        return compareTo(other) > 0;
    }

    public boolean lt(Money other) {
        return compareTo(other) < 0;
    }

    public boolean lte(Money other) {
        return compareTo(other) <= 0;
    }

    public boolean gte(Money o) {
        return compareTo(o) >= 0;
    }

    @Override
    public String toString() {
        return String.format("%0$.2f %s", value, currency().getSymbol());
    }

    public BigDecimal value() {
        return value;
    }

    @Override
    public int compareTo(Money o) {
        checkCurrencies(o);
        return value.compareTo(o.value);
    }

    private void checkCurrencies(Money o) {
        if (!compatibleCurrency(o))
            throw new IllegalArgumentException("Currency mismatch");
    }

}
