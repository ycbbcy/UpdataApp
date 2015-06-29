import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class WriteV implements Runnable{
	
	String id;
	String pa;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	public void run() {
		Write(id,pa);
	}
	
	public WriteV(String id1,String pa1) {
		
		setId(id1);
		setPa(pa1);
		
	}

	public void Write(String id1,String pa1) {
		String id=id1;
		String pa=pa1;

		try {
			Dversion dv=new Dversion();
			Gversion gv=new Gversion();
			String dvr = dv.getdv(id);
			String gvr = gv.getgv(pa);
			if (!dvr.equals(gvr)) {
				String re1 = id+"|"+pa+"|dv="+dvr+"|gv="+gvr;
				System.out.println(re1);
			}else {
				System.out.println(id+"|"+pa+"|未更新");
			}       
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}



