public class Main {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] matrix={{1,2,3},{4,5,6},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        System.out.println(1);
    }
    public static void rotate(int[][] matrix) {
        int time=matrix.length/2;
        for(int i=0;i<time;i++){
            for(int j=i;j<matrix[0].length-i-1;j++){
                int temp=matrix[i][j];
                change(matrix,i,i,j,j,matrix[0].length-i-1);
                matrix[j][matrix[0].length-i-1]=temp;
            }
        }

    }
    public static void change(int[][] matrix,int weidu,int startX,int startY,int nowX,int nowY){
        if(nowX==startX&&nowY==startY){
            return;
        }
        int bianjie=matrix[0].length-weidu-1;
        if(nowY==bianjie&&nowX==startY){
            change(matrix,weidu,startX,startY,bianjie,bianjie-(startY-weidu));
            matrix[bianjie][bianjie-(startY-weidu)]=matrix[nowX][nowY];
        }
        if(nowX==bianjie&&nowY==bianjie-(startY-weidu)){
            change(matrix,weidu,startX,startY,bianjie-(startY-weidu),weidu);
            matrix[bianjie-(startY-weidu)][weidu]=matrix[nowX][nowY];
        }
        if(nowX==bianjie-(startY-weidu)&&nowY==weidu){
            change(matrix,weidu,startX,startY,startX,startY);
            matrix[startX][startY]=matrix[nowX][nowY];
        }
    }
}
