package com.ciberciti.subscraze.boilerplate.utils.ui;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class ToastUtils {

    public static void useLongToast(Context context, String message) {
        if (context == null || message == null)
            return;

        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }


    public static void useShortToast(Context context, String message) {
        if (context == null || message == null)
            return;

        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void useLongToastForIntegerSet(Set<Integer> ourSet, Context context) {
        StringBuilder printStr = new StringBuilder("Set : ");

        Iterator itr = ourSet.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            printStr.append(element.toString()).append(", ");
        }

        useLongToast(context, printStr.toString());
    }


    public static void useToastInService(final Handler handler,
                                         final Context context, final String message) {
        handler.post(() -> useLongToast(context, message));
    }
}
