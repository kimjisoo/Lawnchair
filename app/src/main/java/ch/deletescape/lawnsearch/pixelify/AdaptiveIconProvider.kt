package ch.deletescape.lawnsearch.pixelify

import android.content.res.Resources
import android.graphics.drawable.Drawable
import ch.deletescape.lawnsearch.Utilities
import ch.deletescape.lawnsearch.graphics.IconShapeOverride
import ch.deletescape.lawnsearch.util.DrawableUtils
import ch.deletescape.lawnsearch.util.drawableInflater
import ch.deletescape.lawnsearch.util.overrideSdk

class AdaptiveIconProvider {

    companion object {

        const val TAG = "AdaptiveIconProvider"

        fun getDrawableForDensity(res: Resources, id: Int, density: Int, shapeInfo: IconShapeOverride.ShapeInfo): Drawable {
            var drawable: Drawable? = null
            if (shapeInfo.useRoundIcon && !Utilities.ATLEAST_OREO) {
                // Backport for < O
                res.overrideSdk(26) {
                    drawable = try {
                        res.getDrawableForDensity(id, density)
                    } catch (e: Resources.NotFoundException) {
                        val drawableInflater = res.drawableInflater
                        val parser = res.getXml(id)
                        DrawableUtils.inflateFromXml(drawableInflater, parser)
                    }
                }
            } else if (!shapeInfo.useRoundIcon && Utilities.ATLEAST_OREO) {
                // Force non-rounded icons on O
                res.overrideSdk(25) {
                    drawable = res.getDrawableForDensity(id, density)
                }
            } else {
                drawable = res.getDrawableForDensity(id, density)
            }
            return drawable!!
        }
    }
}