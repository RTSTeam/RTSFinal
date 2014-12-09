<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html ng-app="ui.bootstrap.demo">
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.js"></script>
<script
	src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.0.js"></script>
<script src="js/main.js"></script>
<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet"> -->

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.1.2/angular-strap.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.1.2/angular-strap.tpl.min.js"></script>

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<!-- credit card css -->
<link rel="stylesheet" href="css/creditcard.css">

<!-- shake css -->
<link rel="stylesheet" href="css/csshake.min.css">

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	var avaiQty = 1 ;
	var soldQty = 1;
  	google.load("visualization", "1", {packages:["corechart"]});
  	// google.setOnLoadCallback(drawChart);
  	function drawChart() {
	
    	var data = google.visualization.arrayToDataTable([
      		[ 'Tickets Status', 'numbers'],
      		[ 'Available Quantity', parseInt(avaiQty)],
	  		[ 'Sold Quantity', parseInt(soldQty)]
    	]);

    	var options = {
      		title: 'Ticket Statistic of That Day',
      		pieHole: 0.4,
    	};

    	var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
		chart.draw(data, options);
  	}
  	$(document).ready(function(){
		$("#depatureTime").blur(function(){
			var departureStationID = parseInt($("#departureStationSel").val()) + 1;	// get departure station id
			var arrivalStationID = parseInt($("#arrivalStationSel").val()) + 1;		// get arrival station id
			var departureDate = $("#departureDate").val();
			//alert(departureStationID + "-" + arrivalStationID + "-" + departureDate);
			
			var sendInfo = {
				departureStationID: departureStationID,
				arrivalStationID: arrivalStationID,
				departureDate: departureDate
			}; 
			
			$.ajax({
				url: "http://localhost:8080/RTSProject/rest/ticketChart",
				type: "post",
				dataType: "xml",
				data: sendInfo,
				success:showTickets
			});
		});
	});
	function showTickets(response) {
		// if datatype: "json", 
		// avaiQty = response.avaiQty;
		avaiQty = $(response).find("avaiQty").text();  
		soldQty = $(response).find("soldQty").text();
		//alert(avaiQty);
		//alert(soldQty);
		drawChart();
	}
</script>
    
