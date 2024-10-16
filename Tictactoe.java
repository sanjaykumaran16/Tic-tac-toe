import java.util.*;
import java.io.*;

public class Tictactoe
{
	static HashSet<Integer> ur_set = new HashSet<Integer>();
	static HashSet<Integer> comp_set = new HashSet<Integer>();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args)
	{
		char[][] g_board={{' ','|',' ','|',' '},{'-','|','-','|','-'},{' ','|',' ','|',' '},{'-','|','-','|','-'},{' ','|',' ','|',' '}};
		print_board(g_board);
		
		while(true)
		{
			System.out.println("Enter a number : ");
			int user_pos=scan.nextInt();
			while(ur_set.contains(user_pos)||comp_set.contains(user_pos))
			{
				System.out.println();
				System.out.println("RETRY ! Enter a number : ");
				user_pos=scan.nextInt();
			}
			place_holder(g_board,user_pos,"You");

			String res=check_winner();
			if(res.length()>0)
			{
				System.out.println(res);
				break;
			}

			int comp_pos=gen_random();
			while(ur_set.contains(comp_pos)||comp_set.contains(comp_pos))
			{
				
				comp_pos=gen_random();
			}
			place_holder(g_board,comp_pos,"COM");
			res=check_winner();
			if(res.length()>0)
			{
				System.out.println(res);
				break;
			}

		}
	}

	static String check_winner()
	{
		HashSet<Integer> r1 = new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		HashSet<Integer> r2 = new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		HashSet<Integer> r3 = new HashSet<Integer>();
		r3.add(7);r3.add(8);r3.add(9);
		HashSet<Integer> r4 = new HashSet<Integer>();
		r4.add(1);r4.add(4);r4.add(7);
		HashSet<Integer> r5 = new HashSet<Integer>();
		r5.add(2);r5.add(5);r5.add(8);
		HashSet<Integer> r6 = new HashSet<Integer>();
		r6.add(3);r6.add(6);r6.add(9);
		HashSet<Integer> r7 = new HashSet<Integer>();
		r7.add(1);r7.add(5);r7.add(9);
		HashSet<Integer> r8 = new HashSet<Integer>();
		r8.add(3);r8.add(5);r8.add(7);

		HashSet<HashSet> set = new HashSet<HashSet>();
		set.add(r1);
		set.add(r2);
		set.add(r3);
		set.add(r4);
		set.add(r5);
		set.add(r6);
		set.add(r7);
		set.add(r8);

		for(HashSet c:set)
		{
			if(ur_set.containsAll(c))
				return " YOU WON !!!! ";
			if(comp_set.containsAll(c))
				return " YOU LOST :( ";
		}
		if(ur_set.size()+comp_set.size()==9)
				return "DRAW";
			else
				return "";

	}



	static int gen_random()
	{
		int max=9;
		int min=1;
		int range=max-min+1;
		int res=(int)(Math.random()*range)+min;
		return res;
	}
	static void print_board(char[][] g_board)
	{
		for(int i=0;i<g_board.length;i++)
		{
			for(int j=0;j<g_board[0].length;j++)
			{
				System.out.print(g_board[i][j]);
			}
			System.out.println();
		}

	}
	

	static void place_holder(char[][] g_board,int pos,String user)
	{
		char sy='X';
		if(user.equals("You"))
		{
			sy='X';
			ur_set.add(pos);
		}
		else if(user.equals("COM"))
		{
			sy='O';
			comp_set.add(pos);
		}
		switch(pos)
		{
			case 1:
			{
				g_board[0][0]=sy;
				break;
			}
		case 2:
			{
				g_board[0][2]=sy;
				break;
			}case 3:
			{
				g_board[0][4]=sy;
				break;
			}case 4:
			{
				g_board[2][0]=sy;
				break;
			}case 5:
			{
				g_board[2][2]=sy;
				break;
			}case 6:
			{
				g_board[2][4]=sy;
				break;
			}case 7:
			{
				g_board[4][0]=sy;
				break;
			}case 8:
			{
				g_board[4][2]=sy;
				break;
			}case 9:
			{
				g_board[4][4]=sy;
				break;
			}
		default:
			System.out.println("Invalid number");
		}
		print_board(g_board);
	}
}
