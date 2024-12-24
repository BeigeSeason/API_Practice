package com.ApiEx.PracticeAPI.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Repository
public class BusAPI {

    private static final String SERVICE_KEY = "xHrCgirwASJUWFmySSD%2BsVfTrKfl5GVafcWvBdP0QzXyoINEyiwTtItWDtU8OoqycVB%2F0lblx0C4DqwWzvhiXQ%3D%3D";
    private static final String SERVICE_URL = "http://apis.data.go.kr/1613000/ExpBusInfoService/getStrtpntAlocFndExpbusInfo" +
            "?" + URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) + "=" + SERVICE_KEY;

    public void startEndInfo() throws IOException { // 반드시 입력
        String urlBuilder = "http://apis.data.go.kr/1613000/ExpBusInfoService/getStrtpntAlocFndExpbusInfo" +
                "?" + URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) + "=" + SERVICE_KEY +
                "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + "1" +
                "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + "10" +
                "&" + URLEncoder.encode("_type", StandardCharsets.UTF_8) + "=" + "json" +
                "&" + URLEncoder.encode("depTerminalId", StandardCharsets.UTF_8) + "=" + "NAEK010" +
                "&" + URLEncoder.encode("arrTerminalId", StandardCharsets.UTF_8) + "=" + "NAEK300" +
                "&" + URLEncoder.encode("depPlandTime", StandardCharsets.UTF_8) + "=" + "20230401";

        URL url = new URL(urlBuilder);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        log.warn(sb.toString());
    }

    public void terminalList() throws IOException { // 반드시 입력
        String urlBuilder = "http://apis.data.go.kr/1613000/ExpBusInfoService/getExpBusTrminlList" +
                "?" + URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) + "=" + SERVICE_KEY;
//        +
//                "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + "1" +
//                "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + "10" +
//                "&" + URLEncoder.encode("_type", StandardCharsets.UTF_8) + "=" + "json" +
//                "&" + URLEncoder.encode("terminalNm", StandardCharsets.UTF_8) + "=" + "센트럴";

        URL url = new URL(urlBuilder);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        log.warn(sb.toString());
    }
}