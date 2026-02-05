package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterToLeft {

    public ArrayList<Integer> nextGreaterToLeft(int[] nums){

        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < nums.length; i++){

            //case - 1 when stack is empty
            if(st.size() == 0){
                arr.add(-1);

            }
            else if(st.peek() > nums[i] && st.size() > 0){
                arr.add(st.peek());
            } else if (st.peek() <= nums[i]) {

                //this while run break in two conditon
                //c-1 if stack size became 0
                //c-2 we find element greater than nums[i]
                while(st.size() > 0 && st.peek() <= nums[i]){
                    st.pop();
                }
                if(st.size() == 0){
                    arr.add(-1);
                }
                else{
                    arr.add(st.peek());
                }
            }
            st.add(nums[i]);
        }
        //Collections.sort(arr);
        return arr;
    }


    public static void main(String[] args) {

        NextGreaterToLeft n = new NextGreaterToLeft();

        int[] nums = {1,3,2,4};
        System.out.println(n.nextGreaterToLeft(nums));
    }
}
