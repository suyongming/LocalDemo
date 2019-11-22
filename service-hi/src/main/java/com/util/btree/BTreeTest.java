package com.util.btree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BTreeTest {


    public static void main(String[] args){

//        int[] arr = {6,10,4,14,5,11,15,3,2,12,1,7,8,8,6,3,6,21,5,15,15,6,32,23,45,65,7,8,6,5,4};
//
//        List<Integer> arrList = new ArrayList<>();
//        initList(arr,arrList);



//        Tree2_3 tree2_3 = new Tree2_3();
//        tree2_3.push(1, tree2_3);
//        tree2_3.push(2, tree2_3);
//        tree2_3.push(3, tree2_3);
//        tree2_3.push(4, tree2_3);
//        tree2_3.push(5, tree2_3);
//        tree2_3.push(6, tree2_3);
//        tree2_3.push(7, tree2_3);
//        String end = JSONObject.toJSONString(tree2_3);
//        System.out.println(end);


    }

    private static void initList(int[] arr,List<Integer> arrList){
        for(int i=0;i<arr.length;i++){
            arrList.add(arr[i]);
        }
    }
}
