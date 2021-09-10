package com.leetcode.plan.number.数组;

import com.sun.javafx.scene.text.HitInfo;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/8/17 11:14
 */
public class OneSixSeven {

    /**
     * @题号：167 两数之和 II - 输入有序数组
     *
     *
     * @描述：
     *      给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     *
     *      函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     *
     *      你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
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
        int []numbers = {5,25,75};
        int target = 100;
        int[] ints = twoSum(numbers, target);
        System.out.println();
    }

    //我的思路：双指针：有点暴力，不推荐
    //扩展：
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i <= numbers.length -2; i++) {
            int right = i +1;
            int other = target - numbers[i];
            boolean flag = false;
            while (other>= numbers[i] &&  right < numbers.length && numbers[right] <= other){
                if(numbers[right] == other){
                    result[0] = i +1;
                    result[1] = right +1;
                    flag = true;
                    break;
                }
                right++;
            }
            if(flag)
                break;
        }
        return result;
    }

    //方案2：二分查找：第二个数字在第一个数字的右侧通过二分查找找到
    //时间复杂度：O(nlogn) 其中二分查找的时间复杂度为：O(logn)
    //首先固定第一个数，然后寻找第二个数，第二个数等于目标值减去第一个数的差。
    // 利用数组的有序性质，可以通过二分查找的方法寻找第二个数。（为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找）


    //方案3：双指针
    public static int[] twoSum_1(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0, hight = numbers.length-1;
        while (low < hight){
            int sum = numbers[low] + numbers[hight];
            if(sum == target){
                return new int[]{low+1, hight+1};
            }else if(sum < target){
                low++;
            }else{
                hight--;
            }
        }
        return result;
    }

}
