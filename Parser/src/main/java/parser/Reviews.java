package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Reviews {

    public static void reviews(int num, String url) throws IOException {
        ArrayList<String[]> sentiments = new ArrayList<String[]>();

        for (int i = 0; i < num + 1; i++) {
            String page = url + "page=" + i + "/";
            Document html_doc = Jsoup.connect(page).get();

            Elements reviews = html_doc.select("article.pp-review-i");
            ArrayList<String[]> sentiment = new ArrayList<String[]>();

            for (Element review : reviews) {
                Elements star = review.select("span.g-rating-stars-i");
                Elements text = review.select("div.pp-review-text");
                if (star.size() > 0) {
                    Elements texts = text.select("div.pp-review-text-i");
                    sentiment.add(new String[]{star.first().attr("content"), texts.first().text()});
                }
            }
            sentiments.addAll(sentiment);
            CSVwriter.csvWrite(sentiments, url);
            if (sentiments.size()> Main.max) {
                Main.max = sentiments.size();
                Main.popular = url;
            }
        }
    }
}
