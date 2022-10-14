package com.ciberciti.subscraze.boilerplate.utils.other;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class IntentUtils {
    public static void openLinkInBrowser(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
