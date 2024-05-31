package practices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] bruteForceSolution(final int[] nums, final int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int complement = target - nums[j];
                if (nums[i]==complement) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static int[] twoPassHashTableSolution(final int[] nums, final int target) {
        int n = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();

        // Not working with IntStream
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement)!=i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{};
    }

    public static int[] onePassHashTableSolution(final int[] nums, final int target) {
        int n = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int target1 = 9;
        int[] nums2 = new int[]{3, 2, 4};
        int target2 = 6;
        int[] nums3 = new int[]{3, 3};
        int target3 = 6;

        System.out.println(Arrays.toString(TwoSum.bruteForceSolution(nums1, target1)));
        System.out.println(Arrays.toString(TwoSum.bruteForceSolution(nums2, target2)));
        System.out.println(Arrays.toString(TwoSum.bruteForceSolution(nums3, target3)));
        System.out.println();

        System.out.println(Arrays.toString(TwoSum.twoPassHashTableSolution(nums1, target1)));
        System.out.println(Arrays.toString(TwoSum.twoPassHashTableSolution(nums2, target2)));
        System.out.println(Arrays.toString(TwoSum.twoPassHashTableSolution(nums3, target3)));
        System.out.println();

        System.out.println(Arrays.toString(TwoSum.onePassHashTableSolution(nums1, target1)));
        System.out.println(Arrays.toString(TwoSum.onePassHashTableSolution(nums2, target2)));
        System.out.println(Arrays.toString(TwoSum.onePassHashTableSolution(nums3, target3)));
        System.out.println();
    }
}