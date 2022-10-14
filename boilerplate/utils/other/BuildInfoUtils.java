package com.ciberciti.subscraze.boilerplate.utils.other;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class BuildInfoUtils {
    public static int getVersionCode(Context context) {
        int v = 0;
        try {
            v = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException ignored) {

        }
        return v;
    }
}
