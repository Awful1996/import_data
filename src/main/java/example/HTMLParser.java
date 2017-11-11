package example;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java Program to parse/read HTML documents from File using Jsoup library.
 * Jsoup is an open source library which allows Java developer to parse HTML
 * files and extract elements, manipulate data, change style using DOM, CSS and
 * JQuery like method.
 *
 * @author Javin Paul
 */
public class HTMLParser{

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/labs";
    private static final String user = "root";
    private static final String password = "password";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    private static int startPage = 6744;
    private static int endPage = 30178;

    public static void init(){
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveQuery(String query){
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
    }


    public static void main(String args[]) {
        init();

        String fileNameCorrect = "archive/6744.html";
        Document htmlFile = null;

        for(int i = startPage; i<= endPage ; i++) {
            System.out.println(i);
            try {
                htmlFile = Jsoup.parse(new File("archive/" + i + ".html"), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } // right

            Elements elements = htmlFile.getElementsByClass("info");
            if (elements.last() == null) {
                continue;
            }
            String dateFromPage = elements.last().getElementsByTag("strong").text();
            System.out.println(dateFromPage);
            Elements elements2 = htmlFile.getElementsByAttribute("title");

            SimpleDateFormat dateFormat1 = null;
            SimpleDateFormat dateFormat2 = null;

            dateFormat1 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            dateFormat2 = new SimpleDateFormat("dd.MM.yyyy HH.mm");
            SimpleDateFormat dateMySQLFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
            Date date = null;
            try {
                date = dateFormat1.parse(dateFromPage);
                //System.out.println("Constructor 1: " + date);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                try {
                    date = dateFormat2.parse(dateFromPage);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
            String dateMysql = "";
            if (date != null) {
                dateMysql = dateMySQLFormat.format(date);
                //System.out.println(dateMysql);
            }
            //System.out.println("class of div tag : " + cssClass);
            String tmp = "";
            tmp = elements2.get(1).text();
            String value = tmp.equals("–") ? null : tmp;
            String query1 = "insert into number_of_cars(checkpoint_id,type,number,date) values (7,1," + value + ",\"" + dateMysql + "\") ";
            saveQuery(query1);
            tmp = elements2.get(2).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (7,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(3).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (7,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(4).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (8,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(5).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (8,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(6).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (8,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(7).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (9,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(8).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (9,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(9).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (9,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(10).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (10,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(11).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (10,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(12).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (10,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(13).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (11,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(14).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (11,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(15).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (11,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(16).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (12,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(17).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (12,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(18).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (12,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(19).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (13,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(20).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (13,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(21).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (13,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(22).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (1,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(23).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (1,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(24).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (1,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(25).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (2,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(26).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (2,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(27).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (2,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(28).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (3,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(29).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (3,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(30).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (3,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(31).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (4,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(32).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (4,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(33).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (4,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(34).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (5,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(35).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (5,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(36).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (5,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(37).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (6,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(38).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (6,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(39).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (6,3," + value + ",\"" + dateMysql + "\") ");

            value = elements2.get(40).text().equals("–") ? null : elements2.get(40).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (14,1," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(41).text().equals("–") ? null : elements2.get(41).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (14,2," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(42).text().equals("–") ? null : elements2.get(42).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (14,3," + value + ",\"" + dateMysql + "\") ");

            value = elements2.get(43).text().equals("–") ? null : elements2.get(43).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (15,1," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(44).text().equals("–") ? null : elements2.get(44).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (15,2," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(45).text().equals("–") ? null : elements2.get(45).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (15,3," + value + ",\"" + dateMysql + "\") ");

            value = elements2.get(46).text().equals("–") ? null : elements2.get(46).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (16,1," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(47).text().equals("–") ? null : elements2.get(47).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (16,2," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(48).text().equals("–") ? null : elements2.get(48).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (16,3," + value + ",\"" + dateMysql + "\") ");

            value = elements2.get(49).text().equals("–") ? null : elements2.get(49).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (17,1," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(50).text().equals("–") ? null : elements2.get(50).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (17,2," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(51).text().equals("–") ? null : elements2.get(51).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (17,3," + value + ",\"" + dateMysql + "\") ");

            value = elements2.get(52).text().equals("–") ? null : elements2.get(52).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (18,1," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(53).text().equals("–") ? null : elements2.get(53).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (18,2," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(54).text().equals("–") ? null : elements2.get(54).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (18,3," + value + ",\"" + dateMysql + "\") ");

            value = elements2.get(55).text().equals("–") ? null : elements2.get(55).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (19,1," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(56).text().equals("–") ? null : elements2.get(56).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (19,2," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(57).text().equals("–") ? null : elements2.get(57).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (19,3," + value + ",\"" + dateMysql + "\") ");

            value = elements2.get(58).text().equals("–") ? null : elements2.get(58).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (20,1," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(59).text().equals("–") ? null : elements2.get(59).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (20,2," + value + ",\"" + dateMysql + "\") ");
            value = elements2.get(60).text().equals("–") ? null : elements2.get(60).text();
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (20,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(61).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (21,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(62).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (21,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(63).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (21,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(64).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (22,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(65).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (22,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(66).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (22,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(67).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (23,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(68).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (23,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(69).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (23,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(70).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (24,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(71).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (24,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(72).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (24,3," + value + ",\"" + dateMysql + "\") ");

            tmp = elements2.get(73).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (25,1," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(74).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (25,2," + value + ",\"" + dateMysql + "\") ");
            tmp = elements2.get(75).text();
            value = tmp.equals("–") ? null : tmp;
            saveQuery("insert into number_of_cars(checkpoint_id,type,number,date) values (25,3," + value + ",\"" + dateMysql + "\") ");

        }

        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }

    }
}
