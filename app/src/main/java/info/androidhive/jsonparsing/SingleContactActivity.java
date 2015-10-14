package info.androidhive.jsonparsing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import info.androidhive.jsonparsing.R;

public class SingleContactActivity  extends Activity {

    //variable
    String name ;
    String email ;
    String mobile ;


    Button btnCalltoDonar,btnSmstoDonar,btnSMStoPateient;
	
	// JSON node keys
	private static final String TAG_NAME = "name";
	private static final String TAG_EMAIL = "email";
	private static final String TAG_PHONE_MOBILE = "height";// phone and height has interchange .so use height for mobile and phone for height
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact);
        btnCalltoDonar= (Button) findViewById(R.id.buttonCallFromSingleContacActivtivity);
        btnSmstoDonar= (Button) findViewById(R.id.buttonSMSFromSingleContactActivity);
        btnSMStoPateient= (Button) findViewById(R.id.buttonSMStoPaient);

        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
         name = in.getStringExtra(TAG_NAME);
         email = in.getStringExtra(TAG_EMAIL);
         mobile = in.getStringExtra(TAG_PHONE_MOBILE);
        
        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.textViewName);
        TextView lblEmail = (TextView) findViewById(R.id.textViewEmail);
        TextView lblMobile = (TextView) findViewById(R.id.textViewPhone);
        
        lblName.setText(name);
        lblEmail.setText(email);
        lblMobile.setText(mobile);
    }

    public void CallToDonar(View view){
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mobile));
        //callIntent.setData(Uri.parse("tel:" + mobile));
        startActivity(callIntent);



    }
    public void SMStoDonar(View view){
        Uri uri = Uri.parse("smsto:" + mobile);

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);

        smsIntent.putExtra("sms_body", "Donar  phone no :");

        startActivity(smsIntent);

    }

    public void smstopatient(View view){
        Uri uri = Uri.parse("smsto:" + "");

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);

        smsIntent.putExtra("sms_body", "Name:  "+name+" \n"+"Email:  " +email +"\n "+"Phone No: "+mobile);

        startActivity(smsIntent);


    }


}
