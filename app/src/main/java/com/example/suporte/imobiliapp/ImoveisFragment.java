package com.example.suporte.imobiliapp;


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class ImoveisFragment extends Fragment {

    private RecyclerView recyclerView;
    private ImovelAdapter adapter;
    private List<Imovel> imoveis;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View rootView = inflater.inflate(R.layout.fragment_imoveis, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        imoveis = new ArrayList<>();
        adapter = new ImovelAdapter(getContext(), imoveis);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new ImoveisFragment.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepararImoveis();

        return rootView;
    }

    /**
     * Adiciona imoveis para teste.
     */
    private void prepararImoveis() {
        int[] fotos = new int[] {
                R.drawable.imovel_4,
                R.drawable.imovel_2,
                R.drawable.imovel_3,
                R.drawable.imovel_1,
        };

        Imovel imovel = new Imovel(
                1,
                "Edificio Tatuapé",
                250000,
                "Rua Bonifácio Siqueira",
                3,
                "01/01/2020",
                12,
                fotos[0],
                "-27.596633",
                "-48.527849",
                "qXW6309pu0I"
        );
        imoveis.add(imovel);

        imovel = new Imovel(
                2,
                "Casa Moderna",
                500000,
                "Rua Gentil Leandro",
                5,
                "05/05/2021",
                20,
                fotos[1],
                "-27.608082",
                " -48.520318",
                "KgHRY6JOhe4"
        );
        imoveis.add(imovel);

        imovel = new Imovel(
                3,
                "Res. Porto do Mar",
                375000,
                "Rua Mario Quintana",
                4,
                "25/12/2019",
                24,
                fotos[2],
                "-27.613376",
                "-48.526606",
                "ERx_XAC-VjE"
        );
        imoveis.add(imovel);

        imovel = new Imovel(
                4,
                "Casa na praia",
                450000,
                "Avenida Beira Mar",
                2,
                "01/01/2018",
                18,
                fotos[3],
                "-27.688792",
                "-48.483131",
                "q6gazdTwJig"
        );
        imoveis.add(imovel);

        imovel = new Imovel(
                5,
                "Casa de luxo",
                225000,
                "Avenida Madre",
                2,
                "01/01/2018",
                18,
                fotos[0],
                "-27.690223",
                "-48.485897",
                "USSkQPc396c"
        );
        imoveis.add(imovel);

        adapter.notifyDataSetChanged();
    }


//    /**
//     * Converte dp para pixel
//     */
//    private int dpToPx(int dp) {
//        Resources r = getResources();
//        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
//    }

//    /**
//     * Seta os espaçamentos de cada item da grid.
//     */
//    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
//
//        private int spanCount;
//        private int spacing;
//        private boolean includeEdge;
//
//        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
//            this.spanCount = spanCount;
//            this.spacing = spacing;
//            this.includeEdge = includeEdge;
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            int position = parent.getChildAdapterPosition(view); // item position
//            int column = position % spanCount; // item column
//
//            if (includeEdge) {
//                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
//                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)
//
//                if (position < spanCount) { // top edge
//                    outRect.top = spacing;
//                }
//                outRect.bottom = spacing; // item bottom
//            } else {
//                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
//                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
//                if (position >= spanCount) {
//                    outRect.top = spacing; // item top
//                }
//            }
//        }
//    }

    /**
     * Retorna uma nova instância do fragmento.
     */
    public static ImoveisFragment newInstance() {

        return new ImoveisFragment();
    }
}
