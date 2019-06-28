public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public boolean isIdealPermutation(int[] A) {
        if(A.length==2){
            return true;
        }
        //计算局部倒置
        int maxNum=-1;
        for(int i=1;i<A.length;i++){
            if (A[i] > maxNum) {
                maxNum = Math.max(A[i - 1], maxNum);
            } else {
                return false;
            }
        }
        return true;
    }
}
