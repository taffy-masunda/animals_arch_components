package taffy.co.za.archcomponentspracticeapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import taffy.co.za.archcomponentspracticeapp.AnimalsListActivity;
import taffy.co.za.archcomponentspracticeapp.R;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ItemViewHolder> {

    Context context;
    String[]categories;
    Bundle categoryBundle;
    String[] categoryMapped = {"farm", "jungle", "pet", "water", "bird", "insect", "reptile", "ice"};
    int []categoryIcons = {R.drawable.farm, R.drawable.jungle, R.drawable.pet, R.drawable.big_fish, R.drawable.bird, R.drawable.insect, R.drawable.reptile, R.drawable.ice};

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
        holder.categoryImageview.setImageResource(categoryIcons[position]);
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView categoryImageview;
        TextView categoryTextview;
        public ItemViewHolder(View itemView) {
            super(itemView);
            categoryTextview = itemView.findViewById(R.id.category_title_textview);
            categoryImageview = itemView.findViewById(R.id.bullet_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            categoryBundle = new Bundle();
            Intent openAnimalsListActivity = new Intent(context, AnimalsListActivity.class);
            categoryBundle.putString("animalCategory", categoryMapped[getAdapterPosition()].toString());
            categoryBundle.putString("animalCategoryDescription", categories[getAdapterPosition()].toString());
            openAnimalsListActivity.putExtras(categoryBundle);
            context.startActivity(openAnimalsListActivity);
        }
    }
}
