package pl.com.bottega.ecom.commons;

import org.junit.Test;
import pl.com.bottega.ecom.commons.domain.Money;

import static org.junit.Assert.*;

public class MoneyTest {

    private Money fiftyUsd = Money.valueOf(50, "USD");
    private Money seventyUsd = Money.valueOf(70, "USD");
    private Money fiftyEur = Money.valueOf(50, "EUR");

    @Test
    public void shouldAddMoney() {
        // when
        Money sum = fiftyUsd.add(seventyUsd);

        // then
        Money expected = Money.valueOf(120);
        assertEquals(expected, sum);
        assertEquals(Money.valueOf(50), fiftyUsd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddMoneyInDifferentCurrencies() {
        // when
        fiftyEur.add(seventyUsd);
    }

    @Test
    public void shouldSubtractMoney() {
        // when
        Money dif = fiftyUsd.sub(seventyUsd);

        // then
        Money expected = Money.valueOf(-20);
        assertEquals(expected, dif);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSubtractMoneyInDifferentCurrencies() {
        // when
        fiftyEur.sub(seventyUsd);
    }

    @Test
    public void shouldCompareMoney() {
        assertTrue(fiftyUsd.compareTo(seventyUsd) < 0);
        assertTrue(seventyUsd.compareTo(fiftyUsd) > 0);
        assertTrue(fiftyUsd.compareTo(fiftyUsd) == 0);
    }

    @Test
    public void shouldCompareMoneyUsingBooleanMethods() {
        assertTrue(fiftyUsd.lt(seventyUsd));
        assertTrue(fiftyUsd.lte(seventyUsd));
        assertTrue(seventyUsd.gt(fiftyUsd));
        assertTrue(seventyUsd.gte(fiftyUsd));
        assertFalse(fiftyUsd.gt(seventyUsd));
        assertFalse(fiftyUsd.gte(seventyUsd));
        assertFalse(seventyUsd.lt(fiftyUsd));
        assertFalse(seventyUsd.lte(fiftyUsd));
        assertTrue(fiftyUsd.gte(fiftyUsd));
        assertTrue(fiftyUsd.lte(fiftyUsd));
        assertFalse(fiftyUsd.lt(fiftyUsd));
        assertFalse(fiftyUsd.gt(fiftyUsd));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCompareDifferentCurrencies() {
        fiftyUsd.compareTo(fiftyEur);
    }


}
