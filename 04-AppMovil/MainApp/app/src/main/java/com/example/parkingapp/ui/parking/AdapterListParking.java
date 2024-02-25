package com.example.parkingapp.ui.parking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class AdapterListParking extends RecyclerView.Adapter<AdapterListParking.ViewHolder> {

    JSONArray listaContactos;

    public AdapterListParking(JSONArray listaContactos){
        this.listaContactos = listaContactos;
    }

    @NonNull
    @Override
    public AdapterListParking.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.parkins, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListParking.ViewHolder holder, int position) {
        JSONObject contacto = null;
        try {
            contacto = listaContactos.getJSONObject(position);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        holder.cargarContacto(contacto);
    }

    @Override
    public int getItemCount() {
        return listaContactos.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name_parking, direction_parking;

        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            name_parking = itemView.findViewById(R.id.NameParking);
            direction_parking = itemView.findViewById(R.id.Direction);

        }

        public void cargarContacto(JSONObject parking) {
            try {
                String name = parking.getString("name");
                String address = parking.getString("address");
                name_parking.setText(name);
                direction_parking.setText(address);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
