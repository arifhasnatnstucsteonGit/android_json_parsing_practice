package info.androidhive.jsonparsing;



        import java.util.ArrayList;
        import java.util.HashMap;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import android.app.ListActivity;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;

        import android.widget.Button;
        import android.widget.EditText;

        import android.widget.ListView;
        import android.widget.Toast;

public class Loginpage extends ListActivity {
    public boolean flag;

    EditText editText_email,editText_password;
    Button button_login;
    String stringEmail,stringPassword;
    String stringButton;

    private ProgressDialog pDialog;



    // JSON Node names
    private static final String TAG_CONTACTS = "register";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_ADDRESS = "age";
    private static final String TAG_GENDER = "weight";

    private static final String TAG_PHONE_MOBILE = "height";
    private static final String TAG_PHONE_HOME = "district";
    private static final String TAG_PHONE_OFFICE = "upzilla";
    private static final String TAG_PASSWORD = "password";

    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
    // URL to get contacts JSON
    private static String url = "http://bloodbank.3eeweb.com/register%20data.php";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        // login page ui ----------------
        editText_email= (EditText) findViewById(R.id.editTextUsernameFromLoginPage);
        editText_password= (EditText) findViewById(R.id.editTextpasswordFromLoginPage);
        button_login= (Button) findViewById(R.id.buttonLoginFromLoginPage);


        //------------login page ui ---------------
        contactList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();

    }

    public void logintoPanel(View view){
        new GetContacts().execute();


    }




    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Loginpage.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    contacts = jsonObj.getJSONArray(TAG_CONTACTS);

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);
                        String email = c.getString(TAG_EMAIL);
                        String address = c.getString(TAG_ADDRESS);
                        String gender = c.getString(TAG_GENDER);
                        String phone = c.getString(TAG_PHONE);
                        String password = c.getString(TAG_PASSWORD);

/*
						// Phone node is JSON Object
						JSONObject phone = c.getJSONObject(TAG_PHONE);
						String mobile = phone.getString(TAG_PHONE_MOBILE);
						String home = phone.getString(TAG_PHONE_HOME);
						String office = phone.getString(TAG_PHONE_OFFICE);*/

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, id);
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_EMAIL, email);
                        contact.put(TAG_PHONE_MOBILE, phone);
                        contact.put(TAG_PASSWORD, password);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            stringEmail = editText_email.getText().toString();
            stringPassword = editText_password.getText().toString();

            for (int i = 0; i < contactList.size(); i++) {
//                Log.d("Response: ", " > " + credentialList.get(i).toString());
                //if(email.equalsIgnoreCase(credentialList.get(i).get(TAG_EMAIL).toString()) && password.equals(credentialList.get(i).get(TAG_PASSWORD).toString()))
//                if((email.compareTo(credentialList.get(i).get(TAG_EMAIL).toString()) == 0) && (password.compareTo(credentialList.get(i).get(TAG_PASSWORD).toString()) == 0))

                String e = contactList.get(i).get(TAG_EMAIL).toString();
                String p = contactList.get(i).get(TAG_PASSWORD).toString();


                if (stringEmail.equals(e) && stringPassword.equals(p)) {

                    flag = true;
                    break;
                }
            }

            Log.d("Flag", " > " + flag);

            if (flag) {
                Intent in = new Intent(Loginpage.this, MainActivity.class);
                startActivity(in);
            } else {
                Toast.makeText(Loginpage.this, "Email or Passwrod mismatch.", Toast.LENGTH_SHORT).show();
            }
            pDialog.dismiss();


        }
    }

    //end GetContacts class



}