import java.math.BigInteger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToTerms {
    private ArrayList<Term> tlist0 = new ArrayList<>();

    public ArrayList<Term> toterms(String in) {
        StringBuilder strterms = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) != ' ' && in.charAt(i) != '\t') {
                strterms.append(in.charAt(i));
            }
        }

        //String frop = "[+-]?";//0次或一次匹配加减，项的连接

        //String expp = "**"+nump;
        //String coep = "[+-]?[0-9]*";
        ////////////////////frop /nump       /*///幂函数              //
        Pattern pattern = Pattern.compile("[+-]?([+-]?[0-9]+\\*)?x(\\*\\*[+-]?[0-9]+)?" +
                "|[+-]?[+-]?x(\\*\\*[+-]?[0-9]+)?|[+-]?[+-]?[0-9]+");
        Matcher matcher = pattern.matcher(strterms.toString());
        while (matcher.find()) {
            String term = matcher.group();
            StringBuilder superterm = new StringBuilder();
            for (int i = 0; i < term.length() - 1; i++) {  //最后一位不会是符号
                char getc1 = term.charAt(i);
                char getc2 = term.charAt(i + 1);
                if (getc1 != '+' && (!(getc1 == '-' && getc2 == '-'))) {
                    superterm.append(getc1);
                } else if (getc2 == '-' && getc1 == '-') {
                    superterm.append('+');
                    i++;
                }
            }
            superterm.append(term.charAt(term.length() - 1));
            Pattern nump = Pattern.compile("[+-]?[0-9]+");//带符号整数
            Matcher m = nump.matcher(superterm.toString());
            Term ne = new Term();
            if (superterm.toString().contains("*x**")) {
                m.find();
                ne.setCoefficient(new BigInteger(m.group()));
                m.find();
                ne.setIndex(new BigInteger(m.group()));
            } else if (superterm.toString().contains("*x")) {
                m.find();
                String com = m.group();
                ne.setCoefficient(new BigInteger(com));
                ne.setIndex(new BigInteger("1"));
            } else if (superterm.toString().contains("x**")) {
                if (superterm.toString().charAt(0) == 'x') {
                    ne.setCoefficient(new BigInteger("1"));
                } else {
                    ne.setCoefficient(new BigInteger("-1"));
                }
                m.find();
                ne.setIndex(new BigInteger(m.group()));
            } else if (superterm.toString().contains("x")) {
                if (superterm.toString().charAt(0) == 'x') {
                    ne.setCoefficient(new BigInteger("1"));
                } else {
                    ne.setCoefficient(new BigInteger("-1"));
                }
                ne.setIndex(new BigInteger("1"));
            } else {
                ne.setCoefficient(new BigInteger("0"));
                ne.setIndex(new BigInteger("0"));
            }
            this.tlist0.add(ne);
        }
        return tlist0;
    }
}
