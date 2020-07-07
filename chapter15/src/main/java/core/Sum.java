package core;

public class Sum implements Expression {

    private Expression augend;
    private Expression addend;

    public Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend; 
    }

    public Money reduce(Bank bank, String toCurrency){

        int reducedAugend = this.augend.reduce(bank, toCurrency).getAmount();
        int reducedAddend = this.addend.reduce(bank, toCurrency).getAmount();
        int total = reducedAugend + reducedAddend;

        return new Money(total, toCurrency);
    }

    @Override
    public Expression plus(Expression money) {
        return null;
    }

    @Override
    public Expression times(int multiplier) {
        return null;
    }

    public Expression getAddend() {
        return addend;
    }

    public void setAddend(Expression addend) {
        this.addend = addend;
    }

    public Expression getAugend() {
        return augend;
    }

    public void setAugend(Expression augend) {
        this.augend = augend;
    }
}
