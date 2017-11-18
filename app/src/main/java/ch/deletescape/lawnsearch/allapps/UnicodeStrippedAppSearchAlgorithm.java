package ch.deletescape.lawnsearch.allapps;

import java.util.List;

import ch.deletescape.lawnsearch.AppInfo;
import ch.deletescape.lawnsearch.util.UnicodeFilter;

/**
 * A search algorithm that changes every non-ascii characters to theirs ascii equivalents and
 * then performs comparison.
 */
public class UnicodeStrippedAppSearchAlgorithm extends DefaultAppSearchAlgorithm {
    public UnicodeStrippedAppSearchAlgorithm(List<AppInfo> apps) {
        super(apps);
    }

    @Override
    protected boolean matches(AppInfo info, String query) {
        String title = UnicodeFilter.filter(info.title.toString().toLowerCase());
        String strippedQuery = UnicodeFilter.filter(query.trim());
        int queryLength = strippedQuery.length();

        if (title.length() < queryLength || queryLength <= 0) {
            return false;
        }

        return title.indexOf(strippedQuery) >= 0;
    }
}
