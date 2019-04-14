package com.example.acer.cuahangdienthoai.RetrofitLoginAdmin;

public class APIUtils {
    public static final String Base_Ur="http://192.168.1.20:600/server/";
    public static DataClient getData(){
         return retrofitClient.getClient(Base_Ur).create(DataClient.class);

    }
}
