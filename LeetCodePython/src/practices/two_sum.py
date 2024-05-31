from typing import List


class TwoSum:
    @staticmethod
    def brute_force_solution(nums: List[int], target: int) -> List[int]:
        n = len(nums)

        for i in range(n):
            for j in range(i + 1, n):
                complement = target - nums[j]
                if nums[i] == complement:
                    return [i, j]

        return []

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
