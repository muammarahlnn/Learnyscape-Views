package com.muammarahlnn.convention

import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.Project

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AndroidInstrumentedTestPlugin, 07/03/2024 03.49
 */
internal fun LibraryAndroidComponentsExtension.disableUnnecessaryAndroidTests(project: Project) {
    beforeVariants {
        it.enableAndroidTest= it.enableAndroidTest && project.projectDir.resolve("src/androidTests").exists()
    }
}