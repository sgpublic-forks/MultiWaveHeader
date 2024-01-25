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
        maven("https://jitpack.io")
        jcenter()
    }

    versionCatalogs {
        val multiwave by creating {
            from(files("./gradle/multiwave.versions.toml"))
        }
    }
}

rootProject.name = "MultiWaveHeader"
include(":library")
include(":app")