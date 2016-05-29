package com.example.rsc.myapplication.presenters;

import android.content.Context;

import com.example.rsc.myapplication.db.ConstructorMascotas;
import com.example.rsc.myapplication.fragments.IMascotaRVFragment;
import com.example.rsc.myapplication.pojo.Mascota;

import java.util.ArrayList;


public class MascotaRVFragmentPresenter implements IMascotaRVFragmentPresenter{

    private IMascotaRVFragment iMascotaRVFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotaRVFragmentPresenter(IMascotaRVFragment iMascotaRVFragment, Context context) {
        this.iMascotaRVFragment = iMascotaRVFragment;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotaRVFragment.inicMascotaAdapter(iMascotaRVFragment.crearAdaptador(mascotas));
        iMascotaRVFragment.generarLLVertical();
    }
}
