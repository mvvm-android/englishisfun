package dependencies

/**
 * Project annotation processor dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object AnnotationProcessorsDependencies {
    const val AUTO_SERVICE = "com.google.auto.service:auto-service:${BuildDependenciesVersions.AUTO_SERVICE}"
    const val DATABINDING = "com.android.databinding:compiler:${BuildDependenciesVersions.DATABINDING}"
    const val HILT = "com.google.dagger:hilt-android-compiler:${BuildDependenciesVersions.HILT}"
    const val ROOM = "androidx.room:room-compiler:${BuildDependenciesVersions.ROOM}"
}
