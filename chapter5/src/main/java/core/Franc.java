package core;

import java.util.Objects;

public class Franc {

    private final int amount;

    public Franc(int amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franc franc = (Franc) o;
        return this.amount == franc.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.amount);
    }

    public Franc times(int amount) {
        return new Franc(amount * this.amount);
    }
}
