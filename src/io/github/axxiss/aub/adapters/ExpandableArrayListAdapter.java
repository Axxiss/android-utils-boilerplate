package io.github.axxiss.aub.adapters;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Axxiss
 */
public abstract class ExpandableArrayListAdapter<T, U> extends BaseExpandableListAdapter {
    final protected ArrayList<T> mGroups = new ArrayList<T>();

    final protected ArrayList<ArrayList<U>> mChildren = new ArrayList<ArrayList<U>>();

    final protected Context mContext;

    public ExpandableArrayListAdapter(final Context context) {
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(final int groupPosition) {
        return mChildren.get(groupPosition).size();
    }

    @Override
    public T getGroup(final int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public U getChild(final int groupPosition, final int childPosition) {
        return mChildren.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(final int groupPosition) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getChildId(final int groupPosition, final int childPosition) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasStableIds() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChildSelectable(final int groupPosition, final int childPosition) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setChildren(int groupPosition, U[] items) {
        if (items == null || items.length == 0 || groupPosition < 0 || groupPosition > mGroups.size()) {
            return;
        }

        if (mChildren.get(groupPosition) == null) {
            mChildren.set(groupPosition, new ArrayList<U>());
        }

        mChildren.get(groupPosition).clear();
        mChildren.get(groupPosition).addAll(Arrays.asList(items));
        notifyDataSetChanged();
    }

    public void addGroups(T[] items) {
        if (items == null || items.length == 0) {
            return;
        }

        int length = items.length;

        mGroups.ensureCapacity(mGroups.size() + length);
        mGroups.addAll(Arrays.asList(items));

        mChildren.ensureCapacity(mChildren.size() + length);

        for (int i = 0; i < length; i++) {
            mChildren.add(new ArrayList<U>());
        }

        notifyDataSetChanged();
    }
}
