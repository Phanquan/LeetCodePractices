package practices;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    /**
     * The brute force approach is simple. Loop through each element xxx and find if there is another value that equals to target−x.
     *
     * @param nums   array of numbers
     * @param target equal to sum of 2 elements in nums array
     * @return array of index of those 2 elements in the array
     */
    public static int[] bruteForceSolution(final int[] nums, final int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TwoSum.bruteForceSolution(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(TwoSum.bruteForceSolution(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(TwoSum.bruteForceSolution(new int[]{3, 3}, 6)));
    }
}