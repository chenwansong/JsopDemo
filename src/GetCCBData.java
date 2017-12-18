import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 获取建行的地区码数据
 */
public class GetCCBData {


    public static void main(String[] args) throws IOException {

        String url = "http://www.ccb.com/cn/OtherResource/bankroll/html/code_help.html";
        Document document = Jsoup.connect(url).get();

        Element ele = document.getElementById("content");
        Elements elements = ele.getElementsByClass("addlist");


        for (Element element : elements) {

            Element province = element.select("h3").first();
            Elements tbody = element.selectFirst("table").selectFirst("tbody").select("tr");

            for (int i = 1; i < tbody.size(); i++) {

                AreaCode areaCode = new AreaCode();
                areaCode.province = province.text();

                Elements tds = tbody.get(i).select("td");

                areaCode.code = tds.get(0).text();
                areaCode.city = tds.get(1).text();

                System.out.println("-----" + areaCode.toString());
//                System.out.println("-----" + JSON.toJSONString(areaCode));
            }


        }


    }
}
