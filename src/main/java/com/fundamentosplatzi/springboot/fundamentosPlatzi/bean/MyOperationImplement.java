package com.fundamentosplatzi.springboot.fundamentosPlatzi.bean;

public class MyOperationImplement implements MyOperation {

    @Override
    public int sum(int numero) {
        return numero+1;
    }
}
