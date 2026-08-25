package owaspJuiceShop.pojoClasses.loginPojo;

import java.util.HashMap;

public class LoginPojo {


    //Properties of loginPojo

    private String email;
    private String password;


    public LoginPojo(HashMap<String, Object> mapOfLogin) {

        this.email = mapOfLogin.get("email").toString();
        this.password = mapOfLogin.get("password").toString();
    }

    //getters of loginPojo

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //Setters of loginPojo


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
