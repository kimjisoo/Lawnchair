package ch.deletescape.lawnsearch.allapps;

/**
 * The unicode stripped search controller.
 */
public class UnicodeStrippedAppSearchController extends AllAppsSearchBarController {

    public DefaultAppSearchAlgorithm onInitializeSearch() {
        return new UnicodeStrippedAppSearchAlgorithm(mApps.getApps());
    }
}