</head>
<body>

	<div ng-controller="SearchCtrl" data-ng-init="getStation('ajaxResult')">
		<nav>

		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="shake shake-slow">
					<p class="navbar-brand" href="">Good Afternoon, ${userid}</p>
				</div>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<form class="navbar-form navbar-right" role="form">
					<div class="shake shake-slow">
					<a type="button" class="btn btn-primary"
						href="<c:url value='/j_spring_security_logout'/>">I am Logout! Can you find me?
					</a>
					</div>
				</form>
			</div>
		</div>
		</nav>
		<tabset class="padding"> 
		<tab heading="Search">
		<div class="row">
			<div class="col-md-6">
				<form name="userForm" class="css-form"
					ng-submit="submitData(user, 'ajaxResult')" novalidate>
					<div ng-show="false" class="row">
						<div class="col-md-2">
							<input id="onewayRadio" type="radio" ng-model="user.tripType"
								value="One Way"><label for="onewayRadio">One Way</label>
						</div>
						<div class="col-md-2">
							<input id="roundtripRadio" type="radio" ng-model="user.tripType"
								value="Round Trip" /><label for="roundtripRadio">Round
								Trip</label>
						</div>
					</div>
		
					<p></p>
					<div class="controls">
						<label for="departureStationSel">From:</label> 
						<select
							class="form-control" id="departureStationSel"
							ng-model="user.departureStationValue"
							ng-options="station.stationFullName for station in stations">
						</select>
					</div>
					<div class="controls">
						<label for="arrivalStationSel">To:&nbsp; &nbsp; &nbsp;</label> <select
							class="form-control" id="arrivalStationSel"
							ng-model="user.arrivalStationValue"
							ng-options="station.stationFullName for station in stations"> <!-- ng-options="arrivalStation for arrivalStation in arrivalStationArray" -->
						</select>
					</div>
					<br />
					<div class="controls">
						<label class="control-label"><i class="fa fa-calendar"></i>
							I Want to Departure After:</label><br>
						<div class="form-group">
							<input type="text" size="10" class="form-control" id="departureDate"
								ng-model="user.departureDate" data-autoclose="1"
								placeholder="Date" bs-datepicker>
						</div>
						<div class="form-group" class="col-md-2">
							<input type="text" size="8" class="form-control" id="depatureTime"
								ng-model="user.departureTime" data-autoclose="1"
								placeholder="Time" bs-timepicker>
						</div>
					</div>
					<div class="padding">
						<div class="row">
							<div class="col-md-2">
								<strong>Adults:</strong>
							</div>
							<div class="col-md-2">
								<strong>Seniors:</strong>
							</div>
							<div class="col-md-2">
								<strong>Children:</strong>
							</div>
						</div>
					</div>
					<div class="padding">
						<div class="row">
							<div class="col-md-2">
								<input class="form-control" type="number" min="0" max="10"
									value="{{user.adultsValue}}" ng-model="user.adultsValue" />
							</div>
							<div class="col-md-2">
								<input class="form-control" type="number" min="0" max="10"
									value="{{user.seniorsValue}}" ng-model="user.seniorsValue" />
							</div>
							<div class="col-md-2">
								<input class="form-control" type="number" min="0" max="10"
									value="{{user.childrenValue}}" ng-model="user.childrenValue" />
							</div>
						</div>
					</div>
					<br />
					<div class="controls">
						<div class="row">
							<!-- <div class="col-md-2">&nbsp; &nbsp;<button type="button" class="btn btn-warning" ng-click="resetForm()">Reset</button></div> -->
							<div class="col-md-4">
								<button type="submit" class="btn btn-success"
									ng-disabled="userForm.$invalid">Find Trains</button>
							</div>
						</div>
					</div>
					<!-- <div id="piechart_3d" style="width: 100%; height: 300px;"></div> -->
					<!-- <pre>form = {{user | json}}</pre> -->
				</form>
			</div>
			<div class="col-md-6" id="piechart_3d" style="width: 50%; height: 300px;"></div>
		</div>
		<div ng-show="canShow">
			<table table class="table table-hover">
				<thead>
					<tr>
						<th>Ticket ID</th>
						<th>From</th>
						<th>To</th>
						<th>Departure Time</th>
						<th>Arrival Time</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="ticket in tickets">
						<td>{{ticket.ticketID}}</td>
						<td>{{ticket.departureStationName}}</td>
						<td>{{ticket.arrivalStationName}}</td>
						<td>{{ticket.departureYear}}-{{ticket.departureMonth}}-{{ticket.departureDay}}&nbsp;{{ticket.departureHour}}:{{ticket.departureMinute}}</td>
						<td>{{ticket.arrivalYear}}-{{ticket.arrivalMonth}}-{{ticket.arrivalDay}}&nbsp;{{ticket.arrivalHour}}:{{ticket.arrivalMinute}}</td>
						<td>{{(user.adultsValue + user.seniorsValue +
							user.childrenValue) * ticket.price}} Dollars</td>
						<td>
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#myModal">Buy</button>
							<div ng-controller="MainCtrl" class="modal fade" id="myModal"
								tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
											
											<div ng-show="true">
												<div class="modal-header">
													
													<h4 class="modal-title" id="myModalLabel">Enter Credit
														Card Information:</h4>
												</div>
												<div class="modal-body">
													
														<form novalidate name="paymentForm" ng-controller="MainCtrl">
														<!-- card holderName -->
															<input style="width:200px" class="form-control" type="text" name="holderName" required minlength="3" maxlength="25" placeholder="Card Holder's name">
														<br/>
														<!-- card number -->
															<input style="width:200px" class="form-control" type="text" name="creditCard"
																ng-model="ccinfo.number" required 
																data-ng-pattern="/^[0-9]+$/" data-ng-minlength="15"
																ng-model-options="{ updateOn: 'blur' }" luhn-check type-check
																maxlength="19" placeholder="Card Number">{{ccinfo.type}}
															<br/>
															<span style="color:red"
																	ng-show="paymentForm.creditCard.$error['type-check']"
																	class='error'>Invalid card type</span>
															<span style="color:red" ng-show="paymentForm.creditCard.$error.pattern">Credit
																card must consist of only numbers</span> 
															<span style="color:red"
																ng-show="paymentForm.creditCard.$error.minlength">Credit
																card must be 15-19 digits</span> 
															<span style="color:red" ng-show="paymentForm.creditCard.$error.invalid">Credit
																card must be a valid Amex, Visa, Discover, or Master Card</span>
															<div class="shake shake-slow">
																<span style="color:red"
																	ng-show="!(paymentForm.creditCard.$error.minlength) && paymentForm.creditCard.$error['luhn-check']"
																	class='error'>Invalid card number</span>
															</div>	 
															<span style="color:red"
																ng-show="paymentForm.creditCard.required && paymentForm.creditCard.$pristine">Credit
																Card number required</span> 
																
																<br /> 
															<input class="form-control" style="width:70px"
																type="text" name="securityCode"
																ng-model="ccinfo.securityCode" placeholder="CCV" required
																data-ng-pattern="/^[0-9]+$/" data-ng-minlength="3"
																maxlength="4">

															<div
																ng-show="paymentForm.submitAttempt && !paymentForm.$valid">
															
																<div ng-show="paymentForm.securityCode.$error.pattern">Security
																	code must contain only numbers</div>
																<div ng-show="paymentForm.securityCode.$error.minlength">Security
																	code must be 3-4 digits</div>
																<div ng-show="paymentForm.securityCode.$error.required">Security
																	code required</div>
															</div>

															<br />
															<div class="widthcontrols">
																<select class="form-control" ng-model="ccinfo.month"
																	name="month" data-card-expiration required>
																	<option disabled selected value="">Month</option>
																	<option ng-repeat="month in months" value="{{$index+1}}">
																		{{$index+1}} - {{month}}
																		</li>
																</select>
															</div>
															<br />
															<ul
																ng-show="paymentForm.submitAttempt && !paymentForm.$valid">
																<li ng-show="paymentForm.month.$error.required">Expiration
																	month required</li>
															</ul>
															<div class="widthcontrols">
																<select class="form-control" ng-model="ccinfo.year"
																	name="year" required>
																	<option disabled selected value="">Year</option>
																	<option
																		ng-repeat="year in [] | range:currentYear:currentYear+13">
																		{{year}}
																		</li>
																</select>
															</div>
															<br />
															<ul
																ng-show="paymentForm.submitAttempt && !paymentForm.$valid">
																<li ng-show="paymentForm.year.$error.required">Expiration
																	year required</li>
																<li ng-show="paymentForm.month.$error.invalid">Provided
																	expiration date is invalid</li>
															</ul>

														</form>									
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														ng-click='hideShow()' data-dismiss="modal">Close</button>
													<button type="button" class="btn btn-primary"
														ng-click="hideShow(); checkout('${userid}',ticket, 'ajaxResult'); updateQty(ticket, 'ajaxResult')"
														data-dismiss="modal">Confirmed</button>
												</div>

											</div>	

									</div>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</tab>
		<!-- Transaction History --> 
		<tab heading="Transaction History"
			ng-click="getTransactionData('${userid}', 'ajaxResult')">
			<div ng-show="showTransaction">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Transaction ID</th>
						<th>Ticket ID</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Transaction Type</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="transaction in transactions">
						<td>{{transaction.tranID}}</td>
						<td>{{transaction.ticketID}}</td>
						<td>{{transaction.price * transaction.qty}}</td>
						<td>{{transaction.qty}}</td>
						<td>{{transaction.tranType}}</td>
					</tr>
				</tbody>
			</table>
		</div>
		</tab> 
		
		
		<!-- Personal Information --> 
		<tab heading="Personal Information"
			ng-click="getPersonInfoData('${userid}', 'ajaxResult'); hidePerson()">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>Username</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Birthday</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="personinfo in personinfos">
						<td>{{personinfo.userID}}</td>
						<td>{{personinfo.fname}}</td>
						<td>{{personinfo.lname}}</td>
						<td>{{personinfo.email}}</td>
						<td>{{personinfo.birthday}}</td>
					</tr>
				</tbody>
			</table>

		</tab> 
		
		
		<!-- REFUND -->
		<tab heading="Ticket Refund" ng-click="getOrderedData('${userid}', 'ajaxResult')">
		<div ng-show="showRefund">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Transaction ID</th>
						<th>Ticket ID</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Transaction Type</th>
						<th>Refund Ticket</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="ordered in ordereds">
						<td>{{ordered.tranID}}</td>
						<td>{{ordered.ticketID}}</td>
						<td>{{ordered.price * ordered.qty}}</td>
						<td>{{ordered.qty}}</td>
						<td>{{ordered.tranType}}</td>
						<td>
							<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#secondModal" ng-click="doRefund(ordered.tranID, 'ajaxResult')">
							Refund
							</button>
							<div class="control-group">
							<div class="controls">
								<div class="modal fade" id="secondModal" tabindex="-1" role="dialog">
							    	<div class="modal-dialog">
							    		<div class="modal-content">
									        <div class="modal-header">
									        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
									        <h4 class="modal-title" id="myModalLabel">Your request will be processed. Thank you.</h4>
									     
									        <button type="button" class="btn btn-default" ng-click="getOrderedData('${userid}', 'ajaxResult')" data-dismiss="modal">Close</button>
									       
							    			</div>
							  			</div>
							    	</div>
								</div>
							</div>
							</div>
						</td>		
					</tr>
				</tbody>
			</table>
			</div>
		</tab> 
		
		</tabset>

	</div>

</body>
</html>
