package trm.dt.ddtProjectQueries;

import java.sql.Timestamp;
import java.util.Date;

public class CallbackFunction 
{
	public boolean compareAgeOfTimestap(Timestamp timestamp, int numOfDays)
	{
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		double difference;
		difference = Math.abs(timestamp.getTime() - currentTime.getTime());
		final double milSecPerDay = 24*60*60*1000L;
		if(difference > (milSecPerDay * numOfDays))
			{ return true; }
		return false;		
	}
	
	public static Timestamp dateToTimestamp(Date date)
	{
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}
	
	public static Date timestampToDate(Timestamp ts)
	{
		Date date = new Date(ts.getTime());
		return date;
	}
	
	public void statusChange(int status)
	{
		switch(status)
		{
		case 103:
			//IT
			break;
		case 104:
			//IT
			break;
		case 105:
			//IT
			break;
		case 106:
			//IT
			break;
		case 107:
			//IT
			break;
		case 108:
			//IT
			break;
		case 109:
			//IT
			break;
		case 110:
			//IT sent to PM
			//function to ask PM to choose
			break;
		case 121:
			//IT rejected
			//if to decide to move back or continue
			statusChange(203);
			break;
		case 122:
			//IT approved
			statusChange(130);
			break;
		case 130:
			//IT sent to EXEC
			break;
		case 203:
			//DDT move to middle of screen
			break;
		case 204:
			//DDT first edit to trainer
			break;
		case 205:
			//DDT communicating with trainer
			break;
		case 206:
			//DDT trainer confirmed
			break;
		case 207: 
			//DDT first edit to location
			break;
		case 208: 
			//DDT 
			break;
		case 209: 
			//DDT
			break;
		case 210:
			//DDT awaiting PM approval
			break;
		case 220:
			//DDT response from PM
			break;
		case 221:
			//DDT PM rejected
			break;
		case 222:
			//DDT PM approved
			break;
		case 230:
			//DDT sent to EXEC
			break;
		case 303:
			//VT
			break;
		case 304:
			//VT
			break;
		case 305:
			//VT
			break;
		case 306:
			//VT
			break;
		case 307:
			//VT
			break;
		case 308:
			//VT
			break;
		case 309:
			//VT
			break;
		case 310:
			//VT sent to PM
			break;
		case 320:
			//VT response from PM
			break;
		case 321:
			//VT rejected
			break;
		case 322:
			//VT approved
			break;
		case 330:
			//VT sent to EXEC
			break;
		case 150:
			//Training Completed
			break;
		default:
			break;
			
			
		}
	}
	
	public void statusPosition(int status)
	{
		switch(status)
		{
		case 100:
			//new request
			//create new card for site
			break;
		case 103:
			//IT
			//Move to in process
			break;
		case 104:
			//IT
			break;
		case 105:
			//IT
			break;
		case 106:
			//IT
			break;
		case 107:
			//IT
			break;
		case 108:
			//IT
			break;
		case 109:
			//IT
			break;
		case 110:
			//IT sent to PM
			break;
		case 120:
			//IT response from PM
			break;
		case 121:
			//IT rejected
			statusChange(203);
			break;
		case 122:
			//IT approved
			break;
		case 130:
			//IT sent to EXEC
			break;
		case 203:
			//DDT
			//Move to in process
			break;
		case 204:
			//DDT
			//looking for trainer
			break;
		case 205:
			//DDT
			break;
		case 206:
			//DDT
			break;
		case 207:
			//DDT
			break;
		case 208:
			//DDT
			break;
		case 209:
			//DDT
			break;
		case 210:
			//DDT sent to PM
			break;
		case 221:
			//DDT rejected
			//move back to 203 or onward to 303
			break;
		case 222:
			//DDT approved
			//move to 230
			break;
		case 230:
			//DDT sent to EXEC
			//move to in training
			break;
		case 303:
			//VT
			break;
		case 304:
			//VT
			break;
		case 305:
			//VT
			break;
		case 306:
			//VT
			break;
		case 307:
			//VT
			break;
		case 308:
			//VT
			break;
		case 309:
			//VT
			break;
		case 310:
			//VT sent to PM
			break;
		case 320:
			//VT response from PM
			break;
		case 321:
			//VT rejected
			break;
		case 322:
			//VT approved
			break;
		case 330:
			//VT sent to EXEC
			break;
		case 150:
			//Finished
			//move to archived
			break;
		default:
			break;			
		}
	}
}
