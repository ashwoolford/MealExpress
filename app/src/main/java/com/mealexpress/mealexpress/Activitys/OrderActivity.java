package com.mealexpress.mealexpress.Activitys;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mealexpress.mealexpress.R;
import com.mealexpress.mealexpress.details_data.ItemsTitleData;
import com.mealexpress.mealexpress.order_adapter.OrderMainAdapter;
import com.mealexpress.mealexpress.order_data.ExtraInstructionData;
import com.mealexpress.mealexpress.order_data.ItemChoiceData;
import com.mealexpress.mealexpress.order_data.ItemHeadingData;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private int quantity = 1;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        bindToolbar();

        recyclerView = findViewById(R.id.addToCartRecyclerView);

        TextView posTextView = findViewById(R.id.pos);
        final TextView negTextView  = findViewById(R.id.neg);
        final TextView quantityView = findViewById(R.id.quantity);

        initRecyclerView();

        quantityView.setText(quantity+"");

        posTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                quantityView.setText(quantity+"");
            }
        });

        negTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity--;

                quantityView.setText(quantity+"");

            }
        });


    }

    private void bindToolbar(){

        Toolbar toolbar = findViewById(R.id.order_toolbar);
        TextView toolbarTextView = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        toolbarTextView.setTypeface(setFont("Exo2-Regular.ttf"));
        toolbarTextView.setText("Make Orders");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    private void initRecyclerView(){
        ArrayList<Object> arrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        arrayList.add(new ItemHeadingData("Zesty Nachos" , "Tortilla chips topped with pepper jack," +
                " shredded cheddar cheese, seasoned nacho meat, freshly made pico de gallo, and sour cream, Served as a half."));

        arrayList.add(new ItemsTitleData("Choice of size"));

        arrayList.add(new ItemChoiceData("Half"));
        arrayList.add(new ItemChoiceData("Full"));
        arrayList.add(new ItemChoiceData("Half"));
        arrayList.add(new ItemChoiceData("Full"));
        arrayList.add(new ItemChoiceData("Half"));
        arrayList.add(new ItemChoiceData("Full"));

        arrayList.add(new ItemsTitleData("Special instruction"));

        arrayList.add(new ExtraInstructionData("flag"));

        OrderMainAdapter mainAdapter = new OrderMainAdapter(getApplicationContext() , arrayList);
        recyclerView.setAdapter(mainAdapter);
    }

    private Typeface setFont(String fontName){
        Typeface custom_font = Typeface.createFromAsset(getApplicationContext().getAssets(),  "fonts/"+fontName);
        return custom_font;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
