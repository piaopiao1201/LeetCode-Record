public class main {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int minLength=Integer.MAX_VALUE;
        for(int i=1;i<strs.length;i++){
            int strLength=Math.min(strs[0].length(),strs[i].length());
            int length=0;
            for(int j=0;j<strLength;j++){
                if(strs[0].charAt(j)==strs[i].charAt(j)){
                    length++;
                }else{
                    break;
                }
            }
            minLength=Math.min(minLength,length);
        }
        return strs[0].substring(0,minLength);
    }
}
