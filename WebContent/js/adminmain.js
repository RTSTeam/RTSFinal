var adminmain = angular.module('ui.bootstrap.demo', ['ui.bootstrap', 'mgcrea.ngStrap']);

adminmain.controller("AdminInfo", function($scope, $http ) {
	$scope.personinfos = [];
	$scope.getPersonInfoData = function(useridinput, resultVarName) {
		var params = $.param({ 	
			userID: useridinput
		});
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/userpersoninfo",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config) {
			$scope[resultVarName] = data;
	
			if(angular.isArray(data.personinfo)){
				$scope.personinfos = data.personinfo;
			}
	
			else{
				$scope.personinfos[0]=data.personinfo;
			}
	
			$scope.canShow = true;
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
		});
	};
});

adminmain.controller("Ticket", function($scope, $http ) {
	$scope.ticket = {
			departureStationValue: "",
			arrivalStationValue: "",
			departureDate: "",
			departureTime: "",
			arrivalDate: "",
			arrivalTime: "",
			price: "",
			totalqty: "",
			avalqty: ""
	};
	$scope.ticketqtys=[];
	$scope.tickets=[];
	$scope.stationArray = [];
	$scope.canShow=false;
	
	var oriTicket = angular.copy($scope.ticket);
	$scope.resetForm = function () {
      	$scope.ticket = angular.copy(oriTicket);
      	$scope.canShow = false;
    };

    $scope.isUserChanged = function () {
      	return !angular.equals($scope.ticket, oriTicket);
    };
    
    $scope.updateQty = function(ticketIDInput, newticket,resultVarName){
		var params = $.param({
			ticketID: ticketIDInput,
			newtotalqty: newticket.totalqty,
			newavailqty: newticket.availqty
		});
		
		alert("hi");
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/adminupdateqty",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			
		}).success(function (data, status, headers, config) {
			//$scope[resultVarName] = data;
			alert("hi");
			
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
			alert("fail");
		});
	};
    
	$scope.findAllQty = function(){
		var params = $.param({ 	
		});
		
		//alert("hi");
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/findallqty",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			
		}).success(function (data, status, headers, config) {
			//$scope[resultVarName] = data;
			if(angular.isArray(data.ticket)){
				$scope.ticketqtys = data.ticket;
				
			}
			
			else{
				$scope.ticketqtys[0]=data.ticket;
				//alert("success");
			}
			$scope.canShowResult=true;
			//alert("hi");
			
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
			//alert("fail");
		});
	};
	
	
	
	$scope.queryAllStation = function () {
		var params = $.param({ 	
		});
		
		//alert("hi");
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/findallstation",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			
		}).success(function (data, status, headers, config) {
			//$scope[resultVarName] = data;
			if(angular.isArray(data.station)){
				$scope.stationArray = data.station;
				
			}
			
			else{
				$scope.arrivalStationArray[0]=data.station;
				//alert("success");
			}
			$scope.canShowResult=true;
			alert("hi");
			
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
			alert("fail");
		});
	};
	
	$scope.submitData = function (ticket, resultVarName) {
		var params = $.param({ 	
			departureStationValue: ticket.departureStationValue.stationFullName,
			arrivalStationValue:ticket.arrivalStationValue.stationFullName,
			departureDate: ticket.departureDate,
			departureTime: ticket.departureTime,
			arrivalDate: ticket.arrivalDate,
			arrivalTime: ticket.arrivalTime,
			price: ticket.price,
			totalqty: ticket.totalqty,
			avalqty: ticket.avalqty
		});
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/adminaddticket",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config) {
			$scope[resultVarName] = data;
			if(angular.isArray(data.ticket)){
				$scope.tickets = data.ticket;
				$scope.canShow = true;
			} else if(data.ticket==null){
				$scope.canShow = false;
			}
			else{
				$scope.tickets[0]=data.ticket;
				$scope.canShow = true;
			}
			//$scope.users = data.user;

		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
		});
	};
});


adminmain.controller("Refund", function($scope, $http) {
	$scope.transactions = [];
	$scope.refunds = [];
	$scope.showTable=false;
	$scope.getRefundingData = function (resultVarName) {
		var params = $.param({ 	
		});
		
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/adminqueryrefund",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config) {
			$scope[resultVarName] = data;
			if(angular.isArray(data.transaction)){
				$scope.transactions = data.transaction;
				$scope.showTable = true;
			}
			else if(data.transaction==null){
				$scope.showTable = false;
			}
			else{
				$scope.transactions[0]=data.transaction;
				$scope.showTable = true;
			}
			
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
		});
	};
	
	$scope.returnRefund = function (tranIDinput, ticketIDInput, qtyInput,  resultVarName) {
		var params = $.param({ 	
			tranID: tranIDinput,
			ticketID: ticketIDInput,
			qty: qtyInput
		});
		alert("hi");
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/admindorefund",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config) {
			if(angular.isArray(data.refund)){
				$scope.refunds = data.refund;
			}
			
			else{
				$scope.refunds[0]=data.refund;
			}

			//$scope.transactions = data.transaction;
			$scope.canShow = true;
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
		});
	};
	
});

adminmain.controller("Station", function($scope, $http ) {
	$scope.station = {
    		stationabbrevation: "",
    		stationfullname: ""
  		};
	
	$scope.stations = [];
	 var oriStation = angular.copy($scope.station);
	
	$scope.isUserChanged = function () {
	      	return !angular.equals($scope.station, oriStation);
	    };
	 
	$scope.canShowResult=false;
	$scope.canShowNewResult=false;
	$scope.message=null;
	
	$scope.resetForm = function () {
      	$scope.station = angular.copy(oriStation);
      	//$scope.userForm.$setPristine();
    };
	
	$scope.findAllStation = function () {
		var params = $.param({ 	
		});
		
		$http({
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/findallstation",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			
		}).success(function (data, status, headers, config) {
			//$scope[resultVarName] = data;
			if(angular.isArray(data.station)){
				$scope.stations = data.station;
				
			}
			
			else{
				$scope.stations[0]=data.station;
				//alert("success");
			}
			$scope.canShowResult=true;
			
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
			//alert("fail");
		});
	};
	
	$scope.submitData = function (station, resultVarName) {
		var params = $.param({ 	
    		//stationid: station.id,
    		stationabbrevation: station.abbrevation,
    		stationfullname: station.fullname
		});

		$http({
			
			method: "POST",
			url: "http://localhost:8080/RTSProject/rest/insertstation",
			data: params,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function (data, status, headers, config) {
			$scope[resultVarName] = data;
			$scope.message = data;
			$scope.canShowNewResult=true;
			alert($scope.message);
		}).error(function (data, status, headers, config) {
			$scope[resultVarName] = "SUBMIT ERROR";
		});
	};
});
