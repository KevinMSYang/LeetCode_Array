//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:
//
//Input: nums = [], target = 0
//Output: [-1,-1]
//


public class Find_First_and_Last_Position_of_Element_in_Sorted_Array 
{
	public int[] searchRange(int[] nums, int target)
	{
		int l = 0;
		int r = nums.length -1;
		int[] result = {-1, -1};
		int index = search(nums, l, r, target);
		if (index == -1)
		{
			return result;
		}
		else
		{
			int i = index;
			while (index < nums.length && nums[index] == target)
			{
				result[1] = index;
				index++;
			}
			while(i >= 0 && nums[i] == target)
			{
				result[0] = i;
				i--;
			}
		}
		return result;
		
	}
	
	public int search(int[] nums, int l, int r, int target)
	{
		int m = (l + r) / 2;
		if (l > r || nums.length == 0)
		{
			return -1;
		}

		if (nums[m] == target)
		{
			return m;
			
		}
		
		if (nums[m] < target)
		{
			return search(nums, m+1, r, target);
		}
		else
		{
			return search(nums, l, m-1, target);
		}
	}
	
//	  public int[] searchRange(int[] nums, int target) {
//		    final int l = firstGreaterEqual(nums, target);
//		    if (l == nums.length || nums[l] != target)
//		      return new int[] {-1, -1};
//		    final int r = firstGreaterEqual(nums, target + 1) - 1;
//		    return new int[] {l, r};
//		  }
//
//		  private int firstGreaterEqual(int[] A, int target) {
//		    int l = 0;
//		    int r = A.length;
//		    while (l < r) {
//		      final int m = (l + r) / 2;
//		      if (A[m] >= target)
//		        r = m;
//		      else
//		        l = m + 1;
//		    }
//		    return l;
//		  }
	
	public static void main(String[] args)
	{
		Find_First_and_Last_Position_of_Element_in_Sorted_Array ds = new Find_First_and_Last_Position_of_Element_in_Sorted_Array();
		int[] arr = {1};
		ds.searchRange(arr, 1);
		
		
	}
}
