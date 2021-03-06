package school.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PublicHolidayService {

    private static final String COUNTRY_CODE = "EE";
    private static final String API_URL = "https://date.nager.at/api/v2/PublicHolidays";

    private String baseUrl;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PublicHolidayService() {
        this.baseUrl = API_URL;
    }

    public PublicHolidayService(String url) {
        this.baseUrl = url;
    }

    public List<ZonedDateTime> getPublicHolidays(int year) throws IOException, JSONException {
        return getPublicHolidays(year, baseUrl);
    }

    public List<ZonedDateTime> getPublicHolidays(int year, String apiURL) throws IOException, JSONException {
        List<ZonedDateTime> result = new ArrayList<>();
        String composedUrl = apiURL + "/" + year + "/" + COUNTRY_CODE;

        URL url = new URL(composedUrl);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        String dateString;

        while ((inputLine = in.readLine()) != null) {

            JSONArray jsonArray = new JSONArray(inputLine);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dateString = jsonObject.getString("date");
                LocalDate date = LocalDate.parse(dateString, formatter);
                ZonedDateTime zonedResult = date.atStartOfDay(ZoneId.of("UTC"));

                result.add(zonedResult);

            }
        }
        in.close();

        return result;

    }
}