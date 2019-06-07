public class main {
    public static void main(String[] args) {
        int[] param={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(param));
    }

    public static int maxArea(int[] height) {
        int maxArea=-1;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int h=Math.min(height[i],height[j]);
                maxArea=Math.max(maxArea,h*(j-i));
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxArea=-1;
        int l=0,r=height.length-1;
        while(l<r){
            maxArea=Math.max(maxArea,(r-l)*Math.min(height[l],height[r]));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
