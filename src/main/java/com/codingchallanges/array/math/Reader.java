package com.codingchallanges.array.math;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 *
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */
public class Reader extends Reader4{

	/**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {

        int totalRead = 0;
        int readSize = 4;
        char[] buf4 = new char[4];// temporary buffer

        while(totalRead < n && readSize == 4){

        	readSize = read4(buf4);

            for(int i = 0; i < readSize; i++){

                buf[totalRead++] = buf4[i];

                if(totalRead == n)
                    return totalRead;
            }
        }
        return totalRead;
    }

	public static void main(String[] args) {

		Reader reader = new Reader();
		System.out.println(reader.read(new char[999999], 0));
		System.out.println(reader.read(new char[999999], 4));
		System.out.println(reader.read(new char[999999], 5));
		System.out.println(reader.read(new char[999999], 25));

	}

}
