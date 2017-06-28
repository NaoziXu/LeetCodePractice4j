package org.huoran.lcp4j;

import com.alibaba.fastjson.JSONObject;
import org.huoran.lcp4j.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Naozi on 2017/6/27.
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
 * in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree as
 * "[1,2,3,null,null,4,5]"
 *      1
 *     / \
 *    2   3
 *       / \
 *      4   5
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class No297_SerializeAndDeserializeBinaryTree {

    public static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        pushNode(stringBuilder,root);
        return stringBuilder.toString();
    }

    private static void pushNode(StringBuilder stringBuilder,TreeNode node){
        if(node == null){
            stringBuilder.append('\\');
            stringBuilder.append(',');
        }
        else{
            stringBuilder.append(node.val);
            stringBuilder.append(',');
            pushNode(stringBuilder,node.left);
            pushNode(stringBuilder,node.right);
        }
    }

    public static TreeNode deserialize(String data) {
        if(data != null && data.length() > 0) {
            LinkedList<String> linkedList = new LinkedList<String>();
            linkedList.addAll(Arrays.asList(data.split(",")));
            TreeNode result = getTree(linkedList);
            return result;
        }
        return null;
    }

    private static TreeNode getTree(LinkedList<String> linkedList){
        String node = linkedList.removeFirst();
        if(node == null || node.equals("\\")){
            return null;
        }
        else{
            TreeNode treeNode = new TreeNode(Integer.parseInt(node));
            treeNode.left = getTree(linkedList);
            treeNode.right = getTree(linkedList);
            return treeNode;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        String treeStr = JSONObject.toJSONString(deserialize);
        System.out.println(treeStr);
    }
}
