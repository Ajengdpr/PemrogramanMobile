plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.modul4"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.modul4"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }
}

dependencies {
    val versionCore: String by rootProject.extra
    val versionConstraintLayout: String by rootProject.extra
    val versionGlide: String by rootProject.extra
    val versionKotlin: String by rootProject.extra
    val versionLifecycle: String by rootProject.extra
    val versionMoshi: String by rootProject.extra
    val versionNavigation: String by rootProject.extra
    val versionRetrofit: String by rootProject.extra
    val versionRecyclerview: String by rootProject.extra

    implementation("androidx.core:core-ktx:$versionCore")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:$versionConstraintLayout")
    implementation("androidx.navigation:navigation-fragment-ktx:$versionNavigation")
    implementation("androidx.navigation:navigation-ui-ktx:$versionNavigation")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$versionKotlin")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$versionLifecycle")
    implementation("com.squareup.moshi:moshi-kotlin:$versionMoshi")
    implementation("com.squareup.retrofit2:converter-moshi:$versionRetrofit")
    implementation("com.github.bumptech.glide:glide:$versionGlide")
    implementation("androidx.recyclerview:recyclerview:$versionRecyclerview")
}