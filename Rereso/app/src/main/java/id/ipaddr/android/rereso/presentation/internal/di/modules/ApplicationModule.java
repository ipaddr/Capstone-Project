package id.ipaddr.android.rereso.presentation.internal.di.modules;

/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.ipaddr.android.rereso.data.cache.CertificateOfBirthDataCache;
import id.ipaddr.android.rereso.data.cache.CertificateOfBirthDataCacheImpl;
import id.ipaddr.android.rereso.data.database.CertificateOfBirthDataDatabase;
import id.ipaddr.android.rereso.data.database.CertificateOfBirthDataDatabaseImpl;
import id.ipaddr.android.rereso.data.executor.JobExecutor;
import id.ipaddr.android.rereso.data.repository.CertificateOfBirthDataDataRepository;
import id.ipaddr.android.rereso.domain.executor.PostExecutionThread;
import id.ipaddr.android.rereso.domain.executor.ThreadExecutor;
import id.ipaddr.android.rereso.domain.repository.CertificateOfBirthDataRepository;
import id.ipaddr.android.rereso.presentation.AndroidApplication;
import id.ipaddr.android.rereso.presentation.UiThread;

import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    CertificateOfBirthDataCache provideCertificateOfBirthDataCache(CertificateOfBirthDataCacheImpl certificateOfBirthDataCache) {
        return certificateOfBirthDataCache;
    }

    @Provides @Singleton
    CertificateOfBirthDataDatabase provideCertificateOfBirthDataDatabase(CertificateOfBirthDataDatabaseImpl certificateOfBirthDataDatabase) {
        return certificateOfBirthDataDatabase;
    }

    @Provides @Singleton
    CertificateOfBirthDataRepository provideCertificateOfBirthDataRepository(CertificateOfBirthDataDataRepository certificateOfBirthDataDataRepository) {
        return certificateOfBirthDataDataRepository;
    }
}
