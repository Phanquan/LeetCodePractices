from typing import List


def brute_force(nums: List[int], target: int) -> List[int]:
    n = len(nums)

    for i in range(n):
        for j in range(i + 1, n):
            complement = target - nums[j]
            if nums[i] == complement:
                return [i, j]

    return []


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


def one_pass_hash_table(nums: List[int], target: int) -> List[int]:
    n = len(nums)
    num_map = {}

    for i in range(n):
        complement = target - nums[i]
        if complement in num_map:
            return [num_map[complement], i]
        num_map[nums[i]] = i

    return []


if __name__ == "__main__":
    nums1 = [2, 7, 11, 15]
    target1 = 9
    nums2 = [3, 2, 4]
    target2 = 6
    nums3 = [3, 3]
    target3 = 6

    print(brute_force(nums1, target1))
    print(brute_force(nums2, target2))
    print(brute_force(nums3, target3))
    print()

    print(two_pass_hash_table(nums1, target1))
    print(two_pass_hash_table(nums2, target2))
    print(two_pass_hash_table(nums3, target3))
    print()

    print(one_pass_hash_table(nums1, target1))
    print(one_pass_hash_table(nums2, target2))
    print(one_pass_hash_table(nums3, target3))
    print()
