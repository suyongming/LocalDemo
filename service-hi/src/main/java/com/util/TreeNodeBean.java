package com.util;

import com.entity.base.TreeModelEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class TreeNodeBean<T extends TreeModelEntity>{
    //不可以用TreeNodeBean类型 否则有StackOverflowError风险
    private String parentCode;

    private TreeNodeBean liftChild;//左边的子节点

    private TreeNodeBean rightChild;//右边的子节点

    private String hashCode;//data当前粒度标识,主要是为了data服务

    private Integer number;//暂时用作序号排序

    protected T data;
    public TreeNodeBean(){
        this.hashCode = UUID.randomUUID().toString();
    }

    /**
     * @param
     *       treeNode 当前treeNodeBean
     *           data 树中的元素{dataSort序号}比如选择自增ID，时间戳，务必保证唯一
     * @return boolean
     *     true : 成功添加
     *     false: 添加失败 （不可添加重复序号）
     * */
    public boolean push (TreeNodeBean treeNode,T data){
        int dataSort = data.getSort();
        if(null == treeNode.getNumber()){
            //最终插入的地方
            treeNode.setNumber(dataSort);
//            data.setTreeCode(treeNode.getHashCode());
            treeNode.setData(data);
            return true;
        }

        if(dataSort > treeNode.getNumber()){
            if(treeNode.getRightChild() != null){
                //如果右边child不为空则 一直向树叶递归
                push(treeNode.getRightChild(),data);

            }else{
                //右边的子节点
                treeNode.setRightChild(new TreeNodeBean());

                // -----子节点设置内容

                treeNode.getRightChild().setParentCode(treeNode.getHashCode());
                treeNode.getRightChild().setNumber(dataSort);
                treeNode.getRightChild().setData(data);
                return true;
            }
        }else if(dataSort < treeNode.getNumber()){
            //如果左边child不为空
            if(treeNode.getLiftChild() != null){

                push(treeNode.getLiftChild(),data);

            }else{
                treeNode.setLiftChild(new TreeNodeBean());

                treeNode.getLiftChild().setParentCode(treeNode.getHashCode());
                treeNode.getLiftChild().setNumber(dataSort);
                treeNode.getLiftChild().setData(data);
                return true;
            }
        }
        return false;

    }

    /**
     * 根据序号查找对应节点
     * */
    public TreeNodeBean<T> findBySort(int number,TreeNodeBean<T> treeNodeBean){
        if(number < treeNodeBean.getNumber()) {
            return findBySort(number,treeNodeBean.getLiftChild());
        } else if(number > treeNodeBean.getNumber()){

            return findBySort(number,treeNodeBean.getRightChild());
        }else{
            return treeNodeBean;
        }

    }

    /**
     * 中序遍历 (升序)
     * */
    public List<T> sort(TreeNodeBean<T> treeNodeBean){
        return orderByASC(treeNodeBean,new ArrayList<>());

    }
    private List<T> orderByASC(TreeNodeBean<T> treeNodeBean,List<T> sortList){
        if(treeNodeBean.getLiftChild() != null) {
            orderByASC(treeNodeBean.getLiftChild(),sortList);
        }

        sortList.add(treeNodeBean.getData());

        if(treeNodeBean.getRightChild() != null) {
            orderByASC(treeNodeBean.getRightChild(),sortList);

        }

        return sortList;
    }

    /**
     * 删除节点
     * */
    public TreeNodeBean<T> deleteByNumber(int number,TreeNodeBean<T> treeNodeBean){
        if(treeNodeBean.getLiftChild() == null && treeNodeBean.getRightChild() == null){
            return null;
        }
//        不可遍历删除,否则很慢
        if(number < treeNodeBean.getNumber()) {
            TreeNodeBean afterNode = deleteByNumber(number,treeNodeBean.getLiftChild());
            treeNodeBean.setLiftChild(afterNode);
            return treeNodeBean;

        } else if(number > treeNodeBean.getNumber()){
            TreeNodeBean afterNode = deleteByNumber(number,treeNodeBean.getRightChild());
            treeNodeBean.setRightChild(afterNode);
            return treeNodeBean;

        }else{
            //找到该节点 开始删除(修改当前节点)
            if(treeNodeBean.getLiftChild() != null && treeNodeBean.getLiftChild() != null){
                //如果删除的节点俩儿子都在
                String oldParentCode = treeNodeBean.getParentCode();
                TreeNodeBean oldRightChild = treeNodeBean.getRightChild();
                oldRightChild.setParentCode(oldParentCode);

                //删除重新赋值
                TreeNodeBean newTree = treeNodeBean.getLiftChild();
                newTree.setParentCode(oldParentCode);
                newTree.setRightChild(oldRightChild);
                return newTree;
            }else if(treeNodeBean.getLiftChild() == null && treeNodeBean.getRightChild() != null){
                //如果只有右边的儿子节点
                String oldParentCode = treeNodeBean.getParentCode();
                TreeNodeBean newTree = treeNodeBean.getRightChild();
                newTree.setParentCode(oldParentCode);
                return newTree;
            }else if(treeNodeBean.getLiftChild() != null && treeNodeBean.getRightChild() == null){
                //如果只有左边的儿子节点
                String oldParentCode = treeNodeBean.getParentCode();
                TreeNodeBean newTree = treeNodeBean.getLiftChild();
                newTree.setParentCode(oldParentCode);
                return newTree;
            }else{
                //如果没儿子
                return null;
            }

        }

    }


}
