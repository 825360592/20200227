import java.math.BigInteger;
import java.util.HashMap;

public class Terms {
    private HashMap<BigInteger, BigInteger> terms = new HashMap<>();

    public HashMap<BigInteger, BigInteger> getTerms() {
        return terms;
    }

    public void addt(Term term) {
        BigInteger keyi = term.getIndex();
        BigInteger valuec = term.getCoefficient();
        BigInteger valuen;
        if (valuec.toString().trim().equals("0") || valuec.toString().trim().equals("-0")) {
            return;
        }
        if (terms.containsKey(keyi)) {
            valuen = valuec.add(terms.get(keyi)); //valuen新的系数
            if (valuen.toString().trim().equals("0") || valuen.toString().trim().equals("-0")) {
                terms.remove(keyi);
            } else {
                terms.remove(keyi);
                terms.put(keyi,valuen);
            }
        } else {
            terms.put(keyi, valuec);
        }
    }
}
