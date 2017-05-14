package id.ipaddr.android.rereso.presentation.internal.di.components;

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
import dagger.Component;
import id.ipaddr.android.rereso.domain.executor.PostExecutionThread;
import id.ipaddr.android.rereso.domain.executor.ThreadExecutor;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.repository.CertificateOfBirthDataRepository;
import id.ipaddr.android.rereso.presentation.internal.di.modules.ApplicationModule;
import id.ipaddr.android.rereso.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    CertificateOfBirthDataRepository certificateOfBirthDataRepository();
}
