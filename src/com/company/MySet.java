package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MySet {

    List<String> contents = new ArrayList<>();
    MyBloomFilter bloomFilter = new MyBloomFilter();

    public void add(String value) throws NoSuchAlgorithmException {
        contents.add(value);
        bloomFilter.add(value);
    }

    public boolean contains(String value) throws NoSuchAlgorithmException{
        return bloomFilter.contains(value);
    }

}
