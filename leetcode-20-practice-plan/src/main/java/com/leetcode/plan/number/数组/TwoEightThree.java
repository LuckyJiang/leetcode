package com.leetcode.plan.number.数组;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/8/17 11:14
 */
public class TwoEightThree {

    /**
     * @题号：283 移动零
     *
     *
     * @描述：
     *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @特别注意：
     *
     *
     *
     * @思路：
     *
     *
     * @考察:
     *     数组 双指针 排序
     * @拓展：
     *
     */
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    //方案1：双指针 --笨蛋方法 :缺点：时间复杂度太高
    public static void moveZeroes(int[] nums) {
        for (int left = 0; left < nums.length; left++) {
            if(nums[left] != 0)
                continue;
            for (int right = left +1; right < nums.length; right++) {
                if(nums[right] == 0)
                    continue;
                else{
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    break;
                }
            }
        }
        System.out.println();
    }

    //方案1：双指针 -- 技巧 left：表示被替换的小标；right 为遍历数组的下标；当right == length时，遍历结束，同时替换结束
    public static void moveZeroes_1(int[] nums) {

        int left  = 0, right = 0, length = nums.length;
        while (right < length){
            if(nums[right] !=0){
                int temp = nums[left];
                nums[left] =nums[right];
                nums[right] = temp;
                left ++;
            }
            right++;
        }
    }

    //时间复杂度：O(n)
    //遍历两次：
    //第一次遍历：只要为非0，则就放进数组nums[j++]，其中j也表示非0 个数
    //第二次遍历：从j开始遍历，直到数组结束填充0
    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] =0;
        }
    }
}
