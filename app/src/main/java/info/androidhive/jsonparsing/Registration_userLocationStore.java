package info.androidhive.jsonparsing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by Arif on 15/10/2015.
 */
public class Registration_userLocationStore{
    public static final String sp_name="userDetails";
    SharedPreferences userLocalDatabase;

    public Registration_userLocationStore(Context context) {
        userLocalDatabase=context.getSharedPreferences(sp_name,0);
    }
    public void storeRegistrationModelData(Register_model register_model){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();

        spEditor.putString("name",register_model.name);
        spEditor.putString("phone",register_model.phone);
        spEditor.putString("email",register_model.email);
        spEditor.putString("age",register_model.age);
        spEditor.putString("weight",register_model.weight);
        spEditor.putString("height",register_model.height);
        spEditor.putString("district",register_model.district);
        spEditor.putString("upzilla",register_model.upzilla);
        spEditor.putString("password",register_model.password);
        spEditor.commit();


    }
    public Register_model getLoggedInUser(){

        String name =userLocalDatabase.getString("name", "");
        String phone=userLocalDatabase.getString("phone", "");
        String email=userLocalDatabase.getString("email", "");
        String age=userLocalDatabase.getString("age", "");
        String weight=userLocalDatabase.getString("weight", "");
        String height=userLocalDatabase.getString("height", "");
        String district=userLocalDatabase.getString("district", "");
        String upzilla=userLocalDatabase.getString("upzilla", "");
        String password=userLocalDatabase.getString("password", "");

        Register_model register_model=new  Register_model(name, password,upzilla, district,height, weight, age, email, phone);


        return register_model;
    }
    public boolean getuserLoggedIn(){
        if(userLocalDatabase.getBoolean("loggedIn",false)==true){
            return true;

        }else{
            return false;

        }


    }
    public void setUserloggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();


    }
    public void clearUserloggedIn(){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();


    }
}
