package com.example.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder> {

    ArrayList<RestaurantsHelperClass> LL;

    public RestaurantsAdapter(ArrayList<RestaurantsHelperClass> LL) {
        this.LL = LL;
    }

    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurants_card_design, parent, false);
        RestaurantsViewHolder restaurantsViewHolder = new RestaurantsViewHolder(view);
        return restaurantsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {
        RestaurantsHelperClass restaurantsHelperClass = LL.get(position);

        holder.image.setImageResource(restaurantsHelperClass.getImage());
        holder.title.setText(restaurantsHelperClass.getTitle());
        holder.desc.setText(restaurantsHelperClass.getDescription());
        holder.rb.setRating(restaurantsHelperClass.getRB());

    }

    @Override
    public int getItemCount() {
        return LL.size();
    }

    public static class RestaurantsViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;
        RatingBar rb;

        public RestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.r_image);
            title = itemView.findViewById(R.id.r_title);
            desc = itemView.findViewById(R.id.r_desc);
            rb = itemView.findViewById(R.id.r_rating);

        }
    }

}
