import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
//frequency
// of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
// 
//
//Example 1:
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//Example 2:
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//Example 3:
//
//Input: candidates = [2], target = 1
//Output: []


public class Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> sublist = new ArrayList<>();
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(0, candidates, target, sublist, list);
		return list;
	}
	public void dfs (int s, int[] arr, int target, List<Integer> sublist, List<List<Integer>> list)
	{
		if (target < 0) {
			return;
		}
		if (target == 0) {
			list.add(new ArrayList<>(sublist));
			return;
		}
		for (int i = s; i < arr.length; i++) {
			sublist.add(arr[i]);
			dfs(i, arr, target - arr[i], sublist, list);
			sublist.remove(sublist.size() -1);
		}
	}
	
	public static void main(String[] args)
	{
		Combination_Sum cs = new Combination_Sum();
		int[] arr = {2, 3, 6, 7};
		int target = 8;
		System.out.println(cs.combinationSum(arr, target));
	}
}
