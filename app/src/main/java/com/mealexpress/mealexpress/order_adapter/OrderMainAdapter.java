package com.mealexpress.mealexpress.order_adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mealexpress.mealexpress.R;
import com.mealexpress.mealexpress.details_data.ItemsTitleData;
import com.mealexpress.mealexpress.order_data.ExtraInstructionData;
import com.mealexpress.mealexpress.order_data.ItemChoiceData;
import com.mealexpress.mealexpress.order_data.ItemHeadingData;

import java.util.ArrayList;

/**
 * Created by josh on 1/7/2018.
 */

public class OrderMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Object> list;
    private final int HEADING = 1;
    private final int TITLE = 2;
    private final int ORDERONE = 3;
    private final int EXTRAINS = 4;

    public OrderMainAdapter(Context context, ArrayList<Object> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof ItemHeadingData) return HEADING;
        else if(list.get(position) instanceof ItemsTitleData) return TITLE;
        else if(list.get(position) instanceof ItemChoiceData) return ORDERONE;
        else if(list.get(position) instanceof ExtraInstructionData) return EXTRAINS;
        else return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        int layout;

        switch (viewType){
            case HEADING:
                layout = R.layout.item_order_heading;
                View view = LayoutInflater.from(context).inflate(layout , parent , false);
                holder = new HeadingViewHolder(view);
                break;
            case TITLE:
                layout = R.layout.item_order_title;
                View view1 = LayoutInflater.from(context).inflate(layout , parent , false);
                holder = new TitleViewHolder(view1);
                break;
            case ORDERONE:
                layout = R.layout.item_order_select_one;
                View view2 = LayoutInflater.from(context).inflate(layout , parent , false);
                holder = new ChoiceViewHolder(view2);
                break;
            case EXTRAINS:
                layout = R.layout.item_order_extra_instruction;
                View view3 = LayoutInflater.from(context).inflate(layout , parent , false);
                holder = new ExtraInsViewHolder(view3);
                break;
            default:
                holder = null;

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int type = holder.getItemViewType();
        switch (type){
            case HEADING:
                ItemHeadingData itemHeadingData = (ItemHeadingData) list.get(position);
                ((HeadingViewHolder)holder).name.setText(itemHeadingData.getTitle());
                ((HeadingViewHolder)holder).des.setText(itemHeadingData.getDes());
                break;
            case TITLE:
                ItemsTitleData titleData = (ItemsTitleData) list.get(position);
                ((TitleViewHolder)holder).title.setText(titleData.getTitle());
                break;
            case ORDERONE:
                ItemChoiceData itemChoiceData = (ItemChoiceData) list.get(position);
                ((ChoiceViewHolder)holder).choiceView.setText(itemChoiceData.getTitle());
                break;
            case EXTRAINS:
                break;

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HeadingViewHolder extends RecyclerView.ViewHolder{
        TextView name , des;
        public HeadingViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.order_food_name);
            name.setTypeface(setFont("Exo2-Regular.ttf"));

            des = itemView.findViewById(R.id.order_des);
            des.setTypeface(setFont("Exo2-Regular.ttf"));
        }
    }
    public class TitleViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public TitleViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.order_title);
            title.setTypeface(setFont("Exo2-Regular.ttf"));
        }
    }
    public class ChoiceViewHolder extends RecyclerView.ViewHolder{
        TextView choiceView;
        public ChoiceViewHolder(View itemView) {
            super(itemView);

            choiceView = itemView.findViewById(R.id.order_choice_name);
            choiceView.setTypeface(setFont("Exo2-Regular.ttf"));
        }
    }

    public class ExtraInsViewHolder extends RecyclerView.ViewHolder{

        EditText editText;
        public ExtraInsViewHolder(View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.order_get_Text);
            editText.setTypeface(setFont("Exo2-Regular.ttf"));

        }
    }


    private Typeface setFont(String fontName){
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/"+fontName);
        return custom_font;
    }


}
