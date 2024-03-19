package offer;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前中后序遍历二叉树（分别使用递归和非递归解法）
 * 层序遍历二叉树
 */
public class offer07 {
    public static void main(String[] args) {
        //            1
        //              \
        //               2
        //              /
        //             3
        //pre->123  in->132   post->321  level->123
        TreeNode<Integer> root = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.right.left = new TreeNode<>(3);

        List<Integer> res = new ArrayList<>();
        preorderRecursively(root, res);
        System.out.println("pre:" + res);
        res.clear();
        inorderRecursively(root, res);
        System.out.println("in:" + res);
        res.clear();
        postorderRecursively(root, res);
        System.out.println("post:" + res);
        res.clear();

    }


    //前序遍历 递归
    public static void preorderRecursively(TreeNode<Integer> node, List<Integer> res){
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderRecursively(node.left, res);
        preorderRecursively(node.right, res);
    }

    //中序遍历 递归
    public static void inorderRecursively(TreeNode<Integer> node, List<Integer> res){
        if (node == null) {
            return;
        }
        inorderRecursively(node.left, res);
        res.add(node.val);
        inorderRecursively(node.right, res);
    }

    //后序遍历 递归
    public static void postorderRecursively(TreeNode<Integer> node, List<Integer> res){
        if (node == null) {
            return;
        }
        postorderRecursively(node.left, res);
        postorderRecursively(node.right, res);
        res.add(node.val);
    }

}

