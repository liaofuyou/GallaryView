package me.ajax.galleryview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class GalleryActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_URLS = "EXTRA_IMAGE_URLS";
    public static final String EXTRA_CURR_INDEX = "EXTRA_CURR_INDEX";

    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getWindow().getDecorView().setBackgroundColor(0xFF000000);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //LayoutManager
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //SnapHelper
        PagerSnapHelper mLinearSnapHelper = new PagerSnapHelper();
        mLinearSnapHelper.attachToRecyclerView(recyclerView);

        //ItemTouchHelper
        ItemTouchHelperCallback itemTouchHelperCallback = new ItemTouchHelperCallback();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        //adapter
        recyclerView.setAdapter(imageAdapter = new ImageAdapter());

        imageAdapter.setImageUrl(getIntent().getStringArrayListExtra(EXTRA_IMAGE_URLS));
        recyclerView.scrollToPosition(getIntent().getIntExtra(EXTRA_CURR_INDEX, 0));
    }
}
