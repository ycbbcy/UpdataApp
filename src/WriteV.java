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
		try {
			Write(id,pa);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public WriteV(String id1,String pa1) {
		
		setId(id1);
		setPa(pa1);
		
	}

	public void Write(String id1,String pa1) throws Exception {
		String id=id1;
		String pa=pa1;

		try {
			Dversion dv=new Dversion();
			Cversion cv=new Cversion();
			Gversion gv=new Gversion();
			String dvr = dv.getdv(id);
			String cvr = cv.getcv(pa);
			if ((compareVersion(dvr, cvr)<0)&&(!dvr.equals("失败"))&&(!cvr.equals("失败"))) {
				String re1 = id+"|"+pa+"|dv="+dvr+"|gv="+cvr;
				System.out.println(re1);

			}else {
//				System.out.println(id+"|"+pa+"|未更新");
			}       
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	
	
	public static int compareVersion(String version1, String version2) throws Exception {  
	    if (version1 == null || version2 == null) {  
	        throw new Exception("compareVersion error:illegal params.");  
	    }  
	    String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；  
	    String[] versionArray2 = version2.split("\\.");  
	    int idx = 0;  
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值  
	    int diff = 0;  
	    while (idx < minLength  
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度  
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符  
	        ++idx;  
	    }  
	    //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；  
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;  
	    return diff;  
	}  
}



