package offer;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

import static offer.Offer07_1.*;

public class Offer07_2 {

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //        / \
        //       4   5
        //pre->12453  in->42513   post->45231
        int[] pre = {1, 2, 4, 5, 3};
        int[] in = {4, 2, 5, 1, 3};
        TreeNode<Integer> root = buildTree(pre, in);
        ArrayList<Integer> res = new ArrayList<>();
        preorderRecursively(root, res);
        System.out.println("pre:" + res);
        res.clear();
        inorderRecursively(root, res);
        System.out.println("in:" + res);
        res.clear();
        postorderRecursively(root, res);
        System.out.println("post:" + res);

    }

    public static TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        //判空
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<>(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftInorder.length, preorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}



