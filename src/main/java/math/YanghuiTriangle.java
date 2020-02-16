package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角
 * @author: shan junwei
 * @create: 2020-02-15 19:46
 **/

public class YanghuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  result = new ArrayList<>();

        if(numRows <= 0){
            return result;
        }

        int[][] array = new int[numRows][];

        array[0] =  new int[]{0,1,0};

        List<Integer>  row0 = new ArrayList<>();
        row0.add(1);
        result.add(row0);

        if(numRows == 1){
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer>  row = new ArrayList<>();

            // 比前一行多一个数

            int length = i == 0 ? 3 : array[i-1].length+1;
            array[i]  = new int[length];
            for (int j = 0; j < length; j++) {

                int left = j == 0 ? 0 : array[i-1][j-1];
                int right = j >= array[i-1].length ? 0 : array[i-1][j];
                array[i][j] = Math.addExact(left,right);
                if(array[i][j] != 0){
                    row.add(array[i][j]);
                }
            }
            result.add(row);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        YanghuiTriangle  yanghuiTriangle =  new YanghuiTriangle();
        yanghuiTriangle.generate(2);
    }

}
