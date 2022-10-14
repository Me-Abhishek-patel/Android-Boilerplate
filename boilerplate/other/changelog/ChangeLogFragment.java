package com.ciberciti.subscraze.boilerplate.other.changelog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.ciberciti.subscraze.R;
import it.gmariotti.changelibs.library.view.ChangeLogRecyclerView;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class ChangeLogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ChangeLogRecyclerView chgList = (ChangeLogRecyclerView) layoutInflater.inflate(
                R.layout.changelog_fragment_dialog, null);

        return new AlertDialog.Builder(getActivity(), androidx.appcompat.R.style.AlertDialog_AppCompat)
                .setTitle("What's New!!!")
                .setView(chgList)
                .setPositiveButton("OK",
                        (dialog, whichButton) -> dialog.dismiss()
                )
                .create();
    }

    public static ChangeLogFragment newInstance() {
        Bundle args = new Bundle();
        ChangeLogFragment fragment = new ChangeLogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static void show(FragmentManager fm) {
        ChangeLogFragment fragment = ChangeLogFragment.newInstance();
        fragment.show(fm);
    }

    /**
     *     TODO: Add (    implementation 'com.github.gabrielemariotti.changeloglib:changelog:2.1.0' )
     *     First, add in your layout the ChangeLogRecyclerView that displays your changelog.
     *
     * <?xml version="1.0" encoding="utf-8"?>
     * <it.gmariotti.changelibs.library.view.ChangeLogRecyclerView
     *     xmlns:android="http://schemas.android.com/apk/res/android"
     *     android:id="@+id/view"
     *     android:layout_width="match_parent"
     *     android:layout_height="match_parent"
     *     android:layout_gravity="center" />
     * Then, you need a XML file with change log in res/raw folder. It automatically searches for res/raw/changelog.xml but you can customize filename.
     *
     * <?xml version="1.0" encoding="utf-8"?>
     * <changelog bulletedList="true">
     *
     *     <changelogversion versionName="1.0" changeDate="Aug 26,2013">
     *             <changelogtext>Initial release.</changelogtext>
     *     </changelogversion>
     *
     *     <changelogversion versionName="0.9" changeDate="Aug 11,2013">
     *         <changelogtext>[b]New![/b] Add new attrs to customize header and row layout</changelogtext>
     *         <changelogtext>Fixed log while parsing </changelogtext>
     *         <changelogtext>Add support for html markup</changelogtext>
     *         <changelogtext>Add bullet point in </changelogtext>
     *         <changelogtext>Support for customized xml filename</changelogtext>
     *     </changelogversion>
     *
     * </changelog>
     * Last, if you would like a multi language changelog, you just have to put the translated files changelog.xml in the appropriate folders res/raw-xx/.
     *
     */
}