<%@page import="trm.it.bl.GetRequest"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Process In Progress</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

	<spring:url value="/resources/css/processInProgress.css" var="processInProgressITCss" />
	<spring:url value="/resources/js/processInProgress.js" var="processInProgressITJs" />
	
	<link href="${processInProgressITCss}" rel="stylesheet" />
    <script src="${processInProgressITJs}"></script>

</head>

<div class="container">
	
    <div class="col-md-6">
        <a href="#step1Collapse" class="btn btn-info steps" data-toggle="collapse">
            Step 1 
        </a>
        <div id="step1Collapse" class="collapse">
    
            <form:form action="../saveRequest/${maheshFun.trainingID}">
	
                <a href="#step11Collapse" class="btn btn-info stepsmini" data-toggle="collapse">
            		Step 1.1 Trainer
        		</a>

                <div id="step11Collapse" class="collapse">
                
                <div class="form-group">
                    <label for="trainers" class="control-label col-md-4">Available Trainers:</label>
                    <div class="col-md-6">
                    
                    <form:select path="trainerName" cssClass="form-control" id="trainers">
                    		<form:option value=""><< Choose Trainer >></form:option>
                        <c:forEach var="name" items="${alltrainers}">
							<form:option value="${name}">${name}</form:option>
						</c:forEach>
                    </form:select>
                        
                    </div>

                    <div class="col-md-2">
                        <a href="" id="addTrainer" class="btn btn-info">
                            Add Other
                        </a>
                    </div>
                </div>


				</div>
				<a href="#step12Collapse" class="btn btn-info stepsmini" data-toggle="collapse">
            		Step 1.2 Environment
        		</a>
				<div id="step12Collapse" class="collapse">
					
                <div class="form-group">
                    <label class="control-label col-md-4">Mode:</label>
