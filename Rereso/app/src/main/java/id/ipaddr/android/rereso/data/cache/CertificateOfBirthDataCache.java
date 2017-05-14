package id.ipaddr.android.rereso.data.cache;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 *
 * An interface representing a CertificateOfBirthData Cache.
 */

public interface CertificateOfBirthDataCache {

    /**
     * Gets an {@link Observable} which will emit a {@link CertificateOfBirthDataEntity}.
     *
     * @param id The CertificateOfBirthData id to retrieve data.
     * @return
     */
    Observable<CertificateOfBirthDataEntity> get(final String id);

    /**
     * Puts and element into the cache.
     *
     * @param certificateOfBirthDataEntity Element to insert in the cache.
     */
    void put(CertificateOfBirthDataEntity certificateOfBirthDataEntity);

    /**
     * Checks if an element (User) exists in the cache.
     *
     * @param id The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final String id);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
