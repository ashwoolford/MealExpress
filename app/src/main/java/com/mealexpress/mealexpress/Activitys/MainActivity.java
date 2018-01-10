package com.mealexpress.mealexpress.Activitys;

import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mealexpress.mealexpress.R;
import com.mealexpress.mealexpress.homeadapter.MainAdapter;
import com.mealexpress.mealexpress.homedata.HorizontalData;
import com.mealexpress.mealexpress.homedata.TitleData;
import com.mealexpress.mealexpress.homedata.VerticalData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private ArrayList<Object> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbar_title = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");
        toolbar_title.setText("Deliver to Dhanmondi");
        toolbar_title.setTypeface(setFont("Exo2-Medium.ttf"));


        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        init();




    }

    private void init(){

        data = new ArrayList<>();

        data.add(new TitleData("Your Favorite"));

        //start inflating horizontal

        data.add(new HorizontalData(R.drawable.image_02 , "", "" ,
                " " ));

        data.add(new TitleData("Popular Near to you"));

        data.add(new VerticalData(R.drawable.image_02 , "Burger king", "American • Fast Food • Burgers • ৳" ,
                "10 - 20 MIN" , "★ 3.6 (150)"));


        data.add(new VerticalData(R.drawable.image_01 , "Burger king", "American • Fast Food • Burgers • ৳" ,
                "10 - 20 MIN" , "★ 3.6 (150)"));

        data.add(new VerticalData(R.drawable.image_02 , "Burger king", "American • Fast Food • Burgers • ৳" ,
                "10 - 20 MIN" , "★ 3.6 (150)"));


        MainAdapter adapter = new MainAdapter(data,this);
        recyclerView.setAdapter(adapter);

    }

    public static ArrayList<HorizontalData> getSingleHorizontalData(){
        ArrayList<HorizontalData> list = new ArrayList<>();
        list.add(new HorizontalData(R.drawable.image_01 , "Burger king", "American • Fast Food • Burgers • ৳" ,
                "10 - 20 MIN"));
        list.add(new HorizontalData(R.drawable.image_02 , "Burger king", "American • Fast Food • Burgers • ৳" ,
                "10 - 20 MIN"));
        return list;

    }


    private Typeface setFont(String fontName){
        Typeface custom_font = Typeface.createFromAsset(getApplicationContext().getAssets(),  "fonts/"+fontName);
        return custom_font;
    }



}
