package com.leetcode.plan.number.二分查找;

import com.leetcode.plan.number.Number;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/8/10 17:12
 */
public class TwoSevenEight implements Number {

    /**
     * @题号：278
     *
     *
     * @描述：
     *      你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，
     *      你的产品的最新版本没有通过质量检测。由于每个版本都是基于
     *      之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     *
     *      假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *
     *      你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试
     *      中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     * @特别注意：
     *      调用最少的API次数
     *
     * @思路：
     *      第一种方案：二分查找
     *
     * @考察:
     *
     * @拓展：
     *
     */
    @Override
    public void myCode() {

    }

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        int middle;
        while ( left < right ){                   // 第一点：当有多个值，并返回第一个的下标时，循环条件要变一下；
            middle = left + (right -left)/2;      // 第二点： 超出边界限制
            // middle = left + (right -left)>>1;   // 第三点： 位的运算 比简单的“/”用时要多
            boolean  flag = isBadVersion(middle);
            if(flag){
                right = middle;
            }else{
                left = middle + 1;
            }

        }
        return left;
    }

    private boolean isBadVersion(int middle) {
        return true;
    }


    @Override
    public void bestCode() {

    }
}
