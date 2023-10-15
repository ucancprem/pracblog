package prac.recursion.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Consider n boxes of different widths (w1...n), heights (h1...n), and colors (c1...n). 
 * Find the highest tower of boxes that respects the following conditions:
	You cannot rotate the boxes.
	You cannot place two successive boxes of the same color.
	Each box is strictly larger than the box above it in terms of their width and height
 * 
 * <img src="images/highest_colored_tower..png"/> </br>
 */
enum Color {
	RED,
	YELLOW,
	PURPLE
}

class Box {
	private int width;
	private int height;
	private Color color;
	
	public Box(int width, int height, Color color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(%s,%s,%s)", width, height, color);
	}
}

public class HighestColoredTowerWithoutMemoization {

	private static boolean canStackBox(Box baseBox, Box boxInConsideration){
		if(boxInConsideration.getColor().equals(baseBox.getColor())){
			return false;
		}
		if(boxInConsideration.getWidth() >= baseBox.getWidth() || boxInConsideration.getHeight() >= baseBox.getHeight()){
			return false;
		}
		return true;	
	}
	
	private static int calculateHeight(List<Box> boxes, int baseBoxIndex, int height){		
		int prevHeight = Integer.MIN_VALUE;
		for (int i = baseBoxIndex+1; i < boxes.size(); i++) {
			if(canStackBox(boxes.get(baseBoxIndex), boxes.get(i))){
				prevHeight = Integer.max(prevHeight, height + boxes.get(i).getHeight());
				calculateHeight(boxes, i, prevHeight);	
			} else {
				continue;
			}
		}
		return prevHeight;
	}
	
	private static int calHighestTower(List<Box> boxes){
		
		int prevMaxHeight = Integer.MIN_VALUE;
		for (int i = 0; i < boxes.size(); i++) {
			int height= calculateHeight(boxes, i, boxes.get(i).getHeight());
			prevMaxHeight = Integer.max(prevMaxHeight, height);
		}
		
		return prevMaxHeight;
	}
	
	private static void sortBoxesInDesendingOrder(List<Box> boxes) {
		Collections.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				return Integer.compare(o2.getWidth(), o1.getWidth());
			}
		});
	}
	
	public static void main(String[] args) {
		List<Box> boxes = Arrays.asList(  //List.of is available only in java 9 or later.				
				new Box(2,8, Color.PURPLE),
				new Box(14,10, Color.RED),
				new Box(5,7, Color.PURPLE),
				new Box(10,7, Color.PURPLE),
				new Box(10,5, Color.YELLOW),
				new Box(10,3, Color.PURPLE),
				new Box(7,5, Color.PURPLE)
				);
				
		sortBoxesInDesendingOrder(boxes);	
		System.out.println(String.format("Max stackable height is (%s)",calHighestTower(boxes)));
	}

}
