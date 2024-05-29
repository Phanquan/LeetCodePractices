from typing import List

"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to t
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
"""


class TwoSum:
    """
    The brute force approach is simple. Loop through each element xxx and find if there is another value that equals to target−x.
    Time complexity: O(n^2)
    Space complexity: O(1)
    """

    @staticmethod
    def brute_force_solution(nums: List[int], target: int) -> List[int]:
        n = len(nums)

        for i in range(n):
            for j in range(i + 1, n):
                complement = target - nums[j]
                if nums[i] == complement:
                    return [i, j]

        return []

    """
    This solution is about extracting the nested loop and using Map instead, reduce the complexity of the function.
    Time complexity: O(n)
    Space complexity: O(n)
    """

    @staticmethod
    def two_pass_hash_table(nums: List[int], target: int) -> List[int]:
        n = len(nums)
        num_map = {}

        for i in range(n):
            num_map[nums[i]] = i

        for i in range(n):
            complement = target - nums[i]
            if complement in num_map and num_map[complement] != i:
                return [i, num_map[complement]]

        return []

    """
    This solution is the same as above two pass hash table but removing 1 for loop.
    Time complexity: O(n)
    Space complexity: O(n)
    """

    @staticmethod
    def one_pass_hash_table(nums: List[int], target: int) -> List[int]:
        n = len(nums)
        num_map = {}

        for i in range(n):
            complement = target - nums[i]
            if complement in num_map:
                return [num_map[complement], i]
            num_map[nums[i]] = i

        return []


def main():
    nums1 = [2, 7, 11, 15]
    target1 = 9
    nums2 = [3, 2, 4]
    target2 = 6
    nums3 = [3, 3]
    target3 = 6

    print(TwoSum.brute_force_solution(nums1, target1))
    print(TwoSum.brute_force_solution(nums2, target2))
    print(TwoSum.brute_force_solution(nums3, target3))
    print()

    print(TwoSum.two_pass_hash_table(nums1, target1))
    print(TwoSum.two_pass_hash_table(nums2, target2))
    print(TwoSum.two_pass_hash_table(nums3, target3))
    print()

    print(TwoSum.one_pass_hash_table(nums1, target1))
    print(TwoSum.one_pass_hash_table(nums2, target2))
    print(TwoSum.one_pass_hash_table(nums3, target3))
    print()


if __name__ == "__main__":
    main()
