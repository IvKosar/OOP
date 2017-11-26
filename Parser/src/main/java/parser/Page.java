package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Page {
    public static void page(int num, String url) throws IOException{
        for (int numPage=1; numPage<num; numPage++) {
            String page = url + "page=" + numPage + "/";
            Document html_doc = Jsoup.connect(page).get();
            Elements tiles = html_doc.select("div.g-i-tile-i-title");

            for (Element tile : tiles) {
                Elements links = tile.select("a");
                String link = links.attr("href") + "comments/";
                Reviews.reviews(num, link);
            }
        }
    }
}
