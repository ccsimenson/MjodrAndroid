pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

gradle.startParameter.showStacktrace = ShowStacktrace.ALWAYS

gradle.taskGraph.whenReady {
    tasks.withType<Wrapper>().configureEach {
        gradleVersion = "8.2"
        distributionType = Wrapper.DistributionType.ALL
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Mjöðr"
include(":app")
