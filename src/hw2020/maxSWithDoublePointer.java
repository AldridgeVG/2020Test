package hw2020;

public class maxSWithDoublePointer {

    public int maxArea(int[] height) {
        /*
        //O n2
        int maxS=0;
        if(height == null) return 0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int hori = j-i;
                int vert = Math.min(height[i],height[j]);
                int S = hori*vert;
                if(S>maxS) maxS = S;
            }
        }
        return maxS;
        */


        //Double pointer
        //O n
        int maxS = 0;
        if (height == null) return 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int S = (j - i) * Math.min(height[i], height[j]);
            if (S > maxS) maxS = S;

            //eliminate smaller height
            //because keep smaller height will not find any growth, top limit
            // for height won't change(or even smaller), but length is smaller

            if (height[i] < height[j]) i++;
            else j--;
        }
        return maxS;

    }

}
