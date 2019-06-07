import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        String a="s";
        Character b='s';
        char c=a.charAt(0);
        String res=reverseVowels(".,");
        System.out.println(res);
    }
    public static String reverseVowels(String s) {
        Character[] all={'a','e','o','i','u','A','E','O','I','U'};
        Set<Character> allSet=new HashSet<Character>(Arrays.asList(all));
        char[] ques=s.toCharArray();
        int i=0,j=ques.length-1;
        while(i<j){
            while(i<ques.length&&!allSet.contains(ques[i])){
                i++;
            }
            while(j>=0&&!allSet.contains(ques[j])){
                j--;
            }
            if(i<j){
                char tmp=ques[i];
                ques[i]=ques[j];
                ques[j]=tmp;
                i++;
                j--;
            }
        }
        return new String(ques);
    }
}
