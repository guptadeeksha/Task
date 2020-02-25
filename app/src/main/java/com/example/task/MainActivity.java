package com.example.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  {

//    private ViewPager viewPager;
//  private ViewPagerAdpater viewPagerAdpater;
    RecyclerView recyclerView;
    MyItemRecyclerViewAdapter recyclerViewAdapter;
    private List<Folder> folders;
    RecyclerView.LayoutManager layoutManager;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ItemFragment itemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        folders = new ArrayList<>();
        folders.add(new Folder("FolderOne", 1));
        folders.add(new Folder("FolderTwo", 2));
        folders.add(new Folder("FolderThree", 3));
        folders.add(new Folder("FolderFour", 4));
        folders.add(new Folder("FolderFive", 5));
        folders.add(new Folder("FolderSix", 6));
        folders.add(new Folder("FolderSeven", 7));
        folders.add(new Folder("FolderEight", 8));
        folders.add(new Folder("FolderNine", 9));
        folders.add(new Folder("FolderTen", 10));
        folders.add(new Folder("FolderEleven", 11));
        folders.add(new Folder("FolderTwelve", 12));
        folders.add(new Folder("FolderThirteen", 13));
        folders.add(new Folder("FolderFourteen", 14));
        folders.add(new Folder("FolderFifteen", 15));

        setContentView(R.layout.fragment_item_list);

//        viewPager = findViewById(R.id.viewpager_id);
//        viewPagerAdpater = new ViewPagerAdpater(getSupportFragmentManager());
//
//        viewPagerAdpater.AddFragment(new ItemFragment(),"Items");
//        viewPager.setAdapter(viewPagerAdpater);


        recyclerView = (RecyclerView) findViewById(R.id.frag_list);


        //recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new MyItemRecyclerViewAdapter(folders);
        //DummyContent.Items item = new DummyContent.Items("1","One", "");
//        mAdapter = new MyItemRecyclerViewAdapter(item,);

//        Intent intent = getIntent();
//        startActivity(intent);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //fragmentManager = getSupportFragmentManager();
        //fragmentTransaction = fragmentManager.beginTransaction();

        //itemFragment = new ItemFragment();
       // fragmentTransaction.replace(R.id.frag_list,itemFragment);
        recyclerViewAdapter.setOnEntryClickListener(new MyItemRecyclerViewAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View v, int position) {



//                fragmentTransaction.commit();
//                int itemPosition = recyclerView.indexOfChild(v);
                Log.d("Tag", String.valueOf(folders.get(position).getName()));
            }

        });
        recyclerView.setAdapter(recyclerViewAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu,menu);
//        return true;
//    }
    public void showPopUp(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }
//    @Override
//    public boolean onMenuItemClick(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_close:
//                close();
//                return true;
//            case R.id.action_delete:
//                delete();
//                return true;
//            case R.id.action_open:
//                open();
//                return true;
//
//        }
//        return true;
//    }
    public void switchContent(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, fragment.toString());
        ft.addToBackStack(null);
        ft.commit();

    }

    private void close(){}
    private void delete(){}
    private void open(){}
}
