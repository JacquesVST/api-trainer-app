package tk.jvst.api.util;

import org.springframework.util.DigestUtils;

public class HashUtils {

    public static String stringToSha256(String original) {
        return DigestUtils.md5DigestAsHex(original.getBytes());
    }
}
