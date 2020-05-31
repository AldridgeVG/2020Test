package hw2020;

import java.util.ArrayList;

public class isSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void mRootTraverse(ArrayList ar,ArrayList arl, int lev, TreeNode root) {
        if (root == null) {
            ar.add(-999);
            arl.add(lev);
            return;
        } else {
            if (root.left == null && root.right == null) {
                ar.add(root.val);
                arl.add(lev);
                return;
            }
            mRootTraverse(ar, arl, lev + 1, root.left);
            ar.add(root.val);
            arl.add(lev);
            mRootTraverse(ar, arl, lev + 1, root.right);
            return;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        ArrayList ar = new ArrayList();
        ArrayList arl = new ArrayList();

        mRootTraverse(ar, arl, 1, root);

        int l = ar.size();

        for (int i = 0; i < l / 2; i++) {
            if (ar.get(i).equals(ar.get(l - 1 - i)) && arl.get(i).equals(arl.get(l - 1 - i))) continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(-57);
        root.right = new TreeNode(-57);
        root.left.right = new TreeNode(67);
        root.right.left = new TreeNode(67);


        if (isSymmetric(root)) System.out.println("symmetric");
        else System.out.println("not symmetric");
    }

}
