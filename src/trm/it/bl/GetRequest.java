package bl;

import dao.it.internalTrainingRequest.InternalTrainingRequest;
import dao.it.internalTrainingRequest.InternalTrainingRequestDAO;

public class GetRequest {

	public InternalTrainingRequest getRequestInfo(int requestID) 
	{
		InternalTrainingRequestDAO training = new InternalTrainingRequestDAO();
		return training.getInternalTrainingRequestByTrainingRequestId(requestID);
	}
}
