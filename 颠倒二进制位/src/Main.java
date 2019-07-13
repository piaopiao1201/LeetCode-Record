public class Main {
    /*
    颠倒给定的 32 位无符号整数的二进制位。
示例 1：

输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
示例 2：

输入：11111111111111111111111111111101
输出：10111111111111111111111111111111
解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
      因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
     */
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int reverseBits(int n) {
        String res=Integer.toBinaryString(n);
        while(res.length()<32){
            res='0'+res;
        }
        StringBuilder res2=new StringBuilder(res).reverse();
        if(res2.charAt(0)=='0'){
            return Integer.valueOf(res2.toString(),2);
        }else{
            for(int i=0;i<res2.length();i++){
                if(res2.charAt(i)=='0'){
                    res2.setCharAt(i,'1');
                }else{
                    res2.setCharAt(i,'0');
                }
            }
            int res3=Integer.valueOf(res2.toString(),2)+1;
            return -res3;
        }
    }
}
