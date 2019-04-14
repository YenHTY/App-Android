package com.example.acer.cuahangdienthoai.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.adapter.ThongKeDHAdapter;
import com.example.acer.cuahangdienthoai.model.ThongKeDH;
import com.example.acer.cuahangdienthoai.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    ArrayList<ThongKeDH> arrayListthongKeDH;
    ThongKeDHAdapter adapterDH;

    TextView txtDh,txtThemSP;
    ListView lvThongKe;
    ImageView imageView;
    public static  String EmailChiTietDH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        AnhXa();
        //getDuLieuThongKeDH();
        txtDh.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {

                getDuLieuThongKeDH();
                txtDh.setBackgroundColor(Color.BLUE);
                txtDh.setTextColor(Color.WHITE);
                txtThemSP.setBackgroundColor(Color.WHITE);
                txtThemSP.setTextColor(Color.BLUE);


            }
        });
        txtThemSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminActivity.this,ThemSPActivity.class);
                startActivity(intent);
                txtThemSP.setBackgroundColor(Color.BLUE);
                txtThemSP.setTextColor(Color.WHITE);
                txtDh.setBackgroundColor(Color.WHITE);
                txtDh.setTextColor(Color.BLUE);
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        lvThongKe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EmailChiTietDH=arrayListthongKeDH.get(position).getEmail().toString();
                Intent intent= new Intent(AdminActivity.this, ChiTietDHActivity.class);
                intent.putExtra("EmailDH",EmailChiTietDH);
                startActivity(intent);
            }
        });

    }
    private void getDuLieuThongKeDH() {
        lvThongKe.setAdapter(adapterDH);
        arrayListthongKeDH.clear();
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Server.DuongdanThongKeDH, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if(response!= null)
                {
                    for(int i=0;i< response.length();i++)
                    {
                        try {
                            JSONObject object= response.getJSONObject(i);
                            String HoTen=object.getString("tenkhachhang");
                            String SDT=object.getString("sodienthoai");
                            String Email=object.getString("email");
                            String DiaChi=object.getString("diachi");


                            arrayListthongKeDH.add(new ThongKeDH(HoTen,SDT,Email,DiaChi));
                            adapterDH.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AdminActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    private void AnhXa() {
        imageView=(ImageView)findViewById(R.id.imageviewTrangChinh);
        txtDh= (TextView)findViewById(R.id.textViewDonHangQL);


        txtThemSP=(TextView)findViewById(R.id.textViewThemSP) ;

        lvThongKe=(ListView)findViewById(R.id.listViewThongKeQL);

        arrayListthongKeDH= new ArrayList<>();
        adapterDH= new ThongKeDHAdapter(getApplicationContext(),arrayListthongKeDH);

    }
}
