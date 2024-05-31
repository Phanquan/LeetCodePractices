# Leet Code Practices

Practices with LeetCode.


---

## [Two Sum](https://leetcode.com/problems/two-sum/description/)

### Description

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to
target.
You may assume that each input would have **exactly one solution**, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

- Input: nums = [2,7,11,15], target = 9
- Output: [0,1]
- Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

- Input: nums = [3,2,4], target = 6
- Output: [1,2]

Example 3:

- Input: nums = [3,3], target = 6
- Output: [0,1]

### Editorial

#### Brute Force:

The brute force approach is simple. Loop through each element xxx and find if there is another value that equals to
target−x.

- Time: O(n^2)
- Space: O(1)

Pseudocode:

```{r, tidy=FALSE, eval=FALSE, highlight=FALSE }
Loop through nums array with index = i, start at 0
    Loop through nums array with index = j, start at i
        Init complement = target - current value of nums array at j
        Check if current value at i equals to complement:
            if true, then return result array of [i,j]
            if false, continue
return empty array at the end
```

#### Two Pass Hask Table

This solution is about extracting the nested loop and using Map instead, reduce the complexity of the function.

- Time: O(n)
- Space: O(n)

Pseudocode:

```
Init Map<int, int> numsMap
Loop through nums array, with index = i, start at 0
    add key = nums[i], value = i to numsMap
Loop through nums array, with index = i, start at 0
    Init complement = target - nums[i] (current value of nums)
    Check if numsMap[complement] is not null AND numsMap[complement] != i (not the current one)
        if true, return array of [i, numsMap[complement]]
return empty array at the end
```

#### One Pass Hask Table

This solution is the same as above two pass hash table, but we can combine init numsMap within the loop through nums
array, remove 1 additional loop.

- Time: O(n)
- Space: O(n)

Pseudocode:

```
Init Map<int, int> numsMap
Loop through nums array, with index = i, start at 0
    Init complement = target - nums[i] (current value of nums)
    Check if numsMap[complement] is not null
        if true, return array of [i, numsMap[complement]]
    Remember to put item to map each loop, with key = nums[i], value = i
return empty array at the end
```

---

## [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)

### Description

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse
order**,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list. You may assume
the two numbers do not contain any leading zero, except the number 0 itself.

Example: From l1 and l2, create new linked list, each element equals to the sum of elements of same index from l1, l2.
if sum is gt 10, take the digit and move the carry to next index.
4 + 6 = 10 => result = 0 and take carry = 1 to 3 + 4 + carry = 8

- l1: 2 -> 4 -> 3
- l2: 5 -> 6 -> 4
- ls: 7 -> 0 -> 8

Example:

- l1: 0
- l2: 0
- ls: 0

Example: Like above, the carry applied to null value (count as 0), also create new value = carry in the end of ls.

- l1: 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
- l2: 9 -> 9 -> 9 -> 9
- ls: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1

### Editorial

Just like how you would sum two numbers on a piece of paper, we begin by summing the least-significant digits, which is
the head of `l1` and `l2`. Since each digit is in the range of `0…90`, summing two digits may "overflow".
For example `5+7=12`. In this case, we set the current digit to `2` and bring over the `carry=1` to the next
iteration. `carry` must be either `0` or `1` because the largest possible sum of two
digits (including the carry) is `9+9+1=19`.

- Time: O(n)
- Space: O(1)

Pseudocode:

```text
Initialize current node to dummy head of the returning list.
Initialize carry to 000.
Loop through lists l1 and l2 until you reach both ends and carry is 000.
    Set xxx to node l1's value. If l1 has reached the end of l1, set to 0.
    Set yyy to node l2's value. If l2 has reached the end of l2, set to 0.
    Set sum=x+y+carry.
    Update carry=sum/10.
    Create a new node with the digit value of (sum % 10) and set it to current node's next, then advance current node to next.
    Advance both l1 and l2.
Return dummy head's next node.
```

Note that we use a dummy head to simplify the code. Without a dummy head, you would have to write extra conditional
statements to initialize the head's value.

Take extra caution of the following cases:

| Test case                   | Explanation                                                                  |
|-----------------------------|------------------------------------------------------------------------------|
| l1 = [0,1]<br/>l2 = [0,1,2] | When one list is longer than the other.                                      |
| l1 = []<br/>l2 = [0,1]      | When one list is null, which means an empty list.                            |
| l1 = [9,9]<br/>l2 = [1]     | The sum could have an extra carry of one at the end, which is easy to forget |

---