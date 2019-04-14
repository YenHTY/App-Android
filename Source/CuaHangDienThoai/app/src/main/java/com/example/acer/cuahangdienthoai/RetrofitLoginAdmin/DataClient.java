package com.example.acer.cuahangdienthoai.RetrofitLoginAdmin;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DataClient {
    @Multipart
    @POST("uploadhinhanh.php")
    Call<String> UploadPhoto(@Part MultipartBody.Part photo);

    @FormUrlEncoded
    @POST("insert.php")
    Call<String> InsertData(@Field("tensp") String tensp
                           ,@Field("giasp") int giasp
                             ,@Field("hinhsp") String hinhsp
                            , @Field("motasp") String motasp
                           , @Field("idloaisp") int idloaisp);



}
