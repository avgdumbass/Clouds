plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.cloudswithtile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cloudswithtile"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation ("androidx.wear.tiles:tiles:1.0.0")
    implementation ("androidx.wear.tiles:tiles-material:1.0.0")
    implementation ("com.aallam.openai:openai-client:3.0.0") // Adjust the version as needed
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")
    implementation ("androidx.compose.runtime:runtime-livedata:1.0.5")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.aallam.openai:openai-client:3.0.0")
    implementation("io.ktor:ktor-client-android:2.2.4")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("androidx.wear.protolayout:protolayout-material:1.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.5.1")
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation(libs.play.services.wearable)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)
    implementation(libs.compose.material)
    implementation(libs.compose.foundation)
    implementation(libs.activity.compose)
    implementation(libs.core.splashscreen)
    implementation(libs.tiles)
    implementation(libs.tiles.material)
    implementation(libs.horologist.compose.tools)
    implementation(libs.horologist.tiles)
    implementation(libs.watchface.complications.data.source.ktx)
    implementation(libs.navigation.compose)
    implementation(libs.navigation.runtime.ktx)
    implementation(libs.runtime.livedata)
    implementation(libs.material3.android)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}