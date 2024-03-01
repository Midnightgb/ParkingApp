package com.example.parkingapp.ui.parking;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.parkingapp.R;
import com.example.parkingapp.utils.Config;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterListParking extends RecyclerView.Adapter<AdapterListParking.ViewHolder> {

    private JSONArray listaParkings;
    View root;
    JSONObject parking_buscado;
    Config dataConfig;
    ParkingFragment parkingFragment;

    public AdapterListParking(JSONArray listaParkings, View root, Context context, ParkingFragment parkingFragment){
        this.listaParkings = listaParkings;
        this.root = root;
        this.parkingFragment = parkingFragment;
        this.dataConfig = new Config(context);
    }

    @NonNull
    @Override
    public AdapterListParking.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.parkins, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListParking.ViewHolder holder, int position) {
        JSONObject parking = null;
        try {
            parking = listaParkings.getJSONObject(position);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        holder.cargarParking(parking);
    }

    @Override
    public int getItemCount() {
        return listaParkings.length();
    }


    public void updateData(JSONArray newParkings) {
        this.listaParkings = newParkings;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name_parking, direction_parking;

        Context context;
        Button edit_btnAgregarParking;
        FloatingActionButton btnDetailParking, btnEditParking;
        TextView label_price_motorcycle, label_price_car, label_price_truck, label_price_pickup_truck, label_name_parking, label_addres_parking, edit_field_name_parking, edit_field_address_parking, edit_field_motorcycle, edit_field_car, edit_field_truck, edit_field_pickup_truck;
        LinearLayout sesionDetailParking, sesionEditParking, sesionListParking;

        Spinner spinner_select;

        ImageView loaderTruck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            name_parking = itemView.findViewById(R.id.listNameParking);
            direction_parking = itemView.findViewById(R.id.Direction);
            btnDetailParking = itemView.findViewById(R.id.btnDetailParking);
            btnEditParking = itemView.findViewById(R.id.btnEditParking);

            label_name_parking = root.findViewById(R.id.NameParking);
            label_addres_parking = root.findViewById(R.id.AddresParking);
            label_price_motorcycle = root.findViewById(R.id.priceMoto);
            label_price_car = root.findViewById(R.id.PriceCar);
            label_price_truck = root.findViewById(R.id.PriceTruck);
            label_price_pickup_truck = root.findViewById(R.id.PriceVan);
            sesionDetailParking = root.findViewById(R.id.sesionDetailParking);
            sesionListParking = root.findViewById(R.id.sesionListParking);

            edit_field_name_parking = root.findViewById(R.id.edit_field_name_parking);
            edit_field_address_parking = root.findViewById(R.id.edit_field_address_parking);
            edit_field_motorcycle = root.findViewById(R.id.edit_field_motorcycle);
            edit_field_car = root.findViewById(R.id.edit_field_car);
            edit_field_truck = root.findViewById(R.id.edit_field_truck);
            edit_field_pickup_truck = root.findViewById(R.id.edit_field_pickup_truck);
            sesionEditParking = root.findViewById(R.id.sesionEditParking);
            edit_btnAgregarParking = root.findViewById(R.id.edit_btnAgregarParking);
            loaderTruck = root.findViewById(R.id.loaderTruck);
            Glide.with(context).asGif().load(R.drawable.loader_truck).into(loaderTruck);
            spinner_select = root.findViewById(R.id.editRoles);



            System.out.println(sesionDetailParking);

            if (sesionListParking != null){
                System.out.println("sesionListParking null");
            }

            btnEditParking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        try {
                            switchSection(root.findViewById(R.id.sesionEditParking), root.findViewById(R.id.sesionListParking));
                            parking_buscado = listaParkings.getJSONObject(position);
                            System.out.println(parking_buscado);
                            String parkingId = parking_buscado.getString("id");
                            String name = parking_buscado.getString("name");
                            String address = parking_buscado.getString("address");
                            String price_truck = parking_buscado.getString("camioneta");
                            String price_car = parking_buscado.getString("carro");
                            String price_motorcycle = parking_buscado.getString("moto");
                            String pickup_truck = parking_buscado.getString("camion");
                            edit_field_name_parking.setText(name);
                            edit_field_address_parking.setText(address);
                            edit_field_motorcycle.setText(price_motorcycle);
                            edit_field_car.setText(price_car);
                            edit_field_truck.setText(price_truck);
                            edit_field_pickup_truck.setText(pickup_truck);
                            System.out.println(parkingId);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            edit_btnAgregarParking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(parking_buscado);
                    consumoEditParking();
                }
            });
            btnDetailParking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        try {
                            switchSection(root.findViewById(R.id.sesionDetailParking), root.findViewById(R.id.sesionListParking));
                            JSONObject parking = listaParkings.getJSONObject(position);
                            String parkingId = parking.getString("id");
                            String name = parking.getString("name");
                            String address = parking.getString("address");
                            String price_truck = parking.getString("camioneta");
                            String price_car = parking.getString("carro");
                            String price_motorcycle = parking.getString("moto");
                            String pickup_truck = parking.getString("camion");
                            label_price_motorcycle.setText(price_motorcycle);
                            label_price_car.setText(price_car);
                            label_price_truck.setText(price_truck);
                            label_price_pickup_truck.setText(pickup_truck);
                            label_name_parking.setText(name);
                            label_addres_parking.setText(address);
                            System.out.println(parkingId);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void cargarParking(JSONObject parking) {
            try {
                String name = parking.getString("name");
                String address = parking.getString("address");
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

        public void consumoEditParking() {
            loaderTruck.setVisibility(View.VISIBLE);

            List<String> list_fields_edit = check_fields();
            if (parking_buscado != null || list_fields_edit !=null) {
                System.out.println("Iniciando consumo");

                RequestQueue queue = Volley.newRequestQueue(context);
                String endpoint = "/parking/updateParking.php";
                String url = dataConfig.getEndPoint(endpoint);

                StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println("El servidor POST responde OK");
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println(jsonObject.toString());
                            Toast.makeText(context, "Los cambios fueron realizados", Toast.LENGTH_LONG).show();
                            cleanFieldEdit();
                            parkingFragment.consumoParkings(context);
                            loaderTruck.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            System.out.println("El servidor POST responde con un error:");
                            System.out.println(e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("El servidor POST responde con un error:");
                        System.out.println(error.getMessage());
                    }
                }) {
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        try {
                            params.put("id", parking_buscado.getString("id"));
                            params.put("name", list_fields_edit.get(0));
                            params.put("address", list_fields_edit.get(1));
                            params.put("camioneta", list_fields_edit.get(2));
                            params.put("carro", list_fields_edit.get(3));
                            params.put("moto", list_fields_edit.get(4));
                            params.put("camion", list_fields_edit.get(5));
                            params.put("status", list_fields_edit.get(6));

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                        return params;
                    }
                };

                queue.add(solicitud);
            } else {
                // El objeto parking_buscado es nulo, se debe manejar este caso
                System.out.println("El objeto parking_buscado es nulo. No se puede realizar la solicitud.");
            }
        }
        public void cleanFieldEdit(){
            edit_field_name_parking.setText("");
            edit_field_address_parking.setText("");
            edit_field_motorcycle.setText("");
            edit_field_car.setText("");
            edit_field_truck.setText("");
            edit_field_pickup_truck.setText("");
        }



        public List<String> check_fields() {
            List<String> list_fields_edit = new ArrayList<>();
            list_fields_edit.add(edit_field_name_parking.getText().toString());
            list_fields_edit.add(edit_field_address_parking.getText().toString());
            list_fields_edit.add(edit_field_pickup_truck.getText().toString());
            list_fields_edit.add(edit_field_car.getText().toString());
            list_fields_edit.add(edit_field_motorcycle.getText().toString());
            list_fields_edit.add(edit_field_truck.getText().toString());

            Object selectedItem = spinner_select.getSelectedItem();
            if (selectedItem != null) {
                list_fields_edit.add(selectedItem.toString());
            } else {
                Toast.makeText(context, "Los campos estan vacios", Toast.LENGTH_LONG).show();
                return null;
            }

            for (String field_edit : list_fields_edit) {
                if (field_edit == null || field_edit.trim().isEmpty()) {

                    Toast.makeText(context, "Los campos estan vacios", Toast.LENGTH_LONG).show();
                    return null;
                }
            }
            return list_fields_edit;
        }
    }


}
