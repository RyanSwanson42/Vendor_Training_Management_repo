package trm.it.bl;

import trm.it.dao.it.internalTrainingRequest.InternalTrainingRequest;
import trm.it.dao.it.internalTrainingRequest.InternalTrainingRequestDAO;

public class GetRequest {

	public InternalTrainingRequest getRequestInfo(int requestID) 
	{
		InternalTrainingRequestDAO training = new InternalTrainingRequestDAO();
		return training.getInternalTrainingRequestByTrainingRequestId(requestID);
	}
}
