package com.example.acer.cuahangdienthoai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.model.ThongKeDH;

import java.util.ArrayList;

public class ThongKeDHAdapter extends BaseAdapter {
    Context context;
    ArrayList<ThongKeDH> arrayListthongKeDH;

    public ThongKeDHAdapter(Context context, ArrayList<ThongKeDH> arrayListthongKeDH) {
        this.context = context;
        this.arrayListthongKeDH = arrayListthongKeDH;
    }

    @Override
    public int getCount() {
        return arrayListthongKeDH.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListthongKeDH.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder
    {
        TextView txtTenKH,txtSDT,txtEmail,txtDiaChi;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.dong_thongke_dh,null);
            holder.txtTenKH=(TextView)convertView.findViewById(R.id.textviewTenKHDH);
            holder.txtSDT=(TextView)convertView.findViewById(R.id.textviewSDT);
            holder.txtEmail=(TextView)convertView.findViewById(R.id.textviewEmail);
            holder.txtDiaChi=(TextView) convertView.findViewById(R.id.textviewDiaChi);

            convertView.setTag(holder);
        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }

        ThongKeDH thongKeDH = (ThongKeDH) getItem(position);
        holder.txtTenKH.setText(thongKeDH.getTenkhachhang());
        holder.txtSDT.setText(thongKeDH.getSodienthoai());
        holder.txtEmail.setText(thongKeDH.getEmail());
        holder.txtDiaChi.setText(thongKeDH.getDiachi());



        return convertView;
    }
}
