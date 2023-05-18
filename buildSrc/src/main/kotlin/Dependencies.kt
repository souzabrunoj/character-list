import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.initialization.dsl.ScriptHandler.CLASSPATH_CONFIGURATION

private const val CONFIGURATION_NAME = "implementation"
private const val ANDROID_TESTE_CONFIGURATION_NAME = "androidTestImplementation"
private const val TESTE_CONFIGURATION_NAME = "testImplementation"

fun DependencyHandler.kotlinDependencies() {
    add(CONFIGURATION_NAME, "androidx.core:core-ktx:${Versions.coreKtxVersion}")
}

fun DependencyHandler.lifecycleRuntimeDependencies() {
    add(CONFIGURATION_NAME, "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}")
}

fun DependencyHandler.constraintLayoutImplementation() {
    add(CONFIGURATION_NAME, "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}")
}

fun DependencyHandler.materialImplementation() {
    add(CONFIGURATION_NAME, "com.google.android.material:material:${Versions.materialtVersion}")
}

fun DependencyHandler.projectUnitTestDependencies() {
    add(TESTE_CONFIGURATION_NAME, "junit:junit:${Versions.junitVersion}")
}

fun DependencyHandler.projectAndroidTestImplementation() {
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test.ext:junit:${Versions.extJunitVersion}")
    add(ANDROID_TESTE_CONFIGURATION_NAME, "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}")
}

fun DependencyHandler.projectConfigurantion() {
    add(CLASSPATH_CONFIGURATION, "com.android.tools.build:gradle:${Versions.gradlePluginVersion}")
    add(CLASSPATH_CONFIGURATION, "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePluginVersion}")
}