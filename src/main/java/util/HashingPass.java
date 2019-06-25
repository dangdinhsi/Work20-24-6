package util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class HashingPass {

    private static MessageDigest md;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";

    public static String HashPass(String inputpass,String salt) throws NoSuchAlgorithmException {
        if (md==null){
            md=MessageDigest.getInstance("MD5");
        }
        md.update(inputpass.getBytes());
        md.update(salt.getBytes());
        byte[] hash = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<hash.length;i++){
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }



    public static String generateSalt(int length){
        SecureRandom random = new SecureRandom();

        StringBuilder builder = new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return new String(builder);
    }

}
