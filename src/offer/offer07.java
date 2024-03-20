package offer;

import structure.TreeNode;

import java.util.*;

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

        show(root, res);

        //            5
        //          /   \
        //        4      6
        //      /   \
        //     2     1
        //pre->54216  in->24156   post->21465  level->54621
        root.val = 5;
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(6);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(1);

        show(root, res);
    }

    public static void show(TreeNode<Integer> root, List<Integer> res) {
        preorderRecursively(root, res);
        System.out.println("pre:" + res);
        res.clear();
        inorderRecursively(root, res);
        System.out.println("in:" + res);
        res.clear();
        postorderRecursively(root, res);
        System.out.println("post:" + res);
        res.clear();
        preorderIteratively(root, res);
        System.out.println("pre:" + res);
        res.clear();
        inorderIteratively(root, res);
        System.out.println("in:" + res);
        res.clear();
        postorderIteratively(root, res);
        System.out.println("post:" + res);
        res.clear();
        levelorder(root, res);
        System.out.println("level:" + res);
        res.clear();
    }


    // 前序遍历 递归
    public static void preorderRecursively(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderRecursively(node.left, res);
        preorderRecursively(node.right, res);
    }

    // 中序遍历 递归
    public static void inorderRecursively(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderRecursively(node.left, res);
        res.add(node.val);
        inorderRecursively(node.right, res);
    }

    // 后序遍历 递归
    public static void postorderRecursively(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorderRecursively(node.left, res);
        postorderRecursively(node.right, res);
        res.add(node.val);
    }

    // 前序遍历 非递归
    // 遍历顺序：中-左-右，入栈顺序：中-右-左
    public static void preorderIteratively(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode<Integer> cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 后序遍历 非递归
    // 由前序转变而来  中左右 -> 中右左 -> reverse 左右中
    public static void postorderIteratively(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode<Integer> cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        // 反转数组
        Collections.reverse(res);
    }


    // 中序遍历 非递归
    public static void inorderIteratively(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 先使指针指到树的左下角
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }

    // 层序遍历二叉树 利用队列
    public static void levelorder(TreeNode<Integer> node, List<Integer> res) {
        if (node == null) {
            return;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode<Integer> cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}

