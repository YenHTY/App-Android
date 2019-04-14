package com.example.acer.cuahangdienthoai.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.model.Giohang;
import com.example.acer.cuahangdienthoai.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class  ChiTietSanPham extends AppCompatActivity {
    Toolbar toolbarchitiet;
    ImageView imgChitiet;
    TextView txtten, txtgia, txtmota;
    Spinner spinner;
    Button btnthemvaogio;
    int id=0;
    String tenchitiet="";
    int giachitiet=0;
    String hinhanhchitiet="";
    String motachitiet="";
    int idsanpham=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        Anhxa();
        ActionToolBar();
        GetInformation();
        CatchEventSpinner();
        EventButton();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent= new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void EventButton() {
        btnthemvaogio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.manggiohang.size()>0){
                    int sl=Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists=false;
                    for(int i=0;i< MainActivity.manggiohang.size();i++){
                        if (MainActivity.manggiohang.get(i).getIdsp()==id){
                            MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp()+sl);
                            if(MainActivity.manggiohang.get(i).getSoluongsp()>=10){
                                MainActivity.manggiohang.get(i).setSoluongsp(10);
                            }
                            MainActivity.manggiohang.get(i).setGiasp(giachitiet*MainActivity.manggiohang.get(i).getSoluongsp());
                            exists=true;
                        }
                    }
                     if (exists==false){
                         int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                         long giamoi=soluong*giachitiet;
                         MainActivity.manggiohang.add(new Giohang(id,tenchitiet,giamoi,hinhanhchitiet,soluong));
                     }

                }else {
                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long giamoi=soluong*giachitiet;
                    MainActivity.manggiohang.add(new Giohang(id,tenchitiet,giamoi,hinhanhchitiet,soluong));
                }
                Intent intent=new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CatchEventSpinner() {
        Integer[] soluong= new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter= new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformation() {

        Sanpham sanpham= (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id = sanpham.getID();
        tenchitiet=sanpham.getTensanpham();
        giachitiet=sanpham.getGiasanpham();
        hinhanhchitiet=sanpham.getHinhanhsanpham();
        motachitiet=sanpham.getMotasanpham();
        idsanpham=sanpham.getIDsanpham();
        txtten.setText(tenchitiet);
        DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
        txtgia.setText("Giá :"+decimalFormat.format(giachitiet)+" Đ");
        txtmota.setText(motachitiet);
        Picasso.with(getApplicationContext()).load(hinhanhchitiet)
                .placeholder(R.drawable.noimageavailable)
                .error(R.drawable.error)
                .into(imgChitiet);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarchitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



    private void Anhxa() {
        toolbarchitiet = (Toolbar) findViewById(R.id.toolbarchitietsp);
        imgChitiet = (ImageView) findViewById(R.id.imgchitietsp);
        txtten= (TextView) findViewById(R.id.txttenchitietsp);
        txtgia= (TextView) findViewById(R.id.txtgiachitietsp);
        txtmota= (TextView) findViewById(R.id.txtmota);
        spinner= (Spinner)findViewById(R.id.spinner);
        btnthemvaogio= (Button) findViewById(R.id.buttonthem);
    }
}
