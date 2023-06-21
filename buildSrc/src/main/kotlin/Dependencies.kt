import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.initialization.dsl.ScriptHandler.CLASSPATH_CONFIGURATION

private const val IMPLEMENTATION_CONFIGURATION_NAME = "implementation"
private const val DEBUG_IMPLEMENTATION_CONFIGURATION_NAME = "debugImplementation"
private const val KAPT_CONFIGURATION_NAME = "kapt"
private const val ANDROID_TESTE_CONFIGURATION_NAME = "androidTestImplementation"
private const val TESTE_CONFIGURATION_NAME = "testImplementation"
private const val ANDROID_UTLIS_CONFIGURATION_NAME = "androidTestUtil"

fun DependencyHandler.kotlinDependencies() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.core:core-ktx:${Versions.coreKtxVersion}")
}

fun DependencyHandler.lifecycleRuntimeDependencies() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}"
    )
}

fun DependencyHandler.constraintLayoutImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    )
}

fun DependencyHandler.materialImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "com.google.android.material:material:${Versions.materialtVersion}"
    )
}

fun DependencyHandler.koinImplementation() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "io.insert-koin:koin-android:${Versions.koinVersion}")
}

fun DependencyHandler.picassoImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "com.squareup.picasso:picasso:${Versions.picassoVersion}"
    )
}

fun DependencyHandler.annotationImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "androidx.annotation:annotation:${Versions.annotationVersion}"
    )
}

fun DependencyHandler.customTabImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "com.android.support:customtabs:${Versions.customTabVersion}"
    )
}

fun DependencyHandler.pagingImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "androidx.paging:paging-runtime:${Versions.pagingVersion}"
    )
}

fun DependencyHandler.roomImplementation() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.room:room-runtime:${Versions.roomVersion}")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.room:room-ktx:${Versions.roomVersion}")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.room:room-paging:${Versions.roomVersion}")
    add(KAPT_CONFIGURATION_NAME, "androidx.room:room-compiler:${Versions.roomVersion}")
}

fun DependencyHandler.networkImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    )
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    )
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesVersion}"
    )
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptorVersion}"
    )
    add(IMPLEMENTATION_CONFIGURATION_NAME, "com.google.code.gson:gson:${Versions.gsonVersion}")
}

fun DependencyHandler.navigationImplementation() {
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    )
    add(
        IMPLEMENTATION_CONFIGURATION_NAME,
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    )
}

fun DependencyHandler.projectUnitTestDependencies() {
    add(TESTE_CONFIGURATION_NAME, "junit:junit:${Versions.junitVersion}")
    add(TESTE_CONFIGURATION_NAME, "org.robolectric:robolectric:${Versions.robolectricVersion}")
    add(TESTE_CONFIGURATION_NAME, "io.insert-koin:koin-test:${Versions.koinVersion}")
    add(TESTE_CONFIGURATION_NAME, "io.insert-koin:koin-test-junit4:${Versions.koinVersion}")
    add(TESTE_CONFIGURATION_NAME, "androidx.arch.core:core-testing:${Versions.archCoreTestVersion}")
    add(
        TESTE_CONFIGURATION_NAME,
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    )
}

fun DependencyHandler.projectAndroidTestImplementation() {
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test:core:${Versions.coreTestVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test:core-ktx:${Versions.coreTestVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test:runner:${Versions.runnerTestVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test:rules:${Versions.rulesTestVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test.ext:junit:${Versions.extJunitVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test.ext:junit:${Versions.extJunitVersion}")
    add(
        ANDROID_TESTE_CONFIGURATION_NAME,
        "org.junit.jupiter:junit-jupiter:${Versions.extJunitVersion}"
    )
    add(
        ANDROID_TESTE_CONFIGURATION_NAME,
        "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    )
    add(
        ANDROID_TESTE_CONFIGURATION_NAME,
        "androidx.arch.core:core-testing:${Versions.archCoreTestVersion}"
    )
    add(ANDROID_TESTE_CONFIGURATION_NAME, "io.insert-koin:koin-test:${Versions.koinVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "io.insert-koin:koin-test-junit4:${Versions.koinVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "io.insert-koin:koin-test-junit5:${Versions.koinVersion}")
    add(
        DEBUG_IMPLEMENTATION_CONFIGURATION_NAME,
        "androidx.fragment:fragment-testing:${Versions.fragmentVersion}"
    )
    add(ANDROID_TESTE_CONFIGURATION_NAME, "org.mockito:mockito-android:${Versions.mockitoVersion}")
    add(
        ANDROID_TESTE_CONFIGURATION_NAME,
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    )
    add(
        ANDROID_TESTE_CONFIGURATION_NAME,
        "androidx.navigation:navigation-testing:${Versions.navigationVersion}"
    )
}

fun DependencyHandler.projectConfigurantion() {
    add(CLASSPATH_CONFIGURATION, "com.android.tools.build:gradle:${Versions.gradlePluginVersion}")
    add(
        CLASSPATH_CONFIGURATION,
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePluginVersion}"
    )
    add(CLASSPATH_CONFIGURATION, "org.jacoco:org.jacoco.core:${Versions.jacocoVersion}")
    add(
        CLASSPATH_CONFIGURATION,
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
    )
}

fun DependencyHandler.projectAndroidUtils() {
    add(
        ANDROID_UTLIS_CONFIGURATION_NAME,
        "com.android.support.test:orchestrator:${Versions.orchestratorVersion}"
    )
}