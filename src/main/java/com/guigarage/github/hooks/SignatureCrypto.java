package com.guigarage.github.hooks;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignatureCrypto {

    public static final Logger LOG = Logger.getLogger(SignatureCrypto.class.getName());

    public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    public static final char[] HEX = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static boolean verifySignature(String payload, String signature, String secret) {
        boolean isValid = false;

        if(payload == null || signature == null || secret == null) {
            return false;
        }

        try {
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(), HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(payload.getBytes());
            String expected = signature.substring(5);
            final int amount = rawHmac.length;
            char[] raw = new char[2 * amount];
            int j = 0;
            for (int i = 0; i < amount; i++) {
                raw[j++] = HEX[(0xF0 & rawHmac[i]) >>> 4];
                raw[j++] = HEX[(0x0F & rawHmac[i])];
            }
            String actual = new String(raw);

            isValid = expected.equals(actual);
        } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalStateException ex) {
            LOG.log(Level.WARNING, ex.getLocalizedMessage());
        }
        return isValid;
    }

}
