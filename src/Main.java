import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sun.jndi.url.rmi.rmiURLContext;


public class Main {

	public static void main(String[] args) throws IOException, Exception {
		
		Cversion cv = new Cversion();
		cv.getcv("");
		System.exit(0);
		
		
		String[][] idpa = filereader();  
		WriteV[] wv=new WriteV[idpa.length]; 
		for (int i = 0; i < idpa.length; i++) {
			wv[i] = new WriteV(idpa[i][0],idpa[i][1]);
		}

		Thread thread[] = new Thread[wv.length];
		for (int j = 0; j < wv.length; j++) {
			if (j%10!=0||j==0) {
				thread[j] = new Thread(wv[j]);
				thread[j].start();
			}else {
				Thread.sleep(5000);
				thread[j] = new Thread(wv[j]);
				thread[j].start();
			}
		}
	}


	public static String[][] filereader() throws IOException {

		File fl=new File("idpackage.txt");
		FileReader fr = new FileReader(fl); 
		BufferedReader bf = new BufferedReader(fr);
		String tm = "";
		StringBuilder sb= new StringBuilder();
		while ((tm = bf.readLine()) != null) {
			sb.append(tm+" ");
		}
		String[] idpa = sb.toString().split(" ");
		bf.close();
		String[][] idpa2=new String[idpa.length][1];
		for (int i = 0; i < idpa.length; i++) {
			idpa2[i]=idpa[i].split(","); 
		}
		return idpa2;
	}

	public static void rm(String filename) {
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		}
	}
}




