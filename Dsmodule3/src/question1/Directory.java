package question1;
import java.util.ArrayList;
/**
 * class to represent a directory
 */
public class Directory {

	public String directoryName;
	public ArrayList<Directory> subDirectory;
	
	Directory(String directoryName) {
		this.directoryName=directoryName;
		this.subDirectory=new ArrayList<>();
	}
}