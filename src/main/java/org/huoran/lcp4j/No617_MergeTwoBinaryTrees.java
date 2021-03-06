package org.huoran.lcp4j;

import org.huoran.lcp4j.common.TreeNode;

/**
 * Created by Naozi on 2017/6/26.
 *
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Input:
 *  Tree 1                     Tree 2
 *      1                         2
 *     / \                       / \
 *    3   2                     1   3
 *   /                           \   \
 *  5                             4   7
 * Output:
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  5   4   7
 *
 */
public class No617_MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // get node val
        TreeNode t;
        if(t1 != null && t2 != null){
            t = new TreeNode(t1.val + t2.val);
            // get sub nodes
            if(t != null){
                // left
                t.left = mergeTrees(t1.left, t2.left);
                // right
                t.right = mergeTrees(t1.right, t2.right);
            }
        }
        else if(t1 != null){
            t = t1;
        }
        else if(t2 != null){
            t = t2;
        }
        else{
            t = null;
        }
        // return node
        return t;
    }

}
