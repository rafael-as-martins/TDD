package core;

public class Dollar extends Money{

    public Dollar(int amount) {
        super(amount);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
