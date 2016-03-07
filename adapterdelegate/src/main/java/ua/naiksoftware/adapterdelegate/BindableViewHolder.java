package ua.naiksoftware.adapterdelegate;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by naik on 07.03.16.
 */
public class BindableViewHolder <VB extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final VB mBinding;

    private BindableViewHolder(VB binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public static <VB extends ViewDataBinding> BindableViewHolder<VB> newInstance(
            @LayoutRes int layoutId, LayoutInflater inflater,
            @Nullable ViewGroup parent, boolean attachToParent) {

        VB vb = DataBindingUtil.inflate(inflater, layoutId, parent, attachToParent);
        return new BindableViewHolder<>(vb);
    }

    public VB getBinding() {
        return mBinding;
    }
}
