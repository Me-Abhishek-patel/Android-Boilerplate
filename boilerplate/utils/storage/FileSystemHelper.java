package com.ciberciti.subscraze.boilerplate.utils.storage;

import android.content.Context;
import android.database.Observable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.ciberciti.subscraze.boilerplate.utils.data.RandomUtils;
import timber.log.Timber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
//
//public class FileSystemHelper {
//    private Context context;
//
//    public FileSystemHelper( Context context) {
//        this.context = context;
//    }
//
//    public boolean deleteFile(String path) {
//        if (path == null) {
//            return false;
//        }
//        File file = new File(path);
//        if (file.exists()) {
//            return file.delete();
//        } else {
//            return false;
//        }
//    }
//
//    public Observable<List<String>> listAssetFiles(String path) {
//        return Observable.create(emitter -> {
//            List<String> pathList = new ArrayList<>();
//            listAssetFiles(path, pathList);
//            emitter.onNext(pathList);
//            emitter.onComplete();
//        });
//    }
//
//    private boolean listAssetFiles(String path, List<String> fileList) {
//        String[] list;
//        try {
//            list = context.getAssets().list(path);
//            if (list.length > 0) {
//                // This is a folder
//                for (String file : list) {
//                    if (!listAssetFiles(path + "/" + file, fileList)) {
//                        return false;
//                    } else {
//                        fileList.add(path + "/" + file);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            return false;
//        }
//        return true;
//    }
//
//    public Observable<List<String>> copyAssetsToStorage(List<Pair<String, String>> fileList) {
//        return Observable.create(emitter -> {
//            List<String> files = new ArrayList<>();
//            for (Pair<String, String> filenames : fileList) {
//                Timber.i(filenames.toString());
//                InputStream in = null;
//                OutputStream out = null;
//                try {
//                    in = context.getAssets().open(filenames.getValue0());
//                    File outFile = buildPath(buildFileName(filenames.getValue1()));
//                    out = new FileOutputStream(outFile);
//                    copyFile(in, out);
//                    files.add(outFile.getAbsolutePath());
//                } catch (IOException e) {
//
//                } finally {
//                    if (in != null) {
//                        try {
//                            in.close();
//                        } catch (IOException e) {
//
//                        }
//                    }
//                    if (out != null) {
//                        try {
//                            out.close();
//                        } catch (IOException e) {
//
//                        }
//                    }
//                }
//            }
//            emitter.onNext(files);
//            emitter.onComplete();
//        });
//    }
//
//    private void copyFile(InputStream in, OutputStream out) throws IOException {
//        byte[] buffer = new byte[1024];
//        int read;
//        while ((read = in.read(buffer)) != -1) {
//            out.write(buffer, 0, read);
//        }
//    }
//
//
//    public Observable<Bitmap> getBitmapFromAsset(Context context, String assetPath) {
//        return Observable.fromCallable(() -> {
//                    InputStream ims = context.getAssets().open(assetPath);
//                    return BitmapFactory.decodeStream(ims);
//                }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//    public Observable<Optional<File>> saveFileToDisk(
//            final Response<ResponseBody> response, String filename) {
//        return Observable.create(emitter -> {
//            try {
//                Optional<File> destinationFile = Optional.empty();
//                if (response.isSuccessful()) {
//                    destinationFile = Optional.of(buildPath(buildFileName(filename)));
//
//                    BufferedSink bufferedSink =
//                            Okio.buffer(Okio.sink(destinationFile.get()));
//                    bufferedSink.writeAll(response.body().source());
//                    bufferedSink.close();
//
//                }
//                emitter.onNext(destinationFile);
//                emitter.onComplete();
//            } catch (IOException ex) {
//                emitter.onError(ex);
//            }
//        });
//    }
//
//    public Observable<Optional<File>> saveBitmapToDisk(final Bitmap bmp, String filename) {
//        Timber.i(filename);
//        return Observable.create(emitter -> {
//            FileOutputStream out = null;
//            Optional<File> destinationFile = Optional.empty();
//            try {
//                destinationFile = Optional.of(buildPath(buildFileName(filename)));
//                out = new FileOutputStream(destinationFile.get().getAbsolutePath());
//                bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
//                out.close();
//                emitter.onNext(Optional.of(new File(filename)));
//                emitter.onComplete();
//            } catch (Exception e) {
//                try {
//                    if (out != null) {
//                        out.close();
//                    }
//                } catch (Exception ee) {
//                    emitter.onError(ee);
//                }
//                emitter.onError(e);
//            }
//        });
//    }
//
//    @NonNull
//    private String buildFileName(String name) {
//        return (name != null ? name : new RandomUtils().nextString()) + ".jpg";
//    }
//
//    @NonNull
//    private File buildPath(String filename) {
//        String sub = context.getFilesDir().getPath();
//        String pathF = sub + "/images/";
//        new File(pathF).mkdirs();
//        return new File(pathF + filename);
//    }
//
//    public static Uri getAssetsFilePath(String fileName) {
//        return Uri.parse(String.format("file:///android_asset/%s", fileName));
//    }
//
//}


/**
 * TODO
 * allprojects {
 *     repositories {
 *         maven { url "https://oss.jfrog.org/libs-snapshot" }
 *     }
 * }
 *
 * dependencies {
 *     implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
 *     // Because RxAndroid releases are few and far between, it is recommended you also
 *     // explicitly depend on RxJava's latest version for bug fixes and new features.
 *     // (see https://github.com/ReactiveX/RxJava/releases for latest 3.x.x version)
 *     implementation 'io.reactivex.rxjava3:rxjava:3.0.0'
 * }
 */
