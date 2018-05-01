package com.ubs.opsit.interviews;

import java.util.regex.Pattern;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		String timeString = null;
		
		if(aTime != null && !aTime.equals(""))
		{		
			final String[] time = aTime.split(Pattern.quote(":"));		
			
			timeString = getSecsCode(timeString, time[2]);
			
			timeString = getHourCode(timeString, time[0]);
			
			timeString = getMinsCode(timeString, time[1]);	
		}		
		return timeString;
	}

	private String getSecsCode(String timeString, final String secString) {
		if(secString!=null && ! secString.equals(""))	
		{
			int secValue = Integer.parseInt(secString);
			
			if (secValue%2==0)
			{
				timeString= "Y\r\n";
			}
			else
			{
				timeString= "O\r\n";
			}
		}
		return timeString;
	}

	private String getMinsCode(String timeString, final String minsString) {
		if(minsString!= null && !minsString.equals(""))	
		{
			int minValue = Integer.parseInt(minsString);				
			int divisor  = minValue/5;
			int remainder = minValue%5; 
			for (int i =0; i <11; i++)
			{
				if(i<divisor)
				{
					if(i > 0 && ((i+1)%3==0))
						timeString = timeString.concat("R");						
					else
						timeString = timeString.concat("Y");
				}
				else
					timeString = timeString.concat("O");
			}
			timeString = timeString.concat("\r\n");
			for (int j =0; j <4; j++)
			{
				if(j<remainder)
					timeString = timeString.concat("Y");
				else
					timeString = timeString.concat("O");
			}
		}
		return timeString;
	}

	private String getHourCode(String timeString, final String hourString) {
		if(hourString!= null && !hourString.equals(""))	
		{
			int hourValue = Integer.parseInt(hourString);								
			int divisor  = hourValue/5;
			int remainder = hourValue%5; 
			for (int i =0; i <4; i++)
			{
				if(i<divisor)
					timeString = timeString.concat("R");
				else
					timeString = timeString.concat("O");
			}
			timeString = timeString.concat("\r\n");
			for (int j =0; j <4; j++)
			{
				if(j<remainder)
					timeString = timeString.concat("R");
				else
					timeString = timeString.concat("O");
			}
			timeString = timeString.concat("\r\n");				
		}
		return timeString;
	}
}