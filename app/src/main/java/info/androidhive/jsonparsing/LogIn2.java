package info.androidhive.jsonparsing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Arif on 15/10/2015.
 */
public class LogIn2 extends Activity {
    EditText name,password;
    Button login;
    String nameStr,passwordStr;
    Registration_userLocationStore userLocationStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);
        name= (EditText) findViewById(R.id.editTextNameFormRegisterPage);
        password= (EditText) findViewById(R.id.editTextpasswordFromLoginPage);
        userLocationStore=new Registration_userLocationStore(this);




    }

    public void logintoPanel(View view){
        nameStr=name.getText().toString();
        passwordStr=password.getText().toString();


        Register_model register_model=new Register_model(null,null);
        userLocationStore.storeRegistrationModelData(register_model);
        userLocationStore.setUserloggedIn(true);



    }

    public void registrationClickFromLoginpage(View view){
        Intent intent=new Intent(getApplicationContext(),Registration_page.class);
        startActivity(intent);


    }
}
