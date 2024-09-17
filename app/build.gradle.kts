plugins {
    alias(libs.plugins.compose.compiler)
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    //id("com.google.gms.google-services")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sebasdev.testtrullyimpl"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sebasdev.testtrullyimpl"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.appcompat:appcompat-resources:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //TEST
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")


    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.8.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // dagger hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // Log Call
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // NUBARIUM
    //implementation("com.github.nubarium:BiometricSDKComponents:v1.222")

    // Signature
    implementation("com.github.gcacace:signature-pad:1.3.1")

    // One Time Password
    implementation("dev.turingcomplete:kotlin-onetimepassword:2.4.0")

    // PinView
    implementation("io.github.chaosleung:pinview:1.4.4")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")

    // For developers using AndroidX in their applications
    implementation("pub.devrel:easypermissions:3.0.0")

    // For developers using the Android Support Library
    implementation("pub.devrel:easypermissions:3.0.0")

    //FireBase
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-analytics")

    //implementation(files("build/libs/app-debug.aar"))
    //implementation(project(path = ":data-module", configuration = "default"))
    implementation("com.google.android.gms:play-services-location:21.3.0")

    implementation("com.airbnb.android:lottie:5.2.0")

    //Trully
    implementation("com.github.TrullyAI:DocumentReaderFullAuth:7.9.9555")
    implementation("com.github.TrullyAI:TrullyKotlinSDK:3.0.1") //change latest for the version number v2.2.10
    // Support for Java 8 features
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.2")

}

kapt {
    correctErrorTypes = true
}