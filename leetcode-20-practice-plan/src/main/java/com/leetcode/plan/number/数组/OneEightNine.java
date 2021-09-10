package com.leetcode.plan.number.数组;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/8/18 9:19
 */
public class OneEightNine {
    /**
     * @题号：189
     *
     *
     * @描述：
     *      给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * @特别注意：
     *      空间复杂度为 O(1)
     *
     *      输入: nums = [1,2,3,4,5,6,7], k = 3
     *      输出: [5,6,7,1,2,3,4]
     *      解释:
     *      向右旋转 1 步: [7,1,2,3,4,5,6]
     *      向右旋转 2 步: [6,7,1,2,3,4,5]
     *      向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     *
     * @思路：
     *
     *
     * @考察:
     *
     *
     * @拓展：
     *
     *
     */
    public static void main(String[] args) {
        // int []nums = {1,2,3,4,5,6,7};
        int []nums = {-1};
        // rotate1(nums, 3);
        // rotate2(nums, 2);
        rotate3(nums, 2);
    }

    /**
     * 方案1：使用额外的数组来存储
     *
     * 时间复杂度： O(n)，其中 n 为数组的长度。
     *
     * 空间复杂度： O(n)。
     */
    public static  void rotate1(int[] nums, int k) {
        int []newNums = new int[nums.length];
        for (int i = 0; i<nums.length; i++){
            int temp = (i + k) % nums.length;
            newNums[temp] = nums[i];
        }
        //将newNums存储到nums中；
        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    /**
     * 方案2：环状替换 todo 写的不对
     *
     * 时间复杂度： O(n)，其中 n 为数组的长度。
     *
     * 空间复杂度： O(1)。
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        int temp = nums[0];
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = (index + k) %length;
            int x = nums[index];
            nums[index] =  temp;
            temp = x;
        }
    }

    /**
     * 方案3： 数组翻转
     *  思路：先反转所有的数组：
     *        分别反转 翻转 [0, k mod n - 1] 、[k mod n, n - 1]
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {

        k = k% nums.length;  //k有可能大于nums.length
        swap(nums, 0, nums.length-1);
        swap(nums, 0, k-1);
        swap(nums, k, nums.length-1);
    }

    public static void swap(int[] nums, int start,int end){
        while(start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

}
