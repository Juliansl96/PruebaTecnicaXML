plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //Se requiere para Koin
    id("kotlin-kapt")
}

android {
    namespace = "com.example.pruebatecnicaxml"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.pruebatecnicaxml"
        minSdk = 26
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    //Se usa para el binding
    buildFeatures{
        viewBinding=true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.cardview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    /*implementation koin*/
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)

    /*Implementación de room*/
    implementation(libs.room)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    // ViewModel
    implementation(libs.koin.android)
}