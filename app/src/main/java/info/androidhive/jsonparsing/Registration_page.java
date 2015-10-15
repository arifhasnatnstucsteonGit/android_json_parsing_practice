package info.androidhive.jsonparsing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Arif on 14/10/2015.
 */
public class Registration_page extends Activity {

    EditText name,phone,email,age,weight,height,district,upzilla,password,repassword;
    String nameStr,phoneStr,emailStr,ageStr,weightStr,heightStr,districtStr,upzillaStr,passwordStr,repasswordStr;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        name= (EditText) findViewById(R.id.editTextNameFormRegisterPage);
        phone= (EditText) findViewById(R.id.editTextPhoneFormRegisterPage);
        email= (EditText) findViewById(R.id.editTextUsernameFromLoginPage);
        age= (EditText) findViewById(R.id.editTextAgeFormRegisterPage);
        weight= (EditText) findViewById(R.id.editTextWeightFormRegisterPage);
        height= (EditText) findViewById(R.id.editTextheightFormRegisterPage);
        district= (EditText) findViewById(R.id.editTextDistrictFormRegisterPage);
        upzilla= (EditText) findViewById(R.id.editTextUpzillaFormRegisterPage);
        password= (EditText) findViewById(R.id.editTextpasswordFromLoginPage);
        repassword= (EditText) findViewById(R.id.editTextRePasswordFormRegisterPage);


    }



    public void RegistrationClick(View view){

        nameStr=name.getText().toString();
        phoneStr=phone.getText().toString();
        emailStr=email.getText().toString();
        ageStr=age.getText().toString();
        weightStr=weight.getText().toString();
        heightStr=height.getText().toString();
        districtStr=district.getText().toString();
        upzillaStr=upzilla.getText().toString();
        passwordStr=password.getText().toString();
        repasswordStr=repassword.getText().toString();

        if(passwordStr.equals(repasswordStr)){

            Toast.makeText(getBaseContext(),"test",Toast.LENGTH_LONG).show();

            Register_model register_model=new  Register_model(nameStr, passwordStr,upzillaStr, districtStr,heightStr, weightStr, ageStr, emailStr, phoneStr);




        }


    }
}

