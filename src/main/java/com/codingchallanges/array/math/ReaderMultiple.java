package com.codingchallanges.array.math;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 *
 * Call once: Assume you are always going to read from the start of the file/buffer.
 * Call multiple times: Start reading from where you left off. This means that you
 * have to store the last index where you stopped and store the read but uncopied bytes
 * to the buffer. The start pointer of array may change if you call read() function again,
 * because you want to read the file in a stream style instead of always starting over.
 *
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */
public class ReaderMultiple extends Reader4{

    char[] buf4 = new char[4];
    int readSize = 0;
    int i = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {

    	int totalRead = 0;

        while (totalRead < n) {

            if (i < readSize) {

                buf[totalRead++] = buf4[i++];

            } else {

            	readSize = read4(buf4);
                i = 0;

                if (readSize == 0) {
                    // no more data to consume from stream
                    break;
                }
            }
        }
        return totalRead;
    }

	public static void main(String[] args) {

		ReaderMultiple reader = new ReaderMultiple();
		System.out.println(reader.read(new char[999999], 0));
		System.out.println(reader.read(new char[999999], 4));
		System.out.println(reader.read(new char[999999], 5));
		System.out.println(reader.read(new char[999999], 25));
		System.out.println(reader.read(new char[999999], 30));

	}
}