<!--                     <label class="radio-inline control-label"> -->
<!--                         <input type="radio" name="mode" id="classroom" checked>Classroom -->
<!--                     </label> -->
<!--                     <label class="radio-inline control-label"> -->
<!--                         <input type="radio" name="mode" id="virtual">Virtual -->
<!--                     </label> -->
						<form:radiobutton path="mode" value="classroom" id="classroom"/>Classroom
						<form:radiobutton path="mode" value="virtual" id="virtual"/>Virtual

                </div>
                
                <div id="modeClassroom">
                	<div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                        	<form:label path="address">Street Address</form:label>
                        </div>
                        	<form:input path="address"/>
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="city">City</form:label>
                        </div>
                        	<form:input path="city"/>
                        
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="state">State</form:label>
                    	</div>
                        	<form:input path="state"/>
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="country">Country</form:label>
                        </div>
                        	<form:input path="country" />
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
	                    	<form:label path="zipCode">Zip Code</form:label>
                        </div>
                        	<form:input path="zipCode"/>
                        
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="roomNum">Room Number</form:label>
                        </div>
                        	<form:input path="roomNum"/>
                    </div>
                    
                </div>
                    
                <div id="modeVirtual">
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="url">URL Link</form:label>
                        </div>
                        	<form:input path="url"/>
                    </div>
					<div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="phoneNum">Connection Phone</form:label>
                        </div>
                        	<form:input path="phoneNum"/>
                    </div>
                </div>

				</div>
				<a href="#step13Collapse" class="btn btn-info stepsmini" data-toggle="collapse">
            		Step 1.3 Schedule
        		</a>
				<div id="step13Collapse" class="collapse">

                	<div class="form-group">
                		<div class="col-md-2"></div>
                    	<div class="col-md-3">
                    		<form:label path="startDate">Start Date</form:label>
                    	</div>
                        	<form:input path="startDate"/>
                	</div>
	                <div class="form-group">
	                    <div class="col-md-2"></div>
	                    <div class="col-md-3">
	                    	<form:label path="endDate">End Date</form:label>
	                    </div>
	                        	<form:input path="endDate"/>
	                </div>       
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="startTime">Start Time</form:label>
                        </div>
                        	<form:input path="startTime"/>
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="endTime">End Time</form:label>
                        </div>
                        	<form:input path="endTime"/>
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label  path="timeZone">Time Zone</form:label>
                        </div>
                        	<form:input path="timeZone"/>
                    </div>
                    <div class="form-group">
                    	<div class="col-md-2"></div>
                        <div class="col-md-3">
                    		<form:label path="schedBreakdown">Explanation for Times</form:label>
                    	</div>
                        	<form:textarea maxlength="200" rows="3" cols="23" path="schedBreakdown" />
                	</div>
                </div>
        
        		<a href="#step14Collapse" class="btn btn-info stepsmini"
            		data-toggle="collapse"> Step 1.4 Description </a>
        		<div id="step14Collapse" class="collapse">

		            <div class="form-group">
		                <div class="col-md-3">
		                <form:label path="description">Description</form:label>
		                </div>
		                <form:textarea maxlength="200" rows="5" cols="40" path="description" />
		                
		            </div>
		        </div>
                
				
				<form:button id="saveButtonITForm">Update</form:button>
				
			</form:form>
		</div>


        <div class="pending col-md-12">
            <div>
                <b>Pending Approval:</b>
            </div>
        </div>

        <a href="#step2Collapse" class="btn btn-info steps" data-toggle="collapse">
            Step 2
        </a>
        <div id="step2Collapse" class="collapse">
            <form>
            	<div>
            		Complete the Executive Functions from the Executive Column
            	</div>
            </form>
        </div>
    </div>

    <div class="col-md-6">
        <table class="table">
            <thead>
                <tr>
                    <th>Saved Request Info -- Request ID#</th>
                    <th>${maheshFun.trainingID }</th>
                </tr>
            </thead>
            <tbody style="background-color:fuchsia; ">
            	<tr>
                    <td>Training Type:</td>
                    <td>Internal Training</td>
                </tr>
                <tr>
                    <td>Trainer Name</td>
                    <td>${maheshFun.trainerName }</td>
                </tr>
                <tr>
                    <td>Trainer ID</td>
                    <td>${maheshFun.trainerID }</td>
                </tr>
            </tbody>
            	
            <tbody style="background-color: olive;">
                <tr>
                    <td>Start Date</td>
                    <td>${maheshFun.startDate }</td>
                </tr>
                <tr>
                    <td>End Date</td>
                    <td>${maheshFun.endDate }</td>
                </tr>
                <tr>
                    <td>Start Time</td>
                    <td>${maheshFun.startTime }</td>
                </tr>
                <tr>
                    <td>End Time</td>
                    <td>${maheshFun.endTime }</td>
                </tr>
                </tbody>
                <tbody style='background-color:lime;'>
                <tr>
                    <td>Mode:</td>
                    <td>${maheshFun.mode }</td>
                </tr>
                <tr>
                    <td>URL:</td>
                    <td>${maheshFun.url }</td>
                </tr>
                <tr>
                    <td>Phone Connection Line:</td>
                    <td>${maheshFun.phoneNum }</td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td>${maheshFun.country }</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${maheshFun.address }</td>
                </tr>
                <tr>
                    <td>State</td>
                    <td>${maheshFun.state }</td>
                </tr>
                <tr>
                    <td>Zip Code</td>
                    <td>${maheshFun.zipCode }</td>
                </tr>
                <tr>
                    <td>City</td>
                    <td>${maheshFun.city }</td>
                </tr>
                <tr>
                    <td>Room: </td>
                    <td>${maheshFun.roomNum }</td>
                </tr>
            </tbody>
        </table>
        <button class="button button1" >Move to DT</button>
        <button class="button button1">Move to VT</button>
<%--         <a href="updateproduct/${allproduct.pid}">Update</a> --%>
        
    </div>
</div>







</html>