package com.example.suporte.imobiliapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        navigationView.setSelectedItemId(R.id.navigation_noticias);
        Fragment newsFragment = NewsFragment.newInstance();
        openFragment(newsFragment);

        try {
            Glide.with(this).load(R.drawable.imovel_1).into((ImageView) findViewById(R.id.imagem_imovel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_noticias: {
                Fragment newsFragment = NewsFragment.newInstance();
                openFragment(newsFragment);
                break;
            }
            case R.id.navigation_imoveis: {
                Fragment catalogFragment = ImoveisFragment.newInstance();
                openFragment(catalogFragment);
                break;
            }

            case R.id.navigation_more: {
                Fragment moreFragment = MoreFragment.newInstance();
                openFragment(moreFragment);
                break;
            }
        }
        return true;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
