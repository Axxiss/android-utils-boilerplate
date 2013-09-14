package io.github.axxiss.aub.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/**
 * @author Axxiss
 */
public abstract class BoilerplateSpinnerAdapter<T> extends BoilerplateArrayAdapter<T> implements SpinnerAdapter {
    @Override
    public abstract View getDropDownView(int position, View convertView, ViewGroup parent);
}
