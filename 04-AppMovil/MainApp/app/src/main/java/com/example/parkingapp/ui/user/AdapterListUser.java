package com.example.parkingapp.ui.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.parkingapp.R;
import com.example.parkingapp.ui.parking.AdapterListParking;
import com.example.parkingapp.utils.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdapterListUser extends RecyclerView.Adapter<AdapterListUser.ViewHolder> {

    private JSONArray listaUser;
    View root;
    Config dataConfig;

    JSONObject parking_buscado;
    JSONArray parkingsArray;

    JSONObject parkingAssignUser;
    LinearLayout panelAssign, panelUnassign;

    EditText idParkingAssign, nameParkingAssign;
    UserFragment userFragment;
    public AdapterListUser(JSONArray listaUser, View root, Context context, UserFragment userFragment){
        this.listaUser = listaUser;
        this.root = root;
        this.userFragment = userFragment;
        idParkingAssign = root.findViewById(R.id.idParkingAssign);
        nameParkingAssign = root.findViewById(R.id.nameParkingAssign);
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


    public void updateData(JSONArray newUser) {
        this.listaUser = newUser;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listNameUser, id_user, labelIdSeller, labelNameSeller;
        Button btnDetailUser, btnEditUser, btnConfirmUserEdit, btnAssignParking, btnConfirmAssignParking;

        Context context;
        ImageView loaderTruck;

        EditText idUserEdit, nameUserEdit, emailEdituser, passwordUserEdit, idUserDetail, nameUserDetail, emailDetailuser, userRoleDetail, userStatusDetail;
        Spinner userStatusEdit, userRoleEdit, parkingListAssign;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            listNameUser = itemView.findViewById(R.id.listNameUser);
            id_user = itemView.findViewById(R.id.id_user);
            btnDetailUser = itemView.findViewById(R.id.btnDetailUser);
            btnEditUser = itemView.findViewById(R.id.btnEditUser);
            btnAssignParking = itemView.findViewById(R.id.btnAssignParking);


            nameUserEdit = root.findViewById(R.id.nameUserEdit);
            emailEdituser = root.findViewById(R.id.emailEdituser);
            passwordUserEdit = root.findViewById(R.id.passwordUserEdit);
            userStatusEdit = root.findViewById(R.id.userStatusEdit);
            userRoleEdit = root.findViewById(R.id.userRoleEdit);
            btnConfirmUserEdit = root.findViewById(R.id.btnConfirmUserEdit);


            idUserDetail = root.findViewById(R.id.idUserDetail);
            nameUserDetail = root.findViewById(R.id.nameUserDetail);
            emailDetailuser = root.findViewById(R.id.emailDetailuser);
            userRoleDetail = root.findViewById(R.id.userRoleDetail);
            userStatusDetail = root.findViewById(R.id.userStatusDetail);


            labelIdSeller = root.findViewById(R.id.labelIdSeller);
            labelNameSeller = root.findViewById(R.id.labelNameSeller);
            parkingListAssign = root.findViewById(R.id.parkingListAssign);
            btnConfirmAssignParking = root.findViewById(R.id.btnConfirmAssignParking);
            panelAssign = root.findViewById(R.id.panelAssign);
            panelUnassign = root.findViewById(R.id.panelUnassign);
            loaderTruck = root.findViewById(R.id.loaderTruck);
            Glide.with(context).asGif().load(R.drawable.loader_truck).into(loaderTruck);

            btnEditUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        try {
                            switchSection(root.findViewById(R.id.layoutEditUser), root.findViewById(R.id.layoutListUser));
                            parking_buscado = listaUser.getJSONObject(position);
                            System.out.println(parking_buscado);
                            String name = parking_buscado.getString("name");
                            String email = parking_buscado.getString("email");
                            nameUserEdit.setText(name);
                            emailEdituser.setText(email);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            btnConfirmUserEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(parking_buscado);
                    consumoEditUser();
                }
            });
            btnDetailUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        try {
                            switchSection(root.findViewById(R.id.layoutDetailUser), root.findViewById(R.id.layoutListUser));
                            JSONObject parking = listaUser.getJSONObject(position);
                            String userId = parking.getString("id");
                            String name = parking.getString("name");
                            String address = parking.getString("email");
                            String price_truck = parking.getString("rol");
                            String price_car = parking.getString("status");
                            idUserDetail.setText(userId);
                            nameUserDetail.setText(name);
                            emailDetailuser.setText(address);
                            userRoleDetail.setText(price_truck);
                            userStatusDetail.setText(price_car);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });


            btnAssignParking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        try {
                            switchSection(root.findViewById(R.id.layoutAssignUser), root.findViewById(R.id.layoutListUser));
                            JSONObject user = listaUser.getJSONObject(position);
                            String userId = user.getString("id");
                            String name = user.getString("name");
                            consumoUerParkingAssign(context, loaderTruck, userId);

                            labelIdSeller.setText(userId);
                            labelNameSeller.setText(name);

                            consumoParkings(context, parkingListAssign, loaderTruck);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            btnConfirmAssignParking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(parkingAssignUser == null){
                        Toast.makeText(context,"Debes seleccionar un parqueadero para asignar", Toast.LENGTH_LONG).show();
                        return;
                    }
                    try {
                        String idParking = parkingAssignUser.getString("id");
                        consumoAssignUserParking(labelIdSeller.getText().toString(), idParking);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            parkingListAssign.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        parkingAssignUser = parkingsArray.getJSONObject(position);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // Este método se llama cuando no hay ningún elemento seleccionado en el Spinner
                }
            });
        }


        public void consumoEditUser() {
            List<String> list_fields_edit = check_fields();
            if (parking_buscado != null || list_fields_edit !=null) {
                System.out.println("Iniciando consumo");

                RequestQueue queue = Volley.newRequestQueue(context);
                String endpoint = "/users/Update.php";
                String url = dataConfig.getEndPoint(endpoint);

                StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println("El servidor POST responde OK");
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println(jsonObject.toString());
                            userFragment.consumoUsers(context);
                            Toast.makeText(context, "Los cambios fueron realizados", Toast.LENGTH_LONG).show();
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
                            params.put("iduser", parking_buscado.getString("id"));
                            params.put("name", list_fields_edit.get(0));
                            params.put("email", list_fields_edit.get(1));
                            params.put("password", list_fields_edit.get(2));
                            params.put("rol", list_fields_edit.get(3));
                            params.put("status", list_fields_edit.get(4));


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

        public void consumoAssignUserParking(String idUser, String idParking) {
                System.out.println("Iniciando consumo");

                RequestQueue queue = Volley.newRequestQueue(context);
                String endpoint = "/parking_seller/insertParkingSeller.php";
                String url = dataConfig.getEndPoint(endpoint);

                StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println("El servidor POST responde OK");
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println(jsonObject.toString());
                            userFragment.consumoUsers(context);
                            Toast.makeText(context, "Los cambios fueron realizados", Toast.LENGTH_LONG).show();
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
                        params.put("user_id", idUser);
                        params.put("parking_id", idParking);
                        return params;
                    }
                };

                queue.add(solicitud);
        }
        public void cargarUsers(JSONObject user) {
            try {
                String name = user.getString("name");
                String address = user.getString("id");
                String rol = user.getString("rol");
                listNameUser.setText(name);
                id_user.setText(address);
                if(rol.equalsIgnoreCase("admin")){
                    btnAssignParking.setVisibility(View.GONE);
                }


            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        public List<String> check_fields() {
            List<String> list_fields_edit = new ArrayList<>();
            nameUserEdit = root.findViewById(R.id.nameUserEdit);
            emailEdituser = root.findViewById(R.id.emailEdituser);
            passwordUserEdit = root.findViewById(R.id.passwordUserEdit);
            userStatusEdit = root.findViewById(R.id.userStatusEdit);
            userRoleEdit = root.findViewById(R.id.userRoleEdit);

            list_fields_edit.add(nameUserEdit.getText().toString());
            list_fields_edit.add(emailEdituser.getText().toString());
            list_fields_edit.add(passwordUserEdit.getText().toString());

            Object selectedItemStatus = userStatusEdit.getSelectedItem();
            Object selectedItemRole = userRoleEdit.getSelectedItem();
            if (selectedItemStatus != null) {
                list_fields_edit.add(selectedItemRole.toString());
                list_fields_edit.add(selectedItemStatus.toString());
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

    public void switchSection(View section, View previousSection) {
        if (section.getVisibility() == View.GONE) {
            section.setVisibility(View.VISIBLE);
            previousSection.setVisibility(View.GONE);
        } else {
            section.setVisibility(View.GONE);
        }
    }
    public void consumoParkings(Context context,Spinner spinner, ImageView loaderTruck) {
        loaderTruck.setVisibility(View.VISIBLE);
        System.out.println("Iniciando consumo");

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "";
        String endpoint = "/parking/getParkings.php";
        url = dataConfig.getEndPoint(endpoint);

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                try {
                    parkingsArray = response.getJSONArray("parkings");
                    String[] parkingNames = new String[parkingsArray.length()];

                    for (int i = 0; i < parkingsArray.length(); i++) {
                        JSONObject parkingObj = parkingsArray.getJSONObject(i);
                        String parkingName = parkingObj.getString("name");
                        parkingNames[i] = parkingName;
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, parkingNames);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                    loaderTruck.setVisibility(View.GONE);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
                Toast.makeText(context, "El servidor no da respuesta", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(solicitud);
    }

    public void consumoUerParkingAssign(Context context, ImageView loaderTruck, String user_id){
        loaderTruck.setVisibility(View.VISIBLE);
        System.out.println("Iniciando consumo");

        RequestQueue queue = Volley.newRequestQueue(context);

        String endpoint = "/parking_seller/getParkingSeller.php?id="+user_id;
        String   url = dataConfig.getEndPoint(endpoint);


        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                try {
                    System.out.println(response.toString());
                    if(response.getBoolean("status")){
                        JSONArray parkingInfo = response.getJSONArray("parkings");
                        JSONObject parking_info =  parkingInfo.getJSONObject(0);
                        String id_parking = parking_info.getString("id");
                        String name_parking = parking_info.getString("name");
                        idParkingAssign.setText(id_parking);
                        nameParkingAssign.setText(name_parking);
                        panelAssign.setVisibility(View.GONE);
                        panelUnassign.setVisibility(View.VISIBLE);
                    }else{
                        panelAssign.setVisibility(View.VISIBLE);
                        panelUnassign.setVisibility(View.GONE);
                    }
                    loaderTruck.setVisibility(View.GONE);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
                loaderTruck.setVisibility(View.GONE);
                Toast.makeText(context, "El servidor no da respuesta", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(solicitud);
    }

}