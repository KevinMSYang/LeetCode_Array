//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints 
//of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
//
//Example 1:
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, 
//the max area of water (blue section) the container can contain is 49.
//
//Example 2:
//Input: height = [1,1]
//Output: 1

public class Container_With_Most_Water 
{
	public int maxArea(int[] height)
	{
		int result = 0;
		for (int i = 0; i < height.length -1; i++)
		{
			for (int j = i+1; j < height.length; j++)
			{
				if (height[i] < height[j])
				{
					if (result < (height[i] * (j-i)))
					{
						result = height[i] * (j-i);
					}
				}
				else
				{
					if (result < (height[j] * (j-i)))
					{
						result = height[j] * (j-i);
					}
				}
			}
		}
		
		return result;
	}
	
//	public int maxArea(int[] height) {
//	    int ans = 0;
//	    int l = 0;
//	    int r = height.length - 1;
//
//	    while (l < r) {
//	      final int minHeight = Math.min(height[l], height[r]);
//	      ans = Math.max(ans, minHeight * (r - l));
//	      if (height[l] < height[r])
//	        ++l;
//	      else
//	        --r;
//	    }
//
//	    return ans;
//	  }
	
	public static void main(String[] args)
	{
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		Container_With_Most_Water cwmw = new Container_With_Most_Water();
		System.out.println(cwmw.maxArea(height));
	}
}
