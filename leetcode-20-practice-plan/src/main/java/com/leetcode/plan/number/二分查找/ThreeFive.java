package com.leetcode.plan.number.二分查找;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/8/16 13:25
 */
public class ThreeFive {
    /**
     * @题号：35
     *
     *
     * @描述：
     *      给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     *
     *
     * @特别注意：
     *      请必须使用时间复杂度为 O(log n) 的算法
     *
     * @思路：
     *      方案1：二分查找   O(logn)
     *
     * @考察:
     *
     * @拓展：
     *
     */
    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length -1, middle;
        while (left <= right){
            middle = (left + right)/2;
            if(nums[middle] == target)
                return middle;
            if(target > nums[middle]){
                left = middle + 1;
            }else{
                right = middle -1;
            }
        }
        return left;
    }
}
