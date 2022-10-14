//package com.ciberciti.subscraze.boilerplate.utils.storage;
//
//import java.util.List;
//
///**
// * Created by Abhishek Patel on 12-10-2022.
// */
//
//public class RealmUtils {
//
//    /**
//     * TODO: Add Realm Dependency
//     */
//    public static <E extends RealmModel> E copyFromRealm(E obj, Realm realm) {
//        if (obj == null) return null;
//        return realm.copyFromRealm(obj);
//    }
//
//    public static <E extends RealmModel> List<E> copyFromRealm(
//            Iterable<E> obj, Realm realm) {
//        if (obj == null) return null;
//        return realm.copyFromRealm(obj);
//    }
//
//    public static <E extends RealmModel> void saveToRealm(E obj) {
//        Realm realm = getRealm();
//        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(obj));
//        realm.close();
//    }
//
//    public static <E extends RealmModel> void saveToRealm(List<E> list) {
//        Realm realm = getRealm();
//        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(list));
//        realm.close();
//    }
//
//    public static <E extends RealmModel> void onlySaveToRealm(E obj) {
//        Realm realm = getRealm();
//        realm.executeTransaction(realm1 -> realm1.copyToRealm(obj));
//        realm.close();
//    }
//
//    public static void clearRealmTable(Class<? extends RealmModel> realmClass) {
//        Realm realm = getRealm();
//        realm.executeTransaction(realm1 -> realm1.delete(realmClass));
//        realm.close();
//    }
//
//    public static Realm getRealm() {
//        return Realm.getDefaultInstance();
//    }
//}
//
