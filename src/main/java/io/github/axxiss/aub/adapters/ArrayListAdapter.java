package io.github.axxiss.aub.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Extends a {@link BaseAdapter} using an {@link ArrayList} for handle data.
 * <p/>
 * All common methods of the adapter are defined but {#getView}.
 *
 * @author Axxiss
 */
public abstract class ArrayListAdapter<T> extends BaseAdapter {
    private static final String TAG = "ArrayListAdapter";

    /**
     * Adapter's items.
     */
    protected ArrayList<T> mData = new ArrayList<T>();

    /**
     * Current context.
     */
    protected Context mContext;

    public ArrayListAdapter(Context context) {
        mContext = context;
    }

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
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Appends all of the elements in the specified array to the end of this
     * adapter, maintains order.
     *
     * @param items array containing elements to be added to this adapter
     */
    public void addItems(T[] items) {
        if (items != null && items.length > 0) {
            mData.ensureCapacity(items.length);
            mData.addAll(Arrays.asList(items));
            notifyDataSetChanged();
        }
    }

    /**
     * Clear the current adapter and add the items to the adapter.
     */
    public void refreshAdapter(T[] items) {
        mData.clear();

        if (items != null) {
            mData.ensureCapacity(items.length);
            mData.addAll(Arrays.asList(items));
        }
        notifyDataSetChanged();
    }

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
