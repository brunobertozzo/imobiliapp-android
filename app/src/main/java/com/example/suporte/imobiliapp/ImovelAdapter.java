package com.example.suporte.imobiliapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;



public class ImovelAdapter extends RecyclerView.Adapter<ImovelAdapter.MyViewHolder> {

    private Context context;
    private List<Imovel> imoveis;

    ImovelAdapter(Context context, List<Imovel> imoveis) {
        this.context = context;
        this.imoveis = imoveis;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_imovel, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);

        holder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InfosActivity.class);
                //TODO
                intent.putExtra("imovel", imoveis.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Imovel imovel = imoveis.get(position);
        holder.nome.setText(imovel.getNome());
        holder.valor.setText("R$" + Integer.toString(imovel.getValor()));
        Glide.with(context).load(imovel.getFotoPath()).into(holder.foto);
    }


    @Override
    public int getItemCount() {
        return imoveis.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout cardViewItem;
        private ImageView foto;
        private TextView nome, valor;

        MyViewHolder(View view) {
            super(view);
            cardViewItem = view.findViewById(R.id.card_view_item_id);
            nome = (TextView) view.findViewById(R.id.card_nome);
            valor = (TextView) view.findViewById(R.id.card_valor);
            foto = (ImageView) view.findViewById(R.id.card_foto);
        }
    }


}