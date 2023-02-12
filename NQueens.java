import java.util.*;
public class NQueens
{
	private boolean[][] a;
	private int n;

	public NQueens(int n2)
	{
		n = n2;
		a = new boolean[n][n];
	
		// Initialize all to false
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				a[i][j] = false;
			}
		}
	}

	public int checkrow(int r)
	{
		int solutions = 0;	
		if (r == n)
		{
			solutions++;
			return solutions;
		}
		for (int c = 0; c < n; c++)
		{
			if (canPutQueen(r, c) == true)
			{
				a[r][c] = true;
				solutions += checkrow(r + 1);
				a[r][c] = false;
			}
		}
		return solutions;
	}

	public boolean canPutQueen(int r, int c)
	{
		// Column...
		for (int i = r; i >= 0; i--)
		{
			if (a[i][c] == true)
			{
				return false;
			}
		}

		//Row...
		for (int i = c; i >= 0; i--)
		{
			if (a[r][i] == true)
			{
				return false;
			}
		}

		// Left diagonal...
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
		{
			if (a[i][j] == true)
			{
				return false;
			}
		}

		// Right diagonal...
		for (int i = r, j = c; i >= 0 && j < n; i--, j++)
		{
			if (a[i][j] == true)
			{
				return false;
			}
		}
		
		return true;
	}

	public void clear()
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				a[i][j] = false;
			}
		}
	}
	
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the number of queens: ");
		int n = kb.nextInt();
		NQueens queen = new NQueens(n);
		System.out.println("The number of valid arrangements is " + queen.checkrow(0));
	}

}
