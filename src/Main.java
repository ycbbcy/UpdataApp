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
	
	

	public static void main(String[] args) throws IOException {
		gversion gv = new gversion();
		dversion dv = new dversion();
		String[] idpa = filereader();
		HashMap<Integer, String> idpahHashMap = new HashMap<>(); 
		rm("result.txt");
		FileWriter fw =new FileWriter("result.txt");    //创建一个FileWriter对象   写到磁盘
		BufferedWriter bw =new BufferedWriter(fw);     //创建一个BufferedReader对象


		
		for (int i = 0; i < idpa.length; i++) {
			String[] idpause = idpa[i].split(",");
			Integer in = Integer.parseInt(idpause[0]);
			idpahHashMap.put(in, idpause[1]);		
		}

		Iterator iter = idpahHashMap.entrySet().iterator(); 
		while (iter.hasNext()) { 
			Map.Entry entry = (Map.Entry) iter.next(); 
			String id = entry.getKey().toString(); 
			String pa = entry.getValue().toString(); 
			String dvr = dv.getdv(id);
			String gvr = gv.getgv(pa);
			if (!dvr.equals(gvr)) {
				String re1 = id+"|"+pa+"|dv="+dvr+"|gv="+gvr;
				bw.write(re1);                              //写一行
				bw.newLine(); 
			}else {
				System.out.println(id+"|"+pa+"|未更新");
			}       
		} 
		bw.flush(); 
		bw.close();
	}


	public static String[] filereader() throws IOException {

		File fl=new File("idpackage.txt");
		FileReader fr = new FileReader(fl); 
		BufferedReader bf = new BufferedReader(fr);
		String tm = "";
		StringBuilder sb= new StringBuilder();
		while ((tm = bf.readLine()) != null) {
			sb.append(tm+" ");
		}
		String[] idpa = sb.toString().split(" ");
		return idpa;
	}


	public static void rm(String filename) {
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		}
	}
	


}




