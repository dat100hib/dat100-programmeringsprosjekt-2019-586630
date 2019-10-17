package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double[gpspoints.length];
		
		for (int i = 0; i < latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longitudes = new double[gpspoints.length];
		
		for (int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		
		latitude1 = gpspoint1.getLatitude();
		double latituderadian1 = toRadians(latitude1);
		latitude2 = gpspoint2.getLatitude();
		double latituderadian2 = toRadians(latitude2);
		longitude1 = gpspoint1.getLongitude();
		double longituderadian1 = toRadians(longitude1);
		longitude2 = gpspoint2.getLongitude();
		double longituderadian2 = toRadians(longitude2);
		
		double latituderadian = latituderadian2 - latituderadian1;
		double longituderadian = longituderadian2 - longituderadian1;
		
		
		double a = Math.pow((Math.sin(latituderadian/2)), 2)+Math.cos(latituderadian1)*Math.cos(latituderadian2)*Math.pow(Math.sin(longituderadian/2), 2);             
		double c = 2*atan2(sqrt(a),sqrt(1-a));
		d = R*c;
		// TODO - SLUTT
		return d;

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = ((distance(gpspoint1, gpspoint2)/secs)*18)/5;
		return speed;
		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		int hr, min;
		hr = secs/60/60;
		secs = secs%3600;
		min = secs/60;
		secs = secs%60;
		timestr = (String.format("%1$10s", String.format("%02d", hr) + TIMESEP+
				String.format("%02d", min) + TIMESEP + String.format("%02d",  secs)));
		return timestr;
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		d = d*100;
		d = Math.round(d);
		d = d/100;
		
		str = String.format("%1$" +TEXTWIDTH + "s", d);
		return str;
		

		// TODO - SLUTT
		
	}
}
