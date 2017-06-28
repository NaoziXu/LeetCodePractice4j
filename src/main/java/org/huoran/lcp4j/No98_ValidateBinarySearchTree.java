package org.huoran.lcp4j;

import org.huoran.lcp4j.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Naozi on 2017/6/28.
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *    2
 *   / \
 *  1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 *    1
 *   / \
 *  2   3
 * Binary tree [1,2,3], return false.
 */
public class No98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        else{
            return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
    }

    private boolean valid(TreeNode node,Long minVal, Long maxVal){
        // null
        if (node == null) {
            return true;
        }
        // out of limit
        if (node.val >= maxVal || node.val <= minVal) {
            return false;
        }
        // sub node
        boolean validLeft = valid(node.left, minVal, Long.parseLong(String.valueOf(node.val)));
        boolean validRight = valid(node.right, Long.parseLong(String.valueOf(node.val)), maxVal);
        return validLeft & validRight;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        No98_ValidateBinarySearchTree clazz = new No98_ValidateBinarySearchTree();
        boolean result = clazz.isValidBST(node);
        System.out.println(result);
    }
}
