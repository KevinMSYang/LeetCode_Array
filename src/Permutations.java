//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//Example 2:
//
//Input: nums = [0,1]
//Output: [[0,1],[1,0]]
//Example 3:
//
//Input: nums = [1]
//Output: [[1]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations 
{
	public List<List<Integer>> permute(int[] nums) 
	{
		List<List<Integer>> list = new ArrayList<>();
		int h = nums.length-1;
		permutation(list, nums, 0, h);
		return list;	
	}
	public void permutation(List<List<Integer>> list, int[] nums, int l, int h) {
		if (l == h) 
		{	
			List<Integer> sublist = new ArrayList<>();
			for (int i : nums) 
			{
				sublist.add(i);
			}
			list.add(new ArrayList<Integer>(sublist));
			System.out.println("ADD " + list);
			return;
		}
		
		for (int i = l; i < nums.length; i++)
		{
			System.out.println("current i=" +i + " l="+l);
			swap(nums,l, i);
			print(nums);
			System.out.println("call fun l+1:" + (l+1));
			permutation(list, nums, l+1, h);
			System.out.println("back track: i=" +i + " l=" +l);
			swap(nums, l, i);
			print(nums);
		}
	}

	public int[] swap(int[] nums, int l, int h) 
	{
		int temp = nums[l];
		nums[l] = nums[h];
		nums[h] = temp;
		return nums;
	}
	public void print(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] +",");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Permutations p = new Permutations();
		int[] nums = {1, 2, 3};
		p.permute(nums);
	}
}
