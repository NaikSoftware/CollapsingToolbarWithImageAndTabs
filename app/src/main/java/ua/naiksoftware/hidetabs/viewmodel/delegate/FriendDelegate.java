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
import ua.naiksoftware.adapterdelegate.SimpleViewHolder;
import ua.naiksoftware.hidetabs.R;
import ua.naiksoftware.hidetabs.model.Friend;
import ua.naiksoftware.hidetabs.model.Model;

/**
 * Created by naik on 08.03.16.
 */
public class FriendDelegate implements AdapterDelegate<List<? extends Model>> {

    private final int mViewType;

    public FriendDelegate(int viewType) {
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
        return new SimpleViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friend, parent, false))
                .useView(R.id.friend_avatar)
                .useView(R.id.friend_name);
    }

    @Override
    public void onBindViewHolder(@NonNull List<? extends Model> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        SimpleViewHolder viewHolder = (SimpleViewHolder) holder;
        Friend friend = (Friend) items.get(position);

        viewHolder.getView(R.id.friend_name, TextView.class).setText(friend.name);
        viewHolder.getView(R.id.friend_avatar, ImageView.class).setImageDrawable(
                TextDrawable.builder().buildRound(friend.name.substring(0, 1),
                        ColorGenerator.MATERIAL.getColor(friend.name)).getCurrent()
        );
    }

    @Override
    public long getItemId(@NonNull List<? extends Model> items, int position) {
        return items.get(position).getId();
    }

}
