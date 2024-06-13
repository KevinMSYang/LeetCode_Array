import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
//
// 
//
//Example 1:
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//Example 2:
//
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]


public class Combination_Sum_II {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<Integer> sublist = new ArrayList<>();
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(0, candidates, target, sublist, list);
		return list;
	}
	public void dfs(int s, int[] arr, int target, List<Integer> sublist, List<List<Integer>> list)
	{
		if (target < 0)
		{
			return;
		}
		if (target == 0)
		{
			if (!list.contains(sublist)) 
			{
				System.out.println("add : " + sublist);
				list.add(new ArrayList<>(sublist));
			}
		}
		for (int i = s; i < arr.length; i++)
		{
			if (arr[i] > target)
			{
				return;
			}
			if (i > s && arr[i] == arr[i-1])
			{
				continue;
			}
			sublist.add(arr[i]);
			System.out.println("current : " + sublist + " i = " + i + " s = " + s);
			dfs(i +1, arr, target - arr[i], sublist, list);
			System.out.println("after : " + sublist);
			sublist.remove(sublist.size() -1);
			System.out.println("resize : " + sublist);
		}
	}
	
	public static void main(String[] args)
	{
		Combination_Sum_II cs = new Combination_Sum_II();
		int[] arr = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		System.out.println(cs.combinationSum2(arr, target));
	}
	
	
}
