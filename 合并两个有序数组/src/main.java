public class main {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<nums1.length;i++){
            int j;
            for(j=i;j>0&&nums1[j-1]>nums2[i-m];j--){
                nums1[j]=nums1[j-1];
            }
            nums1[j]=nums2[i-m];
        }
    }
}
