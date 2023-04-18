package com.zjs.product1.collections.avl;

import java.util.Objects;

/**
 * @author zjs
 * @description AVL - TreeNode
 * @create 2023/3/29 10:01
 */
public class TreeNode {
    private int bf = 0; // 平衡因子
    private Object data; //节点存放的数据
    private TreeNode parentNode; // 父节点
    private TreeNode leftChild, rightChild; // 左右子节点
    private int count = 0; //被重复插入的次数

    public TreeNode() {
    }

    public TreeNode(Object data) {
        this.data = data;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String p_data = null, l_data = null, r_data = null;
        if (parentNode != null) {
            p_data = String.valueOf(parentNode.data);
        }
        if (leftChild != null) {
            l_data = String.valueOf(leftChild.data);
        }
        if (rightChild != null) {
            r_data = String.valueOf(rightChild.data);
        }
        return "TreeNode{" +
                " data=" + data +
                ", bf=" + bf +
                ", count=" + count +
                ", parent_node_data=" + p_data +
                ", left_child_data=" + l_data +
                ", right_child_data=" + r_data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bf, data, parentNode, leftChild, rightChild, count);
    }
}
