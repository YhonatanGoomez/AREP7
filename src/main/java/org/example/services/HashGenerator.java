package org.example.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    // Constructor privado para prevenir la instanciación
    private HashGenerator() {
        throw new IllegalStateException("Utility class");
    }

    // Método estático para generar el hash
    public static String hashGenerator(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexStr = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexStr.append('0');
                }
                hexStr.append(hex);
            }

            return hexStr.toString();
        } catch (NoSuchAlgorithmException e) {
            // Lanza la nueva excepción personalizada en caso de un algoritmo no soportado
            throw new HashGenerationException("Failed to generate hash with SHA-256. Algorithm not supported.", e);
        }
    }
}
