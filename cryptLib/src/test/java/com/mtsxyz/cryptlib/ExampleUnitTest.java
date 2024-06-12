package com.mtsxyz.cryptlib;

import org.junit.Test;

import static org.junit.Assert.*;
import static java.lang.Math.min;

import java.util.Arrays;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        try {
            String test = "0123456789";
            Aes aes = new Aes();
            byte[] iv = new byte[16];
            byte[] key = "key123456789".getBytes();
//            test("AES/ECB/NoPadding", aes, test.getBytes(), key, 16);
////            test("AES/ECB/ZeroPadding", aes, test.getBytes(), key, 16);
//            test("AES/ECB/PKCS5Padding", aes, test.getBytes(), key, 16);
////            test("AES/ECB/PKCS7Padding", aes, test.getBytes(), key, 16);
//            test("AES/ECB/NoPadding", aes, test.getBytes(), key, 24);
////            test("AES/ECB/ZeroPadding", aes, test.getBytes(), key, 24);
//            test("AES/ECB/PKCS5Padding", aes, test.getBytes(), key, 24);
////            test("AES/ECB/PKCS7Padding", aes, test.getBytes(), key, 24);
//            test("AES/ECB/NoPadding", aes, test.getBytes(), key, 32);
////            test("AES/ECB/ZeroPadding", aes, test.getBytes(), key, 32);
//            test("AES/ECB/PKCS5Padding", aes, test.getBytes(), key, 32);
////            test("AES/ECB/PKCS7Padding", aes, test.getBytes(), key, 32);
//            // 以上被注释掉的是不支持的，NoPadding需要确保明文（字节）长度是16的整数倍

//            test("AES/CBC/NoPadding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CBC/ZeroPadding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CBC/PKCS5Padding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CBC/PKCS7Padding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CBC/NoPadding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CBC/ZeroPadding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CBC/PKCS5Padding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CBC/PKCS7Padding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CBC/NoPadding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CBC/ZeroPadding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CBC/PKCS5Padding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CBC/PKCS7Padding", aes, test.getBytes(), key, 32, iv);
            // 通过规则同ECB

//            test("AES/CTR/NoPadding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CTR/ZeroPadding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CTR/PKCS5Padding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CTR/PKCS7Padding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CTR/NoPadding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CTR/ZeroPadding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CTR/PKCS5Padding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CTR/PKCS7Padding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CTR/NoPadding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CTR/ZeroPadding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CTR/PKCS5Padding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CTR/PKCS7Padding", aes, test.getBytes(), key, 32, iv);
            // 该模式只有NoPadding能通过测试（无论明文是否16字节整数倍）

//            test("AES/CFB/NoPadding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CFB/ZeroPadding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CFB/PKCS5Padding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CFB/PKCS7Padding", aes, test.getBytes(), key, 16, iv);
//            test("AES/CFB/NoPadding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CFB/ZeroPadding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CFB/PKCS5Padding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CFB/PKCS7Padding", aes, test.getBytes(), key, 24, iv);
//            test("AES/CFB/NoPadding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CFB/ZeroPadding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CFB/PKCS5Padding", aes, test.getBytes(), key, 32, iv);
//            test("AES/CFB/PKCS7Padding", aes, test.getBytes(), key, 32, iv);
            // 该模式只有NoPadding和PKCS5Padding能通过测试（无论明文是否16字节整数倍）

            test("AES/OFB/NoPadding", aes, test.getBytes(), key, 16, iv);
            test("AES/OFB/ZeroPadding", aes, test.getBytes(), key, 16, iv);
            test("AES/OFB/PKCS5Padding", aes, test.getBytes(), key, 16, iv);
            test("AES/OFB/PKCS7Padding", aes, test.getBytes(), key, 16, iv);
            test("AES/OFB/NoPadding", aes, test.getBytes(), key, 24, iv);
            test("AES/OFB/ZeroPadding", aes, test.getBytes(), key, 24, iv);
            test("AES/OFB/PKCS5Padding", aes, test.getBytes(), key, 24, iv);
            test("AES/OFB/PKCS7Padding", aes, test.getBytes(), key, 24, iv);
            test("AES/OFB/NoPadding", aes, test.getBytes(), key, 32, iv);
            test("AES/OFB/ZeroPadding", aes, test.getBytes(), key, 32, iv);
            test("AES/OFB/PKCS5Padding", aes, test.getBytes(), key, 32, iv);
            test("AES/OFB/PKCS7Padding", aes, test.getBytes(), key, 32, iv);
            // 该模式通过规则同CFB


            // 测试不包括密钥的参数
            byte[] content = test.getBytes();
            aes.setKey(key);
            aes.setIv(iv);
            aes.setKeyLength(16);
            aes.setPadding("AES/OFB/NoPadding");
            test(aes, content);
            aes.setPadding("AES/OFB/ZeroPadding");
            test(aes, content);
            aes.setPadding("AES/OFB/PKCS5Padding");
            test(aes, content);
            aes.setPadding("AES/OFB/PKCS7Padding");
            test(aes, content);
            aes.setKeyLength(24);
            aes.setPadding("AES/OFB/NoPadding");
            test(aes, content);
            aes.setPadding("AES/OFB/ZeroPadding");
            test(aes, content);
            aes.setPadding("AES/OFB/PKCS5Padding");
            test(aes, content);
            aes.setPadding("AES/OFB/PKCS7Padding");
            test(aes, content);
            aes.setKeyLength(32);
            aes.setPadding("AES/OFB/NoPadding");
            test(aes, content);
            aes.setPadding("AES/OFB/ZeroPadding");
            test(aes, content);
            aes.setPadding("AES/OFB/PKCS5Padding");
            test(aes, content);
            aes.setPadding("AES/OFB/PKCS7Padding");
            test(aes, content);
            // 效果同上
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test(String pkcs, Aes aes, byte[] testData, byte[] testKey, int keyLen){
        aes.setKeyLength(keyLen);
        byte[] k = new byte[keyLen];
        System.arraycopy(testKey, 0, k, 0, min(k.length, testKey.length));
        aes.setPadding(pkcs);
        System.out.println("k-len:"+keyLen+", padding:"+pkcs);
        try {
            byte[] encData = aes.encrypt(testData, k);
            byte[] decData = aes.decrypt(encData, k);
            assertArrayEquals(testData, decData);
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Err");
        }
    }

    private void test(String pkcs, Aes aes, byte[] testData, byte[] testKey, int keyLen, byte[] iv){
        aes.setKeyLength(keyLen);
        aes.setIv(iv);
        byte[] k = new byte[keyLen];
        System.arraycopy(testKey, 0, k, 0, min(k.length, testKey.length));
        aes.setPadding(pkcs);
        System.out.println("k-len:"+keyLen+", padding:"+pkcs);
        try {
            byte[] encData = aes.encrypt(testData, k);
            byte[] decData = aes.decrypt(encData, k);
            assertArrayEquals(testData, decData);
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Err");
        }
    }

    private void test(Aes aes, byte[] testData){
        try {
            byte[] encData = aes.encrypt(testData);
            byte[] decData = aes.decrypt(encData);
            assertArrayEquals(testData, decData);
            System.out.println("Pass");
        } catch (Exception e) {
            System.out.println("Err");
        }
    }
}