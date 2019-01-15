package com.barry;

import org.junit.Test;

public class SortTest {

    @Test
    public void quickSort() {
        int[] nums = new int[]{5,1,6,2,8,3,9,4,0,7};
        sort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private void sort(int[] nums,int low ,int high) {
        int pivot ;
        if (low <  high){
            pivot = partition(nums,low,high);
            sort(nums,low,pivot-1);
            sort(nums,pivot+1,high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivotKey = nums[low];
        while (low < high){
            while (pivotKey<nums[high]){
                high--;
            }
            swap(nums,low,high);
            while (pivotKey>nums[low]){
                low++;
            }
            swap(nums,low,high);
        }
        return low;
    }

    public void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
