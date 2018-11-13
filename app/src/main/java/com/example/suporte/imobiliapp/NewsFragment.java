package com.example.suporte.imobiliapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class NewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private NoticiaAdapter adapter;
    private List<Noticia> noticias;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        noticias = new ArrayList<>();
        adapter = new NoticiaAdapter(getActivity(), noticias);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepararNoticias();

        return rootView;
    }

    /**
     * Adiciona noticias para teste.
     */
    private void prepararNoticias() {
        Noticia noticia = new Noticia(
                "Residencial Tarumã é lançado!",
                "Venha conhecer nosso mais novo empreendimento."
        );
        noticias.add(noticia);

        noticia = new Noticia(
                "Residencial João de Barro sob avaliação do Corpo de Bombeiros",
                "Estamos garantindo a segurança do seu novo lar."
        );
        noticias.add(noticia);

        adapter.notifyDataSetChanged();
    }

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }
}
