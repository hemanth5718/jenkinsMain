package crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calender {

	public static void main(String[] args) {
		
		Date obj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actdate = sim.format(obj);
		System.out.println(actdate);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String datereq = sim.format(cal.getTime());
		System.out.println(datereq);

	}

}
