public class Main {
    /*
      如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。

给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。

示例 1:

输入:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
输出: True
解释:
在上述矩阵中, 其对角线为:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
各条对角线上的所有元素均相同, 因此答案是True。
示例 2:

输入:
matrix = [
  [1,2],
  [2,2]
]
输出: False
解释:
对角线"[1, 2]"上的元素不同。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/toeplitz-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(1);
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
