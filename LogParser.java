package pocketgem;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogParser {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = "/Users/Lennon/Desktop/input_1.txt";
		if (args.length > 0) {
			filename = args[0];
		}

		String answer = parseFile(filename);
		System.out.println(answer);
	}

	static String parseFile(String filename) throws FileNotFoundException, IOException {
		/*
		 * Don't modify this function
		 */
		BufferedReader input = new BufferedReader(new FileReader(filename));
		List<String> allLines = new ArrayList<String>();
		String line;
		while ((line = input.readLine()) != null) {
			allLines.add(line);
		}
		input.close();

		return parseLines(allLines.toArray(new String[allLines.size()]));
	}

	static String parseLines(String[] lines) {

		long totalTime = 0;
		long connTotalTime = 0;
		long startTime = 0;
		long connTime = 0;
		long disConnTime = 0;
		long shutDownTime = 0;
		
		Boolean conn = false;
		Boolean disConn = false;
		
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String timeString = line.split("::")[0].trim();
			String log = line.split("::")[1].trim();
			long time = parseToTime(timeString);
			
			switch (log) {
			case "START":
				startTime = time;
				break;
				
			case "CONNECTED":
				conn = true;
				connTime = time;
				break;
				
			case "DISCONNECTED":
				disConn = true;
				disConnTime = time;
				break;
				
			case "SHUTDOWN":
				disConn = true;
				shutDownTime = time;
				break;

			default:
				break;
			}
			
			if(conn && disConn){
				if(shutDownTime == 0){
					connTotalTime += (disConnTime - connTime);
				} else{
					connTotalTime += (shutDownTime - connTime);
				}
				conn = false;
				disConn = false;
			}

		}
		
		totalTime = shutDownTime-startTime;
		double result = 0; 
		if(totalTime != 0){
			result = (double)connTotalTime / totalTime;
		}
		int r = (int)Math.floor(result * 100);
		String res = r+"%";

		return res;
	}

	private static long parseToTime(String timeString) {
//		long result = 0;
//		String tmp = timeString.substring(1, timeString.length()-1);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		try {
//			Date dateAndTime = df.parse(tmp.split("-")[0]+" "+tmp.split("-")[1]);
//			result = dateAndTime.getTime();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return result;
		
		String tmp = timeString.substring(1, timeString.length()-1);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
	    Date date = new Date();
	    try {
	      date = df.parse(tmp);
	    } catch (ParseException ignored) {}
	    return date.getTime();
	}
}
