package cu.wilb3r.musalaweatherapp.ui.annotations

import androidx.annotation.IntDef

@IntDef(
    MainActivityStateType.STARTING,
    MainActivityStateType.REQUESTING,
    MainActivityStateType.SUCCESS,
    MainActivityStateType.ERROR,
    MainActivityStateType.ERROR_WITH_DATA
)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class MainActivityStateType {
    companion object {
        const val STARTING = 0
        const val REQUESTING = 1
        const val SUCCESS = 2
        const val ERROR = 3
        const val ERROR_WITH_DATA = 4
    }
}
