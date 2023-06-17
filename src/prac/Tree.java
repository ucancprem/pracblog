package prac;

public class Tree {
	
	public Tree leftChild;
	public Tree RightChild;
	public int data;
	
	public Tree(Tree leftChild, Tree rightChild, int data) {
		super();
		this.leftChild = leftChild;
		RightChild = rightChild;
		this.data = data;
	}
	
	private void insert(int data, Tree head){
		if(head == null){
			new Tree(null, null, data);
		}
		else{
			if(data < this.data ){
				if(leftChild!= null)
					leftChild.insert(data, this);
				else {
					Tree temp =  new Tree(null, null, data);
					this.leftChild = temp;
				}
					
			}
			else {
				if(RightChild!= null)
					RightChild.insert(data, this);
				else {
					Tree temp =  new Tree(null, null, data);
					this.RightChild = temp;
				}
					
			}
		}
			
	}
	
	
	
}
