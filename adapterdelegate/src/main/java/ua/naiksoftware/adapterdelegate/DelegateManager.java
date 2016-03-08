package ua.naiksoftware.adapterdelegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by naik on 07.03.16.
 */
public class DelegateManager<T> {

    private final SparseArray<AdapterDelegate<T>> mDelegateSparseArray = new SparseArray<>();

    public DelegateManager<T> addDelegate(@NonNull AdapterDelegate<T> delegate) {
        int viewType = delegate.getItemViewType();
        if (mDelegateSparseArray.get(viewType) != null) {
            throw new IllegalArgumentException("AdapterDelegate viewType=" + viewType + " already used by other delegate!");
        }

        mDelegateSparseArray.put(viewType, delegate);
        return this;
    }

    public void addDelegates(@NonNull Iterable<AdapterDelegate<T>> delegates) {
        for (AdapterDelegate<T> delegate : delegates) {
            addDelegate(delegate);
        }
    }

    public DelegateManager<T> removeDelegate(AdapterDelegate<T> delegate) {
        mDelegateSparseArray.remove(delegate.getItemViewType());
        return this;
    }

    public int getItemViewType(@NonNull T items, int position) {
        return findDelegateForPosition(items, position).getItemViewType();
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        AdapterDelegate<T> delegate = mDelegateSparseArray.get(viewType);
        return delegate.onCreateViewHolder(parent);
    }

    public void onBindViewHolder(@NonNull T items, int position, @NonNull RecyclerView.ViewHolder viewHolder) {

        AdapterDelegate<T> delegate = mDelegateSparseArray.get(viewHolder.getItemViewType());
        if (delegate == null) {
            throw new NullPointerException("No AdapterDelegate added for ViewType " + viewHolder.getItemViewType());
        }

        delegate.onBindViewHolder(items, position, viewHolder);
    }

    public long getItemId(@NonNull T items, int position) {
        return findDelegateForPosition(items, position).getItemId(items, position);
    }

    @NonNull
    private AdapterDelegate<T> findDelegateForPosition(@NonNull T items, int position) {
        int delegatesCount = mDelegateSparseArray.size();
        for (int i = 0; i < delegatesCount; i++) {
            AdapterDelegate<T> delegate = mDelegateSparseArray.valueAt(i);
            if (delegate.isForViewType(items, position)) {
                return delegate;
            }
        }
        throw new IllegalArgumentException(
                "No AdapterDelegate added that matches position=" + position + " in data source");
    }

}
