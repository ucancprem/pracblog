package prac;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
	boolean isWord;
	char c;
	Map<Character, TrieNode> children = new HashMap<>();
	
	public TrieNode(char c){
		this.c = c;
	}
}

public class Trie {
	
	public void insert(TrieNode root, String word){
		TrieNode child = root;
		//System.out.println(root);
		if(word == null || word.trim().length() == 0|| root == null)
			return;
		else {
			for(char ch : word.toCharArray()){
				if(child!=null && child.children!=null && child.children.get(ch)!=null) {
					System.out.println("already exists");
					child = child.children.get(ch);
				}
				else {
					System.out.println("Adding "+ch);
					TrieNode addCharNode = new TrieNode(ch);
					Map<Character, TrieNode> currChildren = child.children;
					currChildren.put(ch, addCharNode);
					child = addCharNode;
				}
			}

		}
		child.isWord=true;
		
	}
	
	public void search(TrieNode root, String word){
		
		TrieNode currNode = searchNode(root,word);
		if(currNode!=null && currNode.isWord)
			System.out.println("Found "+word);
		else
			System.out.println("Not a complete word ");
		
		
	}
	
	public void startsWithPrefix(TrieNode root, String word){
		
		TrieNode currNode = searchNode(root,word);
		if(currNode!=null)
			System.out.println("Prefix Found "+word);
		else
			System.out.println("Not a prefix ");
		
		
	}
	
	private TrieNode searchNode(TrieNode root, String word){
		TrieNode currNode = root;
		
		if(word == null || word.trim().length() == 0|| root == null)
			return null;
		else {
			for(char ch : word.toCharArray()){
				if(currNode!=null && currNode.children!=null && currNode.children.get(ch)!=null){
					currNode = currNode.children.get(ch);
					
				} else {
					System.out.println("Word not found, longest char ->"+currNode.c);
					return null;
				}	
			}
		}	
		return currNode;
	}	
	
	public static void main(String[] args) {
		Trie trie = new Trie();

		TrieNode root = new TrieNode('_');
		trie.insert(root, "prem");
		trie.insert(root, "prem");
		trie.search(root, "prem");
		trie.search(root, "prep");
		trie.startsWithPrefix(root, "pre");
	}
}
