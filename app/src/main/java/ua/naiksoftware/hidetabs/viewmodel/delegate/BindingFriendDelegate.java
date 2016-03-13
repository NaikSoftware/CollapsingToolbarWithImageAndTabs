package ua.naiksoftware.hidetabs.viewmodel.delegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

import ua.naiksoftware.adapterdelegate.AdapterDelegate;
import ua.naiksoftware.adapterdelegate.BindableViewHolder;
import ua.naiksoftware.adapterdelegate.SimpleViewHolder;
import ua.naiksoftware.hidetabs.R;
import ua.naiksoftware.hidetabs.databinding.ItemFriendBindableBinding;
import ua.naiksoftware.hidetabs.model.Friend;
import ua.naiksoftware.hidetabs.model.Model;

/**
 * Created by naik on 08.03.16.
 */
public class BindingFriendDelegate implements AdapterDelegate<List<? extends Model>> {

    private final int mViewType;

    public BindingFriendDelegate(int viewType) {
        mViewType = viewType;
    }

    @Override
    public int getItemViewType() {
        return mViewType;
    }

    @Override
    public boolean isForViewType(@NonNull List<? extends Model> items, int position) {
        return items.get(position) instanceof Friend;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return BindableViewHolder.newInstance(R.layout.item_friend_bindable, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull List<? extends Model> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        BindableViewHolder<ItemFriendBindableBinding> viewHolder = (BindableViewHolder<ItemFriendBindableBinding>) holder;

        viewHolder.getBinding().setFriend((Friend) items.get(position));
        viewHolder.getBinding().executePendingBindings();
    }

    @Override
    public long getItemId(@NonNull List<? extends Model> items, int position) {
        return items.get(position).getId();
    }

}
