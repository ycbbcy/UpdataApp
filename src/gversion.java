import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class gversion {

	public String getgv(String packagename) throws IOException {
		String gv = "Ê§°Ü";
		String pageUrl = "="+packagename;
		Document doc = Jsoup.connect(pageUrl).userAgent("Mozilla").get();
		Elements e1 = doc.select("div[itemprop]");
		for (Iterator iterator = e1.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			if (element.attr("itemprop").toString().equals("softwareVersion")) {
				gv= element.text().toString();
			};		
		}
		return gv;
	}
}




