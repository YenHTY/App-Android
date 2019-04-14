package com.example.acer.cuahangdienthoai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.model.ChiTietDH;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChiTietDHAdapter extends BaseAdapter{
    Context context;
    ArrayList<ChiTietDH> arraychitietDH;

    public ChiTietDHAdapter(Context context, ArrayList<ChiTietDH> arraychitietDH) {
        this.context = context;
        this.arraychitietDH = arraychitietDH;
    }


    @Override
    public int getCount() {
        return arraychitietDH.size();
    }

    @Override
    public Object getItem(int i) {
        return arraychitietDH.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView txttenchitietdh, txtgiachitietdh, txtsoluongchitietdh;
        public ImageView imgchitietdh;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
       ViewHolder viewHolder= null;
        if (view ==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.chitietdonhang, null);
            viewHolder.txttenchitietdh     = (TextView) view.findViewById(R.id.txttenchitietdh);
            viewHolder.txtgiachitietdh     = (TextView) view.findViewById(R.id.txtgiachitietdh);
            viewHolder.txtsoluongchitietdh = (TextView) view.findViewById(R.id.txtsoluongchitietdh);
            viewHolder.imgchitietdh        =(ImageView) view.findViewById(R.id.imgchitietdh);
            view.setTag(viewHolder);

        }else {
            viewHolder= (ChiTietDHAdapter.ViewHolder) view.getTag();
        }
        ChiTietDH chiTietDH= (ChiTietDH) getItem(position);
        viewHolder.txttenchitietdh.setText(chiTietDH.tensp);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        int gia=Integer.parseInt(chiTietDH.giasp);
        viewHolder.txtgiachitietdh.setText("Giá :"+ decimalFormat.format(gia)+" Đ");

        viewHolder.txtsoluongchitietdh.setText(chiTietDH.soluongsp );
        Picasso.with(context).load(chiTietDH.hinhsp)
                .placeholder(R.drawable.noimageavailable)
                .error(R.drawable.error)
                .into(viewHolder.imgchitietdh);

        return view;
    }

}
