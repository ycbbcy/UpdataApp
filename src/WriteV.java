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
			// TODO �Զ����ɵ� catch ��
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
			if ((compareVersion(dvr, cvr)<0)&&(!dvr.equals("ʧ��"))&&(!cvr.equals("ʧ��"))) {
				String re1 = id+"|"+pa+"|dv="+dvr+"|gv="+cvr;
				System.out.println(re1);

			}else {
//				System.out.println(id+"|"+pa+"|δ����");
			}       
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	
	
	public static int compareVersion(String version1, String version2) throws Exception {  
	    if (version1 == null || version2 == null) {  
	        throw new Exception("compareVersion error:illegal params.");  
	    }  
	    String[] versionArray1 = version1.split("\\.");//ע��˴�Ϊ����ƥ�䣬������"."��  
	    String[] versionArray2 = version2.split("\\.");  
	    int idx = 0;  
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//ȡ��С����ֵ  
	    int diff = 0;  
	    while (idx < minLength  
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//�ȱȽϳ���  
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//�ٱȽ��ַ�  
	        ++idx;  
	    }  
	    //����Ѿ��ֳ���С����ֱ�ӷ��أ����δ�ֳ���С�����ٱȽ�λ�������Ӱ汾��Ϊ��  
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;  
	    return diff;  
	}  
}



