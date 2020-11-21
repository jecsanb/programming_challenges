import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

public class JavaProblemSolution{
    interface Markable{
        void mark(int r,int c);
    }
	//Minesweeper 
	public static void main(String[] args){
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		solution(i,j);
	}
	private static void solution(int i, int j){
        StringBuilder sb = new StringBuilder();
        char[][] grid = getGrid(i,j);
        int[][] result  = sweep(grid);

        for(int k = 0; k < grid.length;++k){
            for(int n = 0; n < grid[0].length; ++n){
                char c = grid[k][n];
                if(c != '*'){
                    System.out.print(result[k][n]);
                }else{

                    System.out.print('*');
                }
            }
            System.out.println();
        }
	}
    private static int[][] sweep(char[][] grid){
        int i = grid.length;
        int j = grid[0].length;
        char mine = '*';
        int[][] counter = new int[i][j];
        
        for(int r = 0; r < i ; ++r){
            for(int c = 0; c < j; ++c){
                if(grid[r][c] == mine){
                    Markable m = (row,col)->{
                        if( row  >=0 && col >= 0 && row < i &&  col < j && grid[row][col] != mine){
                            counter[row][col] += 1;
                        }
                    };
                    m.mark(r,c+1);
                    m.mark(r,c-1);
                    m.mark(r+1,c);
                    m.mark(r-1,c);
                    m.mark(r+1,c+1);
                    m.mark(r-1,c-1);
                    m.mark(r+1,c-1);
                    m.mark(r-1,c+1);
                }
            }
        }
        return counter;
    }
    private static char[ ][] getGrid(int i, int j){
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[i][j];
        for(int k = 0; k < i; ++k ){ String line = scanner.nextLine();
            grid[k] = line.substring(0,j).toCharArray();
        }
        return grid;
    }
}
