import java.math.BigInteger;

public class Term {
    private BigInteger coefficient;
    private BigInteger index;

    public void setCoefficient(BigInteger coefficient) {
        this.coefficient = coefficient;
    }

    public void setIndex(BigInteger index) {
        this.index = index;
    }

    public BigInteger getCoefficient() {
        return coefficient;
    }

    public BigInteger getIndex() {
        return index;
    }

}
