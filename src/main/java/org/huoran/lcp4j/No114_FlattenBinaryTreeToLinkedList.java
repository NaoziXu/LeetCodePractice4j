package org.huoran.lcp4j;

import org.huoran.lcp4j.common.TreeNode;

import java.util.LinkedList;

/**
 * Created by Naozi on 2017/6/27.
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 *
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 */
public class No114_FlattenBinaryTreeToLinkedList {
    /**
     * Be careful of the reference
     * @param root
     */
    public void flatten(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        sortNodes(linkedList, root);
        getFlatTree(linkedList, root);
    }

    private void sortNodes(LinkedList<Integer> valList, TreeNode node){
        if(node != null){
            valList.add(node.val);
            sortNodes(valList, node.left);
            sortNodes(valList, node.right);
        }
    }

    private TreeNode getFlatTree(LinkedList<Integer> valList, TreeNode node){
        if(valList == null || valList.size() == 0){
            return null;
        }
        Integer val = valList.removeFirst();
        if(node == null){
            node = new TreeNode(val);
        }
        else{
            node.val = val;
        }

        /**
         * DO NOT USE evaluation/'=' TO THE PARAM OF A FUNCTION
         * CHANGE A REFERENCE PARAM BY CHANGE THE FIELD OF IT
         *
         * what is path-by-value:
         * http://blog.csdn.net/qq_35225085/article/details/51588889
         */
        node.left = null;
        node.right = getFlatTree(valList, node.right);
        return node;
    }

    public void flattenFaster(TreeNode root) {
        flatten(root,null);
    }

    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root == null){
            return pre;
        }
        pre = flatten(root.right,pre);
        pre = flatten(root.left,pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);
        No114_FlattenBinaryTreeToLinkedList clazz = new No114_FlattenBinaryTreeToLinkedList();
        clazz.flattenFaster(node);
        System.out.println(node);
    }

}
