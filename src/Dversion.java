import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Dversion {

	public String getdv(String id) throws IOException {

		String dv = "Ê§°Ü";
		String[] temp = new String[10]; 
		String pageUrl = ""+id+"";
		Document doc = Jsoup.connect(pageUrl).userAgent("Mozilla").get();
		Elements e1 = doc.select("div[data-gather]");
		Elements e2 = doc.select("span[class]");
		for (Iterator iterator1 = e1.iterator(); iterator1.hasNext();) {
			Element element1 = (Element) iterator1.next();
			if (element1.attr("data-gather").toString().contains(id)) {
				temp = element1.text().toString().split("\\|");
				dv=temp[1].substring(2, temp[1].length()-1);
			}

		}	
		if (dv.equals("Ê§°Ü")) {
			for (Iterator iterator2 = e2.iterator(); iterator2.hasNext();) {
				Element element2 = (Element) iterator2.next();
				if (element2.attr("class").toString().equals("ov")) {
					dv= element2.text().toString();
				};
			}
		}
		return dv;
	}

}

