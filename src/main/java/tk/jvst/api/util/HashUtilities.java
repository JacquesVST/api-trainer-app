package tk.jvst.api.util;

import org.springframework.util.DigestUtils;

public class HashUtilities {

    private HashUtilities() {
    }

    public static String stringToSha256(String original) {
        return DigestUtils.md5DigestAsHex(original.getBytes());
    }
}
