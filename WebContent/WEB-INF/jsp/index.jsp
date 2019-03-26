<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Vendor TRM Team">

<title>Vendor TRM</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- FontAwesome-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<!-- Custom styles-->
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/vtm-modal.css"/>"
	rel="stylesheet">


<!-- Bootstrap core JavaScript -->
<script src="<c:url value="resources/vendor/jquery/jquery.min.js"/>"></script>
<script
	src="<c:url value="resources/vendor/bootstrap/js/bootstrap.bundle.min.js" /> "></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>


<!-- Local js scripts-->
<script src="<c:url value="resources/js/vtm.js" />"></script>
<script src="<c:url value="resources/js/trainingType.js" />"></script>

</head>
<body style="padding-top: 70px">

	<!-- Navigation -->
	<nav class="main-header navbar navbar-expand-lg navbar-dark fixed-top"
		style="background-color: #3c8dbc">
	<div class="container">
		<img src="<c:url value="resources/img/AtosSyntelLogoMedWhite.png" />"
			height="30" /> <a class="navbar-brand" href="#"> <!--<b>Atos</b>Syntel-->
			<i>Vendor <b>TRM</b>
		</i>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item py-1" style="padding-right: 5px"><input
					type="search" id="sb"
					style="color: white; border-radius: 15px; border: #fff 2px solid; background-color: #3c8dbc; padding-top: 2px; padding-bottom: 3px"
					required placeholder="  Filter..." /></li>
				<li class="nav-item"><a class="nav-link" href="#">Run
						Report</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="vendormanagement" />">Vendor Management</a></li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-user-circle"
						style="float: none;"></i> Mahesh
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<span class="dropdown-item">Welcome, SPOC</span> <span
							class="dropdown-item">Your Vertical: Logistics</span>
						<div class="dropdown-divider"></div>
						<a onclick="location.href='/SpringApp/logout'"
							class="dropdown-item"> <b style="color: tomato">Logout</b>
						</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<span
			style="float: right; margin-top: -10px; margin-bottom: 10px; color: #3c8dbc;">Toggle
			In Progress:
			<button type="button" class="btn btn-link " id="hidebutton">
				<i id="itog" class="fas fa-toggle-on fa-2x"></i>
			</button>
		</span> <br> <br>
		<div class="row text-left">
			<div id="new" class="col-md-3"
				style="border: 10px solid #FFFF66; border-style: none none none solid;">
				<h4>New</h4>
			<!-- 	<button type="submit" class="btn btn-outline-warning " id="bpbutton"
					style="float: right; position: relative; top: -40px; margin-right: 10px;">to
					Processing</button> -->
					
				<div id="toProcessing-btng" class="btn-group" style="float: right; position: relative; top: -40px; margin-right: 10px;">
				  <button id="bpbutton" type="button" class="btn btn-outline-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    to Processing
				  </button>
				  <div id="toProcessing-ddm" class="dropdown-menu" style="min-width: 6rem">
				    <a class="dropdown-item" id="it-link" href="toProcessing/it/" style="padding-left: 10px; padding-right: 10px;">
				    <img src="<c:url value="/resources/img/it-icon.png" />">
				    IT</a>
				    <a class="dropdown-item" id="dt-link" href="toProcessing/dt/" style="padding-left: 10px; padding-right: 10px;">
				    <img src="<c:url value="/resources/img/dt-icon.png" />">
				    DT</a>
				    <a class="dropdown-item" id="vt-link" href="toProcessing/vt/" style="padding-left: 10px; padding-right: 10px;">
				    <img src="<c:url value="/resources/img/vendor-icon-placeholder.png" />">
					VT</a>
				  </div>
				</div>
				
				<!-- Start of for loop for new training requests on the left of the screen -->
				<c:forEach var="pro1" items="${vendorTrainingRequestList1}"
					varStatus="theCount">
					<div class="card"
						style="width: 14rem; margin-left: 10px; margin-top: 20px;" id="p1">
						<div class="cardcontainer">
							<%-- <input type="checkbox" class="form-check-input" id="pro1-check-${theCount.count}"> --%>
							
							<label class="chkbox-container">
								<input type="checkbox" class="chk" id="pro1-check-${pro1.getVendorTrainingRequest().vendor_training_request_id}">
							<span class="checkmark" style="margin-top: 8px; margin-right: 8px;"></span>
							</label>
							
							<div class="card-body">
								<h5 class="card-title">
									<span> <i class="fa fa-id-card" aria-hidden="true"
										style="color: #3c8dbc; float: inherit;"></i>
										${pro1.getVendorTrainingRequest().vendor_training_request_id}
									</span>
								</h5>
								<hr style="width: 90%; border-color: #b9b9b9;">
								<p class="card-text">
								<table style="margin-bottom: -15px;">
									<tr>
										<td style="text-align: center"><i class="fas fa-user"
											style="color: #ff3232; float: inherit;"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro1.getEmployee().first_name}
											${pro1.getEmployee().last_name}</td>
									</tr>
									<tr>
										<td style="text-align: center"><i
											class="fas fa-network-wired"
											style="float: inherit; color: #323232"
											id="p_module_icon-${theCount.count}"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro1.getTrainingRequest().request_training_module}</td>
									</tr>
									<tr>
										<td style="text-align: center"><i
											class="fas fa-map-marker-alt"
											style="float: inherit; color: #323232"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro1.getTrainingRequest().request_location}</td>
									</tr>
									<tr>
										<td style="text-align: center"><i class="fas fa-users"
											style="float: inherit; color: #323232"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro1.getTrainingRequest().request_approx_participant}</td>
									</tr>
									<tr>
										<td style="text-align: center"
											id="p_date_icon-${theCount.count}"><i
											class="fas fa-calendar-day"
											style="float: inherit; color: #323232"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro1.getTrainingRequest().request_start_date}</td>
									</tr>
								</table>
								</p>
							</div>
							<div class="vendor-overlay" id="module-overlay-${theCount.count}">
								<div class="cardtext">
									<p
										style="font-family: Arial, Helvetica, sans-serif; font-size: medium; font-weight: 400;">
										<b>Module Name:</b>
										${pro1.getTrainingRequest().request_training_module} <br>
										<b>Module Scope:</b>
										${pro1.getTrainingRequest().request_training_module_scope} <br>
										<b>Training Mode:</b>
										${pro1.getTrainingRequest().request_training_mode}
									</p>
								</div>
							</div>
							<div class="vendor-overlay" id="date-overlay-${theCount.count}">
								<div class="cardtext">
									<p
										style="font-family: Arial, Helvetica, sans-serif; font-size: medium; font-weight: 400;">
										<b>Start Date:</b>
										${pro1.getTrainingRequest().request_start_date} <br> <b>End
											Date:</b> ${pro1.getTrainingRequest().request_end_date} <br>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div id="processing-col" class="col"
				style="border: 10px solid #FFC04C; border-style: none none none solid;"
				id="pd">
				<h4>Processing</h4>
				<div class="row" id="hp">
					<c:forEach var="pro2" items="${vendorTrainingRequestList2}"
						varStatus="theCount">
						<div class="card"
							style="margin-left: 10px; margin-top: 20px; width: 16rem;">
							<div class="card-body">

								<h5 class="card-title">
									<span> <i class="fa fa-id-card" aria-hidden="true"
										style="color: #3c8dbc; float: inherit;"></i>
										${pro2.getVendorTrainingRequest().vendor_training_request_id}
									</span> <span style="float: right;"> <img
										style="margin-top: 27px;"
										src="<c:url value="/resources/img/vendor-icon-placeholder.png" />">
									</span>
								</h5>
								<hr style="width: 90%; border-color: #b9b9b9;">

								<%-- <h5 class="card-title">Vendor Request</h5>
								<h6 class="card-subtitle mb-2 text-muted">ID:
									${pro2.getVendorTrainingRequest().vendor_training_request_id}</h6> --%>
								<p class="card-text">
								<table style="margin-bottom: -15px;">
									<tr>
										<td style="text-align: center"><i class="fas fa-user"
											style="color: #ff3232; float: inherit;"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro2.getEmployee().first_name}
											${pro2.getEmployee().last_name}</td>
									</tr>
									<tr>
										<td style="text-align: center"><i
											class="fas fa-network-wired"
											style="float: inherit; color: #323232"></i></td>
										<td style="text-align: left; padding-left: 5px;" id="n_">
											${pro2.getTrainingRequest().request_training_module}</td>
									</tr>
									<tr>
										<td style="text-align: center"><i
											class="fas fa-map-marker-alt"
											style="float: inherit; color: #323232"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro2.getTrainingRequest().request_location}</td>
									</tr>
									<tr>
										<td style="text-align: center"><i class="fas fa-users"
											style="float: inherit; color: #323232"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro2.getTrainingRequest().request_approx_participant}</a>
										</td>
									</tr>
									<tr>
										<td style="text-align: center"><i
											class="fas fa-calendar-day"
											style="float: inherit; color: #323232"></i></td>
										<td style="text-align: left; padding-left: 5px;">
											${pro2.getTrainingRequest().request_start_date}</td>
									</tr>
								</table>
								</p>

								<!-- Yosuf ElSaadany 3/14/2019 1:47 pm Integration of Modal- DOM for Modal -->
								<i style="margin-left: 10px" id="modalIcons" title="Open"
									data-toggle="modal" data-target="#myModal${theCount.count}"
									class="fas fa-external-link-alt"
									onclick="ajax(${pro2.getVendorTrainingRequest().vendor_training_request_id});"></i>

								<div class="modal" id="myModal${theCount.count}">
									<div class="modal-dialog modal-xl">
										<div class="modal-content">
											<!-- Modal Header -->
											<div class="modal-header">
												<div class="col-lg-4">
													<p>
														<b>Training Request ID:</b>
														${pro2.getVendorTrainingRequest().vendor_training_request_id}
													</p>
												</div>
												<div class="col-lg-4">
													<p>
														<b>Project Manager:</b> ${pro2.getEmployee().first_name}
														${pro2.getEmployee().last_name}
													</p>
												</div>
												<div class="col-lg-2">
													<p>
														<b>Module:</b>
														${pro2.getTrainingRequest().request_training_module}
													</p>
												</div>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>
											<div style="overflow-y: scroll" class="modal-body">
												<div class="row">
													<div class="col">
														<!--Accordion start-->
														<div class="accordion" id="accordionEx" role="tablist"
															aria-multiselectable="true">
															<div class="card">
																<!-- Card header -->
																<div
																	onclick="javascript:section1(${pro2.getVendorTrainingRequest().vendor_training_request_id});"
																	class="card-header" role="tab" id="headingOne1">
																	<a style="text-decoration: none" class="collapsed"
																		data-toggle="collapse" data-parent="#accordionEx"
																		href="#collapseOne1" aria-expanded="true"
																		aria-controls="collapseOne1">
																		<h5 class="mb-0">
																			SPOC Shortlist Vendor <i id="modalIcons"
																				class="fas fa-angle-down rotate-icon"></i>
																		</h5>
																	</a>
																</div>
																<!-- Card body -->
																<div id="collapseOne1" class="collapse show"
																	role="tabpanel" aria-labelledby="headingOne1"
																	data-parent="#accordionEx">
																	<div class="card-body">
																		<%-- 
																			<a class="nav-link" href="#" id="vm-open"
																			data-toggle="modal" data-target="#vm-modal"
																			data-backdrop="static">Vendor Management</a>
																			<button onclick="openVendorModal(${pro2.getVendorTrainingRequest().vendor_training_request_id});" class="nav-link" href="#" id="vm-open"
																			data-toggle="modal" data-target="#vm-modal"
																			data-backdrop="static">Select Vendors</button> --%>
																	</div>
																	<table id="vendorSPOC" class="table">
																		<thead class="thead-light">
																			<tr>
																				<th>Vendor</th>
																				<th>Phone</th>
																				<th>Email</th>
																				<th>City</th>
																				<th>State</th>
																			</tr>
																		</thead>
																		<tbody id="table-body1">

																		</tbody>
																	</table>
																</div>
															</div>
															<div class="card">
																<!-- Card header -->
																<div
																	onclick="javascript:section2(${pro2.getVendorTrainingRequest().vendor_training_request_id});"
																	class="card-header" role="tab" id="headingTwo2">
																	<a style="text-decoration: none" class="collapsed"
																		data-toggle="collapse" data-parent="#accordionEx"
																		href="#collapseTwo2" aria-expanded="false"
																		aria-controls="collapseTwo2">
																		<h5 class="mb-0">
																			PT Shortlist Vendor<i id="modalIcons"
																				class="fas fa-angle-down rotate-icon"></i>
																		</h5>
																	</a>
																</div>
																<!-- Card body -->
																<div id="collapseTwo2" class="collapse" role="tabpanel"
																	aria-labelledby="headingTwo2"
																	data-parent="#accordionEx">
																	<div class="card-body">
																		<table id="vendorPT" class="table">
																			<thead class="thead-light">
																				<tr>
																					<th>Vendor</th>
																					<th>Phone</th>
																					<th>Email</th>
																					<th>City</th>
																					<th>State</th>
																				</tr>
																			</thead>
																			<tbody id="table-body2">

																			</tbody>
																		</table>
																	</div>
																</div>
															</div>
															<div class="card">
																<!-- Card header -->
																<div
																	onclick="javascript:section3(${pro2.getVendorTrainingRequest().vendor_training_request_id});"
																	class="card-header" role="tab" id="headingThree3">
																	<a style="text-decoration: none" class="collapsed"
																		data-toggle="collapse" data-parent="#accordionEx"
																		href="#collapseThree3" aria-expanded="false"
																		aria-controls="collapseThree3">
																		<h5 class="mb-0">
																			PM Approval <i id="modalIcons"
																				class="fas fa-angle-down rotate-icon"></i>
																		</h5>
																	</a>
																</div>
																<!-- Card body -->
																<div id="collapseThree3" class="collapse"
																	role="tabpanel" aria-labelledby="headingThree3"
																	data-parent="#accordionEx">
																	<div class="card-body">Anim pariatur cliche
																		reprehenderit, enim eiusmod high life accusamus terry
																		richardson ad squid. 3 wolf moon officia aute, non
																		cupidatat skateboard dolor brunch. Food truck quinoa
																		nesciunt laborum eiusmod. Brunch 3 wolf moon tempor,
																		sunt aliqua put a bird on it squid single-origin
																		coffee nulla assumenda shoreditch et. Nihil anim
																		keffiyeh helvetica, craft beer labore wes anderson
																		cred nesciunt sapiente ea proident. Ad vegan excepteur
																		butcher vice lomo. Leggings occaecat craft beer
																		farm-to-table, raw denim aesthetic synth nesciunt you
																		probably haven't heard of them accusamus labore
																		sustainable VHS.</div>
																</div>
															</div>
															<div class="card">
																<!-- Card header -->
																<div
																	onclick="javascript:section4(${pro2.getVendorTrainingRequest().vendor_training_request_id});"
																	class="card-header" role="tab" id="headingFour4">
																	<a style="text-decoration: none" class="collapsed"
																		data-toggle="collapse" data-parent="#accordionEx"
																		href="#collapseFour4" aria-expanded="false"
																		aria-controls="collapseFour4">
																		<h5 class="mb-0">
																			Training Schedule <i id="modalIcons"
																				class="fas fa-angle-down rotate-icon"></i>
																		</h5>
																	</a>
																</div>
																<!-- Card body -->
																<div id="collapseFour4" class="collapse" role="tabpanel"
																	aria-labelledby="headingFour4"
																	data-parent="#accordionEx">
																	<div class="card-body">
																		<form>
																			<!-- <label>Training Dates</label> -->
																			<div class="form-group">
																				<div class="row">
																					<div class="col-4">
																						<label>Start Date</label>
																					</div>
																					<input type="date" class="form-control-sm"
																						id="startDate">
																				</div>
																				<div style="margin-top: 0.4rem;" class="row">
																					<div class="col-4">
																						<label>End Date</label>
																					</div>
																					<input type="date" class="form-control-sm"
																						id="endDate">
																				</div>
																			</div>
																			<hr>
																			<div class="form-group">
																				<div class="row">
																					<div class="col-4">
																						<label>Participants</label>
																						<!-- <i class="fas fa-users"></i> -->
																					</div>
																					<input type="number"
																						placeholder="Participants Count"
																						class="form-control-sm" id="participants">
																				</div>
																			</div>
																			<hr>
																			<label>Training Type</label>
																			<div class="form-check">
																				<input class="form-check-input" type="radio"
																					name="exampleRadios" id="classRoom" value="option1">
																				<label class="form-check-label" for="classRoom">
																					Class Room </label>
																			</div>
																			<div class="form-check">
																				<input class="form-check-input" type="radio"
																					name="exampleRadios" id="online" value="option2">
																				<label class="form-check-label" for="online">
																					Online </label>
																			</div>
																			<div id="classRoomForm" class="form-group">
																				<div class="row">
																					<div class="col">
																						<br> <input id="city" placeholder="City"
																							type="text" class="form-control">
																					</div>
																				</div>
																				<div style="margin-top: 0.4rem;" class="row">
																					<div class="col">
																						<input id="state" placeholder="State" type="text"
																							class="form-control">
																					</div>
																				</div>
																				<div style="margin-top: 0.4rem;" class="row">
																					<div class="col">
																						<input id="country" placeholder="Country"
																							type="text" class="form-control">
																					</div>
																				</div>
																				<div style="margin-top: 0.4rem;" class="row">
																					<div class="col">
																						<input id="zipcode" placeholder="Zipcode"
																							type="number" pattern="\d*" max="99999"
																							class="form-control">
																					</div>
																				</div>
																				<div style="margin-top: 0.4rem;" class="row">
																					<div class="col">
																						<input id="location" placeholder="Location"
																							type="text" class="form-control">
																					</div>
																				</div>
																				<div style="margin-top: 0.4rem;" class="row">
																					<div class="col">
																						<input id="room" placeholder="Room Number"
																							type="text" class="form-control">
																					</div>
																				</div>
																			</div>
																			<div id="onlineForm" class="form-group">
																				<div class="row">
																					<div class="col">
																						<br> <input id="url"
																							placeholder="Training URL" type="text"
																							class="form-control">
																					</div>
																				</div>
																				<div style="margin-top: 0.4rem;" class="row">
																					<div class="col">
																						<input id="audio" placeholder="Training Audio"
																							type="text" class="form-control">
																					</div>
																				</div>
																			</div>
																			<button style="float: right" type="submit"
																				class="btn btn-primary">Submit</button>
																			<br>
																		</form>
																	</div>
																</div>
															</div>
														</div>
														<!-- Accordion end -->
													</div>
													<div class="col">
														<div id="card" class="card">
															<div id="card-body" class="card-body">
																<h5 class="card-title">Progress</h5>
																<p class="card-text">Summary of the progress of this
																	training request is shown below</p>
															</div>
															<ul class="list-group list-group-flush">
																<li class="list-group-item">Shortlist Vendor <span
																	id="completed" title="Completed" class="dot"></span>
																</li>
																<li class="list-group-item">Procurement Team
																	Shortlist <span id="completed" title="Completed"
																	class="dot"></span>
																</li>
																<li class="list-group-item">PM Approval <span
																	id="inprogressdot" title="In Progress" class="dot"></span>
																</li>
																<li class="list-group-item">Training Schedule <span
																	id="pending" title="Pending" class="dot"></span>
																</li>
															</ul>
														</div>
													</div>
												</div>
											</div>
											<!-- Modal footer -->
											<div class="modal-footer">
												<button class="btn btn-primary">Save</button>
											</div>
										</div>
									</div>
								</div>

								<!-- Yosuf ElSaadany 3/15/2019 11:06 pm Adding Approval Email Popup -->
								<i id="modalIcons" title="Upload" data-toggle="modal"
									data-target="#approval" class="fas fa-upload"></i>
								<div class="modal" id="approval">
									<div class="modal-dialog modal-md">
										<div class="modal-content">
											<!-- Modal Header -->
											<div class="modal-header">
												<div class="modal-title">Attach Approval Email</div>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>
											<!-- Modal body -->
											<div class="modal-body">
												<input type="file" />
											</div>
											<!-- Modal footer -->
											<div class="modal-footer">
												<button class="btn btn-primary">Upload</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div id="inprogress" class="col-md-3"
				style="border: 10px solid lightgreen; border-style: none none none solid;">
				<h4>In Progress</h4>
				<c:forEach var="pro3" items="${vendorTrainingRequestList3}">
					<div class="card" style="margin-top: 20px; width: 14rem;">
						<div class="card-body">
							<h5 class="card-title">
								<span> <i class="fa fa-id-card" aria-hidden="true"
									style="color: #3c8dbc; float: inherit;"></i>
									${pro3.getVendorTrainingRequest().vendor_training_request_id}
								</span> <span style="float: right;"> <img id="vendor_icon2"
									style="margin-top: 27px;"
									src="<c:url value="/resources/img/vendor-icon-placeholder.png" />" />
								</span>
							</h5>
							<hr style="width: 90%; border-color: #b9b9b9;">
							<h6 class="card-subtitle mb-2 text-muted">
								<i class="fas fa-network-wired"
									style="float: none; margin-right: 5px;"></i>${pro3.getTrainingRequest().request_training_module}
							</h6>
							<p class="card-text">Take attendence</p>
						</div>
					</div>
				</c:forEach>
				<br>
			</div>
		</div>
		<br> <br> <br>
	</div>

	<!-- Footer -->
	<footer class="py-0"
		style="background-color: #3c8dbc; width: 100%; bottom: 0; position: fixed;">
	<div class="container">
		<p class="m-0 text-left text-white"
			style="position: relative; top: 10px">Version 0.0.1</p>
		<p class="m-0 text-right text-white"
			style="position: relative; top: -14px">
			Copyright 2019</b>
		</p>
	</div>
	</div>
	</footer>

	<script>
		$(document).ready(
				function() {
					$('#hidebutton').click(function() {
						if ($('#inprogress').is(':visible')) {
							$('#inprogress').hide();
							$('processing-col').removeClass("col-md-4");
							$('processing-col').addClass("col-5");
							$('#itog').removeClass("fa-toggle-on");
							$('#itog').addClass("fa-toggle-off");
						} else {
							$('#inprogress').show();
							$('processing-col').removeClass("col-5");
							$('processing-col').addClass("col-md-4");
							$('#itog').removeClass("fa-toggle-off");
							$('#itog').addClass("fa-toggle-on");
						}
					});

					$("[id^=p_module_icon]").hover(function() {
						var id = this.id.substring(14, 15);
						var vendis = $('#module-overlay-'+id);
						vendis.css("visibility", "visible");
					}, function() {
						var id = this.id.substring(14, 15);
						//console.log(id+' id');
						var vendis = $('#module-overlay-'+id);
						vendis.css("visibility", "hidden");
					}); 
					
					$("[id^=p_date_icon]").hover(function() {
						var id = this.id.substring(12, 13);
						var vendis = $('#date-overlay-'+id);
						vendis.css("visibility", "visible");
					}, function() {
						var id = this.id.substring(12, 13);
						var vendis = $('#date-overlay-'+id);
						vendis.css("visibility", "hidden");
					}); 		
					
					$("#bpbutton").click(function(e){
					    if($('input[type=checkbox]:checked').length == 0){
					    	alert("Please select minimum one checkbox");
					    	/* $('#toProcessing-ddm').hide(); */
					    } else {
					    	/* $('#toProcessing-ddm').show(); */
					    	var checkedIds = $(".chk:checked").map(function() {
							    return this.id.substring(11,16);
							    }).toArray();		  
				    		var itl = 'toProcessing/it/'+checkedIds;
			    		  	var dtl = 'toProcessing/dt/'+checkedIds.join(",");
						  	var vtl = 'toProcessing/vt/'+checkedIds.join();
						    $("#it-link").attr("href", itl);
					    	$("#dt-link").attr("href", dtl);
						  	$("#vt-link").attr("href", vtl);
						  /* alert("You selected: " + checkedIds.join(", ") + " to process"); */
					    }
					});
					
					$('#sb').change(
							function() {
								$('.card').show();
								var filter = $(this).val(); // get the value of the input, which we filter on
								$('.container').find(
										".card-title:not(:contains(" + filter
												+ "))").parent().css('display',
										'none');
							});
				});
	</script>


	<!-- Yosuf ElSaadany 3/24/2019 10:30pm -->
	<!-- All Ajax Requests -->
	<script>
	
	// Open Vendor Modal from SPOC Vendor Shortlist
	function openVendorModal(id) {
		$.ajax({
        	type: "POST",
            url : 'vendorModal',
            success : function(data) {   
           		//alert('Modal Open');
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) { 
                alert("Status: " + textStatus); alert("Error: " + errorThrown); 
            }   
		});
	}
	
	// Open Modal
	function ajax(id) {
		$.ajax({
        	type: "POST",
            url : 'process',
            success : function(data) {   
           		//alert('Modal Open');
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) { 
                alert("Status: " + textStatus); alert("Error: " + errorThrown); 
            }   
		});
	}
	
	// Section 1 accordion
	function section1(id) {
		$("#vendorSPOC").find("tr:gt(0)").remove();
		$.ajax({
        	type: "POST",
        	data: {id: id},
            url : 'section1',
            success : function(data) {
            	for(var i = 0; i < data.length; i++){
    				var shortlistSPOC = data[i];
            		var tr = '<tr><td>' + shortlistSPOC.vendor_name +  '</td><td>' + shortlistSPOC.vendor_phone +  '</td><td>' + shortlistSPOC.vendor_email +  '</td><td>' + shortlistSPOC.vendor_city +  '</td><td>' + shortlistSPOC.vendor_state +  '</td></tr>';
            		$('#table-body1').append(tr);
            	}       
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) { 
                alert("Status: " + textStatus); alert("Error: " + errorThrown); 
            }   
		});
	}
	
	// Section 2 accordion
	function section2(id) {
		$("#vendorPT").find("tr:gt(0)").remove();
		$.ajax({
        	type: "POST",
        	data: {id: id},
            url : 'section2',
            success : function(data) {
            	for(var i = 0; i < data.length; i++){
    				var shortlistPT = data[i];
            		var tr='<tr><td>' + shortlistPT.vendor_name +  '</td><td>' + shortlistPT.vendor_phone +  '</td><td>' + shortlistPT.vendor_email +  '</td><td>' + shortlistPT.vendor_city +  '</td><td>' + shortlistPT.vendor_state +  '</td></tr>';
            		$('#table-body2').append(tr);
            	}       
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) { 
                alert("Status: " + textStatus); alert("Error: " + errorThrown); 
            }   
		});
	}
	
	// Section 3 accordion
	function section3() {
		alert('Accordion 3 clicked');
	}
	
	// Section 4 accordion
	function section4() {
		alert('Accordion 4 clicked');
	}
	
	</script>
	<!-- Yosuf ElSaadany - Script to
	prevent user from selecting an end
	date less than the start date
	<script>
    var start = $('#startDate').val();
    var end = $('#endDate').val();

    $('#startDate').change(function () {
      if (start)
        end.attr("min",start);
    }, false);

    $('#endDate').change(function () {
      if (end)
        start.max = end.value;
    }, false);
  </script> -->

</body>
</html>