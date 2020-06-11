/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"
    const val BASE_ANDROID = ":base-android"

    object Features {
        const val HOME = ":feature_home"
        const val ABBREVIATIONS = ":feature_abbreviations"
    }

    object Libraries {
        const val TEST_UTILS = ":libraries:test_utils"
    }
}
