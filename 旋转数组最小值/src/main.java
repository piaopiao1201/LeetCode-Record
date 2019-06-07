public class main {
    public static void main(String[] args) {
        int[] array={6,8,2,3,4};
        int[] array2={1,0,1,1,1};
        int res=minNumberInRotateArray2(array2);
        System.out.println(1);
    }
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int left=0,right=array.length-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(left==right){
                return array[left];
            }
            if(array[mid]<array[mid-1]&&array[mid]<=array[mid+1]){
                return array[mid];
            }
            if(array[mid]>=array[array.length-1]&&array[mid]>=array[0]){
                left=mid+1;
            }else if(array[mid]<=array[0]&&array[mid]<=array[array.length-1]){
                right=mid-1;
            }
        }
        return array[mid];
    }

    public static int minNumberInRotateArray2(int [] array) {
        if(array.length==0){
            return 0;
        }
        int left=0,right=array.length-1;
        int mid=0;
        while(array[left]>=array[right]){
            if(right-left==1){
                mid=right;
                break;
            }
            mid=(left+right)/2;
            //判断如果两端值与中位数值一样，则改为顺序查找
            if(array[left]==array[right]&&array[left]==array[mid]){
                return search(array,left,mid);
            }
            if(array[mid]>=array[left]){
                left=mid;
            }
            if(array[mid]<=array[right]){
                right=mid;
            }
        }
        return array[mid];
    }
    public static int search(int[] array,int left,int right){
        int res=array[left];
        for(int i=left;i<=right;i++){
            if(array[i]<res){
                res=array[i];
            }
        }
        return res;
    }
}
