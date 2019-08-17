import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }
    public static boolean isAnagram(String s, String t) {
        return convert(s).equals(convert(t));
    }
    public static String convert(String a){
        char[] temp=a.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}
