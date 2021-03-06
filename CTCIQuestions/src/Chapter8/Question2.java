package Chapter8;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Question2{
	private boolean[][] memo;
	public Question2(){
	}
	
	public List<Point> getPath(boolean[][] grid){
		if(grid ==  null || grid.length == 0){
			return null;
		}
		this.memo = new boolean[grid.length][grid[0].length];
		return getPath(grid, new ArrayList<Point>(), grid.length, grid[0].length);
	}
	
	private List<Point> getPath(boolean[][] grid, List<Point> path, int r, int c){
		//if we are out of bounds or this current cell is blocked
		if(r <= 0 || c <= 0 || !grid[r - 1][c - 1]){
			return null;
		}
		
		//if we've seen this cell before or we're at the base case
		//or else we recurse to try the next two cells.
		if(this.memo[r - 1][c - 1] || r == 1 && c == 1){
			path.add(new Point(r - 1, c - 1));
			return path;
		}

		if(getPath(grid, path, r-1, c) != null || getPath(grid, path, r, c - 1) != null){
			this.memo[r - 1][c - 1] = true;
			path.add(new Point(r - 1, c - 1));
			
			return path;
		}
		
		//dead end
		return null;
	}
	
	public static void printPath(List<Point> memo){
		System.out.print("["); 
		for(int i = 0; i < memo.size() - 1; i++){
			System.out.print(memo.get(i) + ", ");
		}
		System.out.println(memo.get(memo.size() - 1) + "]"); 
	}
	/**
	 * Gayle's method
	 * @param maze
	 * @param row
	 * @param col
	 * @param path
	 * @param cache
	 * @return
	 
	public static ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		int lastRow = maze.length - 1;
		int lastCol = maze[0].length - 1;
		if (getPath(maze, lastRow, lastCol, path, cache)) {
			System.out.println(count);
			return path;
		}
		System.out.println(count);
		return null;
	}
	*/
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
		/* If out of bounds or not available, return.*/
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		Point p = new Point(row, col);
		
		/* If we've already visited this cell, return. */
		if (cache.containsKey(p)) { 
			return cache.get(p);
		}	
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		boolean success = false;
		
		/* If there's a path from the start to my current location, add my location.*/
		if (isAtOrigin || getPath(maze, row, col - 1, path, cache) || getPath(maze, row - 1, col, path, cache)) {
			path.add(p);
			success = true;
		}
		
		cache.put(p, success); // Cache result
		return success;
	}
	

}


