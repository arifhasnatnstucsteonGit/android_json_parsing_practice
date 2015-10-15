package info.androidhive.jsonparsing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Arif on 15/10/2015.
 */
public class UserPanel extends Activity {
    TextView viewProfile,name;
    Button donarList,nearbyHospital,allBloodBankList;
    Registration_userLocationStore userLocationStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_panel);
        name= (TextView) findViewById(R.id.textViewNameFromUserpanelPage);
        userLocationStore=new Registration_userLocationStore(this);


    }
    public void ViewYourProfileOnClick(View view){

    }
    public void AllBloodBankInfoOnClick(View view){

    }
    public void NearbyHospitalOnClick(View view){

    }
    public void DonarListOnClick(View view){

    }

    public void logoutOnClick(View view){
        userLocationStore.clearUserloggedIn();
        userLocationStore.setUserloggedIn(false);

        Intent intent=new Intent(getApplication(),LogIn2.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(authenticate()==true){
            DisplaysuserDetails();

        }else{
            Intent intent=new Intent(getApplicationContext(),LogIn2.class);
            startActivity(intent);
        }
    }

    public boolean authenticate(){
        return userLocationStore.getuserLoggedIn();
    }
    private void DisplaysuserDetails(){
        Register_model register_model=userLocationStore.getLoggedInUser();
        name.setText(register_model.name);


    }
}
