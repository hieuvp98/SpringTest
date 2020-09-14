package com.itstudent.example.loosely_coupled;

public class ServiceSort {

    private final BubbleSort sort = new BubbleSort();

    public void complexBusiness(int[] arr){
        sort.sort(arr);
    }
}
