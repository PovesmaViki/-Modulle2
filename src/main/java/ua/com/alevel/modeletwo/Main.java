package ua.com.alevel.modeletwo;

import javax.crypto.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ваш пароль");
        String s = reader.readLine();
        Cipher cipher = Cipher.getInstance("AES");
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        SecretKey key = kgen.generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(s.getBytes());
        for (byte b : bytes)
            System.out.println(b);
        System.out.print("Введите ваш ключ ");
        String v = reader.readLine();
        System.out.println("\n");
        Cipher decriptCipher = Cipher.getInstance("AES");
        decriptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decriptedBytes = decriptCipher.doFinal(bytes);
        for (byte b : decriptedBytes) {
            System.out.print((char)b);
        }
    }
}


