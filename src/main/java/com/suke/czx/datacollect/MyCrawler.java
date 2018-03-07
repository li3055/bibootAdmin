package com.suke.czx.datacollect;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.Set;
import java.util.regex.Pattern;

public class MyCrawler extends WebCrawler {

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");

    private String content;

    private MyCrawler myCrawler;

//    public MyCrawler() {
//       myCrawler = new MyCrawler();
//    }

    @Override
    public Object getMyLocalData() {
        return myCrawler;
    }

    /*** This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "http://www.ics.uci.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
     */

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith("http://www.ics.uci.edu/");
    }

    /**
     * This function is called when a page is fetched and ready
     * to be processed by your program.
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();
            int start = text.indexOf("Percentage") + 10;
            int end = text.lastIndexOf("%") + 1;
            String content = text.substring(start, end);
            this.content = content;
            System.err.println("Text length: " + content);
            String[] datas = content.split("%");
            for (String data : datas) {
                System.out.println(data);
                String[] items = data.split(" ");
//                 TokenInfoEntity tokenInfo = new TokenInfoEntity();
////                 tokenInfo.setCollectDateInt(Integer.parseInt(DateUtils.format(new Date(),"yyyyMMdd")));
////                 tokenInfo.set
                for (String item : items) {
                    System.out.println(item);
                }
            }
            System.out.println();
            System.out.println("Html length: " + html.length());
            System.out.println("Number of outgoing links: " + links.size());
        }
    }
    //https://etherscan.io/token/0xB8c77482e45F1F44dE1745F52C74426C631bDD52?a=0x841b5b0c5f903b24b1eb98bbf282417aa68ba2b3


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}