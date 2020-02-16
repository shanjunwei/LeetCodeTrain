package string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 字符串中的第一个唯一字符
 * @author: shan junwei
 * @create: 2020-01-31 17:45
 **/

public class FirstUniqChar {

    Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (map.get(item) == null) {
                map.put(item, 1);
            } else {
                int count = map.get(item);
                int plus = count + 1;
                map.put(item, plus);
            }
        }
        System.out.println(8);

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.get(key) == 1) {
                return index;
            }
            index++;
        }
        return -1;
    }


    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        Integer result = firstUniqChar.firstUniqChar("dddccdbba");

        System.out.println(result);
    }

}
