package tk.jvst.api.util;

import com.google.common.base.Strings;
import org.springframework.web.multipart.MultipartFile;
import tk.jvst.api.file.File;

import java.io.IOException;
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

    public static File fromMultipartFile(MultipartFile mpFile) {

        byte[] data = null;

        try {
            data = mpFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return File.builder()
                .size(mpFile.getSize())
                .uploadDate(Timestamp.from(Instant.now()))
                .name(FileUtilities.generateFileName())
                .originalName(mpFile.getOriginalFilename())
                .type(FileUtilities.getExtensionFromFilename(mpFile.getOriginalFilename()))
                .data(data)
                .build();
    }
}
