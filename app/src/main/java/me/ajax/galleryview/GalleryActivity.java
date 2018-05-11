package me.ajax.galleryview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class GalleryActivity extends AppCompatActivity {

    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //LayoutManager
        recyclerView.setLayoutManager(
                //new LinearLayoutManager(this));
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        //SnapHelper
        PagerSnapHelper mLinearSnapHelper = new PagerSnapHelper();
        mLinearSnapHelper.attachToRecyclerView(recyclerView);

        ItemTouchHelperCallback itemTouchHelperCallback = new ItemTouchHelperCallback();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        //adapter
        recyclerView.setAdapter(imageAdapter = new ImageAdapter());
    }
}
