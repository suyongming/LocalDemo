package com.demo.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int arr[]={3,5,7,1,2,6,9,10,8,4};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int length = arr.length;
        for(int i =0; i<length-1;i++){

            for(int j=0;j<length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    // temp
                    arr[j] = arr[j] +arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];

                }
            }
        }
    }
}
