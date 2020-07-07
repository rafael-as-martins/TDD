package core;

public class Sum implements Expression {

    private Money augend;
    private Money addend;

    public Sum(Money augend, Money addend){
        this.augend = augend;
        this.addend = addend; 
    }

    public Money reduce(String toCurrency){
        int total = this.augend.getAmount() + this.addend.getAmount();
        return new Money(total, toCurrency);
    }

    public Money getAddend() {
        return addend;
    }

    public void setAddend(Money addend) {
        this.addend = addend;
    }

    public Money getAugend() {
        return augend;
    }

    public void setAugend(Money augend) {
        this.augend = augend;
    }
}
