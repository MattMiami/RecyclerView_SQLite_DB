package com.example.sqlite_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerContactosAdapter extends RecyclerView.Adapter<RecyclerContactosAdapter.AdaptadorViewHolder> {

    ArrayList<Contacto> listaContactos;
    Context contexto;


    public RecyclerContactosAdapter(ArrayList<Contacto> listaContactos, Context contexto){
        this.listaContactos = listaContactos;
        this.contexto = contexto;

    }

    @NonNull
    @Override
    //Este metodo infla el layout
    public AdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Asignando el layout a los objetos
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,parent,false);

        AdaptadorViewHolder avh = new AdaptadorViewHolder(itemView);
        return avh;
    }

    //Aqui va el codigo de funcionamiento y los listeners
    @Override
    public void onBindViewHolder(@NonNull AdaptadorViewHolder holder, int position) {

        Contacto contacto = listaContactos.get(position);
        holder.tvDni.setText(contacto.getDni());
        holder.tvName.setText(contacto.getName());
        holder.tvSurname.setText(contacto.getSurname());
        holder.tvMail.setText(contacto.getMail());
        holder.tvAddress.setText(contacto.getAddress());
        holder.tvPhone.setText(contacto.getPhone());

        //Los toast o los intents

    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    //La clase view holder nos coge los elementos del item layout

    public class AdaptadorViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout layout_item;
        TextView tvName;
        TextView tvSurname;
        TextView tvDni;
        TextView tvMail;
        TextView tvAddress;
        TextView tvPhone;

        public AdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);

            //Aqui accedemos a cada uno de los elementos del layout
            layout_item = itemView.findViewById(R.id.layout_item);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            tvDni = itemView.findViewById(R.id.tvDni);
            tvMail = itemView.findViewById(R.id.tvMail);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }
    }
}


