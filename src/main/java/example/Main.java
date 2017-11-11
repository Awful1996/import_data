package example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;


public class Main {

    private static int startPage = 6744;
    private static int endPage = 30178;

    public static void main(String[] args) throws IOException {

        for(int i = 20879; i<= endPage ;i++) {
            Date date = new Date();
            System.out.println(i + " - " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
            String theURL = "http://gpk.gov.by/maps/arkhiv-ocheredey.php?ochered_id=" + i;
            StringBuilder pageContent = new StringBuilder();
            URL url = new URL(theURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream(), "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                pageContent.append(str).append("\r\n");
            }
            in.close();
            //System.out.println(pageContent);
            Path path = Paths.get("archive/" + i + ".html");
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(pageContent.toString());
            }
        }
    }
}
