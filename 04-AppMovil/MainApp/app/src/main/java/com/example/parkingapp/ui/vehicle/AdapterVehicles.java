package com.example.parkingapp.ui.vehicle;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AdapterVehicles extends RecyclerView.Adapter<AdapterVehicles.ViewHolder>{

    JSONArray listaVehiculos;
    View root;
    public AdapterVehicles(JSONArray listaVehiculos, View root) {
        this.listaVehiculos = listaVehiculos;
        this.root = root;
    }

    @NonNull
    @Override


    public AdapterVehicles.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVehicles.ViewHolder holder, int position) {

        JSONObject vehicle = listaVehiculos.optJSONObject(position);
        System.out.println(position);
        holder.cargarVehiculos(vehicle);
    }

    @Override
    public int getItemCount() {
        return listaVehiculos.length();
    }

    public void updateData(JSONArray newlistaVehiculos) {
        this.listaVehiculos = newlistaVehiculos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        LinearLayout layout_vehicles,layout_ticket;

        TextView Plate_vehicle,time,name_parking,address_parking,date_entry,durariton,plate_vehicle;
        ImageView ticket;
        Button volver,btn_back;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            layout_vehicles = root.findViewById(R.id.layout_vehicles);
            layout_ticket = root.findViewById(R.id.layout_ticket);
            ticket = itemView.findViewById(R.id.ticket);
            Plate_vehicle = itemView.findViewById(R.id.Plate_vehicle);
            time = itemView.findViewById(R.id.time);
            name_parking=root.findViewById(R.id.name_parking);
            address_parking=root.findViewById(R.id.address_parking);
            date_entry=root.findViewById(R.id.date_entry);
            durariton=root.findViewById(R.id.durariton);
            plate_vehicle=root.findViewById(R.id.plate_vehicle);
            volver = root.findViewById(R.id.volver);
            btn_back = root.findViewById(R.id.btn_back);

        }

        public void cargarVehiculos(JSONObject vehicle) {
            String id = vehicle.optString("id");
            Plate_vehicle.setText(vehicle.optString("plate"));
            String fecha = vehicle.optString("entry_date");
            String nameParking = vehicle.optString("parking_name");
            String addressParking = vehicle.optString("parking_addres");


            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                TimeZone timeZoneColombia = TimeZone.getTimeZone("America/Bogota");
                sdf.setTimeZone(timeZoneColombia);
                Date fechaEntrada = sdf.parse(fecha);
                Date fechaActual = new Date();

                long diferenciaEnMilisegundos = fechaActual.getTime() - fechaEntrada.getTime();


                long minutosTranscurridos = diferenciaEnMilisegundos / (1000 * 60);
                long horasTranscurridas = minutosTranscurridos / 60;
                minutosTranscurridos = minutosTranscurridos % 60;

                if (horasTranscurridas < 1) {
                    System.out.println("Horas transcurridas desde la fecha: " + horasTranscurridas + " horas");


                    time.setText(minutosTranscurridos + " minutos");
                } else {
                    System.out.println("Horas transcurridas desde la fecha: " + horasTranscurridas + " horas o más");
                    time.setText(horasTranscurridas + " horas");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            ticket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("ticket", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("id", id);
                    editor.apply();
                    SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm");

                    try {

                        Date date = sdfInput.parse(fecha);


                        String fechaFormateada = sdfOutput.format(date);
                        date_entry.setText(fechaFormateada);


                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                    name_parking.setText(nameParking);
                    address_parking.setText(addressParking);

                    durariton.setText(time.getText());
                    plate_vehicle.setText(Plate_vehicle.getText());
                    switchSection(layout_ticket, layout_vehicles);
                }
            });

            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchSection(layout_vehicles,layout_ticket);
                }
            });

            volver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchSection(layout_vehicles,layout_ticket);
                }
            });



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
