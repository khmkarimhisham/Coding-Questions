/*
Array X is greater than array Y if the first non-matching element in both arrays has a greater value in X than in Y.

For example, for arrays X and Y such that:
X = [1, 2, 4, 3,5] 
Y = [1, 2, 3, 4, 5]
X is greater than Y because the first element that does not match is larger in X (i.e. for X[2] and Y[2], X[2] > Y[2]).

A contiguous subarray is defined by an interval of the indices. In other words, a contiguous subarray is a subarray which has consecutive indexes.

Write a function:
class Solution { public int[] solution(int[] A, int k); }

that, given a zero-indexed array A consisting of N integers and an integer K, returns the largest contiguous subarray of length K from all the contiguous subarrays of length K.

For example, given array A and K = 4 such that: 

A = [1, 4, 3, 2, 5] 

the function should return [4, 3, 2, 5), because there are two subarrays of size 4:

• [1,4, 3, 2]

• [4, 3, 2,5] 

and the largest subarray is [4, 3, 2, 5]. Assume that:
• 1 ≤ K ≤ N ≤ 100;
• 1 ≤ A[J] ≤ 1000; 
• given an array A contains N distinct integers.
*/

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] A, int K) {
       int[] largestSub = Arrays.copyOfRange(A, 0, K - 1);
       for (int i = 0; i + K - 1 < A.length; i++) {
          int[] sub2 = Arrays.copyOfRange(A, i + 1, i + K + 1);
          for (int c = 0; c < K; c++) {
              if (largestSub[c] != sub2[c]) {
                  if (largestSub[c] < sub2[c]) {
                      largestSub = sub2;
                  }
                  break;
              }
          }
      }
      return largestSub;
   }
}
        
