package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyBloomFilter {



    public boolean[] bitmap = new boolean[256];

    void add(String value) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashResult = md.digest(value.getBytes());

        int index1 = hashResult[0];
        int index2 = hashResult[1];
        int index3 = hashResult[2];

        bitmap[(index1 + 128)] = true;
        bitmap[(index2 + 128)] = true;
        bitmap[(index3 + 128)] = true;

    }

    boolean contains(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashResult = md.digest(value.getBytes());

        int index1 = hashResult[0];
        int index2 = hashResult[1];
        int index3 = hashResult[2];

        if(bitmap[index1 + 128] && bitmap[index2 + 128] && bitmap[index3 + 128]) {
            return true;
        }

        return false;
    }

}
