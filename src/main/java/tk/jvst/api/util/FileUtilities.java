package tk.jvst.api.util;

import com.google.common.base.Strings;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Random;

public class FileUtilities {

    private FileUtilities() {
    }

    public static String generateFileName() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(Timestamp.from(Instant.now()));

        return date + "_" + new Random().nextInt();
    }

    public static String getExtensionFromFilename(String filename) {
        if (!Strings.isNullOrEmpty(filename) && filename.contains(".")) {
            return filename.substring(filename.lastIndexOf(".") + 1);
        }
        return null;
    }
}
