package Stack;

import java.util.Arrays;
import java.util.Stack;

public class TrapingRainWater {

    public int trap(int[] height) {

        int[] maxl = new int[height.length];
        int[] maxr = new int[height.length];
        maxl = maxLeftArray(height);
        maxr = maxRightArray(height);
        int sum = 0;

        for(int i = 0; i < height.length; i++){

            sum += Math.min(maxl[i],maxr[i]) - height[i];
        }

        System.out.println(Arrays.toString(maxl));
        System.out.println(Arrays.toString(maxr));
        return sum;

    }

    public int[] maxLeftArray(int[] height){
        int n = height.length;
        int[] maxL = new int[n];
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for(int i = 0; i < n; i++){

            while(st.size() > 0 && st.peek() < height[i]){
                st.pop();
            }

            if(st.size() == 0){
                max = Math.max(max, height[i]);
                maxL[i] = max;
            } else {
                max = Math.max(max, st.peek());
                maxL[i] = max;
            }


            st.add(height[i]);
        }
        return maxL;
    }

    public int[] maxRightArray(int[] height){
        int n = height.length;
        int[] maxR = new int[n];
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for(int i = n - 1; i  >= 0; i--){

            while(st.size() > 0 && st.peek() < height[i]){
                st.pop();
            }
22
            if(st.size() == 0){
                max = Math.max(max, height[i]);
                maxR[i] = max;
            } else {
                max = Math.max(max, st.peek());
                maxR[i] = max;
            }


            st.add(height[i]);
        }
        return maxR;
    }

    public static void main(String[] args) {

        TrapingRainWater t = new TrapingRainWater();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(t.trap(nums));
    }
}