package taffy.co.za.archcomponentspracticeapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import taffy.co.za.archcomponentspracticeapp.R;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {

    Context context;
    String[]categories;

    public RecyclerViewAdapter(Context context, String[] categories) {
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

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView categoryTextview;
        public ItemViewHolder(View itemView) {
            super(itemView);
            categoryTextview = itemView.findViewById(R.id.category_title_textview);
        }
    }


}
