import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private static Integer max = 0;
    private static String popular;

    public static void main (String[] args) throws IOException {
        String myUrl = "https://rozetka.com.ua/ua/gps-navigators/c80047/";
        parseCategory(myUrl);
        System.out.println("THE MOST POPULAR PRODUCT IS: " + popular);
    }

    public static void parseCategory (String url) throws IOException {
        File data = new File("data");
        if(!data.exists()) {
            data.mkdir();
        }
        Document html_doc = Jsoup.connect(url).get();
        Elements nums = html_doc.select("a.paginator-catalog-l-link");

        Integer num = 0;
        if (nums.size()!= 0) {
            num = Integer.parseInt(nums.last().text());

        }
        for (int numPage=1; numPage<num; numPage++) {
            String page = url + "page=" + numPage + "/";
            parseCategoryPage(page);
        }
    }
    public static void parseCategoryPage(String url) throws IOException {
        Document html_doc = Jsoup.connect(url).get();
        Elements tiles = html_doc.select("div.g-i-tile-i-title");

        for (Element tile : tiles) {
            Elements links = tile.select("a");
            String link = links.attr("href") + "comments/";
            parseReviews(link);
        }
    }

    public static void parseReviews(String url) throws IOException {
        Document html_doc = Jsoup.connect(url).get();
        Elements nums = html_doc.select("a.paginator-catalog-l-link");
        Integer num = 0;
        if (nums.size()!= 0) {
            num = Integer.parseInt(nums.last().text());
        }

        ArrayList<String[]> sentiments;
        sentiments = new ArrayList<String[]>();

        for (int i=0; i<num+1; i++) {
            String page = url + "page=" + i + "/";
            sentiments.addAll(parseReviewsPage(page));
        }
        if (sentiments.size() != 0) {
            String filename = "data/" + url.split("/")[4] + ".csv";
            FileWriter writer = new FileWriter(filename);
            CSVWriter csvwriter = new CSVWriter(writer, ',');
            for (String[] sentiment : sentiments) {
                csvwriter.writeNext(sentiment);
            }
            csvwriter.close();
        }
        System.out.println(sentiments.size() + " reviews from " + url);

        if (sentiments.size()>max) {
            max = sentiments.size();
            popular = url;
        }
    }

    public static ArrayList<String[]> parseReviewsPage(String url) throws IOException {
        Document html_doc = Jsoup.connect(url).get();
        Elements reviews = html_doc.select("article.pp-review-i");
        ArrayList<String[]> sentiments = new ArrayList<String[]>();

        for (Element review : reviews) {
            Elements star = review.select("span.g-rating-stars-i");
            Elements text = review.select("div.pp-review-text");
            if (star.size() > 0) {
                Elements texts = text.select("div.pp-review-text-i");
                sentiments.add(new String[]{star.first().attr("content"), texts.first().text()});
            }
        }
        return sentiments;
    }
}
