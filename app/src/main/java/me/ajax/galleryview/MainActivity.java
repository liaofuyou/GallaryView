package me.ajax.galleryview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<String> imageUrls = new ArrayList<>();

    {
        imageUrls.add("https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=5dee120174f0f736ccf344536b3cd87c/2f738bd4b31c8701570196982b7f9e2f0708ff1d.jpg");
        imageUrls.add("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=687adcb2cfcec3fd9f33af27b7e1bf5a/72f082025aafa40f9a93efa3a764034f78f01972.jpg");
        imageUrls.add("https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=7def2b4f2d3fb80e18dc698557b8444b/2cf5e0fe9925bc31206626e652df8db1cb137090.jpg");
        imageUrls.add("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=65af826d9bdda144ce0464e0d3debbc7/4ec2d5628535e5dd8e6983a17ac6a7efce1b6202.jpg");
        imageUrls.add("https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=7def2b4f2d3fb80e18dc698557b8444b/2cf5e0fe9925bc31206626e652df8db1cb137090.jpg");
        imageUrls.add("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=65af826d9bdda144ce0464e0d3debbc7/4ec2d5628535e5dd8e6983a17ac6a7efce1b6202.jpg");
        imageUrls.add("https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=022e18ba17d5ad6ebef46cb8e0a252be/83025aafa40f4bfb2bd8bd2a0f4f78f0f7361847.jpg");
        imageUrls.add("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=38008e1e43c2d562e605d8bf8678fb8a/ca1349540923dd54d7768716dd09b3de9c824842.jpg");
        imageUrls.add("https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=3e48989abf1c8701c2bbbab44616f54a/63d0f703918fa0ec18c142732a9759ee3d6ddb4d.jpg");
        imageUrls.add("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike272%2C5%2C5%2C272%2C90/sign=c34b9effc71349546a13e0363727f93d/d0c8a786c9177f3efa9dda737ccf3bc79f3d5626.jpg");
    }

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView1 = findViewById(R.id.image_view1);
        imageView2 = findViewById(R.id.image_view2);
        imageView3 = findViewById(R.id.image_view3);
        Glide.with(MainActivity.this)
                .load(imageUrls.get(0))
                .into(imageView1);
        Glide.with(MainActivity.this)
                .load(imageUrls.get(1))
                .into(imageView2);
        Glide.with(MainActivity.this)
                .load(imageUrls.get(2))
                .into(imageView3);

        imageView1.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int index = 0;
            if (v == imageView1) {
                index = 0;
            } else if (v == imageView2) {
                index = 1;
            } else if (v == imageView3) {
                index = 2;
            }

            Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
            intent.putStringArrayListExtra(GalleryActivity.EXTRA_IMAGE_URLS, imageUrls);
            intent.putExtra(GalleryActivity.EXTRA_CURR_INDEX, index);
                /*
                if (android.os.Build.VERSION.SDK_INT > 20) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                            imageView, "transitionImg");
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
                */
            startActivity(intent);
        }
    };
}
