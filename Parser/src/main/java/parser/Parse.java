package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Parse {
    public static int parsePage (String url) throws IOException {

        Document html_doc = Jsoup.connect(url).get();
        Elements nums = html_doc.select("a.paginator-catalog-l-link");

        int num = 0;
        if (nums.size()!= 0) {
            num = Integer.parseInt(nums.last().text());

        }
        return num;

    }
}
