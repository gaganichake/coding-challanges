package com.codingchallanges.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * findProfession
 * 
 * https://app.codesignal.com/interview-practice/task/FwAR7koSB3uYYsqDp/description
 * 
 * Consider a special family of Engineers and Doctors. This family has the following rules:
 * 
 * Everybody has two children.
 * The first child of an Engineer is an Engineer and the second child is a Doctor.
 * The first child of a Doctor is a Doctor and the second child is an Engineer.
 * All generations of Doctors and Engineers start with an Engineer.
 * 
 * Note: in this tree first child is considered as left child, second - as right.
 * 
 * Example
 * 
 * For level = 3 and pos = 3, the output should be
 * 
 * findProfession(level, pos) = "Doctor"
 */
public class FindProfession {

	
	//Best solution
	//Credit: https://github.com/edyluisrey/Codefights-Algorithms
	public static String findProfession(int level, int pos) {
		
		if(level == 1) return "Engineer";
		
		String degree = findProfession(level - 1, (pos+1)/2);
		
        if(degree.equals("Engineer")) {
		
            if(pos % 2 == 0) {
            	degree = "Doctor";
            } else {
            	degree = "Engineer";
            }
        } else {
            if(pos % 2 == 0) {
            	degree = "Engineer";
            } else {
            	degree = "Doctor";
            }
        }
        return degree;
	}
	
	//Alternative solutions: create the whole tree and find profession. Not an optimal approach.
	private static class DegreeNode extends TreeNode<Integer> {
	    int degree;
	    int level;
	    int pos;

	    public DegreeNode(int degree, int level){
			super(0);
			this.degree = degree;
	        this.level = level;
	    }

	    public DegreeNode(int degree, int level, int pos){
			super(0);
			this.degree = degree;
	        this.level = level;
	        this.pos = pos;
	    }
	}

	/* 
	 * Breadth First Search
	 * 
	 * This solution results in correct answer but causes execution time error 
	 * when level and position are larger in number
	 */
	public static String findProfessionBFS(int level, int pos) {

	    String degree = "Engineer";

	    if(level == 1) return degree;

	    int positionAtThisLevel = 0;
	    
	    Queue<DegreeNode> q = new LinkedList<>();
	    q.add(new DegreeNode(0, 1));

	    int previousLevel = 0;
	    DegreeNode node;
	    
	    while(!q.isEmpty()){
	        
	        node = q.poll();
	        
	        if(node.level > previousLevel){
	            previousLevel = node.level;
	            positionAtThisLevel = 0;
	        }
	        
	        positionAtThisLevel++;
	        
	        if(node.level == level && positionAtThisLevel == pos){
	            if(node.degree == 0){
	                return "Engineer";
	            } else {
	                return "Doctor";
	            }
	        }
	        
	        if(node.degree == 0){
	            q.add(new DegreeNode(0, node.level + 1));
	            q.add(new DegreeNode(1, node.level + 1));
	        } else {
	            q.add(new DegreeNode(1, node.level + 1));
	            q.add(new DegreeNode(0, node.level + 1));
	        }
	    }
	    return degree;
	}
	
	static int currentPos = 0;
	
	/* 
	 * Depth First Search
	 * This solution also works but, again, it causes execution time error 
	 * when level and position are larger in number
	 */
	public static String findProfessionDFS(int level, int pos) {
		
		currentPos = 0;//reset every time
		
	    if(level == 1) return "Engineer";
	    
	    DegreeNode root = new DegreeNode(0, 1, 1);
	    
	    int degree = findProfessionDFS(root, level, pos);
	    
	    
		return degree == 0 ? "Engineer" : "Doctor"; 
	}
	
	private static int findProfessionDFS(DegreeNode node, int level, int pos) {
		
		if(node.level == level) {
			
			currentPos++;
			
			return node.degree;
		} 
		
		node.left = new DegreeNode(node.degree == 0 ? 0 : 1, node.level + 1, 1);
		
		int degree = findProfessionDFS((DegreeNode) node.left, level, pos);
		
		if(currentPos == pos) {
			
			return degree;
		}	
		
		node.right = new DegreeNode(node.degree == 0 ? 1 : 0, node.level + 1, 1);
		
		return findProfessionDFS((DegreeNode) node.right, level, pos);
		
	}

	public static void main(String[] args) {

		System.out.println(findProfessionBFS(4,1) + " "  
				+ findProfessionBFS(4,2) + " "  
				+ findProfessionBFS(4,3) + " "  
				+ findProfessionBFS(4,4) + " "  
				+ findProfessionBFS(4,5) + " "
				+ findProfessionBFS(4,6) + " "
				+ findProfessionBFS(4,7) + " "
				+ findProfessionBFS(4,8));
		
		System.out.println(findProfessionDFS(4,1) + " "  
				+ findProfessionDFS(4,2) + " "  
				+ findProfessionDFS(4,3) + " "  
				+ findProfessionDFS(4,4) + " "  
				+ findProfessionDFS(4,5) + " " 
				+ findProfessionDFS(4,6) + " "  
				+ findProfessionDFS(4,7) + " "  
				+ findProfessionDFS(4,8));
		
		System.out.println(findProfession(4,1) + " "  
				+ findProfession(4,2) + " "  
				+ findProfession(4,3) + " "  
				+ findProfession(4,4) + " "  
				+ findProfession(4,5) + " " 
				+ findProfession(4,6) + " "  
				+ findProfession(4,7) + " "  
				+ findProfession(4,8));
	}

}
