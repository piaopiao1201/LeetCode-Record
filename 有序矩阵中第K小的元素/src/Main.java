public class Main {
    public static void main(String[] args) {

    }
    public int kthSmallest(int[][] matrix, int k) {
        int min=matrix[0][0],max=matrix[matrix.length-1][matrix.length-1];
        while(min<max){
            int mid=min+(max-min)/2;
            int count=0;
            for(int i=0;i<matrix.length;i++){
                count+=BinarySearch(matrix[i],mid);
            }
            if(count>=k){
                max=mid;
            }else{
                min=mid+1;
            }
        }
        return min;
    }
    public static int BinarySearch(int[] rows,int target){
        int left=0,right=rows.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(rows[mid]>target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        //代表小于等于target的个数
        return left;
    }
}
