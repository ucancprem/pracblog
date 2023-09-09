package prac;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private int numOfVertices;
	private LinkedList<Integer> vertices[];
	
	public BFS(int numOfVertices){
		this.numOfVertices = numOfVertices;
		vertices = new LinkedList[numOfVertices];
		
		for(int i=0; i < numOfVertices; i++){
			vertices[i] = new LinkedList<Integer>();
		}
	}
	
	private void addEdge(int index, int edgeTo){
		vertices[index].add(edgeTo);
	}
	
	private void traverse(int root){
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[numOfVertices];
		queue.offer(root);
		visited[root] = true;
		while(queue.peek()!=null){
			int nextEle = queue.poll();
			
				System.out.println(nextEle);
				for(int ele: vertices[nextEle]){
					if(visited[ele] == false){
					queue.offer(ele);
					visited[ele] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		BFS bfs = new BFS(4);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);
        int startVertex = 2;
        System.out.println(String.format("Breadth First Traversal (starting from vertex [%d])", startVertex));
        bfs.traverse(startVertex);
	}
	
}
