package hw2020;

public class findMidOf2SortedArr {

    public static void main(String[]args){

        int[] arr1 = {1,2,3,4};
        int[] arr2 = {2,3,4,5,6,7,8};
        System.out.println(findMedianSortedArrays(arr1,arr2));

    }

    /*
     * 1.首先，让我们在任一位置 i 将 A(长度为m) 划分成两个部分：
     *            leftA            |                rightA
     *   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
     *
     * 由于A有m个元素，所以有m + 1中划分方式(i = 0 ~ m)
     *
     * 我们知道len(leftA) = i, len(rightA) = m - i;
     * 注意：当i = 0时，leftA是空集，而当i = m时，rightA为空集。
     *
     * 2.采用同样的方式，将B也划分为两部分：
     *            leftB            |                rightB
     *   B[0],B[1],...      B[j-1] |   B[j],B[j+1],...B[n - 1]
     *  我们知道len(leftA) = j, len(rightA) = n - j;
     *
     *  将leftA和leftB放入一个集合，将rightA和rightB放入一个集合。再把这两个集合分别命名为leftPart和rightPart。
     *
     *            leftPart         |                rightPart
     *   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
     *   B[0],B[1],...      B[j-1] |  B[j],B[j+1],...B[n - 1]
     *
     *   如果我们可以确认：
     *   1.len(leftPart) = len(rightPart); =====> 该条件在m+n为奇数时，该推理不成立
     *   2.max(leftPart) <= min(rightPart);
     *
     *   median = (max(leftPart) + min(rightPart)) / 2;  目标结果
     *
     *   要确保这两个条件满足：
     *   1.i + j = m - i + n - j(或m - i + n - j + 1)  如果n >= m。只需要使i = 0 ~ m，j = (m+n+1)/2-i =====> 该条件在m+n为奇数/偶数时，该推理都成立
     *   2.B[j] >= A[i-1] 并且 A[i] >= B[j-1]
     *
     *   注意:
     *   1.临界条件：i=0,j=0,i=m,j=n。需要考虑
     *   2.为什么n >= m ? 由于0 <= i <= m且j = (m+n+1)/2-i,必须确保j不能为负数。
     *
     *   按照以下步骤进行二叉树搜索
     *   1.设imin = 0,imax = m，然后开始在[imin,imax]中进行搜索
     *   2.令i = (imin+imax) / 2, j = (m+n+1)/2-i
     *   3.现在我们有len(leftPart) = len(rightPart)。而我们只会遇到三种情况：
     *
     *      ①.B[j] >= A[i-1] 并且 A[i] >= B[j-1]  满足条件
     *      ②.B[j-1] > A[i]。此时应该把i增大。 即imin = i + 1;
     *      ③.A[i-1] > B[j]。此时应该把i减小。 即imax = i - 1;
     *
     * */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] sArr = nums1;
        int[] lArr = nums2;
        //make sure sArr is shorter
        if (m > n) {
            int tmpi = m;
            m = n;
            n = tmpi;
            int[] tmpa = sArr;
            sArr = lArr;
            lArr = tmpa;
        }

        int mLeft = 0;
        int mRight = m;
        int mid = (m + n + 1) / 2;
        while (mLeft <= mRight) {
            //s: ... s[sDiv-1] | s[sDiv] ...
            //l: ... l[lDiv-1] | l[lDiv] ...
            int sDiv = (mLeft + mRight) / 2;
            int lDiv = mid - sDiv;
            //sDiv too small
            if (sDiv < mRight && sArr[sDiv] < lArr[lDiv - 1]) {
                mLeft = sDiv + 1;
            }
            //sDiv too small
            else if (sDiv > mLeft && lArr[lDiv] < sArr[sDiv - 1]) {
                mRight = sDiv - 1;
            }
            //cross condition fit, i found
            else {
                //get max of left half
                int leftMax;
                if (sDiv == 0) leftMax = lArr[lDiv - 1];
                else if (lDiv == 0) leftMax = sArr[sDiv - 1];
                else leftMax = Math.max(lArr[lDiv - 1], sArr[sDiv - 1]);
                //m+n odd
                if ((m + n) % 2 == 1) return leftMax;
                    //m+n even
                else {
                    int minRight;
                    if (sDiv == m) minRight = lArr[lDiv];
                    else if (lDiv == n) minRight = sArr[sDiv];
                    else {
                        minRight = Math.min(lArr[lDiv], sArr[sDiv]);
                    }
                    return (leftMax + minRight) * 0.5;
                }

            }

        }
        return 0.0;
    }
}

