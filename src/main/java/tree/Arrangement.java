package tree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 全排列
 * @author: shan junwei
 * @create: 2020-04-09 10:03
 **/

public class Arrangement {

    class Item {

        int num;
        int index;

        public Item(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Item)) {
                return false;
            }
            Item item = (Item) o;
            return num == item.num &&
                index == item.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, index);
        }
    }

    LinkedHashSet<List<Item>> temp = new LinkedHashSet<>();

    Set<String> historyList = new HashSet<>();

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 存在重复数字
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 记录路径
        LinkedList<Item> track = new LinkedList<>();
        backtrack(nums, track);

        temp.forEach(list -> {
            res.add(toIntList(list));
        });
        return res;
    }

   List<Integer> toIntList(List<Item> track){
       List<Integer> integerList = new LinkedList<>();
       for (Item item : track) {
           integerList.add(item.num);
       }
       return  integerList;
   }


    void backtrack(int[] nums, LinkedList<Item> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            List trace = new LinkedList(track);
            String choseList = StringUtils.join(toIntList(track),",");
            if(!historyList.contains(choseList)){
                historyList.add(choseList);
                temp.add(trace);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            Item item = new Item(nums[i], i);
            // 排除不合法的选择
            if (track.contains(item)) {
                continue;
            }
            // 做选择
            track.add(item);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Arrangement arrangement = new Arrangement();
        System.out.println(arrangement.permuteUnique(new int[]{}));
    }

}
