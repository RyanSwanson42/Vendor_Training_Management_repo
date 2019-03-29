package trm.dt.ddtProjectQueries;

import java.sql.Timestamp;
import java.util.Date;

import trm.vt.dao.trainingManagementStatus.TrainingManagementStatusDAO;
import trm.vt.dao.trainingRequestLog.TrainingRequestLogDAO;

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
	
	public void statusChange(int training_id, int status)
    {
        String message = "";
        switch(status)
        {
        case 103:
            message = "Internal Training Request started";
            break;
        case 104:
            message = "Looking for available internal trainers";
            break;
        case 105:
            message = "Internal Training Request ";
            break;
        case 106:
            message = "Internal Training Request ";
            break;
        case 107:
            message = "Internal Training Request ";
            break;
        case 108:
            message = "Internal Training Request ";
            break;
        case 109:
            message = "Internal Training Request ";
            break;
        case 110:
            message = "Internal Training Request at PM for Final Approval";
            //function to ask PM to choose
            break;
        case 121:
            message = "Internal Training Request declined by PM / Awaiting next action";
            //ask spoc if they want to move to next type of training or restart internal process
            //if to decide to move back or continue
            break;
        case 122:
            message = "Internal Training Request approved by PM / Ready for training";
            //move automatically or wait for the start date
            break;
        case 130:
            message = "Internal Training in progress";
            break;
        case 203:
            message = "Development Training Request started";
            break;
        case 204:
            message = "Confirming details with available development trainers";
            break;
        case 205:
            message = "Confirming details with development trainer's manager";
            break;
        case 206:
            message = "Awaiting PM for development trainer approval";
            break;
        case 207: 
            message = "Confirming logistical details for development training";
            break;
        case 208: 
            message = "";
            break;
        case 209: 
            //DDT
            break;
        case 210:
            message = "Development Training Request at PM for final approval";
            break;
        case 221:
            message = "Development Training Request declined by PM / Awaiting next action";
            break;
        case 222:
            message = "Development Training Request approved by PM / Ready for training";
            break;
        case 230:
            message = "Development Training in progress";
            break;
        case 303:
            message = "Vendor Training Request started";
            break;
        case 304:
            message = "Vendor Training Request ";
            break;
        case 305:
            message = "Vendor Training Request ";
            break;
        case 306:
            message = "Vendor Training Request ";
            break;
        case 307:
            message = "Vendor Training Request ";
            break;
        case 308:
            message = "Vendor Training Request ";
            break;
        case 309:
            message = "Vendor Training Request ";
            break;
        case 310:
            message = "Vendor Training Request at PM for Final Approval";
            break;
        case 321:
            message = "Vendor Training Request declined by PM / awaiting next action";
            break;
        case 322:
            message = "Vendor Training Request approved by PM / ready for training";
            break;
        case 330:
            message = "Vendor Training in progress";
            break;
        case 150:
            message = "Training completed / Archiving request";
            break;
        default:
            break;
        }
        TrainingRequestLogDAO rl = new TrainingRequestLogDAO();
        rl.insertTrainingRequestLog(training_id, status, Timestamp.from(java.time.Instant.now()), message);
        TrainingManagementStatusDAO ms = new TrainingManagementStatusDAO();
        ms.updateTrainingManagementStatusOnPid(status, training_id);
	}
}
