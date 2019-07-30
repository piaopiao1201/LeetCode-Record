public class Main {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int startX=matrix.length-1,startY=0;
        while(true){
            if(startX<0||startY>=matrix[0].length){
                break;
            }
            if(matrix[startX][startY]<target){
                startY++;
            }else if(matrix[startX][startY]>target){
                startX--;
            }else{
                return true;
            }
        }
        return false;
    }
}
