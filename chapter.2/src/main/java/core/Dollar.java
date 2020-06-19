package core;

public class Dollar {

    public int amout;

    public Dollar(int amount) {
        this.amout = amount;
    }

    public void times(int multiplier) {
        this.amout*=multiplier;
    }
}
