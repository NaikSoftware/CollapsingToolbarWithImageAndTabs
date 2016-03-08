package ua.naiksoftware.adapterdelegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * @param T data items represented by delegates
 *
 * Created by naik on 07.03.16.
 */
public interface AdapterDelegate<T> {

    int getItemViewType();

    boolean isForViewType(@NonNull T items, int position);

    @NonNull RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(@NonNull T items, int position, @NonNull RecyclerView.ViewHolder holder);

    long getItemId(@NonNull T items, int position);
}
