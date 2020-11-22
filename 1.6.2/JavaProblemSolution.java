import java.util.Arrays; import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

public class JavaProblemSolution{
    interface Markable{
        void mark(int r,int c);
    }
	//Minesweeper 
	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int row =  scanner.nextInt();
        int col =  scanner.nextInt();
        ArrayList<char[][]> fields = new ArrayList<>();
        while( row > 0 && col > 0 ){

            fields.add(solve(readField(row,col)));
            System.out.println("------");
            row =  scanner.nextInt();
            col =  scanner.nextInt();
        }
        int count = 0;
        for(char[][] field: fields){
            System.out.println("\nField #"+ ++count + ":");
            printField(field);
        }
    }

    public static void printField(char[][] field){
        for(char[] col: field){
            System.out.println(new String(col));
        }
    }
    public static char[][] readField(int row, int col){
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[row][col];
        for(int i = 0; i < row; ++i){
            String line  = scanner.nextLine();
            field[i] = line.toCharArray();
        }
        return field;
    }
	private static char[][] solve(char[][] field){
        int[][] result  = sweep(field);
        for(int k = 0; k < field.length;++k){
            for(int n = 0; n < field[0].length; ++n){
                char c = field[k][n];
                if(c != '*'){
                    field[k][n] = Character.forDigit(result[k][n],10);
                }
            }
        }
        return field;
    }
    private static int[][] sweep(char[][] field){
        int i = field.length;
        int j = field[0].length;
        char mine = '*';
        int[][] counter = new int[i][j];
        
        for(int r = 0; r < i ; ++r){
            for(int c = 0; c < j; ++c){
                if(field[r][c] == mine){
                    Markable m = (row,col)->{
                        if( row  >=0 && col >= 0 &&
                            row < i &&  col < j &&
                            field[row][col] != mine){
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
    private static char[ ][] getField(int i, int j){
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[i][j];
        for(int k = 0; k < i; ++k ){ 
            String line = scanner.nextLine();
            field[k] = line.substring(0,j).toCharArray();
        }
        return field;
    }
}
