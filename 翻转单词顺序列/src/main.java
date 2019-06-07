public class main {
    public static void main(String[] args) {
        String res=ReverseSentence(" de ed");
        System.out.println(1);
    }
    public static String ReverseSentence(String str) {
        if(str.length()<=1){
            return str;
        }
        int blackSum=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                blackSum++;
            }else{
                break;
            }
        }
        str=str.substring(blackSum);
        String[] strArr=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=strArr.length-1;i>=0;i--){
            sb.append(strArr[i]);
            sb.append(" ");
        }
        sb.substring(0,sb.length()-1);
        for(int i=0;i<blackSum;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
