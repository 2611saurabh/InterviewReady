package Greedy;
/*
partitioning-into-minimum-number-of-deci-binary-numbers
leetcode link : https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/?envType=daily-question&envId=2026-03-01
 */
public class LeetCode1689 {
}

class Solution {

    public int minPartitions(String n) {

        //char[] arr = n.toCharArray();
        // int count = 0;

        // while(true){
        //     boolean change = false;

        //     for(int i = 0; i < arr.length; i++){

        //         if(arr[i] != '0'){
        //             arr[i]--;
        //             change = true;
        //         }

        //     }

        //     if(!change){
        //         break;
        //     }
        //     count++;
        // }

        // return count;

        char maxCh = '0';

        for (char ch : n.toCharArray()) {
            maxCh = (char)Math.max(maxCh, ch);
        }

        return maxCh - '0';

    }
}


