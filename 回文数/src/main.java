public class main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        String intStr=x+"";
        String reverseStr=new StringBuilder(intStr).reverse().toString();
        if(intStr.equals(reverseStr)){
            return true;
        }else{
            return false;
        }
    }
}
