package com.leetcode.plan.number;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/8/17 11:14
 */
public class NineSevenSeven {

    /**
     * @题号：977
     *
     *
     * @描述：
     *      给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * @特别注意：
     *      时间复杂度为 O(n)
     *
     *      输入：nums = [-4,-1,0,3,10]
     *      输出：[0,1,9,16,100]
     *      解释：平方后，数组变为 [16,1,0,9,100]
     *      排序后，数组变为 [0,1,9,16,100]
     *
     *
     * @思路：
     *      归并排序---双指针：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
     *
     * @考察:
     *     数组 双指针 排序
     * @拓展：
     *      各种排序算法：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/ge-chong-pai-xu-shuang-zhi-zhen-by-toxic-3/
     *      A.
     *
     */
    public static void main(String[] args) {
        int[] ints = sortedSquares1();
    }
    public static int[] sortedSquares1(){
        int[] nums = {-1};
        //1.找到负数与非负数的界限
        int length = nums.length;
        int split = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0)
                split = i;
            else
                break;
        }

        //2.负数与非负数进行比较，并将较小者放入到对应数据中（从index=0开始放）
        int []newNums = new int[length];
        int left = split, right = split + 1, index = 0;
        while ( left >= 0 || right < length){
            if(left < 0){
                newNums[index] = nums[right] * nums[right];
                right++;
            }else if(right == length){
                newNums[index] = nums[left] * nums[left];
                left --;
            }else if(nums[left]* nums[left]<nums[right]*nums[right]){
                newNums[index] = nums[left] * nums[left];
                System.out.println();
                left--;
            }else{
                newNums[index] = nums[right] * nums[right];
                right ++;
            }

            index ++;
        }

        return newNums;
    }

    public int[] sortedSquares2(int[] nums){
        // 从左右两端开始比较，将较大者放入到对应数据的中（从index=nums.length -1 开始放）
        int left = 0, right = nums.length -1, index = nums.length -1;
        int []newNums = new int [nums.length];

        while (index >= 0){
            if(nums[left] * nums[left] < nums[right] * nums[right]){
                newNums[index] = nums[right] * nums[right];
                right --;
            }else{
                newNums[index] = nums[left] *nums[left];
                left ++;
            }
            index --;

        }

        return newNums;
    }
}
