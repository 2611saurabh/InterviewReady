package String;

class Solution1{
    public int subarrayMaxSum(int[] nums, int k){

        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;

        while(j < n){
            sum += nums[j];

            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                max = Math.max(sum, max);
                sum -= nums[i];
                i++;
                j++;

            }
        }
        return max;
    }
}

public class Main {

    public static void main(String[] args) {

        int[] nums = {2,3,5,2,9,7,1};
        int k = 3;

        Solution1 s = new Solution1();
        System.out.println(s.subarrayMaxSum(nums, k));
    }
}


