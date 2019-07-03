public class Main {
    public static void main(String[] args) {

    }
    public int largestOverlap(int[][] A, int[][] B) {
        int maxRes=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                maxRes=Math.max(maxRes,Math.max(check(A,B,i,j),check(B,A,i,j)));
            }
        }
        return maxRes;
    }
    public static int check(int[][] A,int[][] B,int i,int j){
        int num=0;
        for(int Ai=i;Ai<A.length;Ai++){
            for(int Aj=j;Aj<A[0].length;Aj++){
                if(A[Ai][Aj]==1&&B[Ai-i][Aj-j]==1){
                    num++;
                }
            }
        }
        return num;
    }
}
