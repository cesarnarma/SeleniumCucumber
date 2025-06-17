package utils;

public class ContantesAPI {

    public static final String URL_CONVERSOR_DIVISAS = "https://jsonplaceholder.typicode.com/comments";
    public static final String URL_CONVERSOR_DIVISAS_BAD = "https://jsonplaceholder.typicode.com/comments2";
    public static final String URL_REQRES_REGISTRO_USER = "https://reqres.in/api/users";
    public static final String URL_REQRES_REGISTRO_USER_404 = "https://reqres.in/api2/usersbad";
    public static final String URL_REQRES_LOGIN_USER = "https://reqres.in/api/register";

    public static String getURL(String url)
    {
        if(url.equals("conversorDeDivisas"))
        {
            return URL_CONVERSOR_DIVISAS;
        }else if(url.equals("conversorDeDivisas2"))
        {
            return URL_CONVERSOR_DIVISAS_BAD;
        }else if(url.equals("registroUsuario"))
        {
            return URL_REQRES_REGISTRO_USER;
        }
        else if(url.equals("registroUsuario_bad"))
        {
            return URL_REQRES_REGISTRO_USER_404;
        }
        else if(url.equals("loginUser")) {
            return URL_REQRES_LOGIN_USER;
        }

        return null;
    }


}
