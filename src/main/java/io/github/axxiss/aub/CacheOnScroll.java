package main.java.io.github.axxiss.aub;

import android.widget.AbsListView;

/**
 * A {@link android.widget.AbsListView} scroll listener for caching data in the background before
 * the user needs it.
 *
 * @author Axxiss
 */
public abstract class CacheOnScroll implements AbsListView.OnScrollListener {
    private static final String TAG = "CacheOnScroll";

    /**
     * Flag to indicate if data is being loaded.
     */
    private boolean loading = true;

    /**
     * Current page number
     */
    private int currentPage = 0;

    /**
     * Variable to determine when load finished.
     */
    private int previousTotal = 0;

    /**
     * Initialize the listener and get the initial data set.
     */
    public CacheOnScroll() {
        cacheOnBackground(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onScroll(final AbsListView view, final int firstVisibleItem, final int visibleItemCount,
                         final int totalItemCount) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                currentPage++;
            }
        }

        if (!(loading) && (totalItemCount - visibleItemCount) <= firstVisibleItem) {
            cacheOnBackground(currentPage);
            loading = true;
        }
    }

    /**
     * This method implementation must contain an asynchronous call the fetch
     * new data.
     */
    public abstract void cacheOnBackground(int page);
}
