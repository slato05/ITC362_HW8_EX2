plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.safeargs)
}

android {
    namespace = "com.example.itc362_hw8_ex2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.itc362_hw8_ex2"
        minSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)


    // Chapter 20 libraries
    implementation (libs.retrofit)
    implementation (libs.okhttp)
    implementation (libs.moshi)
    implementation (libs.converter.moshi)
    implementation (libs.converter.scalars)
    implementation (libs.coil)
    implementation(libs.navigation.fragment.ktx)
    ksp (libs.moshi.kotlin.codegen)
    ksp (libs.androidx.room.compiler)
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.paging.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}