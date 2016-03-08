package ua.naiksoftware.adapterdelegate;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * @param T data items
 *
 * Created by naik on 08.03.16.
 */
public class DelegateRecyclerAdapter<T extends List> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final DelegateManager<T> mDelegateManager;
    private T mData;

    public DelegateRecyclerAdapter(List<AdapterDelegate<T>> delegates, T data, boolean hasStableIds) {
        mData = data;
        mDelegateManager = new DelegateManager<>();
        mDelegateManager.addDelegates(delegates);
        setHasStableIds(hasStableIds);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mDelegateManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mDelegateManager.onBindViewHolder(mData, position, holder);
    }

    @Override
    public int getItemViewType(int position) {
        return mDelegateManager.getItemViewType(mData, position);
    }

    @Override
    public long getItemId(int position) {
        return mDelegateManager.getItemId(mData, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
