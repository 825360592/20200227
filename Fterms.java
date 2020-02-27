import java.math.BigInteger;
import java.util.ArrayList;

public class Fterms {
    public Terms df(ArrayList<Term> tlist0) {
        Terms terms = new Terms();
        int j = tlist0.size();
        for (int i = 0; i < j; i++) {
            BigInteger coe = tlist0.get(i).getCoefficient();
            BigInteger ind = tlist0.get(i).getIndex();
            BigInteger newc;
            BigInteger newi;
            BigInteger one = new BigInteger("1");
            if (ind.toString().trim().equals("0") || ind.toString().trim().equals("-0")) {
                newc = new BigInteger("0");
                newi = new BigInteger("0");
            } else {
                newc = coe.multiply(ind);
                newi = ind.subtract(one);
            }
            Term term = new Term();
            term.setCoefficient(newc);
            term.setIndex(newi);
            terms.addt(term);
        }
        return terms;
    }
}
