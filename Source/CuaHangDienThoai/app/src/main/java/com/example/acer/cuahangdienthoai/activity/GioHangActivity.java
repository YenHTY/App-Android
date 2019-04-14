package com.example.acer.cuahangdienthoai.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.adapter.GioHangAdapter;
import com.example.acer.cuahangdienthoai.ultil.CheckConnection;

import java.text.DecimalFormat;



public class GioHangActivity extends AppCompatActivity {
    ListView lvgiohang;
    TextView txtthongbao;
    static TextView txttongtien;
    Button btnthanhtoan, btntieptucmua;
    Toolbar toolbargiohang;
    GioHangAdapter gioHangAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        Anhxa();
        ActionToolBar();
        CheckData();
        EventUltil();
        CatchOnItemListView();
        EventButton();
    }

    private void EventButton() {
        btntieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.manggiohang.size()>0){
                    Intent intent = new Intent(getApplicationContext(),ThongTinKhachHang.class);
                    startActivity(intent);
                }else {
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Giỏ hàng của bạn chưa có sản phẩn để thanh toán");
                }
            }
        });
    }

    private void CatchOnItemListView() {
        lvgiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(GioHangActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn chắc chắn muốn xóa sẩn phẩm này?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       if (MainActivity.manggiohang.size()<=0){
                           txtthongbao.setVisibility(View.VISIBLE);
                       } else {
                           MainActivity.manggiohang.remove(position);
                           gioHangAdapter.notifyDataSetChanged();
                           EventUltil();
                           if (MainActivity.manggiohang.size()<=0){
                               txtthongbao.setVisibility(View.VISIBLE);
                           }else {
                               txtthongbao.setVisibility(View.INVISIBLE);
                               gioHangAdapter.notifyDataSetChanged();
                               EventUltil();
                           }
                       }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gioHangAdapter.notifyDataSetChanged();
                        EventUltil();
                    }
                });
                builder.show();
                return false;
            }


        });
    }

    public static void EventUltil() {
        long tongtien=0;
        for (int i=0;i<MainActivity.manggiohang.size();i++){
            tongtien+=MainActivity.manggiohang.get(i).getGiasp();

        }
        DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien)+" Đ");
    }

    private void CheckData() {
        if(MainActivity.manggiohang.size()<=0){
           gioHangAdapter.notifyDataSetChanged();
           txtthongbao.setVisibility(View.VISIBLE);
           lvgiohang.setVisibility(View.INVISIBLE);
        }
        else {
            gioHangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.INVISIBLE);
            lvgiohang.setVisibility(View.VISIBLE);
        }


    }

    private void ActionToolBar() {
        setSupportActionBar(toolbargiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void Anhxa() {
        lvgiohang = (ListView) findViewById(R.id.listviewgiohang);
        txtthongbao=(TextView) findViewById(R.id.txtthongbao);
        txttongtien= (TextView) findViewById(R.id.txttongtien);
        btnthanhtoan= (Button) findViewById(R.id.btnthanhtoan);
        btntieptucmua=(Button) findViewById(R.id.btntieptucmua);
        toolbargiohang = (Toolbar) findViewById(R.id.toolbargiohang);
        gioHangAdapter = new GioHangAdapter(GioHangActivity.this,MainActivity.manggiohang);
        lvgiohang.setAdapter(gioHangAdapter);
    }
}
