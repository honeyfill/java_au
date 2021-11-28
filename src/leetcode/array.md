# Array
<!----->

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

## Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int current = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if (nums[left]*nums[left] < nums[right]*nums[right]) {
                ans[current] = nums[right] * nums[right];
                right--;
            }else{
                ans[current] = nums[left] * nums[left];
                left++;
            }
            current--;
        }
        return ans;
    }
}
```