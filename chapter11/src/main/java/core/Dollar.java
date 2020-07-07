package core;

public class Dollar extends Money{

    protected Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
