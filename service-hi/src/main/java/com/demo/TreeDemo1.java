package com.demo;

import com.entity.base.TreeModelEntity;
import com.util.TreeNodeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeDemo1 {

    public static void main(String[] args){
        //测试单位为纳秒
//        getTestingTime();
        TreeNodeBean treeNodeBean = push();
        TreeNodeBean afterNode = treeNodeBean.deleteByNumber(26,treeNodeBean);
                List<TreeModelEntity> resultList = treeNodeBean.sort(afterNode);
        resultList.forEach(node->{
            System.out.println(node.getSort());
        });
        System.out.println(" ");


    }
    private static TreeNodeBean push(){
        List<TreeModelEntity> result = new ArrayList<>();

        for(int flag = 1; flag <= 50;flag++){
            TreeModelEntity obj = new TreeModelEntity();
            Random random = new Random();
            //乱序设值，为了校验二叉树
            obj.setSort(random.nextInt(100));
            obj.setName("张"+flag);
            result.add(obj);
        }
        TreeModelEntity obj = new TreeModelEntity();
        obj.setSort(26);
        obj.setName("张"+26);
        result.add(obj);

        TreeNodeBean<TreeModelEntity> treeNodeBean = new TreeNodeBean<>();
        result.forEach(node->{
            treeNodeBean.push(treeNodeBean,node);
        });
        treeNodeBean.push(treeNodeBean,obj);
        return treeNodeBean;
    }

    private static void getTestingTime(){
        List<TreeModelEntity> result = new ArrayList<>();

        for(int flag = 1; flag <= 50;flag++){
            TreeModelEntity obj = new TreeModelEntity();
            Random random = new Random();
            //乱序设值，为了校验二叉树
            obj.setSort(random.nextInt(500000));
            obj.setName("张"+flag);
            result.add(obj);
        }
        TreeModelEntity obj = new TreeModelEntity();
        obj.setSort(34533);
        obj.setName("张"+34533);
        result.add(obj);

        //----------------普通遍历性能测试
        long start=System.nanoTime();
        String resultName = null;
        for(int i = 0 ; i<result.size();i++){
            if(result.get(i).getSort() == 34533){
                long end=System.nanoTime(); //获取结束时间

                resultName = result.get(i).getName();
                System.out.println("普通程序查找时间： "+(end-start)+"ns-----"+resultName);
            }
        }


        //----------------二叉树查找
        TreeNodeBean<TreeModelEntity> treeNodeBean = new TreeNodeBean<>();
        result.forEach(node->{
            treeNodeBean.push(treeNodeBean,node);
        });
        treeNodeBean.push(treeNodeBean,obj);
        long startTime=System.nanoTime();   //获取开始时间
        TreeNodeBean resultNode = treeNodeBean.findBySort(34533,treeNodeBean);
        long endTime=System.nanoTime(); //获取结束时间
//        System.out.println(treeNodeBean.toString());

//        System.out.println(JSONObject.toJSONString(resultNode,SerializerFeature.DisableCircularReferenceDetect));

        System.out.println("二叉树程序查找时间： "+(endTime-startTime)+"ns-----"+resultNode.getData().getName());

        //-----lambda
        long lambdaStart=System.nanoTime();
        result.forEach(node->{
            if(node.getSort() == 34533){
                long lambdaEnd=System.nanoTime(); //获取结束时间

                System.out.println("lambda查找时间： "+(lambdaEnd-lambdaStart)+"ns-----"+node.getName());
            }
        });
    }



}
