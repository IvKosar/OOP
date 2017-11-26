package parser;

import java.io.File;
import java.io.IOException;

public class Main {protected static Integer max = 0;
    protected static String popular;

    public static void main (String[] args) throws IOException {
        String myUrl = "https://rozetka.com.ua/ua/gps-navigators/c80047/";
        File data = new File("data");
        if(!data.exists()) {
            data.mkdir();
        }
        Page.page(Parse.parsePage(myUrl), myUrl);
        System.out.println("THE MOST POPULAR PRODUCT IS: " + popular);

    }
}
