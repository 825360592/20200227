import java.math.BigInteger;

public class Termsout {
    public void termsout(Terms terms) {
        boolean isout = false;
        if (terms.getTerms().isEmpty()) {
            System.out.print("0");
            isout = true;
            return;
        }
        for (BigInteger key : terms.getTerms().keySet()) {
            BigInteger coe = terms.getTerms().get(key);
            BigInteger ind = key;
            if ((!coe.toString().trim().equals("0"))
                    && (!coe.toString().trim().equals("-0"))) { //系数为0 没有输出
                char[] arr = coe.toString().trim().toCharArray();
                if (arr[0] != '-' && isout) {           //前导+号的输出判断
                    System.out.print("+");
                }

                if (coe.toString().trim().equals("1")) {  //case系数为1
                    if (ind.toString().trim().equals("0")) {
                        System.out.print("1");
                    } else if (ind.toString().trim().equals("1")) {
                        System.out.print("x");
                    } else {
                        System.out.print("x**" + ind);
                    }
                } else if (coe.toString().trim().equals("-1")) {  //case 系数为-1
                    if (ind.toString().trim().equals("0")) {
                        System.out.print("-1");
                    } else if (ind.toString().trim().equals("1")) {
                        System.out.print("-x");
                    } else {
                        System.out.print("-x**" + ind);
                    }
                } else {                                        //系数为其他
                    if (ind.toString().trim().equals("0")) {
                        System.out.print(coe);
                    } else if (ind.toString().trim().equals("1")) {
                        System.out.print(coe + "*x");
                    } else {
                        System.out.print(coe + "*x**" + ind);
                    }
                }
                isout = true;
            }
        }
        if (!isout) {
            System.out.print("0");
        }
    }
}

