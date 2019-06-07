public class mergeSortClass {
    public static int run(int A[]){
        return mergeSort(A,0,A.length-1);
    }
    public static int mergeSort(int A[],int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            int leftCount=mergeSort(A,left,mid);
            int rightCount=mergeSort(A,mid+1,right);
            int count=merge(A,left,mid,mid+1,right);
            return leftCount+rightCount+count;
        }else{
            return 0;
        }
    }
    public static int merge(int A[],int L1,int R1,int L2,int R2){
        int[] temp=new int[R2-L1+1];
        int index=temp.length-1;
        int i=R1,j=R2;
        int count=0;
        while(i>=L1&&j>=L2){
            if(A[i]<=A[j]){
                temp[index--]=A[j--];
            }else{
                temp[index--]=A[i--];
                count+=j-R1;
            }
        }
        while(i>=L1){
            temp[index--]=A[i--];
        }
        while(j>=L2){
            temp[index--]=A[j--];
        }
        for(int k=0;k<temp.length;k++){
            A[L1+k]=temp[k];
        }
        return count;
    }
}
