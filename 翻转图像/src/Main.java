public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] res=new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                res[i][j]=Math.abs(A[i][A[0].length-1-j]-1);
            }
        }
        return res;
    }
}
