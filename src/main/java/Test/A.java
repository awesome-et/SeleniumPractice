package Test;
import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        String a = "abcc B";
        String b = "bcac b";

        boolean status ;
        String ab = a.replaceAll("//s", "");
        String ba = b.replaceAll("//s", "");
        char[] ac = ab.toLowerCase().toCharArray();
        char[] bc = ba.toLowerCase().toCharArray();
        if(ab.length()!=ba.length()){
            status = false;
        }
        else{
            Arrays.sort(ac);
            Arrays.sort(bc);
            status = Arrays.equals(ac,bc);
        }

        if(status){
            System.out.print("Anagram");
        }
        else{
            System.out.print("Not Anagram");
        }


    }
}
