package info.androidhive.jsonparsing;

/**
 * Created by Arif on 14/10/2015.
 */
public class Register_model {

    String name,phone,email,age,weight,height,district,upzilla,password;

    public Register_model(String name, String password, String upzilla, String district, String height, String weight, String age, String email, String phone) {
        this.name = name;
        this.password = password;
        this.upzilla = upzilla;
        this.district = district;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public Register_model(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
