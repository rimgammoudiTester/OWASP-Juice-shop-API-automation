package owaspJuiceShop.pojoClasses.userRegisterPojo;

import java.util.HashMap;

public class UserRegisterPojo {

    //Properties of userPojo

    private String userEmail;
    private String userPassword;
    private String userRepeatPassword;
    private HashMap<String,Object> userSequrityQuestion;
    private String userAnswer;

    public UserRegisterPojo(HashMap<String, Object> mapOfUserRegistration) {

        userSequrityQuestion=new HashMap<>();
        this.userEmail = mapOfUserRegistration.get("email").toString();
        this.userPassword = mapOfUserRegistration.get("password").toString();
        this.userRepeatPassword = mapOfUserRegistration.get("passwordRepeat").toString();
        this.userAnswer = mapOfUserRegistration.get("securityAnswer").toString();
        // userSequrityQuestion.put("question",mapOfUserRegistration.get("securityQuestion.question").toString());
        userSequrityQuestion.put("createdAt",mapOfUserRegistration.get("securityQuestion.createdAt"));
        userSequrityQuestion.put("id",mapOfUserRegistration.get("securityQuestion.id").toString());
        userSequrityQuestion.put("question",mapOfUserRegistration.get("securityQuestion.question").toString());
        userSequrityQuestion.put("updatedAt",mapOfUserRegistration.get("securityQuestion.updatedAt"));
    }

    //getters of registration pojo

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserRepeatPassword() {
        return userRepeatPassword;
    }

    public String getUserSequrity() {
        return userSequrityQuestion.get("question").toString();
    }

    public String getUserAnswer() {
        return userAnswer;
    }


    //Setters of registration pojo


    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public void setUserRepeatPassword(String userRepeatPassword) {
        this.userRepeatPassword = userRepeatPassword;
    }

    public void setUserSequrity(String sequrityQuestion) {
        userSequrityQuestion.put("question",sequrityQuestion);
    }

    public void setUserAnswer(String answerOfQuestion) {
        this.userAnswer = answerOfQuestion;
    }


}



