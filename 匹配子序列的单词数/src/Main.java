public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int numMatchingSubseq(String S, String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            String temp=words[i];
            if(isSub(S,temp)){
                count++;
            }
        }
        return count;
    }
    public static boolean isSub(String s,String temp){
        int offset=0;
        for(int i=0;i<temp.length();i++){
            char cTemp=temp.charAt(i);
            int res=s.indexOf(cTemp,offset);
            if(res!=-1){
                offset=res+1;
            }else{
                return false;
            }
        }
        return true;
    }
}
