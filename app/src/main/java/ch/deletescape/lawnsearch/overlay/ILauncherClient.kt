package ch.deletescape.lawnsearch.overlay

import android.content.Context
import ch.deletescape.lawnsearch.BuildConfig
import ch.deletescape.lawnsearch.Launcher
import ch.deletescape.lawnsearch.util.PackageManagerHelper

interface ILauncherClient {

    fun onStart()
    fun onStop()
    fun onPause()
    fun onResume()
    fun onDestroy()
    fun onAttachedToWindow()
    fun onDetachedFromWindow()
    fun remove()
    fun openOverlay(animate: Boolean)
    fun hideOverlay(animate: Boolean)
    fun startMove()
    fun endMove()
    fun updateMove(progress: Float)

    val isConnected: Boolean

    companion object {

        fun create(launcher: Launcher): ILauncherClient = if (BuildConfig.ENABLE_LAWNFEED)
            LawnfeedClient(launcher)
        else
            LauncherClientImpl(launcher, true)

        const val GOOGLE_APP_PACKAGE = "com.google.android.googlequicksearchbox"

        const val ENABLED = 0
        const val DISABLED_NO_GOOGLE_APP = 1
        const val DISABLED_NO_PROXY_APP = 2

        fun getEnabledState(context: Context): Int {
            var state = ENABLED
            if (!PackageManagerHelper.isAppEnabled(context.packageManager, GOOGLE_APP_PACKAGE, 0))
                state = state or DISABLED_NO_GOOGLE_APP
            if (BuildConfig.ENABLE_LAWNFEED &&
                    !PackageManagerHelper.isAppEnabled(context.packageManager, LawnfeedClient.PROXY_PACKAGE, 0))
                state = state or DISABLED_NO_PROXY_APP
            return state
        }
    }
}