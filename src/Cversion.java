import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Cversion {

	public String getcv(String packagename) throws IOException {
		String cv = "Ê§°Ü";
		String pageUrl = ""+packagename;
		Document doc = Jsoup.connect(pageUrl).userAgent("Mozilla").get();
		Elements e1 = doc.select("title");
		for (Iterator iterator = e1.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
				cv= element.text().toString().split("_")[1];	
		}
		return cv;
	}
}