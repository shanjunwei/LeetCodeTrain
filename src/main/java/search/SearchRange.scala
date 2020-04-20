package search

/*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]*/
object SearchRange {

  def main(args: Array[String]): Unit = {
    var arrays = Array(5)
    println(searchBinary(arrays, 0, arrays.length-1, 5))
    println(searchBinary(arrays, 0, arrays.length-1, 7))

    arrays = Array(5, 7, 7, 8, 8, 10)
    println(searchRange(arrays, 6).mkString(" "))

    arrays = Array()
    println(searchRange(arrays, 6).mkString(" "))

    arrays = Array(1)
    println(searchRange(arrays, 1).mkString(" "))
  }

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    if (nums.length == 0) return Array(-1, -1)

    // 尝试二分查找
    val first = searchBinary(nums, 0, nums.length-1, target)
    if (first == -1) {
      return Array(-1, -1)
    }
    // 左边界
    var left = first
    // 右边界
    var right = first
    while ((left - 1) >= 0 && nums(left - 1) == target) {
      left = left - 1
    }
    while ((right + 1) < nums.length && nums(right + 1) == target) {
      right = right + 1
    }
    Array(left, right)
  }

  /**
    * 二分查找实现
    */
  def searchBinary(nums: Array[Int], left: Int, right: Int, target: Int): Int = {
    if (left > right) {
      return -1
    }
    // 防止int溢出
    val middle = left + (right - right) / 2

    if (target < nums(middle)) {
      searchBinary(nums, left, middle - 1, target)
    }
    else if (target > nums(middle)) {
      searchBinary(nums, middle + 1, right, target)
    }
    else middle
  }

}
