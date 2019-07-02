package com.demo.sort;

import lombok.Data;

import java.util.Arrays;

@Data
public class MergeSort {
    public static void main(String []args){
        int[] array = new int[]{10,9,8,7,6,5,4,3,2,1};
        mergeSort(array,0,array.length-1);

//        int[] array2 = new int[]{10,9,8,7,6,5,4,3,2,1};
//        sort(array2);
        System.out.println(Arrays.toString(array));

        int x=10, y = 15;

        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println(x+"+"+ y +"="+(x+y));

    }

    private static void mergeSort(int[] array,int l,int r ){
        int mid = l + ((r-l)>>1);

        if (l>=r){
            return;
        }
        mergeSort(array,l,mid);
        mergeSort(array,mid+1,r);
//        if (array[mid] > array[mid + 1])
        merge(array,l,mid,r);

    }

    private static void merge(int[] array,int l,int mid,int r ) {
        int[] help = new int[r - l + 1];
        int k = 0;
        int p1 = l, p2 = mid + 1;
        //while(p1 <= mid && p2 <= R)
        //   help[k++] = arr[p1] < arr[p2]  ? arr[p1++] : arr[p2++];
        while (p1 <= mid && p2 <= r)
            help[k++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];  //左右两边相等的话，就先拷贝左边的(实现稳定性)
        while (p1 <= mid)  //左边剩余的部分
            help[k++] = array[p1++];
        while (p2 <= r)   //右边剩余的部分
            help[k++] = array[p2++];
        for (int i = 0; i < k; i++) //拷贝回原来的数组
            array[i + l] = help[i];

//        int[] temp = new int[r-l+1];
//
//        for (int i=l;i<=r;i++){
//            temp[i-l] = array[i];
//        }
//
//        int i=l,j=mid+1;
//        for (int k=l;k<=r;k++){
//            if (i>mid){
//                array[k] = temp[j-l];
//                j++;
//            }
//            else if (j>r){
//                array[k] = temp[i-l];
//                i++;
//            }else{
//                if (temp[i-l]<temp[j-l]){
//                    array[k] = temp[i-l];
//                    i++;
//                }else{
//                    array[k] = temp[j-l];
//                    j++;
//                }
//            }
//
//
//
//        }

    }

    //---------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------


    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

}
