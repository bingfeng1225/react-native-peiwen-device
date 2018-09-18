
package com.qd.peiwen.device;

import android.os.Build;
import android.util.Base64;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PWDeviceModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext context;

    public PWDeviceModule(ReactApplicationContext context) {
        super(context);
        this.context = context;
    }

    @Override
    public String getName() {
        return "PWDevice";
    }


    @ReactMethod
    public void uniqueDeviceID(Promise promise) {
        try {
            String deviceid = PWDevice.deviceID(this.context);
            promise.resolve(deviceid);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject(e);
        }

    }

}
