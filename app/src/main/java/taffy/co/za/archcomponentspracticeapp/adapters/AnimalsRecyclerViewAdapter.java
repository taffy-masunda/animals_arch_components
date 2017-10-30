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

import com.bumptech.glide.Glide;

import java.util.List;

import taffy.co.za.archcomponentspracticeapp.AnimalDetailsActivity;
import taffy.co.za.archcomponentspracticeapp.R;
import taffy.co.za.archcomponentspracticeapp.models.Animal;

public class AnimalsRecyclerViewAdapter extends RecyclerView.Adapter<AnimalsRecyclerViewAdapter.AnimalViewHolder> {

    private Context context;
    private List<Animal> animals;
    private String imageUrl;

    public AnimalsRecyclerViewAdapter(Context context, List<Animal>animals) {
        this.context = context;
        this.animals = animals;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.animal_list_item, parent, false);
        return new AnimalViewHolder(row);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        holder.animalName.setText(animals.get(position).getName().toString());
        imageUrl = "http://api.spectradigital.co.za/animals_app/animal_pics/" + animals.get(position).getImageUrl().toString();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.animalImage);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView animalName, animalCategory, animalHabitat, animalDescription;
        ImageView animalImage;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            animalImage = itemView.findViewById(R.id.animal_imageview);
            animalName = itemView.findViewById(R.id.animal_name_textview);
            //animalCategory = itemView.findViewById(R.id.description_textview);
            //animalHabitat = itemView.findViewById(R.id.description_textview);
            //animalDescription = itemView.findViewById(R.id.description_textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent openDetailedAtivity = new Intent(context, AnimalDetailsActivity.class);
            Bundle animalBundle = new Bundle();
            animalBundle.putString("imageUrl", animals.get(getAdapterPosition()).getImageUrl().toString());
            animalBundle.putString("animalName", animals.get(getAdapterPosition()).getName().toString());
            animalBundle.putString("animalCategory", animals.get(getAdapterPosition()).getCategory().toString());
            animalBundle.putString("animalHabitat", animals.get(getAdapterPosition()).getHabitat().toString());
            animalBundle.putString("animalDescription", animals.get(getAdapterPosition()).getDescription().toString());
            animalBundle.putString("soundUrl", animals.get(getAdapterPosition()).getSoundUrl().toString());
            openDetailedAtivity.putExtras(animalBundle);
            context.startActivity(openDetailedAtivity);
        }
    }
}