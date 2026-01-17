import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library") version "8.2.2"
    id("org.jetbrains.kotlin.android") version "1.9.22"
    id("org.jetbrains.kotlin.plugin.parcelize") version "1.9.22"
    id("com.google.devtools.ksp") version "1.9.22-1.0.17"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
    `maven-publish`
}

group = "org.fossify"
version = "1.0.0"

android {
    namespace = "org.fossify.commons"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
        vectorDrawables.useSupportLibrary = true
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    tasks.withType<KotlinCompile> {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    api("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.7")
    api("androidx.core:core-ktx:1.12.0")
    api("androidx.appcompat:appcompat:1.6.1")
    api("com.google.android.material:material:1.11.0")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.documentfile:documentfile:1.0.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.exifinterface:exifinterface:1.3.7")
    implementation("androidx.biometric:biometric-ktx:1.2.0-alpha05")
    implementation("androidx.lifecycle:lifecycle-process:2.7.0")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.compose.ui:ui:1.6.7")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.7")
    implementation("androidx.compose.ui:ui-viewbinding:1.6.7")

    implementation("com.googlecode.ez-vcard:ez-vcard:0.11.3")
    api("joda-time:joda-time:2.12.7")
    api("me.zhanghai.android.fastscroll:library:1.3.0")
    
    // --- FIXED DEPENDENCIES (DO NOT CHANGE) ---
    // 1. Reprint: Use the specific commit hash or valid tag if 4.0.0 fails
    api("com.github.tibbi:reprint:28bfde9") 
    
    // 2. RtlViewPager: Use the specific commit hash from GitHub
    api("com.github.duolingo:rtl-viewpager:940f12724f") 

    // 3. PatternLockView: Use master-SNAPSHOT as there are no release tags
    api("com.github.aritraroy:PatternLockView:master-SNAPSHOT") 
    // ------------------------------------------

    api("com.google.code.gson:gson:2.10.1")

    api("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
    ksp("com.github.bumptech.glide:ksp:4.16.0")

    api("androidx.room:room-runtime:2.6.1")
    api("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
}
