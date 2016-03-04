package lintcode.binarysearch;

/**
 * Created by zzy on 15/11/17.
 */

import javax.swing.tree.TreeNode;

/**
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。
 * 如果没有，返回到它将会被按顺序插入的位置。
 * 你可以假设在数组中无重复元素。
 * 如:
 * [1,3,5,6]，5 → 2
 * [1,3,5,6]，2 → 1
 * [1,3,5,6]， 7 → 4
 * [1,3,5,6]，0 → 0
 */
public class SearchInserPosition {
//    public static int searchInserPosition(int [] A, int target){
//        if (A == null || A.length == 0 ){
//            return  0;
//        }
//
//        int B[] = new int [];
//        System.out.println(B.length);
//
//        return  0;
//    }


    public static void main(String[] args) {
//        int [] nums ={4, 5, 6, 7, 0, 1, 2};
//        findMin(nums);
//        int [] nums = {1,10,9,8,7,6,5,4};
//        findPeak(nums);
//        int [] nums = {1002,10203,9,10,100,101};
//        System.out.println(search(nums,9));

        System.out.println( searchRange( new int [1], 1));




    }

    public static  int[] searchRange(int[] num, int target) {
        // write your code here
        if (num.length == 0 || num == null) {
            return new int[] {-1,-1};
        }
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == target) {
                start = mid;
            } else if (num[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int[] tmp =new int [] {-1, -1};
        if (num[start] == target) {
            tmp[0] = start;
        } else if (num[end] == target) {
            tmp[1] = end;

        }
        while (num[tmp[0]] == target && tmp[0] > 0) {
            if (!(tmp[0] == 1)){
                tmp[0]--;
            }

        }
        while (num[tmp[1]] == target && tmp[1] > 0){
            if ( !(tmp[1] == 1)){
                tmp[1]--;
            }

        }

        return tmp;
    }


    public static  int search(int[] num, int target) {
        // write your code here
        if (num == null || num.length == 0){
            return -1;
        }
        int start = 0;
        int end = num.length -  1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == target) {
                // end = mid;
                return mid;
            }

            if (num[start] < num[mid]) {
                if (num[start] <= target && target <= num[mid]){
                    end = mid;
                }else {
                    start = mid;
                }
            } else {
                if (num[mid] <= target && target <= num[end]) {
                    start = mid;
                }else {
                    end = mid;
                }
            }


        }
        if (num[start] == target) {
            return start;
        } else if (num[end] == target) {
            return end;
        }
        return -1;
    }

    public static int findPeak(int[] num) {
        // write your code here
        if (num.length == 0 || num == null){
            return -1;
        }
        int start = 0;
        int end = num.length - 2;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (num[mid] < num[mid + 1]){
                start = mid;
            } else if(num[mid] > num[mid - 1]) {
                end = mid;
            } else {
//                end = mid;
                 start = mid;
            }

        }
        if(num [start] < num[end]) {
            return end;
        } else {
            return start;
        }

    }

    public static int findMin(int[] num) {
        // write your code here
        if (num.length == 0 || num == null){
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int target = num[end];
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (num[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (num[start] < num[end]){
            return num[start];
        } else {
            return num[end];
        }
    }
}
