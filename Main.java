import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();//读入一行
        ArrayList<Term> tlist0;
        StringToTerms stoTerms = new StringToTerms();
        tlist0 = stoTerms.toterms(in);//字符串转数据
        Terms tmap;
        Fterms fterms = new Fterms();
        tmap = fterms.df(tlist0);//数据组/项列 运算
        Termsout out = new Termsout();
        out.termsout(tmap);//输出
    }
}
