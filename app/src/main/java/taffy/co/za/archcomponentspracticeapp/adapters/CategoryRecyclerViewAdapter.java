package taffy.co.za.archcomponentspracticeapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import taffy.co.za.archcomponentspracticeapp.AnimalsListActiivity;
import taffy.co.za.archcomponentspracticeapp.R;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ItemViewHolder> {

    Context context;
    String[]categories;

    public CategoryRecyclerViewAdapter(Context context, String[] categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.category_item, parent, false);
        ItemViewHolder itemHolder = new ItemViewHolder(row);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.categoryTextview.setText(categories[position]);
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView categoryTextview;
        public ItemViewHolder(View itemView) {
            super(itemView);
            categoryTextview = itemView.findViewById(R.id.category_title_textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent openAnimalsListActivity = new Intent(context, AnimalsListActiivity.class);
            context.startActivity(openAnimalsListActivity);
        }
    }


}
