import java.util.ArrayList;
import java.util.List;
import java.util.*;
//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.


public class Valid_Sudoku 
{
	public boolean isValidSudoku(char[][] board) 
	{
		Set<String> duplic = new HashSet<>();
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if ( board[i][j] == '.')
				{
					continue;
				}
				if (!duplic.add(board[i][j]+"@row"+i) || !duplic.add(board[i][j]+"@col"+j) || !duplic.add(board[i][j]+"@box"+i/3+j/3))
				{
					return false;
				}
			}
		}
		return true;
    }
	
//	  public boolean isValidSudoku(char[][] board) 
//	  {
//		    Set<String> seen = new HashSet<>();
//
//		    for (int i = 0; i < 9; ++i)
//		      for (int j = 0; j < 9; ++j) {
//		        if (board[i][j] == '.')
//		          continue;
//		        final char c = board[i][j];
//		        if (!seen.add(c + "@row" + i) || //
//		            !seen.add(c + "@col" + j) || //
//		            !seen.add(c + "@box" + i / 3 + j / 3))
//		          return false;
//		      }
//
//		    return true;
//	  }
	public static void main(String[] args)
	{
		Valid_Sudoku vs = new Valid_Sudoku();
		char[][] arr = {{'5','3','.','.','7','.','.','.','.'},
						{'6','.','.','1','9','5','.','.','.'},
						{'.','9','8','.','.','.','.','6','.'},
						{'8','.','.','.','6','.','.','.','3'},
						{'4','.','.','8','.','3','.','.','1'},
						{'7','.','.','.','2','.','.','.','6'},
						{'.','6','.','.','.','.','2','8','.'},
						{'.','.','.','4','1','9','.','.','5'},
						{'.','.','.','.','8','.','.','7','9'}};
						
		System.out.println(vs.isValidSudoku(arr));
	}
}
