package com.example.acer.cuahangdienthoai.RetrofitLoginAdmin;

public class ResenterLogin implements PresenterLoginIm {
    ViewImLogin viewImLogin;

    public ResenterLogin(ViewImLogin viewImLogin) {
        this.viewImLogin = viewImLogin;
    }

    @Override
    public void CheckLogin(String Username, String PassWord) {
        if(Username.equals("admin")&&PassWord.equals("123"))
        {
            viewImLogin.LoginSuccess();
        }
        else
        {
            viewImLogin.LoginFail();
        }
    }
}
