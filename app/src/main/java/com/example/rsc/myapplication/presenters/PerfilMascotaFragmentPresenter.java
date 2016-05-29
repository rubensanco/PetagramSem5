package com.example.rsc.myapplication.presenters;

import android.content.Context;

import com.example.rsc.myapplication.db.ConstructorMascotas;
import com.example.rsc.myapplication.db.ConstructorMiMascota;
import com.example.rsc.myapplication.fragments.IPerfilMascotaFragment;
import com.example.rsc.myapplication.pojo.Mascota;

import java.util.ArrayList;


public class PerfilMascotaFragmentPresenter implements IPerfilMascotaFragmentPresenter {

    private IPerfilMascotaFragment iPerfilMascotaFragment;
    private Context context;
    private ConstructorMiMascota constructorMiMascota;
    private ArrayList<Mascota> miMascota;

    public PerfilMascotaFragmentPresenter(IPerfilMascotaFragment iPerfilMascotaFragment, Context context) {
        this.iPerfilMascotaFragment = iPerfilMascotaFragment;
        this.context = context;
        obtenerDatosMiMascota();
    }


    @Override
    public void obtenerDatosMiMascota() {
        constructorMiMascota = new ConstructorMiMascota(context);
        miMascota = constructorMiMascota.obtenerMiMascota();
        mostrarDatosMiMascota();
    }

    @Override
    public void mostrarDatosMiMascota() {
        iPerfilMascotaFragment.inicMiMascotaAdapter(iPerfilMascotaFragment.crearAdaptadorMiMascota(miMascota));
        iPerfilMascotaFragment.generarGridLayout();
    }
}
