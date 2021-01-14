package com.example.sqlite_recycler.ui.contatos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite_recycler.Contacto;
import com.example.sqlite_recycler.Ctrl_Contactos;
import com.example.sqlite_recycler.R;
import com.example.sqlite_recycler.RecyclerContactosAdapter;

import java.util.ArrayList;

public class ContactosFragment extends Fragment {

    private ContactosViewModel mViewModel;

    private ArrayList<Contacto> listaContactos;

    //Variable para trabajar con nuestro recycler view
    private RecyclerView rvContactos;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private Contacto c;




    public static ContactosFragment newInstance() {
        return new ContactosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contactos, container, false);
        //Inicializamos el recycler
        rvContactos = v.findViewById(R.id.rvCotactos);


        cargarDatosContactos();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Asignamos el itemView a nuestro recycler view
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvContactos.setLayoutManager(layoutManager);

        //Inicializamos el adaptador y lo asociamos al recycler
        adapter = new RecyclerContactosAdapter(listaContactos, getContext());
        rvContactos.setAdapter(adapter);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContactosViewModel.class);
        // TODO: Use the ViewModel
    }

    private void cargarDatosContactos() {
        Ctrl_Contactos list = new Ctrl_Contactos(getContext());
        listaContactos = list.listarContactos();
        Toast.makeText(getContext(), " " + listaContactos.size(),Toast.LENGTH_SHORT).show();
    }

}