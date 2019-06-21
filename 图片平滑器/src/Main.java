public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int[][] imageSmoother(int[][] M) {
        int[][] res=new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                res[i][j]=getMean(M,i,j);
            }
        }
        return res;
    }
    public static int getMean(int[][] M,int x,int y){
        int res=0;
        int resNum=0;
        int[] dir1={-1,0,1};
        int[] dir2={-1,0,1};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(check(M,x+dir1[i],y+dir2[j])){
                    res+=M[x+dir1[i]][y+dir2[j]];
                    resNum++;
                }
            }
        }
        return res/resNum;
    }
    public static boolean check(int[][] M,int x,int y){
        if(x<0||x>=M.length||y<0||y>=M[0].length){
            return false;
        }
        return true;
    }
}
