package prac.recursion.dp;

/**
 * For n=1: Having a single disk, we need to move one disk from rod A to C.
 * 
 * For n=2: We know how to move a single disk. To move two, we need to complete the following steps:
 * Move disk 1 from A to B (rod B acts as an intermediate for disk 1).
 * Move disk 2 from A to C (disk 2 goes directly in its final place).
 * Move disk 1 from B to C (disk 1 can be moved on top of disk 2 on rod C).
 * 
 * For n=3
 * Due to n=2, we know how to move the top two disks from A (origin) to C (target). 
 * In other words, we know how to move the top two disks from one rod to another rod. Let's move them from A to B, as follows
 * Move disk 1 from A to C (this time, we use C as the intermediate).
 * Move disk 2 from A to B.
 * Move disk 1 from C to B.
 * OK, so this is something that we've done before. Next, we can move disks 2 and 3 onto C, as follows:
 * Move disk 3 from A to C.
 * Move disk 1 from B to A (we use A as the intermediate).
 * Move disk 2 from B to C.
 * Finally, move disk 3 from A to C.
 * 
 * Continuing with this logic, we can see that we can move four disks because we know how to move three, 
 * we can move five disks because we know how to move four, and so on. 
 * 
 * With rod A as the origin, rod B as the intermediate, and rod C as the target, 
 * we can conclude that we can move n disks by doing the following:
Move the top n - 1 disks from the origin to the intermediate, using the target as an intermediate.
Move the top n - 1 disks from the intermediate to the target, using the origin as an intermediate.
 * 
 * @author premkumarnarayanappavenkatesh
 */
public class TowerOfHanoi {

	private int movedisks(int n, String source, String intermediate, String target, int count){
		
		if(n < 1){
			return count;
		}
		if(n==1){
			count++;
			System.out.println(String.format("(%d) - Moving disk (%d) from (%s, %s)", count, 1, source, target));
			return count;
		}
		count = movedisks(n-1, source, target, intermediate, count);
		count++;
		System.out.println(String.format("(%d) - Moving disk (%d) from (%s, %s)", count, n, source, target));
		count = movedisks(n-1, intermediate, source, target, count);
		return count;
	}
	
	public static void main(String[] args) {
		TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
		int numOfMoves = towerOfHanoi.movedisks(3, "A", "B", "C", 0);
		System.out.println(String.format("Total num of moves - (%d)", numOfMoves));
	}
}
