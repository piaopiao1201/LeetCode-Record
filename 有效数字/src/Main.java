public class Main {
    public static void main(String[] args) {
        System.out.println(s2.contains(String.valueOf(s1)));
        boolean res=isNumber(" 005047e+6");
        System.out.println(res);
    }
    public static boolean isNumber(String s) {
        if(s.matches("^\\s*\\.+\\s*")){
            return false;
        }
        if(s.matches("^\\s*(-?\\+?)\\.\\s*$")){
            return false;
        }
        if(s.matches("^\\s*\\.e\\d*$")){
            return false;
        }
        // if(s.matches("^\\s*\\.+\\s*\\d+")){
        //     return false;
        // }
        String reg1="^\\s*(-?|\\+?)\\d+\\s*$";
        String reg2="^\\s*(-?|\\+?)\\d*\\.\\d*\\s*$";
        String reg3="^\\s*(-?|\\+?)\\d+e(-?|\\+?)\\d+\\s*";
        String reg4="^\\s*(-?|\\+?)\\d*\\.\\d*e(-?|\\+?)\\d+\\s*";
        String reg5="^\\s*(-?|\\+?)\\d+\\.\\d*";
        boolean res=s.matches(reg1)||s.matches(reg2)||s.matches(reg3)||s.matches(reg4)||s.matches(reg5);
        return res;
    }
}
