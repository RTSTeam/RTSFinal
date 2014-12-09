<!doctype html>
<html ng-app="ui.bootstrap.demo" >
<head>
  <meta charset="utf-8">
  <title>AngularJS Credit Card Validation Example</title>

  <link rel="stylesheet" href="css/creditcard.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular-resource.min.js"></script>
  <script src="js/creditcard.js"></script>
</head>
<body>
  <form novalidate name="paymentForm" ng-controller="MainCtrl">
    <input
      type="text"
      name="creditCard"
      ng-model="ccinfo.number"
      required
      data-credit-card-type
      data-ng-pattern="/^[0-9]+$/"
      data-ng-minlength="15"
	  ng-model-options="{ updateOn: 'blur' }" 
      luhn-check
	  maxlength="19"
      placeholder="Card Number" >{{ccinfo.type}}
		  <span ng-show="paymentForm.creditCard.$error.pattern">Credit card must consist of only numbers</span>
		  <span ng-show="paymentForm.creditCard.$error.minlength">Credit card must be 15-19 digits</span>
		  <span ng-show="paymentForm.creditCard.$error.invalid">Credit card must be a valid Amex, Visa, Discover, or Master Card</span>
		  <span ng-show="paymentForm.creditCard.$error['luhn-check']" class='error'>Error: failed Luhn check</span>
		  <span ng-show="paymentForm.creditCard.required && paymentForm.creditCard.$pristine">Credit Card number required</span>
	<br/>
    <input
      type="text"
      name="securityCode"
      ng-model="ccinfo.securityCode"
      placeholder="CCV"
      required
      data-ng-pattern="/^[0-9]+$/"
      data-ng-minlength="3"
      maxlength="4">
    
    <div ng-show="paymentForm.submitAttempt && !paymentForm.$valid">
	  <div ng-show="myForm.number.$error['luhn-check']" class='error'>Invalid card number</div>	
      <div ng-show="paymentForm.securityCode.$error.pattern">Security code must contain only numbers</div>
      <div ng-show="paymentForm.securityCode.$error.minlength">Security code must be 3-4 digits</div>
      <div ng-show="paymentForm.securityCode.$error.required">Security code required</div>
    </div>
	
	<br/>
    <select ng-model="ccinfo.month" name="month" data-card-expiration required>
      <option disabled selected value="">Month</option>
      <option ng-repeat="month in months" value="{{$index+1}}" > {{$index+1}} - {{month}}</li>
    </select>
    <br/>
    <ul ng-show="paymentForm.submitAttempt && !paymentForm.$valid">
      <li ng-show="paymentForm.month.$error.required">Expiration month required</li>
    </ul>
    <select ng-model="ccinfo.year" name="year" required>
      <option disabled selected value="">Year</option>
      <option ng-repeat="year in [] | range:currentYear:currentYear+13">{{year}}</li>
    </select>
    <br/>
    <ul ng-show="paymentForm.submitAttempt && !paymentForm.$valid">
      <li ng-show="paymentForm.year.$error.required">Expiration year required</li>
      <li ng-show="paymentForm.month.$error.invalid">Provided expiration date is invalid</li>
    </ul>
    <button ng-click="paymentForm.submitAttempt=true;save(ccinfo)" type="submit">Submit</button>

  </form>
    <pre>form = {{ccinfo | json}}</pre>
    <pre>master = {{master | json}}</pre>
</body>
</html>