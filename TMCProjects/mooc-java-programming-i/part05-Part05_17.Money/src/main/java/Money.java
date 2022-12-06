
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        int newCents = this.cents() + addition.cents();
        int newEuros = this.euros() + addition.euros();

        return new Money(newEuros, newCents);
    }

    public boolean lessThan(Money compared) {
        boolean isLess = this.euros() * 100 + this.cents() < compared.euros() * 100 + compared.cents();
        return isLess;
    }

    public Money minus(Money decreaser) {
        if (this.lessThan(decreaser)) {
            return new Money(0, 0);
        } else {
            int newCents = this.cents() - decreaser.cents();
            int newEuros = this.euros() - decreaser.euros();
            if (newCents < 0) {
                newCents = 100 - Math.abs(newCents) % 100;
                newEuros -= (100 + newCents) / 100;
            }
            return new Money(newEuros, newCents);
        }
    }
}
