package ua.naiksoftware.hidetabs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by naik on 28.02.16.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter {

    private final int mItemsCount;

    public SimpleRecyclerAdapter(int itemsCount) {
        mItemsCount = itemsCount;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SimpleHolder) holder).label.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return mItemsCount;
    }

    private static class SimpleHolder extends RecyclerView.ViewHolder {

        final TextView label;

        public SimpleHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.item_label);
        }
    }
}
