package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description: 反转字符串
 * @author: shan junwei
 * @create: 2020-01-31 19:29
 **/
public class ReverseStr {

    public String reverseStr(String s, int k) {
        // 暴力破解

        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;


        int flag = 0;
        while (index < s.length()) {
            flag = flag ^ 1;
            int end = index + k > s.length() ? s.length() : index + k;
            String str = s.substring(index, end);
            if(flag == 1){
                String revert = reverseString(str.toCharArray());
                stringBuilder.append(revert);
            }else{
                stringBuilder.append(str);
            }
            index = end;
        }
        return stringBuilder.toString();
    }

    public String reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i <= j) {
            swap(s, i, j);
            i++;
            j--;
        }
        return new String(s);
    }

    // 交换
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    @Test
    public  void test() {
        ReverseStr reverseStr  = new ReverseStr();
        String result = reverseStr.reverseStr("abcdefg",2);
        Assert.assertEquals("bacdfeg",result);

        result = reverseStr.reverseStr("ab",2);
        Assert.assertEquals("ba",result);

        result = reverseStr.reverseStr("a",2);
        Assert.assertEquals("a",result);
    }


}
