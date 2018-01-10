package com.mealexpress.mealexpress.homeadapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mealexpress.mealexpress.Activitys.DetailActivity;
import com.mealexpress.mealexpress.R;
import com.mealexpress.mealexpress.homedata.HorizontalData;
import com.mealexpress.mealexpress.homedata.TitleData;
import com.mealexpress.mealexpress.homedata.VerticalData;

import java.util.ArrayList;

import static com.mealexpress.mealexpress.Activitys.MainActivity.getSingleHorizontalData;

/**
 * Created by josh on 1/3/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Object> arrayList;
    private final int VERTICAL = 1;
    private final int HORIZONTAL = 2;
    private final int TITLE = 3;
    private Context context;

    public MainAdapter(ArrayList<Object> arrayList , Context context){
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public int getItemViewType(int position) {
        if(arrayList.get(position) instanceof TitleData) return TITLE;
        else if(arrayList.get(position) instanceof VerticalData) return VERTICAL;
        else if(arrayList.get(position) instanceof HorizontalData) return HORIZONTAL;
        else return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        int layout = 0;

        switch (viewType){
            case VERTICAL:
                layout = R.layout.item_home_layout;
                View view = LayoutInflater.from(context).inflate(layout , parent , false);
                holder= new VerticalViewHolder(view);
                break;
            case TITLE:
                layout = R.layout.item_title_row;
                View view1 = LayoutInflater.from(context).inflate(layout , parent , false);
                holder= new VerticalTitleHolder(view1);
                break;
            case HORIZONTAL:
                layout = R.layout.horizontal;
                View view2 = LayoutInflater.from(context).inflate(layout , parent , false);
                holder = new HorizontalViewHolder(view2);
                break;

            default:
                holder = null;
                break;

        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int type = holder.getItemViewType();

        switch (type){
            case VERTICAL:

                VerticalData verticalData = (VerticalData) arrayList.get(position);
                ((VerticalViewHolder)holder).imageView.setImageResource(verticalData.getImages());
                ((VerticalViewHolder) holder).type.setText(verticalData.getType());
                ((VerticalViewHolder) holder).rating.setText(verticalData.getRating());
                ((VerticalViewHolder) holder).title.setText(verticalData.getTitle());
                ((VerticalViewHolder) holder).time.setText(verticalData.getTime());
                ((VerticalViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(context , DetailActivity.class));
                    }
                });
                break;
            case TITLE:
                TitleData titleData = (TitleData) arrayList.get(position);
                ((VerticalTitleHolder)holder).textView.setText(titleData.getTitle());
                break;
            case HORIZONTAL:
                HorizontalView((HorizontalViewHolder) holder);
                break;

        }


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private void HorizontalView(HorizontalViewHolder holder){

        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(getSingleHorizontalData() , context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false));
        holder.recyclerView.setAdapter(horizontalAdapter);

    }


    public class VerticalViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title , rating , type , time;

        public VerticalViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.coverImage);
            title = itemView.findViewById(R.id.title);
            title.setTypeface(setFont("Exo2-SemiBold.ttf"));
            rating = itemView.findViewById(R.id.rating);
            rating.setTypeface(setFont("Exo2-Regular.ttf"));
            type = itemView.findViewById(R.id.type);
            type.setTypeface(setFont("Exo2-Regular.ttf"));
            time = itemView.findViewById(R.id.est_time);
            time.setTypeface(setFont("Exo2-Regular.ttf"));

        }
    }

    public class VerticalTitleHolder extends RecyclerView.ViewHolder{

        TextView textView;


        public VerticalTitleHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.titleView);
            textView.setTypeface(setFont("Exo2-Regular.ttf"));
        }
    }


    public class HorizontalViewHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        public HorizontalViewHolder(View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.inner_recyclerView);
        }
    }

    private Typeface setFont(String fontName){
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/"+fontName);
        return custom_font;
    }

}
