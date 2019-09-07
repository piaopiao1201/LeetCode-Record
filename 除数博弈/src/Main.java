public class Main {
    static int[] record=new int[1002];
    static int[] record2=new int[1002];
    public static void main(String[] args) {
        boolean res=divisorGame(7);
        System.out.println(1);
    }
    public static boolean divisorGame(int N) {
        return a1(N);
    }
    public static boolean a1(int N){
        if(N==2){
            return true;
        }
        if(N==3){
            return false;
        }
        if(record[N]!=0){
            return record[N]==1?true:false;
        }
        boolean flag=false;
        for(int i=1;i<N;i++){
            if(N%i==0){
                flag=flag||!b1(N-i);
                if(flag){
                    break;
                }
            }
        }
        record[N]=flag?1:-1;
        return flag;
    }
    public static boolean b1(int N){
        if(N==2){
            return true;
        }
        if(N==3){
            return false;
        }
        if(record2[N]!=0){
            return record2[N]==1?true:false;
        }
        boolean flag=false;
        for(int i=1;i<N;i++){
            if(N%i==0){
                flag=flag||!a1(N-i);
                if(flag){
                    break;
                }
            }
        }
        record2[N]=flag?1:-1;
        return flag;
    }
}
