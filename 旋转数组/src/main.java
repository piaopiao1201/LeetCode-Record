public class main {
    public static void main(String[] args) {
        int[] arr={2,2,2,2,2};
        int res=minNumberInRotateArray(arr);
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
}
