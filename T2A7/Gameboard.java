public class Gameboard
{
	public char[][] board = new char[8][8];
	public Gameboard(boolean setup)
	{
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				board[i][j] = '-';
		if(setup) {
			for (int i = 0; i < board.length; i++)
			{
				for (int j = 0; j < board[i].length; j++)
				{
					if (XOR((i % 2) != 0, (j % 2) != 0))
					{
						if (i < 3)
							board[i][j] = 'r';
						if (i > 4)
							board[i][j] = 'w';
					}
				}
			}
		}
	}
	public static boolean XOR(boolean x, boolean y)
	{
		return ((x || y) &&! (x && y));
	}

	public boolean isRed(int x, int y)
	{
		return (board[x][y] == 'r');
	}

	public boolean isWhite(int x, int y)
	{
		return (board[x][y] == 'w');
	}
	/*
	a is left possible
	b is right possible
	 */
	public char edge(int y, char colour)
	{
		char temp = ' ';
		if(colour == 'w')
		{
			if(y == 0)
				temp = 'a';
			if(y == 7)
				temp = 'b';
		}
		if(colour == 'r')
		{
			if(y == 7)
				temp = 'a';
			if(y == 0)
				temp = 'b';
		}
		return temp;
	}

	boolean move(int x, int y, boolean left)
	{
		boolean temp = true;
		if(board[x][y] != '-')
		{
			jump(x, y);
			if(left)
			{
				if(isRed(x, y) && (edge(y, 'r') == 'a'))
				{
					board[x][y] = '-';
					board[x + 1][y + 1] = 'r';
				}
				else if(!isRed(x, y) && (edge(y, 'w') == 'a'))
				{
					board[x][y] = '-';
					board[x - 1][y - 1] = 'w';
				}
				else
					temp = false;
			}
			if(!left)
			{
				if(isRed(x, y) && (edge(y, 'r') == 'b'))
				{
					board[x][y] = '-';
					board[x + 1][y - 1] = 'r';
				}
				else if(!isRed(x, y) && (edge(y, 'w') == 'b'))
				{
					board[x][y] = '-';
					board[x - 1][y + 1] = 'w';
				}
				else
					temp = false;
			}
		}
		return temp;
	}

	boolean jump(int x, int y)
	{
		boolean temp = false;
		if(board[x][y] != '-')
		{
			if(isWhite(x, y))
			{
				if(edge(y, 'w') == 'a')
				{
					board[x][y] = '-';
					board[x - 1][y - 1] = '-';
					board[x - 2][y - 2] = 'w';
					temp = true;
					jump(x - 2, y - 2);
				}
				else if(edge(y, 'w') == 'b')
				{
					board[x][y] = '-';
					board[x - 1][y + 1] = '-';
					board[x - 2][y + 2] = 'w';
					temp = true;
					jump(x - 2, y + 2);
				}
			}
			else if(isRed(x, y))
			{
				if(edge(y, 'r') == 'a')
				{
					board[x][y] = '-';
					board[x + 1][y + 1] = '-';
					board[x + 2][y + 2] = 'r';
					temp = true;
					jump(x + 2, y + 2);
				}
				else if(edge(y, 'r') == 'b')
				{
					board[x][y] = '-';
					board[x + 1][y - 1] = '-';
					board[x + 2][y - 2] = 'r';
					temp = true;
					jump(x + 2, y - 2);
				}
			}
		}
		return temp;
	}

	boolean kingMe(int x, int y)
	{
		if(board[x][y] != '-')
		{
			board[x][y] = Character.toUpperCase(board[x][y]);
			return true;
		}
		else
			return false;
	}

	public String toString()
	{
		String temp = "";
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				temp += board[i][j] + " ";
			}
			temp += "\n";
		}
		return temp;
	}
}
