plugins {
    alias(multiwave.plugins.android.application)
    alias(multiwave.plugins.kotlin.android)
    alias(multiwave.plugins.kotlin.kapt)
}

android {
    namespace = "com.scwang.wave.app"
    compileSdk = 34

    defaultConfig {
        applicationId = namespace
        minSdk = 14
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(multiwave.androidx.appcompat)
    implementation(multiwave.material)
    implementation(multiwave.androidx.constraintlayout)
    implementation(multiwave.androidx.vectordrawable)
    implementation(multiwave.lobsterpicker)
    implementation(multiwave.discrete.seekbar)

    androidTestImplementation(multiwave.androidx.test.runner)
    androidTestImplementation(multiwave.espresso.core)
    testImplementation(multiwave.junit)

    implementation(project(":library"))
}
