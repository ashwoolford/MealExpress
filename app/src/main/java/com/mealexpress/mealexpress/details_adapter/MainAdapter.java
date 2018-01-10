package com.mealexpress.mealexpress.details_adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mealexpress.mealexpress.Activitys.OrderActivity;
import com.mealexpress.mealexpress.R;
import com.mealexpress.mealexpress.details_data.ItemsData;
import com.mealexpress.mealexpress.details_data.ItemsTitleData;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by josh on 1/6/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final int TITLE = 1;
    private final int CONTENT = 2;

    private Context context;
    private ArrayList<Object> arrayList;

    public MainAdapter(Context context, ArrayList<Object> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @Override
    public int getItemViewType(int position) {
        if(arrayList.get(position) instanceof ItemsTitleData)
            return TITLE;
        else if(arrayList.get(position) instanceof ItemsData)
            return CONTENT;
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;
        int layout;

        switch (viewType){
            case TITLE:
                layout = R.layout.item_inner_title;
                View view = LayoutInflater.from(context).inflate(layout , parent , false);
                holder = new TitleViewHolder(view);
                break;
            case CONTENT:
                layout = R.layout.item_details_layout;
                View view1 = LayoutInflater.from(context).inflate(layout , parent , false);
                holder = new ContentViewHolder(view1);
                break;
             default:
                 holder = null;
                 break;

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = holder.getItemViewType();

        switch (viewType){
            case TITLE:
                ItemsTitleData titleData = (ItemsTitleData) arrayList.get(position);
                ((TitleViewHolder)holder).textView.setText(titleData.getTitle());
                break;
            case CONTENT:
                ItemsData itemsData = (ItemsData) arrayList.get(position);
                ((ContentViewHolder)holder).imageView.setImageResource(itemsData.getImageView());
                ((ContentViewHolder)holder).title.setText(itemsData.getTitle());
                ((ContentViewHolder)holder).des.setText(itemsData.getDes());
                ((ContentViewHolder)holder).price.setText(itemsData.getPrice());
                ((ContentViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(context , OrderActivity.class));
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public TitleViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.inner_title);
            textView.setTypeface(setFont("Exo2-Regular.ttf"));
        }
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder{
        @InjectView(R.id.inner_cover) ImageView imageView;
        @InjectView(R.id.inner_title) TextView title;
        @InjectView(R.id.inner_des) TextView des;
        @InjectView(R.id.inner_price) TextView price;

        public ContentViewHolder(View itemView) {
            super(itemView);

            ButterKnife.inject(this, itemView);

            title.setTypeface(setFont("Exo2-SemiBold.ttf"));

            des.setTypeface(setFont("Exo2-Regular.ttf"));

            price.setTypeface(setFont("Exo2-Regular.ttf"));

        }
    }


    private Typeface setFont(String fontName){
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/"+fontName);
        return custom_font;
    }


}
