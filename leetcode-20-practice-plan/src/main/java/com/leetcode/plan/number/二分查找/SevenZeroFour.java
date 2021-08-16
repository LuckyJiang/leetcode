package com.leetcode.plan.number.二分查找;

import com.leetcode.plan.number.Number;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/8/10 16:25
 * @describe
 *      704
 *      给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 *      写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @思路：
 *      方案1：二分查找   O(logn)
 *
 * * @考察:
 */
public class SevenZeroFour implements Number {


    @Override
    public void myCode() {

    }

    //二分查找法：
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return  -1;
        int left = 0;
        int right = nums.length -1;
        int middle;
        while ( left<=right ){
            middle = (left + right)/2;
            if(target == nums[middle])
                return middle;
            if(target < nums[middle]){
                right = middle -1;
            }else{
                left = middle + 1;
            }

        }
        return -1;
    }

    @Override
    public void bestCode() {

    }
}
