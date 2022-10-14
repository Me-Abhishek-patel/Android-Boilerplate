package com.ciberciti.subscraze.boilerplate.utils.other;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AppUtils {
    /**
     * Created by Abhishek Patel on 12-10-2022. 
     */

    private AppUtils() {
        // This class is not publicly instantiable
    }

    public static void openPlayStoreForApp(Context context ) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
}
