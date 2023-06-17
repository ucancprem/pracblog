package prac;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boggle {
	
	static int M;
	static int N;
	
	private static boolean valid(int i, int j, boolean[][] visited){
		//System.out.println("checking "+i+","+j);
		if(i < 0 || i >= M || j < 0 || j >= N || visited[i][j] == true)
			return false;
		return true;
	}

	private static void searchAdjacent(char[][] board,List<String> words, int i, int j,boolean[][] visited, String knownWord){
		
		int[] rows = {-1,-1,-1,0,0,1,1,1};
		int[] cols = {-1,0,1,-1,1,-1,0,1};
		
		knownWord = knownWord+ board[i][j];
		visited[i][j] = true;
		if(words.contains(knownWord))
			System.out.println("Found word in dictionary "+knownWord);
			
		for(int k=0; k < rows.length; k++) {
			if(valid(i+rows[k], j+cols[k], visited)) {
				searchAdjacent(board, words, i+rows[k], j+cols[k], visited, knownWord);
			}
		}
		visited[i][j] = false;
	}
	
	private static void searchBoggle(char[][] board,List<String> words){
		M = board.length;
		N = board[0].length;
		boolean[][] visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				
				searchAdjacent(board, words, i,j, visited, "");
			}
		}	
		
	}
	
	public static void main(String[] args)
	{
		Map<String, Integer> test = new HashMap<>();
		test.put("one",1);
		test.put("two",2);
		System.out.println(test);
		
		char[][] board =
		{
			{'M', 'S', 'E', 'F'},
			{'R', 'A', 'T', 'D'},
			{'L', 'O', 'N', 'E'},
			{'K', 'A', 'F', 'B'}
		};

		List<String> words = Arrays.asList("START", "NOTE", "SAND", "STONED");
		searchBoggle(board, words);
		
		
		
		
	}
}
