//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//Example 2:
//
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//Example 3:
//
//Input: nums = [1,3,5,6], target = 7
//Output: 4


public class Search_Insert_Position 
{
	public int searchInsert(int[] nums, int target)
	{
		return search(nums, target, 0, nums.length-1);
	}
	
	public int search(int[] nums, int target, int l, int r)
	{
		int m = (l + r) / 2;
		if (nums[m] == target)
		{
			return m;
		}
		if (l >= 0 && r <= nums.length && m >= l && m <= r)
		{
			if (nums[m] > target)
			{
				if (l == r)
				{
					if (l == 0)
					{
						return 0;
					}
					else
					{
						return m-1;
					}
				}
				else
				{
					m = search(nums, target, l, m-1);
				}
			}
			else 
			{
				if (l == r)
				{
					return m+1;
				}
				else
				{
					m = search(nums, target, m+1, r);
				}	
			}
		}
		return m;
	}
	
	public static void main(String[] args)
	{
		Search_Insert_Position sip = new Search_Insert_Position();
		int[] arr = {1, 3};
		int target = 0;
		System.out.println(sip.searchInsert(arr, target));
	}
}
