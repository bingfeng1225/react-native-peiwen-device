package com.qd.peiwen.device;

import android.content.Context;
import android.os.Build;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PWDevice {
    public static String deviceID(Context context) throws NoSuchAlgorithmException {
        StringBuilder builder = new StringBuilder();
        String key = "AIHISENSE";
        builder.append(key);

        String model = Build.MODEL;
        builder.append(String.format("%02x", model.length()));
        builder.append(model);

        String serial = Build.SERIAL;
        builder.append(String.format("%02x", serial.length()));
        builder.append(serial);

        String manufacturer = Build.MANUFACTURER;
        builder.append(String.format("%02x", manufacturer.length()));
        builder.append(manufacturer);

        String board = Build.BOARD;
        builder.append(String.format("%02x", board.length()));
        builder.append(board);

        String brand = Build.BRAND;
        builder.append(String.format("%02x", brand.length()));
        builder.append(brand);

        String hardware = Build.HARDWARE;
        builder.append(String.format("%02x", hardware.length()));
        builder.append(hardware);

        String packabename = context.getPackageName();
        builder.append(String.format("%02x", packabename.length()));
        builder.append(packabename);

        String deviceid = String.format("%02x", builder.length()) + builder.toString();
        String hexString = string2HEXString(deviceid);
        String base64String = string2BASE64String(hexString);
        String md5String = string2MD5String(base64String);
        return "ANDROID" + string2HEXString(md5String).toUpperCase() + "HS1";
    }

    private static String string2HEXString(String str) {
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }

    private static String string2BASE64String(String str) {
        return Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
    }

    private static String string2MD5String(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes());
        return new String(digest.digest());
    }
}
