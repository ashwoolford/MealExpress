package com.mealexpress.mealexpress.Activitys;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mealexpress.mealexpress.R;
import com.mealexpress.mealexpress.details_adapter.MainAdapter;
import com.mealexpress.mealexpress.details_data.ItemsData;
import com.mealexpress.mealexpress.details_data.ItemsTitleData;
import com.mealexpress.mealexpress.homedata.TitleData;

import java.util.ArrayList;

import butterknife.InjectView;

public class DetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.7f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.9f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    @InjectView(R.id.main_linearlayout_title) LinearLayout mTitleContainer;
    @InjectView(R.id.main_textview_title) TextView mTitle;
    @InjectView(R.id.app_bar_layout) AppBarLayout mAppBarLayout;
    @InjectView(R.id.main_toolbar) Toolbar mToolbar;
    @InjectView(R.id.detailsRecyclerview) RecyclerView recyclerView;
    @InjectView(R.id.item_name_da) TextView mAppbarTitle;
    @InjectView(R.id.item_type_da) TextView mType;
    @InjectView(R.id.item_need_time_da) TextView mEstTime;
    @InjectView(R.id.item_status_time_da) TextView mStatus;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindActivity();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_main);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        initRecyclerView();



    }

    private void bindActivity() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        mTitle.setTypeface(setFont("Exo2-Regular.ttf"));
        mAppbarTitle.setTypeface(setFont("Exo2-Regular.ttf"));

        mEstTime.setTypeface(setFont("Exo2-Regular.ttf"));

        mStatus.setTypeface(setFont("Exo2-Regular.ttf"));

        mType.setTypeface(setFont("Exo2-Regular.ttf"));
    }

    private void initRecyclerView(){
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new ItemsTitleData("Burgers"));
        arrayList.add(new ItemsData(R.drawable.image_01 , "Beacon Avocado Cheeseburger"
                , "Crispy bacon, fresh avocado, and melted cheddar cheese top" , "120 ৳"));

        arrayList.add(new ItemsData(R.drawable.image_02 , "Prime Rib Cobb Salad"
                , "Crispy bacon, fresh avocado, and melted cheddar cheese top" , "120 ৳"));

        arrayList.add(new ItemsTitleData("Appetizers"));

        arrayList.add(new ItemsData(R.drawable.image_01 , "Chicken Strips"
                , "Crispy bacon, fresh avocado, and melted cheddar cheese top" , "120 ৳"));

        arrayList.add(new ItemsData(R.drawable.image_02 , "Chicken and Sausage Quesadilla"
                , "Crispy bacon, fresh avocado, and melted cheddar cheese top" , "120 ৳"));
        MainAdapter adapter = new MainAdapter(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }


    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;

                //Toast.makeText(getApplicationContext() , "Show" , Toast.LENGTH_SHORT).show();
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {

            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
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
