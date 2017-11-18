package ch.deletescape.lawnsearch.config

import android.content.Context
import ch.deletescape.lawnsearch.Utilities
import ch.deletescape.lawnsearch.allapps.theme.AllAppsBaseTheme
import ch.deletescape.lawnsearch.allapps.theme.AllAppsVerticalTheme
import ch.deletescape.lawnsearch.allapps.theme.IAllAppsThemer
import ch.deletescape.lawnsearch.popup.theme.IPopupThemer
import ch.deletescape.lawnsearch.popup.theme.PopupBaseTheme
import ch.deletescape.lawnsearch.popup.theme.PopupCardTheme

open class ThemerImpl : IThemer {

    var allAppsTheme: IAllAppsThemer? = null
    var popupTheme: IPopupThemer? = null

    override fun allAppsTheme(context: Context): IAllAppsThemer {
        val useVerticalLayout = Utilities.getPrefs(context).verticalDrawerLayout
        if (allAppsTheme == null ||
                (useVerticalLayout && allAppsTheme !is AllAppsVerticalTheme) ||
                (!useVerticalLayout && allAppsTheme is AllAppsVerticalTheme))
            allAppsTheme = if (useVerticalLayout) AllAppsVerticalTheme(context) else AllAppsBaseTheme(context)
        return allAppsTheme!!
    }

    override fun popupTheme(context: Context): IPopupThemer {
        val useCardTheme = Utilities.getPrefs(context).popupCardTheme
        if (popupTheme == null ||
                (useCardTheme && popupTheme !is PopupCardTheme) ||
                (!useCardTheme && popupTheme !is PopupBaseTheme)) {
            popupTheme = if (useCardTheme) PopupCardTheme() else PopupBaseTheme()
        }
        return popupTheme!!
    }
}