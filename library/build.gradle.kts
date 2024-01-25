plugins {
    alias(multiwave.plugins.android.library)
    alias(multiwave.plugins.kotlin.android)
    alias(multiwave.plugins.kotlin.kapt)
}

android {
    namespace = "com.scwang.wave"
    compileSdk = 34

    defaultConfig {
        minSdk = 14

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    testImplementation(multiwave.junit)
    androidTestImplementation(multiwave.androidx.test.runner)
    androidTestImplementation(multiwave.espresso.core)

    compileOnly(multiwave.androidx.appcompat)
    compileOnly(multiwave.androidx.core)
}
