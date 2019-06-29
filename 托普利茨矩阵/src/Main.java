public class Main {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        //检查横向元素
        int row=0;
        for(int i=0;i<matrix[0].length;i++){
            int start=matrix[row][i];
            int tempJ=i;
            int tempRow=row;
            while(true){
                tempRow++;
                tempJ++;
                if(tempRow>=matrix.length||tempJ>=matrix[0].length){
                    break;
                }
                if(matrix[tempRow][tempJ]!=start){
                    return false;
                }
            }
        }
        int column=0;
        for(int i=0;i<matrix.length;i++){
            int start=matrix[i][column];
            int tempI=i;
            int tempCol=column;
            while(true){
                tempCol++;
                tempI++;
                if(tempI>=matrix.length||tempCol>=matrix[0].length){
                    break;
                }
                if(matrix[tempI][tempCol]!=start){
                    return false;
                }
            }
        }
        return true;
    }
}
