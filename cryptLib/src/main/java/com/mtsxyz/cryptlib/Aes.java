package com.mtsxyz.cryptlib;
/* ****************************************************
 ** Function: Aes 加解密类
 * https://developer.android.google.cn/privacy-and-security/cryptography?hl=el
 ** 加密模式分为五种：
 * ECB-电码本模式(Electronic Codebook Book)：
 *      这种模式是将整个明文分成若干段相同的小段，然后对每一小段进行加密。
 *      适合于单块小数据
 * CBC-密码分组链接模式(Cipher Block Chaining):
 *      这种模式是先将明文切分成若干小段，然后每一小段与初始块或者上一段的密文段进行异或运算后，
 *      再与密钥进行加密。第一块就直接使用IV的值，其它块使用上一段的密文进行。
 *      适合于大数据（强度比ECB大，分组通用）
 * CTR-计算器模式(Counter)：
 *      有一个自增的算子（计数器），这个算子用密钥加密之后的输出和明文异或的结果得到密文，相当于一次一密。
 *      这种加密方式简单快速，安全可靠，而且可以并行加密，可以仅解密某数据块，计数值最好不能重复，否则将产生
 *      相同的输出（用密钥加密计数器后的输出）。
 *      适合于流式数据（快速计算）
 * CFB-密码反馈模式（Cipher FeedBack）：
 *      1，将初始向量（IV）与密钥通过加密算法生成第一轮的密文作为加密输出。
 *      2，将第一轮的密文与明文异或，得到加密后的数据，同时将该加密后的数据作为下一轮的输入。
 *      重复以上步骤，直到所有数据均加密完成。
 *      适合于多通道（数据流通用）
 * OFB-输出反馈模式（Output FeedBack）：
 *      先用块加密器生成密钥流（Keystream），然后再将密钥流与明文流异或得到密文流，解密是先用块加密器生成密钥流，
 *      再将密钥流与密文流异或得到明文，由于异或操作的对称性所以加密和解密的流程是完全一样的
 *      适合于噪声信道流传输
 ** Author: MQX
 ** Date: 2024-05-30
 ** Copyright: 2024 www.mtsxyz.com All rights reserved.
 ** ****************************************************/

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
    private static final String ALGORITHM = "AES";
    private static final String DEF_PADDING = "AES/ECB/PKCS5Padding";
    private static final int DEF_KEY_LEN = 32;
    private static final int IV_LEN = 16;
    private static final byte[] DEF_IV = new byte[IV_LEN];
    // 填充模式
    private String mPadding;
    // 密钥长度（默认256位）
    private int mKeyLength;
    // 向量(偏移量)初始为全0
    private byte[] mIv;
    private byte[] mKey;

    public Aes() {
        this(DEF_PADDING);
    }

    public Aes(String padding) {
        this(padding, DEF_KEY_LEN);
    }

    public Aes(String padding, int keyLength) {
        this(padding, keyLength, DEF_IV);
    }

    public Aes(String padding, int keyLength, byte[] iv) {
        this.mPadding = padding;
        this.mKeyLength = keyLength;
        this.mIv = iv;
    }

    public void setKey(byte[] key){
        mKey = key;
    }
    public byte[] getKey(){
        return mKey;
    }

    public void setPadding(String padding){
        mPadding = padding;
    }
    public String getPadding(){
        return mPadding;
    }

    public void setKeyLength(int keyLength){
        mKeyLength = keyLength;
    }
    public int getKeyLength(){
        return mKeyLength;
    }

    public void setIv(byte[] iv){
        mIv = iv;
    }
    public byte[] getIv(){
        return mIv;
    }

    public byte[] encrypt(byte[] data) throws Exception{
        return encrypt(data, mKey);
    }

    public byte[] decrypt(byte[] data) throws Exception{
        return decrypt(data, mKey);
    }

    public byte[] encrypt(byte[] data, byte[] key) throws Exception{
        return doAes(Cipher.ENCRYPT_MODE, data, key, mKeyLength, mIv, mPadding);
    }

    public byte[] decrypt(byte[] data, byte[] key) throws Exception{
        return doAes(Cipher.DECRYPT_MODE, data, key, mKeyLength, mIv, mPadding);
    }

    private byte[] doAes(int mode, byte[] data, byte[] key, int keyLen, byte[] iv,
                         String padding) throws Exception {
        // 如果加密的内容或密钥为null则直接返回（加/解密也会抛异常）
        if (null == data || null == key)
            return null;
        byte[] useKey = key;
        if (key.length != keyLen){
            // 如果密钥长度和密钥内容长度不同则进行调整
            useKey = new byte[keyLen];
            System.arraycopy(key, 0, useKey, 0, Math.min(key.length, useKey.length));
        }
        SecretKeySpec keySpec = new SecretKeySpec(useKey, 0, keyLen, ALGORITHM);
        Cipher cipher = Cipher.getInstance(padding);

        if (!padding.contains("ECB")) {
            // 同样地，对偏移向量也要处理
            byte[] useIv = iv;
            if (iv.length != IV_LEN){
                useIv = new byte[IV_LEN];
                System.arraycopy(iv, 0, useIv, 0, Math.min(iv.length, useIv.length));
            }
            IvParameterSpec ivParam = new IvParameterSpec(useIv);
            cipher.init(mode, keySpec, ivParam);
        }else
            cipher.init(mode, keySpec);
        return cipher.doFinal(data);
    }
}
