<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>DTT Page</title>
<!-- <meta charset="utf-8"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS dependencies -->
<link rel="stylesheet"
	href="./resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/fontawesome-free-5.7.2-web/fontawesome-free-5.7.2-web/css/all.css">

<!-- JS dependencies -->
<script src="./resources/js/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./resources/js/popper.min.js"></script>
<script src="./resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>

<!-- Custom CSS -->
<link rel="stylesheet" href="./resources/css/styles.css">
<link rel="stylesheet" href="./resources/css/accordion.css">

<!-- Custom JS -->
<script src="./resources/js/main.js"></script>
<script src="./resources/css/main.js"></script>


</head>

<body>


	<header class="phead">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xl-4">
				<img id="ashlogo" src="./resources/imgs/ToolBar logo.png" alt="">
			</div>

			<div class="col-xl-6" align="right">
				<h4>Welcome User!</h4>
			</div>
			<div class="icons col-xl-2" align="center">
				<button type="button" class="btn" data-toggle="modal"
					data-target="#userProfile" title="User Profile">
					<i class="hfas fas fa-user-circle"></i>
				</button>
				<button type="button" class="btn" data-toggle="modal"
					data-target="#logOut" title="Log Out">
					<i class="hfas fas fa-sign-out-alt"></i>
				</button>
			</div>
		</div>
	</div>
	</header>

	<div class="modal" id="logOut">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">Log Out?</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Log
						Out</button>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="userProfile">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">Profile</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>

				</div>

				<div class="modal-body">
					<h3>Users Information</h3>
					<br>
					<p>Name: Mahesh1</p>
					<p>Email: mahesh@syntelinc.net</p>


				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#changePassword" data-dismiss="modal">Change
						Password</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="changePassword">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">Profile</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<div class="modal-body">
					<h3>Change Password:</h3>
					<br>
					<form class="form" action="/action_page.php">
						<label for="oldPass" class="mr-sm-2">Old Password:</label> <input
							type="password" class="form-control mb-2 mr-sm-2" id="oldPass">
						<label for="newPass1" class="mr-sm-2">New Password:</label> <input
							type="password" class="form-control mb-2 mr-sm-2" id="newPass1">
						<label for="newPass2" class="mr-sm-2">Confirm New
							Password:</label> <input type="password"
							class="form-control mb-2 mr-sm-2" id="newPass2">


						<button type="submit" class="btn btn-primary mb-2">Submit</button>
					</form>


				</div>

				<div class="modal-footer">

					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#settings" data-dismiss="modal">Change
						Password</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>


	<nav class="navbar navbar-expand-sm navbar-dark nvbr ">
	<form class="form-inline">
		<select name="Filters" style="border-radius: 0%" id="filterList"
			class="form-control">
			<option value=".pmname">Project Manager</option>
			<option value=".location">Location</option>
			<option value=".trainingType">Training Type</option>
			<option value=".startDate">Start Date</option>
			<option value=".groupSize">Group Size</option>
			<option value=".requestId">Request ID</option>
		</select> <input class="form-control navsearch" style="border-radius: 0%;"
			type="text" placeholder="Search">

	</form>
	<div class="Collapse navbar-collapse justify-content-end">
		<button class="openbtn" onclick="openNav()" title="Executive View">
			<i class="fas fa-angle-double-left"></i></button>
	</div>

	</nav>
	<br>


	<div class="container main-container">
		<!--Put the body of the file in here-->
		<div class="row" style="margin-bottom: 1%;">
			<div class="col-sm-3">
				<h3>New Requests</h3>
			</div>
			<div class="col-sm-9">
				<h3 class="text-center">Training Requests Being Processed</h3>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-2">
				<!--------------------------------- NEW REQUESTS ----------------------------------->
 <c:forEach var="newReqs" items="${TRM_DTT_Homepage1}">
        <div>
          <table class="newTrainTable1" border="4px" width='180px' style="border-radius: 9px; border-color:royalblue; box-shadow: -5px 5px grey">

            <tr>
              <td style="border: 0;" align="center">Training: ${newReqs.trainingModule}</td>
            </tr>
            <tr>
              <td style="border: 0" height="30px"><img width='20px' height='20px' src='./resources/images/PM2.jpg'>: ${newReqs.firstName} 
              
              <a href="#" data-toggle="modal" data-target="#Process${newReqs.requestId}"><img width='20px' height='20px' src='./resources/images/rightTriangle.png'> </a></td>
            </tr>
            
            <tr>
            <td colspan="3">
					<div class="modal" id="Process${newReqs.requestId}" tabindex="-1" role="dialog" aria-labelledby="myModalLabelUpdate">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">

								<div class="modal-header">
									<h4 class="modal-title" id="myModalLabelDelete">Choose Training Type</h4>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
								</div>

								<!-- Modal body -->
								<div class="modal-body">
									<c:catch>
										<form action="toProcess/${newReqs.requestId}">
											<input type="submit" class="btn btn-primary" value="DTT" /><br>
										</form>

										<form action="#">
											<input type="submit" class="btn btn-primary" value="ITT" /><br>
										</form>
										<form action="#">
											<input type="submit" class="btn btn-primary" value="VTT" /><br>
										</form>
									</c:catch>
								</div>

								<!-- Modal footer -->
								<div class="modal-footer">

									<!-- <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button> -->
								</div>
							</div>
						</div>
					</div>
				</td>
            </tr>
          </table>
          <br>
          
        </div>
        </c:forEach>
			</div>


			<!-------------------------- TRAINING REQUESTS BEING PROCESSED ---------------------------------->
			<div class="col-sm-10 form-inline" id="col-sm-1">

				<c:forEach var="requests" items="${TRM_DTT_Homepage}" varStatus="index">
					<div class="card proc-card proc-card-a">
						<div class="card-header requestId">${requests.requestId}
							<button type="button" class="summary-btn danger" href='#'
								id="popover" data-html="true" data-toggle="popover"
								data-trigger="hover" title="Summary"
								data-content='
                         <div class="card proc-card">
    <div class="card-header">${requests.requestId}</div>
    <div class="card-body proc-card-body">
      <i class="fas fa-chalkboard-teacher" title="Training"></i> <span id="summary-training">${requests.trainingModule}</span><br>
      <i class="fas fa-user" title="Project Manager"></i> <span id="summary-pm">${requests.firstName} ${requests.lastName}</span><br>
      <i class="fas fa-calendar-alt" title="Start Date"></i> <span id="summary-start-date">${requests.startDate} - ${requests.endDate}</span><br>
      <i class="fas fa-map-marker-alt" title="Location"></i> <span id="summary-location">${requests.location}</span><br>
      <i class="fas fa-globe" title="Country"></i> <span id="summary-country">USA</span><br>
      <hr>
      <i class="fas fa-building" title="Room Number"></i> <span id="summary-room-no">Plaza Ballroom I</span>
      <br> or <br>
      <i class="fas fa-link" title="Class URL"></i> <span id="summary-url"><a href="https://www.atos-syntel.net/" title="Syntel University">https://www.atos-syntel.net/</a></span><br>
      <i class="fas fa-scroll" title="Training Summary"></i> <span id="summary-sum">Additional training summary or details go here.</span><br>
      <hr>
      <p id="status">Status:</p>

    </div>
  </div>'>....</button>
						</div>
						<div class="card-body proc-card-body">
							<table width="100%">
								<tr>
									<td class="proc-card-icon-col"><i class="fas fa-user"
										title="Project Manager"></i></td>
									<td class="pmname">${requests.firstName} ${requests.lastName}</td>

									<td rowspan="5" class="align-bottom"><button type="button"
											class="btn btn-primary proc-btn" data-toggle="modal"
											data-target="#edit_steps${requests.requestId}">Edit</button></td>
								</tr>
								<tr>
									<td class="proc-card-icon-col"><i
										class="fas fa-chalkboard-teacher" title="Training"></i></td>
									<td class="trainingType">${requests.trainingType}:
										${requests.trainingModule} (${requests.trainingModuleScope})</td>
								</tr>
								<tr>
									<td class="proc-card-icon-col"><i
										class="fas fa-calendar-alt" title="Start Date"></i></td>
									<td class="startDate">${requests.startDate}</td>
								</tr>
								<tr>
									<td class="proc-card-icon-col"><i class="fas fa-users"
										title="Number of Participants"></i></td>
									<td class="groupSize">${requests.approxParticipants}</td>
								</tr>
								<tr>
									<td class="proc-card-icon-col"><i
										class="fas fa-map-marker-alt" title="Location"></i></td>
									<td class="location">${requests.location}</td>
								</tr>
							</table>


							<div id="popover_content_wrapper1" style="display: none;">
								<div class="card proc-card">
									<div class="card-header">10001</div>
									<div class="card-body proc-card-body">
										<i class="fas fa-chalkboard-teacher" title="Training"></i> <span
											id="summary-training">Java</span><br> <i
											class="fas fa-user" title="Project Manager"></i> <span
											id="summary-pm">${requests.firstName}</span><br> <i
											class="fas fa-calendar-alt" title="Start Date"></i> <span
											id="summary-start-date">02/13/2019 - 04/05/2019</span><br>
										<i class="fas fa-map-marker-alt" title="Location"></i> <span
											id="summary-location">2532 W Peoria Ave<br>
											Phoenix, AZ 85029
										</span><br> <i class="fas fa-globe" title="Country"></i> <span
											id="summary-country">USA</span><br>
										<hr>
										<i class="fas fa-building" title="Room Number"></i> <span
											id="summary-room-no">Plaza Ballroom I</span> <br> or <br>
										<i class="fas fa-link" title="Class URL"></i> <span
											id="summary-url"><a
											href="https://www.atos-syntel.net/" title="Syntel University">https://www.atos-syntel.net/</a></span><br>
										<i class="fas fa-scroll" title="Training Summary"></i> <span
											id="summary-sum">Additional training summary or
											details go here.</span><br>
										<hr>
										<p id="status">Status:</p>

									</div>
								</div>
							</div>

							<div class="modal" id="edit_steps${requests.requestId}">
								<div class="modal-dialog modal-dialog-centered modal-lg">
									<div class="modal-content">

										<div class="modal-header">
											<h4 class="modal-title">Update Training Request</h4>
											<button type="button" class="close" data-dismiss="modal">x</button>
										</div>

										<!-- Modal body -->
										<div class="modal-body">
											<div class="row">
												<div class="col-sm-6">


													<ul id="accordion" class="accordion">
                <li>
                  <div class="link"><i class="fa fa-database"></i>S.D.T.T.<i class="fa fa-chevron-down"></i></div>
                  <ul class="submenu">
                    <!--   Trainer Confirmation -->
                    <li>
                      <table>
                        <tr>
                         <div class= "stupidLeft">
                            <i class="hfas fas fa-user-tie"><label>Trainer</label></i>
                         </div> 
						    <div class = "stupidRight" style="padding-left:10px">
                            <datalist id="trainerdatalist">
                              <option value="Mahesh Rajput"></option>
                              <option value="Some Guy"></option>
                              <option value="Copyrighted Character"></option>
                            </datalist>
                            <input class = "trainerList" type="text" name="trainer" list="trainerdatalist" />
                          </div>
						  </tr>
                        <tr>
                          <td>
                            <i class="hfas fas fa-check"><label>Trainer Acceptance</label></i>
                          </td>
                          <td>
                            <input type="checkbox" />
                          </td>
                        </tr>

                      </table>
                    </li>
                    <!--   Schedule Confirmation  -->
																
						<li>
                      <table>
					                              <tr>	
												  
							<div class = "justwork">
					<label>Start</label>		</div>
							<div class = "justworkdate">
                            <input type="text" class="datepicker">
							
							</div>
							</tr>
                            <tr>					
							<div class = "justwork">
					<label>End</label>		</div>
							<div class = "justworkdate">
                            <input type="text" class="datepicker">

							</div>
							</tr>
						<tr><td style="width:100%">
						  <div class="checkboxes">
                          <label><input type="checkbox" name="Classroom" value="classroom"> Classroom</label>
                          <label><input type="checkbox" name="Online" value="online"> Online</label>
                          <label><input type="checkbox" name="Virtual" value="classroom"> Virtual</label>
						  </div></td></tr>
                      </table>
                    </li>
                  </ul>
                </li>
				
                <li>
				
                  <div class="link approval" data-dec="approved"><i class="fa fa-code"></i>P.M. Approved</div>

                </li>
				
                <li>
                  <div class="link"><i class="fas fa-cloud"></i>Logistics<i class="fa fa-chevron-down"></i></div>
                  <ul class = "submenu">
                    <form>
					<div class = "container">
                      <table>
                        <tr>
                            <i class="hfas fas fa-map-marker" title="Location">Enter Location</i>
                        </tr>
                        <tr>
                          <td align = "right">
                            <label class="location">City: </label>
							</td>
							<td>
						
							</td>
							<td align = "left"><input type="text"  value="" /></td>
						</tr>
                            
						<tr>
						<td align = "right">
							<label class="location">State: </label>
							</td>
							<td align = "left"><input type="text" /></td>
                        </tr>
							
							<tr>
							<td align = "right">
                            <label class="location">Country: </label>
							</td>
							<td align = "left"><input type="text" /></td>
							</tr>
                            
							<tr>
							<td align = "right">
                            <label class="location">Zip: </label></td>
							<td align = "left"><input type="text" /></td>
							</tr>
                      </table>
																	                      <br>
                      <table>
                        <tr>
                          
                            <i class="hfas fas fa-book">Enter Room Number</i>
                          
                        </tr>
                        <tr>
                          <td align = "right">
						  <label class="location" style="padding-left:68px"></label>	</td>
						  <td align = "left"><input type="text"/></td>
                        </tr>
                      </table>
					  
                      <br>
                     

                        <table>
                          <tr>
                            
                              <i class="hfas fas fa-desktop" title="Online">Enter Class URL</i>
                            
                          </tr>
                          <tr>
						  <td align = "right">
						  <label class="location" style="padding-left:68px"></label>	</td>
                            <td align style="left">

							  <input type="text"/>

                            </td>
                          </tr>
                        </table>
                        <br>
                        <table>
                          <tr>
                            <td>
                              <i class="hfas fas">Training Summary: <br><br><textarea style="height: 140px"></textarea></i>

                            </td>
                          </tr>
                        </table>
                    </form>
					</div>
					</li>
                  </ul>
              </ul>
            </div>
												<div class="col-sm-6">
													<div class="card proc-card">
														<div class="card-header">${requests.requestId}</div>
														<div class="card-body proc-card-body">
															<i class="fas fa-chalkboard-teacher" title="Training"></i>
															${requests.trainingType}: ${requests.trainingModule}
															(${requests.trainingModuleScope})<br> <i
																class="fas fa-user" title="Project Manager"></i>
															${requests.firstName} ${requests.lastName}<br> <i
																class="fas fa-calendar-alt" title="Dates"></i>
															${requests.startDate} - ${requests.endDate}<br> <i
																class="fas fa-map-marker-alt" title="Location"></i> <span
																style="font-style: italic">(Address)</span><br> <i
																class="fas fa-globe" title="Country"></i>
															${requests.location}<br>

															<hr>
															<i class="fas fa-building" title="Room Number"></i> <span
																style="font-style: italic">(Room)</span><br> or <br>
															<i class="fas fa-link" title="Class URL"></i> <a
																href="https://www.atos-syntel.net/"
																title="Syntel University">https://www.atos-syntel.net/</a><br>
															<i class="fas fa-scroll" title="Training Summary"></i> <span
																style="font-style: italic">Additional training
																summary or details go here.</span><br>
															<hr>
															<p id="status">Status:</p>
														</div>
													</div>
												</div>
											</div>
										</div>

										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Close</button>

										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<footer>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xl-10">
				<img id="asflogo" src="./resources/imgs/footerlogo.png" alt="">
			</div>

			<div class="col-xl-2"
				style="display: flex; align-items: center; justify-content: center">
				<i class="far fa-copyright"></i> 2019
			</div>
		</div>
	</div>
	</footer>
	<div id="mySidebar" class="sidebar">
		<script>
      function openNav() {
        document.getElementById("mySidebar").style.width = "350px";
      }

      function closeNav() {
        document.getElementById("mySidebar").style.width = "0";
      }
      $(document).ready(function () {
        $(".exec-check-box").click(function () {
          if ($(this).find("span").attr("class") == "far fa-square")
            $(this).find("span").removeClass("far fa-square").addClass("far fa-check-square");
          else
            $(this).find("span").removeClass("far fa-check-square").addClass("far fa-square");
        });


      });
    </script>

		<div class="container">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">x</a>

			<br>
			<c:forEach var="wf" items="${TRM_DTT_Homepage3}">
			<div class="card exec-card">
				<div class="card-header exec-card-header">

					<h4 class="card=title">
						<span class="fa fa-calendar-check"></span> Workflow
						<button id="exec-expand-btn" data-toggle="collapse"
							data-target="#exec-table">
							<span class="fa fa-angle-double-down" title="Expand"></span>
						</button>
					</h4>

					<table width="100%">
						<tr>
							<td align="center"><span class="fa fa-book"
								title="Training Course"></span></td>
							<td>${wf.request.request_training_module}</td>
						</tr>
						<tr>
							<td align="center"><span class="fa fa-chalkboard-teacher"
								title="Trainer"></span></td>
							<td>
							${wf.ct.first_name} ${wf.ct.last_name}
							</td>
						</tr>
						<tr>
							<td align="center"><span class="fa fa-calendar-alt"
								title="Start and End Dates"></span></td>
							<td>${wf.schedule.training_start_date} - ${wf.schedule.training_end_date}</td>
						</tr>
					</table>

				</div>
				<div class="card-body">
					<div id="exec-table" class="collapse">
						<form action="updateWorkflowStatus/${wf.workflow.executive_workflow_status_id}">
						<c:if test="${wf.workflow.sent_invitations == 1}">
							<input type="checkbox" class="wfcl" name="sent_invitations" value="1" checked/> Invitations Sent<br>
						</c:if>
						<c:if test="${wf.workflow.sent_invitations == 0}">
							<input type="checkbox" class="wfcl" name="sent_invitations" value="0" /> Invitations Sent<br>
						</c:if>
						
						<c:if test="${wf.workflow.completed_skillport_enrollment == 1}">
							<input type="checkbox" class="wfcl" name="completed_skillport_enrollment" value="1" checked/> Skillport Enrollment<br>
						</c:if>
						<c:if test="${wf.workflow.completed_skillport_enrollment == 0}">
							<input type="checkbox" class="wfcl" name="completed_skillport_enrollment" value="0" /> Skillport Enrollment<br>
						</c:if>
						
						
						<c:if test="${wf.workflow.assessments_recorded == 1}">
							<input type="checkbox" class="wfcl" name="assessments_recorded" value="1" checked/> Assessments Recorded<br>
						</c:if>
						<c:if test="${wf.workflow.assessments_recorded == 0}">
							<input type="checkbox" class="wfcl" name="assessments_recorded" value="0" /> Assessments Recorded<br>
						</c:if>
						
						
						<c:if test="${wf.workflow.vendor_training_clearance == 1}">
							<input type="checkbox" class="wfcl" name="vendor_training_clearance" value="1" checked/> Vendor Training Clearance<br>
						</c:if>
						<c:if test="${wf.workflow.vendor_training_clearance == 0}">
							<input type="checkbox" class="wfcl" name="vendor_training_clearance" value="0" /> Vendor Training Clearance<br>
						</c:if>
						
						<c:if test="${wf.workflow.completed_feedback == 1}">
							<input type="checkbox" class="wfcl" name="completed_feedback" value="1" checked/> Feedback Received<br>
						</c:if>
						<c:if test="${wf.workflow.completed_feedback == 0}">
							<input type="checkbox" class="wfcl" name="completed_feedback" value="0" /> Feedback Received<br>
						</c:if>
						
						<c:if test="${wf.workflow.training_completed == 1}">
							<input type="checkbox" class="wfcl" name="training_completed" value="1" checked/> Training Completed<br>
						</c:if>
						<c:if test="${wf.workflow.training_completed == 0}">
							<input type="checkbox" class="wfcl" name="training_completed" value="0" /> Training Completed<br>
						</c:if>
						
							<input type="submit" label="Save" value="Save" class="btn btn-primary btn-wf" />
						</form>
					<script>
					$(document).ready(function() {
						$(".wfcl").click(function() {
							if($(this).is(":checked")){
								$(this).val(1);
							}
							else {
								$(this).val(0);
							}
							
							
						});
						
						
					});
					
					
					</script>
					
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>

</body>

</html>
