package com.luziye.bootluanch;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] x=new int[2];
        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if (map.containsKey(com)) {
                return new int[]{map.get(com),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 1;
        int[] x=solution(nums, target);
        System.out.println(Arrays.toString(x));
    }
}
