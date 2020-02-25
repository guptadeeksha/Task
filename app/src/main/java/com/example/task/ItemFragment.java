package com.example.task;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link}
 * interface.
 */
public class ItemFragment extends Fragment {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    View view;
    private RecyclerView recyclerView;
    private List<Folder> folders;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        folders = new ArrayList<>();
//        folders.add(new Folder("FolderOne", 1));
//        folders.add(new Folder("FolderTwo", 2));
//        folders.add(new Folder("FolderThree", 3));
//        folders.add(new Folder("FolderFour", 4));
//        folders.add(new Folder("FolderFive", 5));
//        folders.add(new Folder("FolderSix", 6));
//        folders.add(new Folder("FolderSeven", 7));
//        folders.add(new Folder("FolderEight", 8));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_view, container, false);
        return view;
    }



}
