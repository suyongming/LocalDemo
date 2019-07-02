package com.demo.sort;

public class QuickSort {
    private int pivot;

    public static void main(String[] args){
        int arr[]={3,5,7,1,2,6,9,10,8,4};
        //第一次 应该变为

        sort(arr);
    }

//    pivot 这里的基准取 arr[length]

    public static void sort(int[] arr){
        int pivot = arr[arr.length-1];
        for(int i=0;i<arr.length;i++){

        }

        System.out.println(pivot);

    }

    public static void partition(int[] arr){
//    partition 分组  根据基准区分  小于基准放到左
//    右边 为第二次递归
    }


}
