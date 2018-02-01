import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dao.bill.BillDao;
import dao.loan.LoanDao;
import models.Bill;
import models.CurrentWeather;
import models.Loan;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.net.URL;
import java.util.List;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static spark.Spark.*;

public class Main {

//
//    public static void main(String[] args) {
//        get("/hello", (req, res) -> "Hello World");
//    }


//    public static void main(String[] argv) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("Spring-Module.xml");
//
//        LoanDao loanDao= (LoanDao) context.getBean("loanDao");
//        BillDao billDao = (BillDao) context.getBean("billDao");
//
//        List<Loan> loans = loanDao.selectAll();
//        List<Bill> bills = billDao.selectAll();
//
//        for (Loan l : loans) {
//            System.out.println(l.getMonthlyPayment());
//        }
//
//        for (Bill l : bills) {
//            System.out.println(l.getAmount());
//        }
//
//    }
    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {
        try {
            CurrentWeather weather = sendGet();
            System.out.println("Temperature: " + weather.getMain().getTemp());
            System.out.println("Humidity: " + weather.getMain().getHumidity());
            System.out.println(StringUtils.capitalize(weather.getWeather()[0].getDescription()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // HTTP GET request
    private static CurrentWeather sendGet() throws Exception {
//
//        String url = "http://api.openweathermap.org/data/2.5/weather?zip=30345&units=imperial&appid=" + api_key;
//
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        // optional default is GET
//        con.setRequestMethod("GET");
//
//        //add request header
//        con.setRequestProperty("User-Agent", USER_AGENT);
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());

        String json = "{\"coord\":{\"lon\":-84.29,\"lat\":33.85},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"stations\",\"main\":{\"temp\":280.25,\"pressure\":1026,\"humidity\":30,\"temp_min\":279.15,\"temp_max\":281.15},\"visibility\":16093,\"wind\":{\"speed\":3.1,\"deg\":330},\"clouds\":{\"all\":1},\"dt\":1517345760,\"sys\":{\"type\":1,\"id\":790,\"message\":0.0047,\"country\":\"US\",\"sunrise\":1517315678,\"sunset\":1517353618},\"id\":0,\"name\":\"Atlanta\",\"cod\":200}\n";

        ObjectMapper om = new ObjectMapper();
        CurrentWeather weather = om.readValue(json, CurrentWeather.class);

        return weather;

    }


}