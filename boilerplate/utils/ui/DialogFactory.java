package com.ciberciti.subscraze.boilerplate.utils.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class DialogFactory {
    public static Dialog createSimpleOkErrorDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton("OK", null);
        return alertDialog.create();
    }

    public static Dialog createSimpleOkErrorDialog(Context context,
                                                   @StringRes int titleResource,
                                                   @StringRes int messageResource) {

        return createSimpleOkErrorDialog(context,
                context.getString(titleResource),
                context.getString(messageResource));
    }

    //TODO : Replace hardcoded Strings with context.getString(R.string.dialog_error_title)
    public static Dialog createGenericErrorDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage(message)
                .setNeutralButton("OK", null);
        return alertDialog.create();
    }

    public static Dialog createGenericErrorDialog(Context context, @StringRes int messageResource) {
        return createGenericErrorDialog(context, context.getString(messageResource));
    }

    public static ProgressDialog createProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static ProgressDialog createProgressDialog(Context context,
                                                      @StringRes int messageResource) {
        return createProgressDialog(context, context.getString(messageResource));
    }
}
