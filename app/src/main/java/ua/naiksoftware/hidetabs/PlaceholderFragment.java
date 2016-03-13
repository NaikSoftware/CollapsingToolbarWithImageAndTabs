package ua.naiksoftware.hidetabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ua.naiksoftware.adapterdelegate.AdapterDelegate;
import ua.naiksoftware.adapterdelegate.DelegateRecyclerAdapter;
import ua.naiksoftware.hidetabs.model.Model;
import ua.naiksoftware.hidetabs.model.utils.Utils;
import ua.naiksoftware.hidetabs.viewmodel.delegate.BindingFriendDelegate;
import ua.naiksoftware.hidetabs.viewmodel.delegate.FriendDelegate;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(getListAdapter(Utils.generateFriends(30)));

        return rootView;
    }

    private RecyclerView.Adapter getListAdapter(List<? extends Model> models) {
        return new DelegateRecyclerAdapter<>(new ArrayList<AdapterDelegate<List<? extends Model>>>() {{
            add(new BindingFriendDelegate(1));
        }}, models, true);
    }
}