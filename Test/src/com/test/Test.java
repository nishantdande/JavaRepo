package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.validator.routines.EmailValidator;




public class Test {
	
	public static final SimpleDateFormat format=new SimpleDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ssZZZ", Locale.ENGLISH);

	String[] stringsGermanWeekly ={"Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Friday","Samstag"};
	
    String[] stringsGermanRepetition={"Eins","Sekunde","Dritte","weiter"};
	
	
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
//		Date startdate = new Date();
//		Date enddate=new Date();
//		startdate = format.parse("2013-10-21"+ "T" +"22:45:34+0200");
//		enddate=format.parse("2013-10-22"+ "T" +"22:45:34+0200");
//		
//		System.out.println(max(startdate, enddate));
		
		//System.out.println(isEmailValidate("hei§@gmail.com"));

		/*String dateString="8-8-2012";
		if (convertToDate(dateString)!=null) {
			System.out.println("8/8/2012" + " = " + convertToDate(dateString));
		}else{
			System.out.println("14/12/2012" + " = " + convertToDate("2013-12-14"));	
		}*/
		
		ExecutorService service=Executors.newFixedThreadPool(3);
		for (int i = 0; i < 50; i++) {
			service.submit(new ThreadPoolExample(i));
		}
		
		
		System.out.println("Hi new test");
	}
	
	
	
	
	// List of all date formats that we want to parse.
    // Add your own format here.
    private static List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>() {
    	{
//            add(new SimpleDateFormat("M/dd/yyyy"));
//            add(new SimpleDateFormat("dd.M.yyyy"));
//            add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
//            add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
//            add(new SimpleDateFormat("dd.MMM.yyyy"));
//            add(new SimpleDateFormat("dd-MMM-yyyy"));
            add(new SimpleDateFormat("yyyy-MM-dd"));
        }
    };

	/**
     * Convert String with various formats into java.util.Date
     * 
     * @param input
     *            Date as a string
     * @return java.util.Date object if input string is parsed 
     *          successfully else returns null
     */
    public static Date convertToDate(String input) {
        Date date = null;
        if(null == input) {
            return null;
        }
        for (SimpleDateFormat format : dateFormats) {
            try {
                format.setLenient(false);
                date = format.parse(input);
            } catch (ParseException e) {
                //Shhh.. try other formats
            }
            if (date != null) {
                break;
            }
        }
 
        return date;
    }
    
    
	public static boolean isEmailValidate(String string) {
		EmailValidator emailValidator=EmailValidator.getInstance();
		return emailValidator.isValid(string);
	}
	
	/** 
     * Returns the maximum of two dates. A null date is treated as being less
     * than any non-null date. 
     */
    public static Date max(Date d1, Date d2) {
        if (d1 == null && d2 == null) return null;
        if (d1 == null) return d2;
        if (d2 == null) return d1;
        return (d1.after(d2)) ? d1 : d2;
    }
    
    /** 
     * Returns the minimum of two dates. A null date is treated as being greater
     * than any non-null date. 
     */
    public static Date min(Date d1, Date d2) {
        if (d1 == null && d2 == null) return null;
        if (d1 == null) return d2;
        if (d2 == null) return d1;
        return (d1.before(d2)) ? d1 : d2;
    }
}
