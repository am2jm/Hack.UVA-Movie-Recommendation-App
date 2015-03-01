package com.example.sanjana.hackuvamoviereccomendation;

/**
 * Created by Sanjana on 2/28/15.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageExtractor {

    public String imageURL;

    public ImageExtractor(String url) {
        imageURL = getFirstImage(url);
    }


    private String getFirstImage(String htmlString){

        if(htmlString==null) return null;

        String img ="";
        Document doc = Jsoup.parse(htmlString);
        Elements imgs = doc.getElementsByTag("img");



        for (Element imageElement : imgs) {
            if(imageElement!=null){
                //for each element get the srs url
                img = imageElement.absUrl("src");
                if( !img.contains("doubleclick.net") &&
                        !img.contains("feedburner.com") &&
                        !img.contains("feedsportal.com") &&
                        !img.contains("ads"))

                    return img;
            }
        }

        return null;
    }

    public String getImageURL() {return imageURL;}


}


