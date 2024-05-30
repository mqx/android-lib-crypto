package com.mtsxyz.cryptlib;
/* ****************************************************
 ** Function: Aes 加解密类
 **
 ** Author: MQX
 ** Date: 2024-05-30
 ** Copyright: 2024 www.mtsxyz.com All rights reserved.
 ** ****************************************************/

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
    private String mAlgorithm = "AES/ECB/PKCS5Padding";
    private byte[] mIv = new byte[16];

    public void setAlgorithm(String algorithm){
        mAlgorithm = algorithm;
    }
    public byte[] enc(byte[] data, byte[] key) throws Exception{
        return doAes(true, data, key, 32, mIv, mAlgorithm);
    }

    public byte[] dec(byte[] data, byte[] key) throws Exception{
        return doAes(false, data, key, 32, mIv, mAlgorithm);
    }

    private byte[] doAes(boolean isEnc, byte[] data, byte[] key, int keyLen, byte[] iv,
                               String algorithm) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key, 0, keyLen, algorithm);

        Cipher cipher = Cipher.getInstance(algorithm);//Default "AES/ECB/PKCS5Padding"
        if (mAlgorithm.contains("ECB")){
            if (isEnc)
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            else
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
        }else{
            IvParameterSpec ivParam = new IvParameterSpec(iv);
            if (isEnc)
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParam);
            else
                cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParam);
        }

        return cipher.doFinal(data);
    }
}
