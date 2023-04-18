package com.zjs.product1.collections.avl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/29 10:06
 */
public class AVLTree {
    private Queue<TreeNode> tree = new LinkedList<TreeNode>(); // 存放节点的队列
    private TreeNode root;

    public void insertNode(int data) {
        TreeNode new_node = new TreeNode(data);
        tree.add(new_node);
    }


    public boolean insertNode(Object node){
        if (root == null){
            root = new TreeNode(node);
            return true;
        }

        TreeNode n = root;
        while(true){
            if (n.getData().equals(node)){

            }
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(7);
        avlTree.insertNode(6);
        System.out.println("最终结果：" + avlTree.tree.toString());
    }

}

