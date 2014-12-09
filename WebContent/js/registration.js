var app = angular.module('form-example1', ['ui.bootstrap']);

app.controller('appCtrl', function($scope, $http ) {
	$scope.user = {
			username: "",
			password: "",
  			fname: "",
  			lname:"",
  			birthday:"",
  			email:""
  		};
	$scope.users = [];
	$scope.welcomeMsg = null;
	$scope.canShowForm=true;
	$scope.canShowResult = false;
    
    var oriUser = angular.copy($scope.user);

    $scope.resetForm = function () {
      	$scope.user = angular.copy(oriUser);
      	$scope.userForm.$setPristine();
      	$scope.canShow = false;
    };

    $scope.isUserChanged = function () {
      	return !angular.equals($scope.user, oriUser);
    };
    
	$scope.submitData = function (user, resultVarName) {
    var params = $.param({ 	
    	    username: user.username,
	    	password: user.password,
	    	fname: user.fname,
	    	lname: user.lname,
	    	birthday: user.birthday,
	    	email: user.email
    });
	$http({
		method: "POST",
		url: "http://localhost:8080/RTSProject/rest/registration",
		data: params,
		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	}).success(function (data, status, headers, config) {
		$scope[resultVarName] = data;
		$scope.users = data.user;
		$scope.welcomeMsg = data.msg;
		$scope.canShowForm=false;
		$scope.canShowResult = true;
	}).error(function (data, status, headers, config) {
		$scope[resultVarName] = "SUBMIT ERROR";
	});
	};
  });

app.directive('username', function($q, $timeout) {
  return {
    require: 'ngModel',
    link: function(scope, elm, attrs, ctrl) {
    var usernames = ['Jim', 'John', 'Jill', 'Jackie'];

      ctrl.$asyncValidators.username = function(modelValue, viewValue) {

        if (ctrl.$isEmpty(modelValue)) {
          // consider empty model valid
          return $q.when();
        }

        var def = $q.defer();

        $timeout(function() {
          // Mock a delayed response
          if (usernames.indexOf(modelValue) === -1) {
            // The username is available
            def.resolve();
          } else {
            def.reject();
          }

        }, 2000);

        return def.promise;
      };
    }
  };
});

app.controller('DatepickerDemoCtrl', function ($scope) {
    $scope.today = function() {
      $scope.birthday = new Date();
    };
    $scope.today();

    $scope.clear = function () {
      $scope.birthday = null;
    };

    // Disable weekend selection
    $scope.disabled = function(date, mode) {
      return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
    };

    $scope.toggleMin = function() {
      $scope.minDate = $scope.minDate ? null : new Date();
    };
    $scope.toggleMin();
    
    $scope.toggleMax = function() {
        $scope.maxDate = $scope.maxDate ? null : new Date();
      };
    $scope.toggleMax();
    
    $scope.open = function($event) {
      $event.preventDefault();
      $event.stopPropagation();

      $scope.opened = true;
    };

    $scope.dateOptions = {
      formatYear: 'yy',
      startingDay: 1
    };

    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
  });
app.directive("passwordVerify", function() {
	   return {
	      require: "ngModel",
	      scope: {
	        passwordVerify: '='
	      },
	      link: function(scope, element, attrs, ctrl) {
	        scope.$watch(function() {
	            var combined;

	            if (scope.passwordVerify || ctrl.$viewValue) {
	               combined = scope.passwordVerify + '_' + ctrl.$viewValue; 
	            }                    
	            return combined;
	        }, function(value) {
	            if (value) {
	                ctrl.$parsers.unshift(function(viewValue) {
	                    var origin = scope.passwordVerify;
	                    if (origin !== viewValue) {
	                        ctrl.$setValidity("passwordVerify", false);
	                        return undefined;
	                    } else {
	                        ctrl.$setValidity("passwordVerify", true);
	                        return viewValue;
	                    }
	                });
	            }
	        });
	     }
	   };
	});
