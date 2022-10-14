package com.ciberciti.subscraze.boilerplate.utils.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class FragmentUtils {
    public static boolean isBackStackEmpty(FragmentActivity fragmentAct) {
        FragmentManager fm = fragmentAct.getSupportFragmentManager();
        return fm.getBackStackEntryCount() == 0;
    }

    public static void addFragment(int contId, Fragment fg,
                                   FragmentActivity fragmentAct) {
        FragmentTransaction transaction = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        transaction.add(contId, fg);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static void addFragmentWithoutBackStack(int contId, Fragment fg,
                                                   FragmentActivity fragmentAct) {
        FragmentTransaction transaction = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        transaction.add(contId, fg);
        transaction.commit();
    }

    public static void clearBackStackAndAddFragment(int contId, Fragment fg,
                                                    FragmentActivity fragmentAct) {
        clearBackStack(fragmentAct);
        addFragment(contId, fg, fragmentAct);
    }

    public static void clearBackStackAndAddFragmentWithoutIt(
            int contId, Fragment fg, FragmentActivity fragmentAct) {
        addFragmentWithoutBackStack(contId, fg, fragmentAct);
    }

    public static void clearBackStack(FragmentActivity fragmentAct) {
        FragmentManager manager = fragmentAct.getSupportFragmentManager();
        int backStackCount = manager.getBackStackEntryCount();
        for (int i = 0; i < backStackCount; i++) {
            int backStackId = manager.getBackStackEntryAt(i).getId();
            manager.popBackStack(backStackId,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public static void replaceWithoutBackStack(int contId, Fragment fg,
                                               FragmentActivity fragmentAct) {
        FragmentTransaction transaction = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        transaction.replace(contId, fg);
        transaction.commit();
    }

    public static void replaceWithoutBackStackWithTransition(int contId,
                                                             Fragment fg, FragmentActivity fragmentAct) {
        FragmentTransaction tr = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        tr.setCustomAnimations(android.R.anim.slide_in_left, 0);
        tr.replace(contId, fg);
        tr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tr.commit();
    }

    public static void replaceWithoutBackStackWithTransition(int contId,
                                                             int animId, Fragment fg, FragmentActivity fragmentAct) {
        FragmentTransaction tr = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        tr.setCustomAnimations(animId, 0);
        tr.replace(contId, fg);
        tr.commit();
    }

    public static void replaceWithBackStackWithTransition(int contId,
                                                          int animId, Fragment fg, FragmentActivity fragmentAct) {
        FragmentTransaction tr = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        tr.setCustomAnimations(animId, 0);
        tr.replace(contId, fg);
        tr.addToBackStack(null);
        tr.commit();
    }

    public static void replaceWithBackStackWithAnimation(int contId,
                                                         List<Integer> animQuartet,
                                                         Fragment fg,
                                                         FragmentActivity fragmentAct) {
        FragmentTransaction tr = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        tr.setCustomAnimations(animQuartet.get(0),
                animQuartet.get(1),
                animQuartet.get(2),
                animQuartet.get(3));
        tr.replace(contId, fg);
        tr.addToBackStack(null);
        tr.commit();
    }

    public static void replaceWithBackStack(int contId, Fragment fg, FragmentActivity fragmentAct) {
        FragmentTransaction tr = fragmentAct
                .getSupportFragmentManager().beginTransaction();
        tr.replace(contId, fg);
        tr.addToBackStack(null);
        tr.commit();
    }

    public static Fragment getTopFragment(FragmentActivity fragmentAct, int contId) {
        return fragmentAct.getSupportFragmentManager().findFragmentById(contId);
    }
}
