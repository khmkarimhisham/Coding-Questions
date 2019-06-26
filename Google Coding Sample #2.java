/*

One string is strictly smaller than another when the frequency of occurrence of the smallest character in the string is less than the frequency of occurrence of the smallest character in the comparison string.

For example, string "abcd" is smaller than string "aaa" because the smallest character (in lexicographical order) in "abcd" is 'a', with a frequency of 1, and the smallest character in "aaa" is also 'a', but with a frequency of 3. In another example, string "a" is smaller than string "bb" because the smallest character in "a" is 'a' with a frequency of 1, and the smallest character in "bb" is 'b' with a frequency of 2.

Write a function: 
class Solution { public int[] solution (String A, String B); } 

that, given string A (which contains M strings separated by ' ') and string B (which contains N strings separated by ' '), returns an array C of N integers. For 0 ≤ J < N, values of C[J] specify the number of strings in A which are strictly smaller than the comparison J-th string in B (starting from 0). 

For example, given strings A and B such that: 
A = "abcd aabc bd" 
B = "aaa aa" 
the function should return [3, 2], because: 
• All the strings in the array are strictly smaller than "aaa" on the basis of the given comparison criteria;
• Strings "abcd" and "bd" are strictly smaller than "aa". 

Assume that:
• 1 ≤ N, M ≤ 10000; 
• 1 ≤ length of any string contained by A or B ≤ 10;
• All the input strings comprise only lowercase English alphabet letters.

*/


public class Solution {
    public String solution(String A, String B) {
    String a[] = A.split(" ");
        String b[] = B.split(" ");
        int[] N = new int[b.length];
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            for (int c = 0; c < a.length; c++) {
                if (counter(a[c]) < counter(b[i])) {
                    count++;
                }
            }
            N[i] = count;
            count = 0;
        }
        return N;
    }

    static int counter(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(0)) {
                count++;
            }
        }
        return count;
    }
}
