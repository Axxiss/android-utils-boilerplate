package io.github.axxiss.aub.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Extends a {@link BaseAdapter} using an {@link ArrayList} for handle data.
 * <p/>
 * All common methods of the adapter are defined but {#getView}.
 *
 * @author Axxiss
 */
public abstract class BoilerplateArrayAdapter<T> extends BaseAdapter {
    /**
     * Adapter's items.
     */
    protected ArrayList<T> mData = new ArrayList<T>();

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(final int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this adapter, maintains
     * order.
     *
     * @param items array containing elements to be added to this adapter
     */
    public void addItems(Collection<T> items) {
        mData.ensureCapacity(mData.size() + items.size());
        mData.addAll(items);
        notifyDataSetChanged();
    }


    /**
     * Clear the current adapter and add the items to the adapter.
     */
    public void refreshAdapter(Collection<T> items) {
        mData.clear();
        addItems(items);
    }

    public void addItems(T[] items) {
        addItems(Arrays.asList(items));
    }

    public void refreshAdapter(T[] items) {
        refreshAdapter(Arrays.asList(items));
    }


    /**
     * Remove an item.
     *
     * @param position position to me removed
     */
    public void removeItem(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract View getView(final int position, final View convertView, final ViewGroup parent);
}
