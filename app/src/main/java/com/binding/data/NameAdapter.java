package com.binding.data;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.binding.R;
import com.binding.databinding.ListItemTaskBinding;

import java.util.Calendar;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.TaskHolder> {

    Calendar c;

    /* Callback for list item click events */
    public interface OnItemClickListener {
        void onItemClick(View v, int position);

        void onItemToggled(boolean active, int position);
    }

    /* ViewHolder for each task item */
    public class TaskHolder extends RecyclerView.ViewHolder {
        private ListItemTaskBinding item;

        public TaskHolder(View itemView) {
            super(itemView);
            item = DataBindingUtil.bind(itemView);

        }

    }

    private Cursor mCursor;

    public NameAdapter(Cursor cursor) {
        c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        mCursor = cursor;
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);

        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, int position) {
        Name task = getItem(position);
        holder.item.setUser(task);
    }

    @Override
    public int getItemCount() {
        return (mCursor != null) ? mCursor.getCount() : 0;
    }


    public Name getItem(int position) {
        if (!mCursor.moveToPosition(position)) {
            throw new IllegalStateException("Invalid item position requested");
        }

        return new Name(mCursor);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    public void swapCursor(Cursor cursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = cursor;
        notifyDataSetChanged();
    }
}
