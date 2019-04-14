package com.example.acer.cuahangdienthoai.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.RetrofitLoginAdmin.APIUtils;
import com.example.acer.cuahangdienthoai.RetrofitLoginAdmin.DataClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThemSPActivity extends AppCompatActivity {
        EditText edtTensp, edtGiasp, edtMotasp;
        Button btnThem;
        ImageView imgHinhsp;
        Spinner spinner;
        Toolbar toolbarThem;
        String tensp;
        int giasp;
        String motasp;
        String hinhsp;
        int idloaisp;
        int Request_Code_Image=123;
        String realPath="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sp);
        Anhxa();
        ActionToolBar();
        CatchEventSpinner();
        imgHinhsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,Request_Code_Image);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tensp=edtTensp.getText().toString();

                motasp=edtMotasp.getText().toString();
                idloaisp=Integer.parseInt(spinner.getSelectedItem().toString());

                giasp= Integer.parseInt(edtGiasp.getText().toString());


                    if (tensp.length() > 0 && motasp.length() > 0 && giasp > 0) {
                        File file = new File(realPath);
                        String file_path = file.getAbsolutePath();

                        if (TextUtils.equals(file_path, "/")) {

                            Toast.makeText(ThemSPActivity.this, "Vui lòng chọn ảnh", Toast.LENGTH_SHORT).show();

                        } else {
                            String[] mangtenfile = file_path.split("\\.");

                            Log.d("ghg", file_path);
                            file_path = mangtenfile[0] + System.currentTimeMillis() + "." + mangtenfile[1];
                            Log.d("gyyy", file_path);
                            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);

                            MultipartBody.Part body = MultipartBody.Part.createFormData("uploaded_file", file_path, requestBody);
                            DataClient dataClient = APIUtils.getData();
                            Call<String> callback = dataClient.UploadPhoto(body);
                            callback.enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {
                                    if (response != null) {
                                        final String message = response.body();

                                        if (message.length() > 0) {
                                            DataClient insertdata = APIUtils.getData();

                                            Call<String> callback = insertdata.InsertData(tensp, giasp, APIUtils.Base_Ur + "image/" + message, motasp, idloaisp);

                                            callback.enqueue(new Callback<String>() {
                                                @Override
                                                public void onResponse(Call<String> call, Response<String> response) {
                                                    String kq = response.body();
                                                    if (kq.equals("OK")) {
                                                        Toast.makeText(ThemSPActivity.this, "Thêm thành công ", Toast.LENGTH_SHORT).show();
                                                        finish();
                                                    } else {
                                                        Toast.makeText(ThemSPActivity.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                                                    }
                                                }


                                                @Override
                                                public void onFailure(Call<String> call, Throwable t) {

                                                }
                                            });
                                        }
                                    }
                                }


                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    Log.d("aaa", t.getMessage());
                                }
                            });
                        }
                    } else {
                        Toast.makeText(ThemSPActivity.this, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    }



            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==Request_Code_Image && resultCode==RESULT_OK && data!=null){
            Uri uri= data.getData();
            realPath=getRealPathFromURI(uri);
            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                imgHinhsp.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }

    private void Anhxa() {
        edtTensp = (EditText) findViewById(R.id.txttensp);
        edtGiasp=(EditText) findViewById(R.id.txtgiasp);
        edtMotasp=(EditText) findViewById(R.id.txtmotasp);
        btnThem=(Button) findViewById(R.id.btnThem);
        imgHinhsp=(ImageView) findViewById(R.id.imgsanpham);
        spinner=(Spinner) findViewById(R.id.spinner);
        toolbarThem=(Toolbar) findViewById(R.id.toolbarThem);
    }
    private void CatchEventSpinner() {
        Integer[] soluong= new Integer[]{1,2};
        ArrayAdapter<Integer> arrayAdapter= new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }
    private void ActionToolBar() {
        setSupportActionBar(toolbarThem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarThem.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

