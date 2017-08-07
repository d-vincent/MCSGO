package org.madisonbaseball.mba;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    Fragment mFragment;
    ImageView bracket;
    ImageView hotels;
    ImageView dining;
    ImageView madisonInfo;
    ImageView weather;

    @Override
    public void onBackPressed() {
        if (mFragment instanceof BracketFragment){
            ((BracketFragment) mFragment).mWebview.setVisibility(View.GONE);
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.home);

        Drawable icon = toolbar.getNavigationIcon();
        icon.setColorFilter(new
                PorterDuffColorFilter(getResources().getColor(R.color.unselected),PorterDuff.Mode.MULTIPLY));

        setSupportActionBar(toolbar);

        HomeFragment fragment = HomeFragment.newInstance(0);
        mFragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

        bracket = (ImageView)findViewById(R.id.bracket);
        hotels = (ImageView)findViewById(R.id.hotels);
        dining = (ImageView)findViewById(R.id.dining);
        madisonInfo = (ImageView)findViewById(R.id.madison_info);
        weather = (ImageView)findViewById(R.id.weather);

        weather.setColorFilter(getResources().getColor(R.color.unselected));
        madisonInfo.setColorFilter(getResources().getColor(R.color.unselected));
        dining.setColorFilter(getResources().getColor(R.color.unselected));
        hotels.setColorFilter(getResources().getColor(R.color.unselected));
        bracket.setColorFilter(getResources().getColor(R.color.unselected));


        bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bracket.setColorFilter(getResources().getColor(R.color.colorAccent));
                madisonInfo.setColorFilter(getResources().getColor(R.color.unselected));
                dining.setColorFilter(getResources().getColor(R.color.unselected));
                hotels.setColorFilter(getResources().getColor(R.color.unselected));
                weather.setColorFilter(getResources().getColor(R.color.unselected));
                if(mFragment instanceof PDFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof HotelFragment || mFragment instanceof HomeFragment) {
                    BracketFragment bracketFragment = BracketFragment.newInstance();
                    mFragment = bracketFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, bracketFragment).commit();
                }

            }
        });
        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hotels.setColorFilter(getResources().getColor(R.color.colorAccent));
                madisonInfo.setColorFilter(getResources().getColor(R.color.unselected));
                dining.setColorFilter(getResources().getColor(R.color.unselected));
                weather.setColorFilter(getResources().getColor(R.color.unselected));
                bracket.setColorFilter(getResources().getColor(R.color.unselected));
                if (!(mFragment instanceof HotelFragment)) {
                    HotelFragment hotelFragment = HotelFragment.newInstance();
                    mFragment = hotelFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, hotelFragment).commit();
                }
            }

        });
        dining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dining.setColorFilter(getResources().getColor(R.color.colorAccent));
                madisonInfo.setColorFilter(getResources().getColor(R.color.unselected));
                weather.setColorFilter(getResources().getColor(R.color.unselected));
                hotels.setColorFilter(getResources().getColor(R.color.unselected));
                bracket.setColorFilter(getResources().getColor(R.color.unselected));


                if(mFragment instanceof PDFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof HotelFragment || mFragment instanceof BracketFragment) {
                    HomeFragment diningFrag = HomeFragment.newInstance(1);
                    mFragment = diningFrag;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, diningFrag).commit();
                }else if (mFragment instanceof HomeFragment){
                    ((HomeFragment) mFragment).loadNewPage(1);
                }
            }
        });
        madisonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                madisonInfo.setColorFilter(getResources().getColor(R.color.colorAccent));
                weather.setColorFilter(getResources().getColor(R.color.unselected));
                dining.setColorFilter(getResources().getColor(R.color.unselected));
                hotels.setColorFilter(getResources().getColor(R.color.unselected));
                bracket.setColorFilter(getResources().getColor(R.color.unselected));

                if (!(mFragment instanceof MadisonInfoFragment)) {
                    MadisonInfoFragment infoFrag = MadisonInfoFragment.newInstance();
                    mFragment = infoFrag;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, infoFrag).commit();
                }
            }
        });
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weather.setColorFilter(getResources().getColor(R.color.colorAccent));
                madisonInfo.setColorFilter(getResources().getColor(R.color.unselected));
                dining.setColorFilter(getResources().getColor(R.color.unselected));
                hotels.setColorFilter(getResources().getColor(R.color.unselected));
                bracket.setColorFilter(getResources().getColor(R.color.unselected));

                if(mFragment instanceof PDFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof HotelFragment || mFragment instanceof BracketFragment) {
                    HomeFragment weatherFragment = HomeFragment.newInstance(2);
                    mFragment = weatherFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, weatherFragment).commit();
                } else if (mFragment instanceof HomeFragment){
                    ((HomeFragment) mFragment).loadNewPage(2);
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.getItem(0).getIcon().setColorFilter(new
                PorterDuffColorFilter(getResources().getColor(R.color.unselected),PorterDuff.Mode.MULTIPLY));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()){
            case android.R.id.home:

                weather.setColorFilter(getResources().getColor(R.color.unselected));
                madisonInfo.setColorFilter(getResources().getColor(R.color.unselected));
                dining.setColorFilter(getResources().getColor(R.color.unselected));
                hotels.setColorFilter(getResources().getColor(R.color.unselected));
                bracket.setColorFilter(getResources().getColor(R.color.unselected));

                if(mFragment instanceof PDFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof  HotelFragment || mFragment instanceof BracketFragment) {
                    HomeFragment homeFragment = HomeFragment.newInstance(0);

                    mFragment = homeFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                }
                else if (mFragment instanceof HomeFragment){
                    ((HomeFragment) mFragment).loadNewPage(0);
                }
                break;

            case R.id.info:

                weather.setColorFilter(getResources().getColor(R.color.unselected));
                madisonInfo.setColorFilter(getResources().getColor(R.color.unselected));
                dining.setColorFilter(getResources().getColor(R.color.unselected));
                hotels.setColorFilter(getResources().getColor(R.color.unselected));
                bracket.setColorFilter(getResources().getColor(R.color.unselected));

                if(!(mFragment instanceof PDFragment)) {
                    PDFragment fragment = PDFragment.newInstance();

                    mFragment = fragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
