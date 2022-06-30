package com.codingchallanges.array.sort;

/*
 * almostIncreasingSequence
 * 
 * https://app.codesignal.com/arcade/intro/level-2/2mxbGwLzvkTCKAJMG
 * 
 * Given a sequence of integers as an array, determine whether it is possible to obtain 
 * a strictly increasing sequence by removing no more than one element from the array.
 * 
 * Note: sequence a0, a1, ..., an is considered to be a strictly increasing 
 * if a0 < a1 < ... < an. Sequence containing only one element is also considered to be 
 * strictly increasing.
 * 
 * Example:
 * 
 * For sequence = [1, 3, 2, 1], the output should be
 * almostIncreasingSequence(sequence) = false.
 * 
 * There is no one element in this array that can be removed in order to get a strictly 
 * increasing sequence
 * 
 * For sequence = [1, 3, 2], the output should be
 * almostIncreasingSequence(sequence) = true.
 * 
 * You can remove 3 from the array to get the strictly increasing sequence [1, 2]. 
 * Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
 */
public class AlmostIncreasingSequence {

	boolean almostIncreasingSequence(int[] sequence) {
        
        for(int i = 0; i < sequence.length-1; i++){
            
            //"strictly" increasing sequence, hence no two numbers should be same
            if(sequence[i] >= sequence[i+1]){

				return almostIncreasingSequence(i - 1, sequence) || almostIncreasingSequence(i, sequence) || almostIncreasingSequence(i + 1, sequence);
            }
        }
        return true;
	}

	private boolean almostIncreasingSequence(int ignoreIndex, int[] sequence){
	    
	    for(int i = 0; i < sequence.length-1; i++){
	        
	        if(i+1 == ignoreIndex && i+2 < sequence.length && sequence[i] >= sequence[i+2]) return false;
	        
	        if(i == ignoreIndex && i-1 > -1 && sequence[i-1] >= sequence[i+1]) return false;
	        
	        if(i != ignoreIndex && i+1 != ignoreIndex && sequence[i] >= sequence[i+1]) return false;       
	    } 
	    return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
