//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

public class Two_Sum 
{
	public int[] twoSum(int[] nums, int target)
	{
		int[] result = new int[2];
		if (nums.length >= 2)
		{
			for (int i = 0; i < nums.length -1; i++)
			{
				for (int j = i + 1; j < nums.length; j++)
				{
					if ( nums[i] + nums[j] == target)
					{
						result[0] = i;
						result[1] = j;
						return result;
					}
				}
			}
		}
		return result;
	}
	
//	public int[] twoSum(int[] nums, int target) {
//	    Map<Integer, Integer> numToIndex = new HashMap<>();
//
//	    for (int i = 0; i < nums.length; ++i) {
//	      if (numToIndex.containsKey(target - nums[i]))
//	        return new int[] {numToIndex.get(target - nums[i]), i};
//	      numToIndex.put(nums[i], i);
//	    }
//
//	    throw new IllegalArgumentException();
//	  }
	
	public static void main(String[] args)
	{
		Two_Sum twosum = new Two_Sum();
		
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(twosum.twoSum(nums, target).toString());
	}
}
