package ch.deletescape.lawnsearch.config

import android.content.Context
import ch.deletescape.lawnsearch.allapps.theme.IAllAppsThemer
import ch.deletescape.lawnsearch.popup.theme.IPopupThemer

interface IThemer {

    fun allAppsTheme(context: Context): IAllAppsThemer
    fun popupTheme(context: Context): IPopupThemer
}