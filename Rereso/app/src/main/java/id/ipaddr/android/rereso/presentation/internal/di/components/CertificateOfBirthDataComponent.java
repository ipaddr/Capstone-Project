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

import dagger.Component;
import id.ipaddr.android.rereso.presentation.internal.di.PerActivity;
import id.ipaddr.android.rereso.presentation.internal.di.modules.ActivityModule;
import id.ipaddr.android.rereso.presentation.internal.di.modules.CertificateOfBirthDataModul;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataGetDetailFragment;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataGetListFragment;
import id.ipaddr.android.rereso.presentation.view.fragment.CertificateOfBirthDataSetDetailFragment;

/**
 * A scope {@link PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, CertificateOfBirthDataModul.class})
public interface CertificateOfBirthDataComponent extends ActivityComponent {
    void inject(CertificateOfBirthDataGetListFragment certificateOfBirthDataGetListFragment);
    void inject(CertificateOfBirthDataGetDetailFragment certificateOfBirthDataGetDetailFragment);
    void inject(CertificateOfBirthDataSetDetailFragment certificateOfBirthDataSetDetailFragment);
}