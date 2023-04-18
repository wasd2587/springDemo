package com.zjs.product1.collections.avl;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/29 15:31
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        //int[] arr = { 4, 3, 6, 5, 7, 8 };// 左旋转
        // int[] arr = { 10, 12, 8, 9, 7, 6 };// 右旋转
         int[] arr = { 10, 11, 7, 6, 8, 9 };// 双旋转
        AVLTree2 avlTree2 = new AVLTree2();
        for (int i = 0; i < arr.length; i++) {
            avlTree2.add(new Node2(arr[i]));
        }

        System.out.println("树的高度=" + avlTree2.getRoot().height());
        System.out.println("左子树的高度=" + avlTree2.getRoot().leftHeight());
        System.out.println("右子树的高度=" + avlTree2.getRoot().rightHeight());
        System.out.println("前序遍历");
        avlTree2.preList();
        System.out.println("中序遍历");
        avlTree2.infixList();
    }

}

//创建平衡二叉树
class AVLTree2 {
    Node2 root;

    public Node2 getRoot() {
        return root;
    }

    // 前序遍历
    public void preList() {
        if (root == null) {
            System.out.println("空树无法遍历！");
            return;
        }
        root.preList();
    }

    // 中序遍历
    public void infixList() {
        if (root == null) {
            System.out.println("空树无法遍历！");
            return;
        }
        root.infixList();
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node2 node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }
}

//创建节点类
class Node2 {
    int value;
    Node2 left;
    Node2 right;

    public Node2(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node2 [value=" + value + "]";
    }

    // 前序遍历
    public void preList() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preList();
        }
        if (this.right != null) {
            this.right.preList();
        }
    }

    // 中序遍历
    public void infixList() {
        if (this.left != null) {
            this.left.infixList();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixList();
        }
    }

    // 以当前节点为根节点，求其树的高度
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    // 求当前节点左子树的高度
    public int leftHeight() {
        if (this.left == null) {
            return 0;
        }
        return this.left.height();

    }

    // 求当前节点右子树的高度
    public int rightHeight() {
        if (this.right == null) {
            return 0;
        }
        return this.right.height();
    }

    /**
     * 左旋转
     */
    public void leftRotate() {
        // 1.以当前节点为根结点，创建一个新的节点，值为当前节点的值
        Node2 newNode = new Node2(this.value);
        // 2.将新节点的左子节点设置成当前节点的左子树
        newNode.left = this.left;
        // 3.将新节点的右子节点设置成当前节点右子节点的左子树
        newNode.right = this.right.left;
        // 4.将当前节点的值替换成其右子节点的值
        this.value = this.right.value;
        // 5.将当前节点的右子节点设置成当前节点右子节点的右子树
        this.right = this.right.right;
        // 6.将当前节点的左子节点设置成新节点
        this.left = newNode;
    }

    /**
     * 右旋转
     */
    public void rightRotate() {
        // 1.以当前节点为根节点，创建一个新的节点，值为当前节点的值
        Node2 newNode = new Node2(this.value);
        // 2.将新节点的右子节点设置成当前节点的右子树
        newNode.right = this.right;
        // 3.将新节点的左子节点设置成当前节点左子节点的右子树
        newNode.left = this.left.right;
        // 4.将当前节点的值替换成其左子节点的值
        this.value = this.left.value;
        // 5.将当前节点的左子节点设置成当前节点左子节点的左子树
        this.left = this.left.left;
        // 6.将当前节点的右子节点设置成新节点
        this.right = newNode;
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node2 node) {
        if (node == null) {
            return;
        }
        // 如果要添加节点的值小于当前节点的值
        if (node.value < this.value) {
            // 如果当前节点的左子节点为空，那就直接挂上
            if (this.left == null) {
                this.left = node;
            } else {// 如果不为空，左递归
                this.left.add(node);
            }
        } else {// 如果要添加节点的值大于或等于当前节点的值
            // 如果当前节点的右子节点为空，那就直接挂上
            if (this.right == null) {
                this.right = node;
            } else {// 如果不为空，右递归
                this.right.add(node);
            }
        }

        // 节点添加完毕后，要开始判断是否是平衡二叉树，如果不是需要进行旋转操作
        // 1.如果当前节点的左子树高度-右子树高度>1，那么需要进行右旋转
        if (this.leftHeight() - this.rightHeight() > 1) {
            // !!!这里有种情况：如果以当前节点的左子节点为根节点，其右子树的高度>其左子树的高度时，需要局部进行左旋转。
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                // 以当前节点的左子节点为根节点，进行局部左旋转
                this.left.leftRotate();
            }
            // 然后以当前节点为根节点，进行右旋转
            this.rightRotate();
            // 旋转完就可以退出了
            return;
        }

        // 2.如果当前节点的右子树高度-左子树高度>1，那么需要进行左旋转
        if (this.rightHeight() - this.leftHeight() > 1) {
            // !!!这里有种情况：如果以当前节点的右子节点为根节点，其左子树的高度>其右子树的高度时，需要进行局部右旋转
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                // 以当前节点的右子节点为根结点，进行局部右旋转
                this.right.rightHeight();
            }
            // 然后以当前节点为根结点，进行左旋转
            this.leftRotate();
        }
    }
}

