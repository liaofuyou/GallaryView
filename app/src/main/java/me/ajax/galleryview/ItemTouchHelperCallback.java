package me.ajax.galleryview;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

    public static final float ALPHA_FULL = 1.0f;

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        //上下滑动，不管拖拽
        return makeMovementFlags(0, ItemTouchHelper.UP | ItemTouchHelper.DOWN);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder targetViewHolder) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (viewHolder.itemView.getContext() instanceof Activity) {
            ((Activity) viewHolder.itemView.getContext()).finish();
        }
    }


    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                            float dX, float dY, int actionState, boolean isCurrentlyActive) {

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            // Fade out the view as it is swiped out of the parent's bounds

            float alpha = ALPHA_FULL - Math.abs(dY) / (float) viewHolder.itemView.getWidth();
            alpha = Math.max(0.5F, alpha);
            alpha = Math.min(1F, alpha);

            if (recyclerView.getContext() instanceof GalleryActivity) {
                View decorView = ((GalleryActivity) recyclerView.getContext()).getWindow().getDecorView();
                if (decorView != null) {
                    decorView.setBackgroundColor(Color.argb((int) (alpha * 255), 0, 0, 0));
                }
            }
            viewHolder.itemView.setTranslationY(dY);
        } else {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }

    private void l(Object... objs) {
        StringBuilder text = new StringBuilder();
        for (Object o : objs) {
            text.append(o.toString()).append("     ");
        }
        Log.e("#######", text.toString());
    }

}