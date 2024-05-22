//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//Example 2:
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum 
{
	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		Arrays.sort(nums);
		List<List<Integer>> listoflists = new ArrayList<>();
		
		
		for (int i = 0; i < nums.length -3 ; i++)
		{
			for (int j = i + 1; j < nums.length -2; j++)
			{
				
				int c = j + 1;
				int d = nums.length -1;
				while ( c < d)
				{
					List<Integer> list = new ArrayList<>();
			
					long sum = (long)nums[i] + (long)nums[j] + (long)nums[c] + (long)nums[d];
					if(sum == target)
					{
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[c]);
						list.add(nums[d]);
						if (!listoflists.contains(list))
						{
							listoflists.add(list);
						}
						
					}
					if (sum < target)
					{
						c++;
					}
					else
					{
						d--;
					}
				}
			}
		}
		return listoflists;
	}
	
//	public List<List<Integer>> fourSum(int[] nums, int target) {
//	    List<List<Integer>> ans = new ArrayList<>();
//	    Arrays.sort(nums);
//	    nSum(nums, 4, target, 0, nums.length - 1, new ArrayList<>(), ans);
//	    return ans;
//	  }
//
//	  // Finds n numbers that add up to the target in [l, r].
//	  private void nSum(int[] nums, long n, long target, int l, int r, List<Integer> path,
//	                    List<List<Integer>> ans) {
//	    if (r - l + 1 < n || target < nums[l] * n || target > nums[r] * n)
//	      return;
//	    if (n == 2) {
//	      // Similar to the sub procedure in 15. 3Sum
//	      while (l < r) {
//	        final int sum = nums[l] + nums[r];
//	        if (sum == target) {
//	          path.add(nums[l]);
//	          path.add(nums[r]);
//	          ans.add(new ArrayList<>(path));
//	          path.remove(path.size() - 1);
//	          path.remove(path.size() - 1);
//	          ++l;
//	          --r;
//	          while (l < r && nums[l] == nums[l - 1])
//	            ++l;
//	          while (l < r && nums[r] == nums[r + 1])
//	            --r;
//	        } else if (sum < target) {
//	          ++l;
//	        } else {
//	          --r;
//	        }
//	      }
//	      return;
//	    }
//
//	    for (int i = l; i <= r; ++i) {
//	      if (i > l && nums[i] == nums[i - 1])
//	        continue;
//	      path.add(nums[i]);
//	      nSum(nums, n - 1, target - nums[i], i + 1, r, path, ans);
//	      path.remove(path.size() - 1);
//	    }
//	  }
	
	public static void main(String[] args)
	{
		Four_Sum foursum = new Four_Sum();
		int[] nums = {1000000000, 1000000000, 100000000, 100000000};
		int target = -294967296;
		System.out.println(foursum.fourSum(nums, target));
		
	}
}
