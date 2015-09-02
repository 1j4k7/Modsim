package finalProject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class Model {
	public static void main(String[] args) {
		changeNumber(100000);
		changeDistance(10000);
		changeFile(10000);
	}
	
	public static void changeNumber(int endNum) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("number.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 2; i<endNum; i++) {
			out.print(plugIn(100, i, 1000)+", ");
		}
		out.close();
	}
	
	public static void changeDistance(int endDist) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("distance.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i<endDist; i++) {
			out.print(plugIn(i, 100, 1000)+", ");
		}
		out.close();
	}
	
	public static void changeFile(int endSize) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("size.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (double i = 1; i<endSize; i++) {
			out.print(plugIn(100, 100, i)+", ");
		}
		out.close();
	}
	
	public static double plugIn(int distance/*meters*/, int number, double size/*Mbits*/) {
		double upload = 20;
		double download = 10;
		double speedElectricity = 3000000;/*m/s*/
		double distroLatency = 0;
		double propLatency = 0;
		distroLatency = Math.max((double)size/upload, Math.max((double)size/download, (double)number*size/(upload*(number+1))));
		propLatency = number*distance/speedElectricity;
		return distroLatency+propLatency;
	}
}
