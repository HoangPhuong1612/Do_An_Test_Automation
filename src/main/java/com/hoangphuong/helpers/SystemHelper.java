package com.hoangphuong.helpers;

import java.io.File;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class SystemHelper {


    //getCurrentDir: get thư mục soure hiện tại
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
