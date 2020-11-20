import java.util.ArrayList;
public class JavaProblemSolution{
	//The 3n +1 Problem
	public static void main(String[] args){
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		solution(i,j);
	}
	private static void solution(int i, int j){
		int largestSeq = 0;
		int seqLen;
		int k = i;
		while(k <= j){
			seqLen = 1;
			int n = k;
			while(n !=  1){
				n = n % 2 == 0 ?  n/2 : 3*n+ 1 ;
				++seqLen;
			}
			if(largestSeq < seqLen){
				largestSeq = seqLen;
			}
			++k;
		}
		System.out.printf("%s %s %s\n",i,j,largestSeq);
	}
}
