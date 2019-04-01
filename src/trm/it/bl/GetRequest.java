package trm.it.bl;

import trm.it.dao.internalTrainingRequest.InternalTrainingRequest;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequestDAO;

public class GetRequest {

	public InternalTrainingRequest getRequestInfo(int requestID) 
	{
		InternalTrainingRequestDAO training = new InternalTrainingRequestDAO();
		return training.getInternalTrainingRequestByTrainingRequestId(requestID);
	}
}
