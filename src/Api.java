import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Api {
    public JSONObject DataJSON() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
        String strDate = formatter.format(date);
        try {
            URL u = new URL("https://api.banghasan.com/sholat/format/json/jadwal/kota/667/tanggal/" + strDate);
            HttpURLConnection hr = (HttpURLConnection) u.openConnection();
            if (hr.getResponseCode() == 200) {
                InputStream im = hr.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(im));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JSONParser jp = new JSONParser();
                Object object = jp.parse(response.toString());
                JSONObject jso = (JSONObject) object;
                JSONObject jadwal = (JSONObject) jso.get("jadwal");
                JSONObject data = (JSONObject) jadwal.get("data");
                return data;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }
}
