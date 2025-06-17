package utils;

import java.util.HashMap;
import java.util.Map;

public class Headers
{
    public static Map<String, String> getHesders(String headers)
    {
        Map<String, String> headersApi = new HashMap<>();
        if(headers.equals("conversorDivisas")) {
            headersApi.put("Content-type", "application/json; charset=UTF-8");
            headersApi.put("market", "AR");
            headersApi.put("Origin", "https://www.skyairline.com");
            headersApi.put("Referer", "https://www.skyairline.com/");
            headersApi.put("_token", "99999999989999999");
            return headersApi;
        }else if(headers.equals("registroUsers_head"))
        {
            headersApi.put("Content-type", "application/json");
        }

        return null;
    }
}
