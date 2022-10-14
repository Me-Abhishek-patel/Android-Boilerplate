package com.ciberciti.subscraze.boilerplate.other.changelog;

import androidx.fragment.app.FragmentActivity;
import com.ciberciti.subscraze.boilerplate.utils.other.BuildInfoUtils;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class ChangeLogManager {
    private FragmentActivity activity;
    private ChangeLogPreferencesHelper preferenceManager;
    private int currentVersionCode;

    public ChangeLogManager(FragmentActivity context) {
        this.activity = context;
        preferenceManager = new ChangeLogPreferencesHelper(context);
    }

    private boolean isChangeLogNeeded() {
        int cachedVersionCode = preferenceManager.getVersionCode();
        currentVersionCode = BuildInfoUtils.getVersionCode(activity);

        return cachedVersionCode == ChangeLogPreferencesHelper.DEFAULT_VERSION_CODE ||
                currentVersionCode != cachedVersionCode;
    }

    public void analyze() {
        if (isChangeLogNeeded()) {
            ChangeLogFragment.show(activity.getSupportFragmentManager());
            preferenceManager.setVersionCode(currentVersionCode);
        }
    }
}
