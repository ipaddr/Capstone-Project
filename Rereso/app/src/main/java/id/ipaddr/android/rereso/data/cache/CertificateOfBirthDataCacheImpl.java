package id.ipaddr.android.rereso.data.cache;

import android.content.Context;

import java.io.File;

import javax.inject.Inject;

import id.ipaddr.android.rereso.data.cache.serializer.Serializer;
import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.exception.CertificateOfBirthDataNotFoundException;
import id.ipaddr.android.rereso.domain.executor.ThreadExecutor;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 */

public class CertificateOfBirthDataCacheImpl implements CertificateOfBirthDataCache {

    private static final String SETTINGS_FILE_NAME = "id.ipaddr.android.rereso.data.cache.SETTINGS";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

    private static final String DEFAULT_FILE_NAME = "certificateofbirth_";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

    private final Context mContext;
    private final File mCacheDir;
    private final Serializer mSerializer;
    private final FileManager mFileManager;
    private final ThreadExecutor mThreadExecutor;

    @Inject CertificateOfBirthDataCacheImpl(Context context, Serializer serializer, FileManager fileManager, ThreadExecutor executor){
        if (context == null || serializer == null ||fileManager == null || executor == null){
            throw new IllegalArgumentException("Invalid null parameter");
        }
        mContext = context;
        mCacheDir = mContext.getCacheDir();
        mSerializer = serializer;
        mFileManager = fileManager;
        mThreadExecutor = executor;
    }

    @Override
    public Observable<CertificateOfBirthDataEntity> get(final String id) {
        return Observable.create(emitter -> {
            final File userEntityFile = CertificateOfBirthDataCacheImpl.this.buildFile(id);
            final String fileContent = CertificateOfBirthDataCacheImpl.this.mFileManager.readFileContent(userEntityFile);
            final CertificateOfBirthDataEntity entity =
                    CertificateOfBirthDataCacheImpl.this.mSerializer.deserialize(fileContent, CertificateOfBirthDataEntity.class);

            if (entity != null) {
                emitter.onNext(entity);
                emitter.onComplete();
            } else {
                emitter.onError(new CertificateOfBirthDataNotFoundException());
            }
        });
    }

    @Override
    public void put(CertificateOfBirthDataEntity certificateOfBirthDataEntity) {
        if (certificateOfBirthDataEntity != null){
            final File certificateOfBirthDataFile = this.buildFile(certificateOfBirthDataEntity.id);
            if (!isCached(certificateOfBirthDataEntity.id)) {
                final String jsonString = this.mSerializer.serialize(certificateOfBirthDataEntity, CertificateOfBirthDataEntity.class);
                this.executeAsynchronously(new CacheWriter(this.mFileManager, certificateOfBirthDataFile, jsonString));
                setLastCacheUpdateTimeMillis();
            }
        }
    }

    @Override
    public boolean isCached(String id) {
        final File entityFile = this.buildFile(id);
        return this.mFileManager.exists(entityFile);
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

        if (expired) {
            this.evictAll();
        }

        return expired;
    }

    @Override
    public void evictAll() {
        this.executeAsynchronously(new CacheEvictor(this.mFileManager, this.mCacheDir));
    }

    /**
     * Build a file, used to be inserted in the disk cache.
     *
     * @param id The id user to build the file.
     * @return A valid file.
     */
    private File buildFile(String id) {
        final StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(mCacheDir.getPath());
        fileNameBuilder.append(File.separator);
        fileNameBuilder.append(DEFAULT_FILE_NAME);
        fileNameBuilder.append(id);

        return new File(fileNameBuilder.toString());
    }

    /**
     * Set in millis, the last time the cache was accessed.
     */
    private void setLastCacheUpdateTimeMillis() {
        final long currentMillis = System.currentTimeMillis();
        mFileManager.writeToPreferences(mContext, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private long getLastCacheUpdateTimeMillis() {
        return mFileManager.getFromPreferences(mContext, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE);
    }

    /**
     * Executes a {@link Runnable} in another Thread.
     *
     * @param runnable {@link Runnable} to execute
     */
    private void executeAsynchronously(Runnable runnable) {
        mThreadExecutor.execute(runnable);
    }

    /**
     * {@link Runnable} class for writing to disk.
     */
    private static class CacheWriter implements Runnable {
        private final FileManager fileManager;
        private final File fileToWrite;
        private final String fileContent;

        CacheWriter(FileManager fileManager, File fileToWrite, String fileContent) {
            this.fileManager = fileManager;
            this.fileToWrite = fileToWrite;
            this.fileContent = fileContent;
        }

        @Override public void run() {
            this.fileManager.writeToFile(fileToWrite, fileContent);
        }
    }

    /**
     * {@link Runnable} class for evicting all the cached files
     */
    private static class CacheEvictor implements Runnable {
        private final FileManager fileManager;
        private final File cacheDir;

        CacheEvictor(FileManager fileManager, File cacheDir) {
            this.fileManager = fileManager;
            this.cacheDir = cacheDir;
        }

        @Override public void run() {
            this.fileManager.clearDirectory(this.cacheDir);
        }
    }
}
