pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // Keep this strict mode! It's good practice.
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        // We move the required repo HERE
        maven { url = uri("https://jcenter.bintray.com") } 
    }
}

rootProject.name = "Commons"
