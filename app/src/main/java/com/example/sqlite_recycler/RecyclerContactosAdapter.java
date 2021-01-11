package com.example.sqlite_recycler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class RecyclerContactosAdapter extends RecyclerView.Adapter<RecyclerContactosAdapter.AdaptadorViewHolder> {
    @NonNull
    @Override

    //Este metodo infla el layout
    public AdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    //Aqui va el codigo de funcionamiento y los listeners
    @Override
    public void onBindViewHolder(@NonNull AdaptadorViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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


