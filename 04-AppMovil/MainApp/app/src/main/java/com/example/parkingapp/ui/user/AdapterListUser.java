package com.example.parkingapp.ui.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.parkingapp.R;
import com.example.parkingapp.utils.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AdapterListUser extends RecyclerView.Adapter<AdapterListUser.ViewHolder> {

    private JSONArray listaUser;
    View root;
    Config dataConfig;

    public AdapterListUser(JSONArray listaUser, View root, Context context){
        this.listaUser = listaUser;
        this.root = root;
        this.dataConfig = new Config(context);
    }

    @NonNull
    @Override
    public AdapterListUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.users, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListUser.ViewHolder holder, int position) {
        JSONObject user = null;
        try {
            user = listaUser.getJSONObject(position);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        holder.cargarUsers(user);
    }

    @Override
    public int getItemCount() {
        return listaUser.length();
    }


    public void updateData(JSONArray newParkings) {
        this.listaUser = newParkings;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name_parking, direction_parking;

        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            name_parking = itemView.findViewById(R.id.listNameUser);
            direction_parking = itemView.findViewById(R.id.id_user);

        }

        public void cargarUsers(JSONObject parking) {
            try {
                String name = parking.getString("name");
                String address = parking.getString("id");
                name_parking.setText(name);
                direction_parking.setText(address);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public void switchSection(View section, View previousSection) {
            if (section.getVisibility() == View.GONE) {
                section.setVisibility(View.VISIBLE);
                previousSection.setVisibility(View.GONE);
            } else {
                section.setVisibility(View.GONE);
            }
        }

    }
}