import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.util.Scanner;
public class CurrencyConverter{
    public static double getExchangeRate(String base, String target){
        try{
            String urlStr = "https://api.exchangerate-api.com/v4/latest/USD" ;
            URI uri = new URI(urlStr);
            URL url = uri.toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response =  new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            String data = response.toString();
            String search = "\"" + target + "\":" ;
            int index = data.indexOf(search);
            if(index == -1) return -1;
            int start = index + search.length();
            int end = start;
            while (end < data.length()  && (Character.isDigit(data.charAt(end)) || data.charAt(end) == '.')) {
                end++;
            }     
            return Double.parseDouble(data.substring(start,end));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error fetching exchange rate");
            return -1;        
        }
    }
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("------Currency Converter------");
    System.out.println("enter base currency");
    String base = sc.next().toUpperCase();
    System.out.println("enter target currency");
    String target = sc.next().toUpperCase();
    System.out.print("enter amount");
    double amount = sc.nextDouble();
    double rate = getExchangeRate(base,target);
    if(rate == -1){
        System.out.println("conversion failed");
        return;
    }
    double converted = amount *rate;
    System.out.println("\n------Result-------");
    System.out.println(amount + " " + base + "=" + converted
+ " " + target);
sc.close();
} 
} 
