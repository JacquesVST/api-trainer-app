package tk.jvst.api.util.literals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileTypes {

    private FileTypes() {
    }

    public static Set<String> getImageTypes() {
        return new HashSet<>(Arrays.asList("png", "jpg", "jpeg", "gif"));
    }

    public static Set<String> getVideoTypes() {
        return new HashSet<>(Arrays.asList("mp4", "wmv", "mkv", "gif"));
    }

}
