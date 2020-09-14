package com.itstudent.example.loosely_coupled;

import org.springframework.stereotype.Service;

public class ServiceSort2 {

    private SortAlgorithm sortAlgorithm;

    public ServiceSort2() {

    }

    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness(int[] arr){
        sortAlgorithm.sort(arr);
    }
}
