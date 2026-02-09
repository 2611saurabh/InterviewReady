package SlidingWindow;

public class LargestSubarrayofsumK {

    public int largestSubarrayOfSumK(int[] nums, int k){

        int n = nums.length;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < n){
            sum += nums[j];
            if(sum < k){
                j++;
            } else if (sum == k) {
                count = j - i + 1;
                max = Math.max(max, count);

                j++;

            }
            else{ //if sum > k
                sum -= nums[i];
                sum -= nums[j];
                i++;
            }
        }

        return  max;
    }

    public static void main(String[] args) {

        LargestSubarrayofsumK s = new LargestSubarrayofsumK();

        int[] nums = {4,1,1,1,2,3,5};
        int k = 5;
        System.out.println(s.largestSubarrayOfSumK(nums, k));

    }
}
