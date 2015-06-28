import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class dversion {

	public String getdv(String id) throws IOException {
		
		String dv = "Ê§°Ü";
		String pageUrl = ""+id+".html";
		Document doc = Jsoup.connect(pageUrl).userAgent("Mozilla").get();
		Elements e1 = doc.select("span[class]");
		for (Iterator iterator = e1.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
            if (element.attr("class").toString().equals("ov")) {
    			dv= element.text().toString();
			};		
		}
		return dv;
	}
	
}
