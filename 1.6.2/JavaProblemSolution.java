import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class JavaProblemSolution{
	//Minesweeper 
	public static void main(String[] args){
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		solution(i,j);
	}
	private static void solution(int i, int j){
        char[][] grid = getGrid(i,j);

	}
    private static char[][] getGrid(int i, int j){
		char[][] grid  = new char[i][j];
        Scanner scanner = new Scanner(System.in);
        //fill the gird
        for(int k = 0; k < i; ++k ){
            String line = scanner.nextLine();
            grid[k] = line.substring(0,j).toCharArray();
        }
        return grid;

    }
}
