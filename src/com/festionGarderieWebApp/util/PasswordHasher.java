package com.festionGarderieWebApp.util;

import java.security.MessageDigest;

public class PasswordHasher {
    public static String hashPassword(String password) {
        try {
            // Initialisation de l'algorithme SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));

            // Conversion du tableau de bytes en une chaîne hexadécimale
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du hachage du mot de passe", e);
        }
    }

    public static void main(String[] args) {
        String password = "monSuperMotDePasse";
        String hashedPassword = hashPassword(password);
        System.out.println("Mot de passe haché : " + hashedPassword);
    }
}
