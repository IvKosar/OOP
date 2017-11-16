import com.opencsv.CSVWriter;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    static String myUrl = "https://rozetka.com.ua/ua/rozetki-i-vykluchateli/c3803575/";

    public static void main (String[] args) throws IOException {
        String myUrl = "https://rozetka.com.ua/ua/rozetki-i-vykluchateli/c3803575/";
        parseCategory(myUrl);
    }
    public static void parseCategory (String url) throws IOException {
        File data = new File("data");
        if(!data.exists()) {
            data.mkdir();
        }
        Document html_doc = Jsoup.connect(myUrl).get();
        Elements nums = html_doc.select("a.paginator-catalog-l-link");
        Integer num = 0;
        if (nums.size()!= 0) {
            num = Integer.parseInt(nums.last().text());
        }
        for (int numPage=0; numPage<num; numPage++) {
            String page = url + "page=" + numPage + "/";
            parseCategoryPage(page);
        }
    }
    public static void parseCategoryPage(String url) throws IOException {
        Document html_doc = Jsoup.connect(myUrl).get();
        Elements tiles = html_doc.select("div.paginator-catalog-l-link");
        for (Element tile : tiles) {
            Elements links = tile.select("a.div.paginator-catalog-l-link");
            String link = links.attr("href") + "comments/";
            parseReviews(link);
        }
    }

    public static void parseReviews(String url) throws IOException {
        Document html_doc = Jsoup.connect(myUrl).get();
        Elements nums = html_doc.select("a.paginator-catalog-l-link");
        Integer num = 0;
        if (nums.size()!= 0) {
            num = Integer.parseInt(nums.last().text());
        }

        ArrayList<String[]> sentiments;
        sentiments = new ArrayList<String[]>();
        for (int i=0; i<num; i++) {
            String page = url + "page=" + i + "/";
            sentiments.addAll(parseReviewsPage(page));
        }
        String filename = "data/" + myUrl.split("/")[4] + ".csv";
        FileWriter writer = new FileWriter(filename);
        CSVWriter csvwriter = new CSVWriter(writer, ',');
        for (String[] sentiment : sentiments) {
            csvwriter.writeNext(sentiment);
        }
        csvwriter.close();

        System.out.println(sentiments.size() + "reviews from " + url);
    }

    public static ArrayList<String[]> parseReviewsPage(String url) throws IOException {
        Document html_doc = Jsoup.connect(myUrl).get();
        Elements reviews = html_doc.select("article.pp-review-stars-i");
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
