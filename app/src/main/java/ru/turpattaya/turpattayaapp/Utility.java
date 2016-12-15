package ru.turpattaya.turpattayaapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    // выдергиваем курс доллара из HTML кода сгенерированного с помощью Build
    private static final String regexpRuble ="Russian Ruble\\s*</td><td class=\"D3\">(\\d+\\.\\d+)\\s*</td><td class=\"D4\">-</td><td class=\"D4\">-</td><td class=\"D4\">-</td><td class=\"D4\">-</td><td class=\"D5\">(\\d+\\.\\d+)";
    private static final String regexpUSD1 = "USD : 1\\s*</td><td class=\"D3\">(\\d+\\.\\d+).*?\"D5\">(\\d+\\.\\d+)";
    /*private static final String regexpUSD5_20 ="USD : 5-20</td><td class=\"D3\">(\\d+\\.\\d+)</td><td class=\"D4\">35.37</td><td class=\"D4\">35.37</td><td class=\"D4\">35.47</td><td class=\"D4\">35.77</td><td class=\"D5\">(\\d+\\.\\d+)";
    private static final String regexpUSSD50_100 ="USD : 50-100</td><td class=\"D3\">(\\d+\\.\\d+)</td><td class=\"D4\">35.37</td><td class=\"D4\">35.37</td><td class=\"D4\">35.47</td><td class=\"D4\">35.77</td><td class=\"D5\">(\\d+\\.\\d+)";
    private static final String regexpEURO ="Euro</td><td class=\"D3\">(\\d+\\.\\d+)</td><td class=\"D4\">37.33041</td><td class=\"D4\">37.33041</td><td class=\"D4\">37.41625</td><td class=\"D4\">38.1925</td><td class=\"D5\">(\\d+\\.\\d+)";*/


    private static final Pattern patternRuble = Pattern.compile(regexpRuble);
    private static final Pattern patternUSD1 = Pattern.compile(regexpUSD1);
/*    private static final Pattern patternUSD5_20 = Pattern.compile(regexpUSD5_20);
    private static final Pattern patternUSD50_100 = Pattern.compile(regexpUSSD50_100);
    private static final Pattern patternEURO = Pattern.compile(regexpEURO);*/

    public static void main(String[] args) {
        String kassikorn = getPage("http://www.kasikornbank.com/EN/RatesAndFees/ForeignExchange/Pages/ForeignExchange.aspx");
        System.out.println(getRuble(kassikorn));
        System.out.println(getUsd1(kassikorn));
    }


    // метод который будет обрабатывать страницу
    public static String getPage(String pageUrl) {
        StringBuffer buffer = new StringBuffer();

        try {
            URL url = new URL(pageUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); //считываем инфу из inputStream

            //теперь будем считывать построчно в BufferedReader
            String line = "";   //строка , которая будет считывать
            try {
                while((line = bufferedReader.readLine()) !=null) {
                    buffer.append(line);
                }
            }
            finally  {
                try {
                    bufferedReader.close();
                    inputStream.close();
                } catch (IOException e) {e.printStackTrace();}
            }
        }
        catch (Exception e) {e.printStackTrace();}
        return buffer.toString();
    }

    private static String getRuble(String text) {
        String resultRubBy = "";
        String resultRubSell = "";
        Matcher matcherRuble = patternRuble.matcher(text);

        if (matcherRuble.find()) {
            resultRubBy = matcherRuble.group(1);
            resultRubSell = matcherRuble.group(2);
        }
        return "By Rub  " + resultRubBy+ "    Sell Rub  " + resultRubSell;
    }

    private static String getUsd1(String text) {
        String resultUSD1By = "";
        String resultUSD1Sell = "";
        Matcher matcherUSD1 = patternUSD1.matcher(text);

        if (matcherUSD1.find()) {
            resultUSD1By = matcherUSD1.group(1);
            resultUSD1Sell = matcherUSD1.group(2);
        }
        return "By USD1  " + resultUSD1By+ "    Sell USD1 " + resultUSD1Sell;
    }
}
