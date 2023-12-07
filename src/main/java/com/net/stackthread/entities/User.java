package com.net.stackthread.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Date;


@Slf4j
@Getter
@Setter
@Entity
@Table(name = "users")
public class User
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, unique = true)
   private String username;

   @Column(name = "created_at", nullable = false)
   private Date createdAt = new Date();

   private String passwordHash;

   private String passwordSalt;

   @Column(nullable = false)
   private String securityQuestion;

   @Column(nullable = false)
   private String securityAnswer;

   public void saveUniqueSaltForUser()
   {
      byte[] salt = generateSalt();
      this.passwordSalt = Base64.getEncoder().encodeToString(salt);
   }

   /**
    * Sets the password using salt and hash.
    *
    * @param password the password to set
    */
   public void savePasswordHash(String password)
   {
      this.passwordHash = generateHash(password, Base64.getDecoder().decode(passwordSalt));
   }

   public void saveAnswerHash(String answer)
   {
      this.securityAnswer = generateHash(answer, Base64.getDecoder().decode(passwordSalt));
   }

   /**
    * Checks if the provided password matches the stored password hash.
    *
    * @param password the password to check
    * @return true if the password is a match, false otherwise
    */
   public boolean checkPassword(String password)
   {
      String hashedPassword = generateHash(password, Base64.getDecoder().decode(passwordSalt));
      return passwordHash.equals(hashedPassword);
   }

   /**
    * Generates a salt for password hashing.
    *
    * @return the generated salt
    */
   private byte[] generateSalt()
   {
      // Generate a new salt using a secure random number generator
      byte[] salt = new byte[16];
      new SecureRandom().nextBytes(salt);
      return salt;
   }

   /**
    * Generates a hash of the password using the provided salt.
    *
    * @param password the password to hash
    * @param salt     the salt to use for hashing
    * @return the generated hash
    */
   private String generateHash(String password, byte[] salt)
   {
      // Generate a hash using  the PBKDF2 algorithm with 10000 iterations and a key length of 128 bits
      try {
         SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
         KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 128);
         SecretKey secretKey = keyFactory.generateSecret(spec);
         byte[] hash = secretKey.getEncoded();
         return Base64.getEncoder().encodeToString(hash);
      }
      catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
         log.error("Error generating password hash", e);
         throw new RuntimeException("Not able to save user data", e);
      }
   }
}
