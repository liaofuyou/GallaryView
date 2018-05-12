package me.ajax.galleryview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aj on 2018/5/09
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<String> myData = new ArrayList<>();

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_image, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.setImageUrl(myData.get(position));
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public void setImageUrl(ArrayList<String> imageUrls) {
        if (imageUrls == null) return;
        this.myData.addAll(imageUrls);
    }

    //自定义Holder
    static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;


        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }

        public void setImageUrl(String imageUrl) {
            Glide.with(itemView.getContext())
                    .load(imageUrl)
                    .into(imageView);
        }

    }
}

