package com.websocket.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Created by Tammy on 2016/6/21.
 */
public class PidUtil {

    public static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        try {
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Exception e) {
            return -1;
        }
    }


    public static void pidfile(String path) throws IOException {
        String dir = path.substring(0, path.lastIndexOf('/'));
        File dirfile = new File(dir);
        if (!dirfile.isDirectory() || !dirfile.exists()) {
            dirfile.mkdirs();
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        out.write(String.valueOf(getPid()).getBytes());
        out.close();
    }

}
