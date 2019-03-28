package bl;

import java.util.List;

import dao.getStatus.GetStatus;
import dao.getStatus.GetStatusDAO;
import dao.trainingManagementStatus.TrainingManagementStatusDAO;

public class GetRequestCol {
	public int getNew()
	{
		TrainingManagementStatusDAO finalTMS = new TrainingManagementStatusDAO();
		GetStatusDAO statusdao = new GetStatusDAO();
		List<GetStatus> getst = statusdao.getNew();
		
		return getst.size();
	}
	public int getProcess() 
	{
		TrainingManagementStatusDAO finalTMS = new TrainingManagementStatusDAO();
		GetStatusDAO statusdao = new GetStatusDAO();
		List<GetStatus> getlist = statusdao.getInProcess();
		
		return getlist.size();
	}
	public int getFinal()
	{
		TrainingManagementStatusDAO finalTMS = new TrainingManagementStatusDAO();
		GetStatusDAO statusdao = new GetStatusDAO();
		List<GetStatus> getlist = statusdao.getFinal();
		
		return getlist.size();
	}
	
	public static void main(String[] args) {
		GetRequestCol test = new GetRequestCol();
		System.out.println(test.getNew());
	}
}

