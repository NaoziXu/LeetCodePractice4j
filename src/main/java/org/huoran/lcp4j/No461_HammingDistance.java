package org.huoran.lcp4j;

/**
 * Created by Naozi on 2017/6/26.
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 */
public class No461_HammingDistance {
    public static int getHammingDistance(int x, int y){
        // get xor of x and y to get the different bits
        int xor = x ^ y;
        int count = 0;
        // judge 1 in xor by bits
        while(xor != 0){
            // judge whether the last bit is 1
            count += xor & 1;
            // right shift to get the next bit
            xor = xor >> 1;
        }
        return count;
    }

    public static void main(String[] args){
        int result = getHammingDistance(1, 4);
        System.out.println(result);
    }
}
