public class Registro {

    public boolean valida(String username, String password, String confirmPassword){
        if(username.isEmpty() || password.isEmpty()){
            return false;
        }
        if(username.contains("#")){
            return false;
        }
        if(password != confirmPassword){
            return false;
        }
        if(password.length() < 8){
            return false;
        }
        return true;
    }
}
