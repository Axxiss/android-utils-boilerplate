package io.github.axxiss.aub.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/**
 * @author Axxiss
 */
public abstract class SpinnerArrayListAdapter<T> extends ArrayListAdapter<T> implements SpinnerAdapter {
    public SpinnerArrayListAdapter(final Context context) {
        super(context);
    }

    @Override
    public abstract View getDropDownView(int position, View convertView, ViewGroup parent);
}
