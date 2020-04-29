package school.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PublicHolidayService {

    private static final String COUNTRY_CODE = "EE";
    private static final String API_URL = "https://date.nager.at/api/v2/PublicHolidays/";


    public List<ZonedDateTime> getPublicHolidays(int year) {
        List<ZonedDateTime> result = new ArrayList<>();
        String composedUrl = API_URL + year + "/" + COUNTRY_CODE;
        int holidays = 0;

        try {
            URL url = new URL(composedUrl);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;

            if ((inputLine = in.readLine()) != null) {
                //Gson gson = new Gson();
                //Type listType = new TypeToken<List<HashMap>>() {}.getType();
                List<HashMap> itemList = new Gson().fromJson(inputLine, new TypeToken<List<HashMap>>() {
                }.getType());

                for (HashMap value : itemList) {

                    result.add(school.util.Utils.dateToTypeZoneDateTime(value.get("date").toString()));

                }
                //if (itemList.get(0).get("date").toString().equals())
                //System.out.println(School.Util.Utils.dateToTypeZoneDateTime(itemList.get(1).get("date").toString()).equals(School.Util.Utils.dateToTypeZoneDateTime("2020-02-24")));
            }
            in.close();
        } catch (Exception ex) {
            // alas
        }
        return result;
    }
}