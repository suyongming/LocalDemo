package com.util.btree;

import lombok.Data;

@Data
public class Tree2_3 {
    //叶子节点M  非叶子节点为个数 保证为 M-1
    //特点 只有叶子节点 才可能会存在3+个child
    //遍历过程中所有的节点 个数永远不会低于叶子节点/2，否则这垃圾树就没意义
    //
    private Tree2_3 parentNode;

    private Integer leftKey;
    private Integer leftValue;

    private Integer inKey;
    private Integer inValue;

    private Integer rightKey;
    private Integer rightValue;


    //约定:过程中in这个节点如果有值说明俩兄弟肯定不为空!
    //所以每次temp以后 要记得把这个节点重置为 null;
    private Tree2_3 inChild;

    private Tree2_3 leftChild;

    private Tree2_3 rightChild;

    private static final int IS_BEFORE = 1;
    private static final int LEFT = 1;
    private static final int IN = 2;
    private static final int RIGHT = 3;



    /**
     * 判断当前节点是否是三个节点全满
     * */
    private boolean childrenIsNull(Tree2_3 thisNode){
        if(thisNode.inChild == null) {
//        thisNode.leftChild
            return true;
        }else{
            return false;
        }
    }


    public void push(Integer paramValue,Tree2_3 treeNode,int flag){
//        6 10 4 14 5 11 15 3 2 12 1 7 8 8 6 3 6 21 5 15 15 6 32 23 45 65 7 8 6 5 4
        //1.到最底层
        //向右
        if (paramValue>treeNode.rightValue){
            if(treeNode.rightChild != null){
                push(paramValue,treeNode.getRightChild(),RIGHT);
                return;
            }else{
                Tree2_3 rightChildNode = new Tree2_3();
                rightChildNode.setLeftValue(paramValue);
                rightChildNode.setParentNode(treeNode);

                treeNode.setRightChild(rightChildNode);
                return;
            }
        }

        //向左
        if (paramValue<treeNode.leftValue){
            if(treeNode.leftChild != null) {
                push(paramValue, treeNode.getLeftChild(),LEFT);
                return;
            }else{
                Tree2_3 leftChildNode = new Tree2_3();
                leftChildNode.setLeftValue(paramValue);
                leftChildNode.setParentNode(treeNode);

                treeNode.setLeftChild(leftChildNode);
                return;
            }
        }

        //向中
        if (paramValue < treeNode.rightValue
                && paramValue > treeNode.leftValue){
            if(treeNode.inChild != null) {
                push(paramValue, treeNode.getInChild(),IN);
                return;
            }else{
                //到这里就应该旋转重新指向
                Tree2_3 inChildNode = new Tree2_3();
                inChildNode.setLeftValue(paramValue);
                inChildNode.setParentNode(treeNode);

                treeNode.setInChild(inChildNode);
                return;
            }
        }




    }
}
