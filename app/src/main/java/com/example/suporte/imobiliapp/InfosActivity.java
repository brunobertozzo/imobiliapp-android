package com.example.suporte.imobiliapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class InfosActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String DEVELOPER_KEY = "AIzaSyC3N1Ah7JAMAZiIhoxN7CXKUgYcYd1mjEQ";
    private YouTubePlayerSupportFragment youTubePlayerFragment;
    private YouTubePlayer youTubePlayer;
    private Imovel imovel;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        context = this;

        this.imovel = (Imovel) getIntent().getSerializableExtra("imovel");

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //TODO : TAIS REFERENCIANDO AQUI O XML QUE FOI COMENTADO
        ((TextView) findViewById(R.id.infos_nome)).setText(imovel.getNome());
        ((TextView) findViewById(R.id.detail_valor)).setText("Preço: R$" + String.valueOf(imovel.getValor()));
        ((TextView) findViewById(R.id.detail_endereco)).setText("Endereço: " + imovel.getEndereco());
        ((TextView) findViewById(R.id.detail_numero_quartos)).setText("Número de quartos: " + String.valueOf(imovel.getNumeroQuartos()));
        ((TextView) findViewById(R.id.detail_data_entrega)).setText("Data de entrega: " + imovel.getDataEntrega());
        ((TextView) findViewById(R.id.detail_prazo_financiamento)).setText("Prazo de financiamento: " + String.valueOf(imovel.getPrazoFinanciamento()) + " meses");

        try {
            Glide.with(this).load(this.imovel.getFotoPath()).into((ImageView) findViewById(R.id.imagem_imovel));
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, MapsActivity.class);
                startActivity(intent);
            }
        });

        initializeYoutubePlayer();
    }

    /**
     * initialize youtube player via Fragment and get instance of YoutubePlayer
     */
    private void initializeYoutubePlayer() {

        youTubePlayerFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player_fragment);

        if (youTubePlayerFragment == null)
            return;

        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                                boolean wasRestored) {
                if (!wasRestored) {
                    youTubePlayer = player;

                    //set the player style default
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

                    //cue the 1st video by default
                    youTubePlayer.cueVideo(imovel.getVideoURL());
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {

                //print or show error if initialization failed
                Log.e(TAG, "Youtube Player View initialization failed");
            }
        });
    }

}
