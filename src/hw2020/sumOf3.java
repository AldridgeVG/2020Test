package hw2020;

import java.util.*;

public class sumOf3 {

    public static void main(String[]args){
        int nums[] = {1,2,3,4,5,-1,-2,-3,-4};
        List<List<Integer>> a = threeSum(nums);
        for(List<Integer> b:a){
            System.out.println(b);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //o n3
        if(nums == null) return null;
        List<List<Integer>> a = new ArrayList();
        int n= nums.length;
        if(n<=2){
            return a;
        }

        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1;
            int r = n-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r] == 0){
                    if((l-i>1 && nums[l]==nums[l-1])||(n-r>1&&nums[r]==nums[r+1])||((l-i>1 && nums[l]==nums[l-1])&&(n-r>1&&nums[r]==nums[r+1]))){
                        l++;
                        r--;
                        continue;
                    }
                    List tmp = new ArrayList();
                    tmp.add(new Integer(nums[i]));
                    tmp.add(new Integer(nums[l]));
                    tmp.add(new Integer(nums[r]));
                    a.add(tmp);
                    l++;
                    r--;
                }
                else{
                    if(nums[i]+nums[l]+nums[r]>0) r--;
                    else if(nums[i]+nums[l]+nums[r]<0) l++;
                }
            }
        }
        return a;
    }
}
