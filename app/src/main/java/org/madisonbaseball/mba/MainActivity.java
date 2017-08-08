package org.madisonbaseball.mba;

import android.graphics.ColorFilter;
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

public class MainActivity extends AppCompatActivity {

    Fragment mFragment;
    ImageView catalogs;
    ImageView places;
    ImageView forward;
    ImageView iNow;
    ImageView scores;

    Toolbar toolbar;
    Menu menu;

    @Override
    public void onBackPressed() {
        if (mFragment instanceof BlogFragment){
            ((BlogFragment) mFragment).holderview.setVisibility(View.GONE);
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.home_blue);
        toolbar.setTitle("");

//        Drawable icon = toolbar.getNavigationIcon();
//        icon.setColorFilter(new
//                PorterDuffColorFilter(getResources().getColor(R.color.unselected),PorterDuff.Mode.MULTIPLY));

        setSupportActionBar(toolbar);

        HomeFragment fragment = HomeFragment.newInstance(0);
        mFragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

        catalogs = (ImageView)findViewById(R.id.bracket);
        places = (ImageView)findViewById(R.id.hotels);
        forward= (ImageView)findViewById(R.id.dining);
        iNow = (ImageView)findViewById(R.id.madison_info);
        scores = (ImageView)findViewById(R.id.weather);

        scores.setColorFilter(getResources().getColor(R.color.unselected));
        iNow.setColorFilter(getResources().getColor(R.color.unselected));
        forward.setColorFilter(getResources().getColor(R.color.unselected));
        places.setColorFilter(getResources().getColor(R.color.unselected));
        catalogs.setColorFilter(getResources().getColor(R.color.unselected));


        catalogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_book_open_variant_grey600_48dp));
                toolbar.setNavigationIcon(R.drawable.home);
                catalogs.setColorFilter(getResources().getColor(R.color.colorAccent));
                iNow.setColorFilter(getResources().getColor(R.color.unselected));
                forward.setColorFilter(getResources().getColor(R.color.unselected));
                places.setColorFilter(getResources().getColor(R.color.unselected));
                scores.setColorFilter(getResources().getColor(R.color.unselected));
                if(mFragment instanceof LinksFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof HotelFragment || mFragment instanceof HomeFragment || mFragment instanceof BlogFragment) {
                    BracketFragment bracketFragment = BracketFragment.newInstance();
                    mFragment = bracketFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, bracketFragment).commit();
                }

            }
        });
        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_book_open_variant_grey600_48dp));
                toolbar.setNavigationIcon(R.drawable.home);
                places.setColorFilter(getResources().getColor(R.color.colorAccent));
                iNow.setColorFilter(getResources().getColor(R.color.unselected));
                forward.setColorFilter(getResources().getColor(R.color.unselected));
                scores.setColorFilter(getResources().getColor(R.color.unselected));
                catalogs.setColorFilter(getResources().getColor(R.color.unselected));
                if (!(mFragment instanceof HotelFragment)) {
                    HotelFragment hotelFragment = HotelFragment.newInstance();
                    mFragment = hotelFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, hotelFragment).commit();
                }
            }

        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_book_open_variant_grey600_48dp));
                toolbar.setNavigationIcon(R.drawable.ic_refresh_grey600_48dp);

                forward.setColorFilter(getResources().getColor(R.color.colorAccent));
                iNow.setColorFilter(getResources().getColor(R.color.unselected));
                scores.setColorFilter(getResources().getColor(R.color.unselected));
                places.setColorFilter(getResources().getColor(R.color.unselected));
                catalogs.setColorFilter(getResources().getColor(R.color.unselected));

                if (!(mFragment instanceof BlogFragment)){
                    BlogFragment fragmentfff = BlogFragment.newInstance();
                    mFragment = fragmentfff;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentfff).commit();
                }

            }
        });
        iNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_book_open_variant_grey600_48dp));
                toolbar.setNavigationIcon(R.drawable.home);
                iNow.setColorFilter(getResources().getColor(R.color.colorAccent));
                scores.setColorFilter(getResources().getColor(R.color.unselected));
                forward.setColorFilter(getResources().getColor(R.color.unselected));
                places.setColorFilter(getResources().getColor(R.color.unselected));
                catalogs.setColorFilter(getResources().getColor(R.color.unselected));

                if(mFragment instanceof LinksFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof HotelFragment || mFragment instanceof BracketFragment || mFragment instanceof BlogFragment) {
                    HomeFragment weatherFragment = HomeFragment.newInstance(2);
                    mFragment = weatherFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, weatherFragment).commit();
                } else if (mFragment instanceof HomeFragment){
                    ((HomeFragment) mFragment).loadNewPage(2);
                }
            }
        });
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_book_open_variant_grey600_48dp));
                toolbar.setNavigationIcon(R.drawable.home);
                scores.setColorFilter(getResources().getColor(R.color.colorAccent));
                iNow.setColorFilter(getResources().getColor(R.color.unselected));
                forward.setColorFilter(getResources().getColor(R.color.unselected));
                places.setColorFilter(getResources().getColor(R.color.unselected));
                catalogs.setColorFilter(getResources().getColor(R.color.unselected));

                if(mFragment instanceof LinksFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof HotelFragment || mFragment instanceof BracketFragment ||mFragment instanceof BlogFragment) {
                    HomeFragment weatherFragment = HomeFragment.newInstance(1);
                    mFragment = weatherFragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, weatherFragment).commit();
                } else if (mFragment instanceof HomeFragment){
                    ((HomeFragment) mFragment).loadNewPage(1);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        menu.getItem(0).getIcon().setColorFilter(new
//                PorterDuffColorFilter(getResources().getColor(R.color.unselected),PorterDuff.Mode.MULTIPLY));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()){
            case android.R.id.home:

                if (!(mFragment instanceof  BlogFragment)) {


                    menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_book_open_variant_grey600_48dp));


                    toolbar.setNavigationIcon(R.drawable.home_blue);
                    Drawable icon = toolbar.getNavigationIcon();
                    //icon.setTint(getResources().getColor(R.color.selected));
//                    icon.setColorFilter(new
//                            PorterDuffColorFilter(getResources().getColor(R.color.selected),PorterDuff.Mode.MULTIPLY));
                    scores.setColorFilter(getResources().getColor(R.color.unselected));
                    iNow.setColorFilter(getResources().getColor(R.color.unselected));
                    forward.setColorFilter(getResources().getColor(R.color.unselected));
                    places.setColorFilter(getResources().getColor(R.color.unselected));
                    catalogs.setColorFilter(getResources().getColor(R.color.unselected));


                    if (mFragment instanceof LinksFragment || mFragment instanceof MadisonInfoFragment || mFragment instanceof HotelFragment || mFragment instanceof BracketFragment || mFragment instanceof BlogFragment) {
                        HomeFragment homeFragment = HomeFragment.newInstance(0);

                        mFragment = homeFragment;
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    } else if (mFragment instanceof HomeFragment) {
                        ((HomeFragment) mFragment).loadNewPage(0);
                    }
                    break;
                }
                else {
                    ((BlogFragment) mFragment).refresh();
                    break;
                }

            case R.id.info:

                item.setIcon(R.drawable.book_blue);
                toolbar.setNavigationIcon(R.drawable.home);
                scores.setColorFilter(getResources().getColor(R.color.unselected));
                iNow.setColorFilter(getResources().getColor(R.color.unselected));
                forward.setColorFilter(getResources().getColor(R.color.unselected));
                places.setColorFilter(getResources().getColor(R.color.unselected));
                catalogs.setColorFilter(getResources().getColor(R.color.unselected));

                if(!(mFragment instanceof LinksFragment)) {
                    LinksFragment fragment = LinksFragment.newInstance();

                    mFragment = fragment;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
