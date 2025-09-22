package com.woniu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

//@SpringBootTest
class BasicInfoApplicationTests {

    //冒泡排序
    @Test
    void contextLoads() {
        int[] arr = {1, 3, 12, 0, 3, 6};
        for (int i = arr.length; i >= 1; i--) {
            bubble(arr, arr.length);
        }
        for (int i : arr) {
            System.out.println(i);
        }

    }

    void bubble(int[] arr, int n) {
        //连续将两个数进行交换，小的放左边，大的放右边
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
//        return arr;
    }

    //选择排序
    @Test
    void choose() {
        int[] arr = {1, 3, 12, 0, 3, 6};
        selection(arr,arr.length);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }


    void selection(int arr[], int n) {
        while (n > 1) {
            int maxIndex = findMaxIndex(arr, n);
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[n - 1];
            arr[n - 1] = temp;
            n--;
        }
    }

    int findMaxIndex(int arr[], int n) {
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] > max) {
                max = arr[i + 1];
                maxIndex = i + 1;
            }
        }
        return maxIndex;
    }

    //插入排序
    @Test
    void main(){
        int[] arr = {3,0,4,8,1,9,6};
        insertion(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    void insertion(int arr[],int n){
        for(int i=1;i<n;i++){
            insert(arr,i);
        }
    }

    void insert(int arr[],int n){
        int key = arr[n]; //想将这个key值插入到正确顺序的位置
        int i = n;

        while(arr[i-1]>key){
            arr[i] = arr[i-1];
            i--;
            if(i==0){
                break;
            }
        }
        arr[i] = key;
    }



    //快速排序
    public static void main(String[] args) {
        int[] array = {6,1,2,7,9,3,4,5,10,8};
        System.out.println("before: " + Arrays.toString(array));
        quickSort(array,0,array.length-1);
        System.out.println("after: " + Arrays.toString(array));
    }
    public static  void quickSort(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int tmp = arr[left]; //基准值
        int i = left;
        int j = right;
        while(i !=j){
            while(arr[j]>=tmp && j>i){ //从右往左走
                j--;
            }
            while (arr[i]<=tmp && j>i){
                i++;
            }
            if(j>i){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = tmp;
        quickSort(arr, left, i-1); //递归左边
        quickSort(arr, i+1, right); //递归右边
    }

























    @Test
    void main1(){
        int arr[] = {6,1,2,7,9,3,4,5,10,8};
        quickSort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void quickSort1(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int key = arr[left];
        int i = left;
        int j = right;
        while(i!=j){
            while(arr[j]>=key&&j>i){
                j--;
            }
            while(arr[i]<=key&&i<j){
                i++;
            }
            if(j>i){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;
        quickSort1(arr,left,i-1);
        quickSort1(arr,i+1,right);
    }

    Thread

}
