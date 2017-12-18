import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 获取浦发AE白金卡酒店兑换数据
 */
public class GetSpdbHotel {


    public static void main(String[] args) throws IOException {

        String url = "http://ccc.spdb.com.cn/miniSite/Platamex2017/1_4_list.shtml";
        Document document = Jsoup.connect(url).get();


        Element body = document.body();
        Element tbody = body.selectFirst("tbody");
        Elements tr = tbody.select("tr");

        for (int i = 2; i < tr.size(); i++) {

            SpdbHotelBean spdbHotelBean = new SpdbHotelBean();
            Elements tds = tr.get(i).select("td");

            spdbHotelBean.country = tds.get(0).text();
            spdbHotelBean.city = tds.get(1).text();
            spdbHotelBean.hotelNameCN = tds.get(2).text();
            spdbHotelBean.hotelNameEN = tds.get(3).text();
            spdbHotelBean.type = tds.get(4).text();
            spdbHotelBean.breakfast = tds.get(5).text();
            spdbHotelBean.address = tds.get(6).text();
            spdbHotelBean.closeDay = tds.get(7).text();

            System.out.println("-----" + spdbHotelBean.hotelNameCN);

        }
    }
}
