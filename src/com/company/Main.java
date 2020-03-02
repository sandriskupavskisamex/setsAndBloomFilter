package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        String sample = Files.readString(Paths.get("wordlist.txt"), Charset.forName("windows-1252"));
        String[] arr = sample.split("\n");

//        MessageDigest md = MessageDigest.getInstance("MD5");
//        byte[] hashResult = md.digest("Hello".getBytes());
//
//        System.out.println(md.digest("Hello".getBytes()));
//
//        boolean[] bitmap = new boolean[256];
//
//        bitmap[hashResult[0] + 128] = true;
//
//        System.out.println(hashResult[0]);
//        for (boolean b: bitmap) {
//            System.out.println(b ? 1 : 0);
//        }

        MySet myset = new MySet();
        myset.contents = Arrays.asList(arr);

        System.out.println(myset.bloomFilter.contains("Joke"));

        for(int i = 0; i < myset.contents.size(); i++) {
            myset.bloomFilter.add(myset.contents.get(i));
        }

        System.out.println(myset.bloomFilter.contains("toolboxxxx434"));

    }
}
