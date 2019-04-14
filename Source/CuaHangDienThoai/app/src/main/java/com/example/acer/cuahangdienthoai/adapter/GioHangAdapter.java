package com.example.acer.cuahangdienthoai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.activity.GioHangActivity;
import com.example.acer.cuahangdienthoai.activity.MainActivity;
import com.example.acer.cuahangdienthoai.model.Giohang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang> arraygiohang;

    public GioHangAdapter(Context context, ArrayList<Giohang> arraygiohang) {
        this.context = context;
        this.arraygiohang = arraygiohang;
    }

    @Override
    public int getCount() {
        return arraygiohang.size();
    }

    @Override
    public Object getItem(int i) {
        return arraygiohang.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        public TextView txttengiohang, txtgiagiohang;
        public ImageView imggiohang;
        public Button btngiam, btnvalues, btntang;
    }

    @Override
    public View getView(final int i, View view, ViewGroup parent) {
        ViewHolder viewHolder= null;
        if (view ==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_giohang, parent,false);
            viewHolder.txttengiohang = (TextView) view.findViewById(R.id.txttengiohang);
            viewHolder.txtgiagiohang = (TextView) view.findViewById(R.id.txtgiagiohang);
            viewHolder.imggiohang =(ImageView) view.findViewById(R.id.imggiohang);
            viewHolder.btngiam=(Button) view.findViewById(R.id.btngiam);
            viewHolder.btnvalues=(Button) view.findViewById(R.id.btnvalues);
            viewHolder.btntang=(Button) view.findViewById(R.id.btntang);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        Giohang giohang= (Giohang) getItem(i);
        viewHolder.txttengiohang.setText(giohang.getTensp());
        DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText(decimalFormat.format(giohang.getGiasp())+" Đ");
        Picasso.with(context).load(giohang.getHinhsp())
                .placeholder(R.drawable.noimageavailable)
                .error(R.drawable.error)
                .into(viewHolder.imggiohang);
        viewHolder.btnvalues.setText(giohang.getSoluongsp()+"");
        int sl= Integer.parseInt(viewHolder.btnvalues.getText().toString());
        if (sl>=10){
            viewHolder.btntang.setVisibility(View.INVISIBLE);
            viewHolder.btngiam.setVisibility(View.VISIBLE);
        }else if (sl<=1)
        {
            viewHolder.btngiam.setVisibility(View.INVISIBLE);
        }else if(sl>=1){
            viewHolder.btntang.setVisibility(View.VISIBLE);
            viewHolder.btngiam.setVisibility(View.VISIBLE);
        }
        final ViewHolder finalViewHolder = viewHolder;
        final ViewHolder finalViewHolder1 = viewHolder;
        viewHolder.btntang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat= Integer.parseInt(finalViewHolder.btnvalues.getText().toString()) +1;
                int slht = MainActivity.manggiohang.get(i).getSoluongsp();
                long giaht = MainActivity.manggiohang.get(i).getGiasp();
                MainActivity.manggiohang.get(i).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht*slmoinhat)/slht;
                MainActivity.manggiohang.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+" Đ");
                GioHangActivity.EventUltil();
                if (slmoinhat>9){
                    finalViewHolder1.btntang.setVisibility(View.INVISIBLE);
                    finalViewHolder1.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder1.btnvalues.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder1.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder1.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder1.btnvalues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        viewHolder.btngiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat= Integer.parseInt(finalViewHolder.btnvalues.getText().toString()) -1;
                int slht = MainActivity.manggiohang.get(i).getSoluongsp();
                long giaht = MainActivity.manggiohang.get(i).getGiasp();
                MainActivity.manggiohang.get(i).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht*slmoinhat)/slht;
                MainActivity.manggiohang.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+" Đ");
                GioHangActivity.EventUltil();
                if (slmoinhat<2){
                    finalViewHolder1.btngiam.setVisibility(View.INVISIBLE);
                    finalViewHolder1.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder1.btnvalues.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder1.btngiam.setVisibility(View.VISIBLE);
                    finalViewHolder1.btntang.setVisibility(View.VISIBLE);
                    finalViewHolder1.btnvalues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        return view;
    }
}
