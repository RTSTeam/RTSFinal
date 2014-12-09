var app = angular.module('ui.bootstrap.demo', []);
var luhnChk = function(cc) {
	// digits 0-9 doubled with nines cast out
    var doubled = [0, 2, 4, 6, 8, 1, 3, 5, 7, 9];

    // remove non-digit characters
    cc = cc.replace(/[^\d]/g, '');
    var digits = cc.split('');

    // alternate between summing the digits
    // or the result of doubling the digits and
    // casting out nines (see Luhn description)
    var alt = false;
    var total = 0;
    while (digits.length)
    {
        var d = Number(digits.pop());
        total += (alt ? doubled[d] : d);
        alt = !alt;
    }
    return total % 10 == 0;
};
 
app.controller
  ( 'MainCtrl'
  , function($scope,$locale) {
      $scope.currentYear = new Date().getFullYear();
      $scope.currentMonth = new Date().getMonth() + 1;
      $scope.months = $locale.DATETIME_FORMATS.MONTH;
      $scope.ccinfo = {type:undefined};
      $scope.save = function(data){
        if ($scope.paymentForm.$valid){
          console.log(data); // valid data saving stuff here
        }
      };
      $scope.ccinfo = {
      month: "",
      year: ""
      };
    }
  );
 
 
app.directive
  ( 'cardExpiration'
  , function(){
      var directive =
        { require: 'ngModel'
        , link: function(scope, elm, attrs, ctrl){
            scope.$watch('[ccinfo.month,ccinfo.year]',function(value){
              ctrl.$setValidity('invalid',true);
              if ( scope.ccinfo.year == scope.currentYear
                   && scope.ccinfo.month <= scope.currentMonth
                 ) {
                ctrl.$setValidity('invalid',false);
              }
              return value;
            },true);
          }
        };
      return directive;
      }
    );
 
app.filter
  ( 'range'
  , function() {
      var filter = 
        function(arr, lower, upper) {
          for (var i = lower; i <= upper; i++) arr.push(i)
          return arr;
        };
      return filter;
    }
  );
  
  app.directive('luhnCheck', function() {
  return {
    restrict: 'A',
    require: 'ngModel',
    link: function(scope, element, attributes, ngModel) {

      function luhnCheck(value) {
                    ngModel.$setValidity('luhn-check', luhnChk(value));
                    return value;
      }

      ngModel.$parsers.push(luhnCheck);
      ngModel.$formatters.push(luhnCheck);
    }

  };
});

