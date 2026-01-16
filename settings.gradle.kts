pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        // CRITICAL: PatternLockView and RTL-ViewPager live here
        maven { url = uri("https://jcenter.bintray.com") } 
    }
}

rootProject.name = "Commons"
