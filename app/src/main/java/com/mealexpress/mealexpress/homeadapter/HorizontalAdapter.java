package com.mealexpress.mealexpress.homeadapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mealexpress.mealexpress.Activitys.DetailActivity;
import com.mealexpress.mealexpress.R;
import com.mealexpress.mealexpress.homedata.HorizontalData;

import java.util.ArrayList;

/**
 * Created by josh on 1/3/2018.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder>{

    ArrayList<HorizontalData> arrayList;
    Context context;

    public HorizontalAdapter(ArrayList<HorizontalData> arrayList , Context context){
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_layout , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImages());
        holder.typeView.setText(arrayList.get(position).getType());
        holder.timeView.setText(arrayList.get(position).getTime());
        holder.titleView.setText(arrayList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               context.startActivity(new Intent(context, DetailActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titleView, timeView, typeView;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.title);
            titleView.setTypeface(setFont("Exo2-SemiBold.ttf"));

            timeView = itemView.findViewById(R.id.est_time);
            timeView.setTypeface(setFont("Exo2-Regular.ttf"));

            typeView = itemView.findViewById(R.id.type);
            typeView.setTypeface(setFont("Exo2-Regular.ttf"));

            imageView = itemView.findViewById(R.id.coverImage);
        }
    }

    private Typeface setFont(String fontName){
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/"+fontName);
        return custom_font;
    }

}
