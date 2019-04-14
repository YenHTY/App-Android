package com.example.acer.cuahangdienthoai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.adapter.ChiTietDHAdapter;
import com.example.acer.cuahangdienthoai.model.ChiTietDH;
import com.example.acer.cuahangdienthoai.ultil.CheckConnection;
import com.example.acer.cuahangdienthoai.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChiTietDHActivity extends AppCompatActivity {
    ListView lvchitietdh;
    TextView txttongtien;
    Toolbar toolbarchitietdh;
    ChiTietDHAdapter chiTietDHAdapter;
    ArrayList<ChiTietDH> arrayListthongKeDH;
    int tongtien=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietdonhang);
        Anhxa();
        ActionToolBar();
        Intent intent=getIntent();
        String EmailDH=intent.getStringExtra("EmailDH");
        GetData(EmailDH);

    }

    private void Anhxa() {
        lvchitietdh=(ListView) findViewById(R.id.listviewchitietdh);
        txttongtien= (TextView) findViewById(R.id.txttongtien);
        toolbarchitietdh=(Toolbar) findViewById(R.id.toolbarchitietdh);
        arrayListthongKeDH= new ArrayList<>();
        chiTietDHAdapter = new ChiTietDHAdapter(getApplicationContext(), arrayListthongKeDH);
        lvchitietdh.setAdapter(chiTietDHAdapter);

    }

    private void GetData(final String email) {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        String duongdan= Server.DuongdanChiTietDH;
        StringRequest stringRequest= new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String tensp = "";
                String giasp = "";
                String hinhsp = "";
                String soluongsp = "";

                if (response != null ) {

                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            tensp     = jsonObject.getString("TenSP");
                            giasp     = jsonObject.getString("GiaSP");
                            hinhsp    = jsonObject.getString("HinhSP");
                            soluongsp = jsonObject.getString("SLSP");
                            arrayListthongKeDH.add(new ChiTietDH(tensp, giasp, hinhsp, soluongsp));

                            chiTietDHAdapter.notifyDataSetChanged();


                            tongtien +=Integer.parseInt(arrayListthongKeDH.get(i).giasp);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
                    txttongtien.setText(decimalFormat.format(tongtien)+" Đ");



                } else {

                    CheckConnection.ShowToast_Short(getApplicationContext(), "Đã hết dữ liệu");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param= new HashMap<String, String>();
                param.put("email", email);
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarchitietdh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchitietdh.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}