package recursion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lister {
	static File file;
	static boolean showHidden;
	
	public Lister(File f, boolean hidden) {
		this.file = f;
		boolean showHidden = hidden;
	}
	
	public static void list() throws FileNotFoundException {
		listRecurse(file, "");
	}
	
	private static void listRecurse(File f, String indent) throws FileNotFoundException {
		if(f.getName().startsWith(".") && (!showHidden)) {
			return;
		}
		
		if(f.isFile()) {
			System.out.println(indent + f.getName());
		}else {
			String[] filesInside = f.list();
			System.out.println(indent + f.getName());
			for(String s :filesInside) {
				File f2 = new File(f,s);
				listRecurse(f2,indent + "  ");
			}
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Lister l = new Lister(new File("/Users/marcoshung/Downloads/Class/CS46B"), true);
		l.list();
	}
}
