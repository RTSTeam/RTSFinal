<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Railway</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!--mobile version-->
	<meta name="viewpoint" content="width=device-width, initial-scale=1.0">
	<link href = "css/bootstrap.min.css" rel="stylesheet">
	<!-- search css -->
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular-resource.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
  
    <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.0.js"></script>
  
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
  
    <script src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.1.2/angular-strap.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.1.2/angular-strap.tpl.min.js"></script>
  
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <!-- added -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!--mobile version-->
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    <link href = "css/bootstrap.min.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/registration.js"></script>
    <link rel="stylesheet" href="css/registration.css"> 

    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function() {		
		$("#jQName").on("blur", function() {
			$("#userExist").hide();
			$("#nameReq").hide();
			$("#nameLength").hide();
			var name = $("#jQName").val();
			
			if(name==null){
				$("#nameReq").show();
				$(this).prop("invalid", true);
				$("#jSubmit").hide();
				$( "#jQName" ).css( "border", "3px solid orange" );	
			}
			
			else if((name.length<3) || (name.length>12)){
				$("#nameLength").show();
				$(this).prop("invalid", true);
				$("#jSubmit").hide();
				$( "#jQName" ).css( "border", "3px solid orange" );	
			}
			
			else{
				$.ajax({
					url: "http://localhost:8080/RTSProject/rest/registration/checkusernameunique",
					type: "get",
					dataType: "text",
					data: {name: $("#jQName").val()},
					async: false,
					success: function(response) {
						var result = response.toString().trim();
						if (result=="false") {
							$("#userExist").show();
							$(this).prop("invalid", true);
							$("#jSubmit").hide();
							$( "#jQName" ).css( "border", "3px solid orange" );
							//$('input[type="submit"]').attr('disabled','disabled');
							//$("#jSubmit").attr("disabled", true);
							//this.disabled = true;
						}
						else{
							$(this).prop("invalid", false);
							$( "#jQName" ).css( "border", "3px solid green" );
							//$('input[type="submit"]').removeAttr('disabled');
							$("#jSubmit").show();
						}
					},
					error: function(msg) {
						//alert(msg);
					}
				});//ajax
			}
		});
		
		$("#jQEmail").on("blur", function() {
			$("#userExist").hide();
			$.ajax({
				url: "http://localhost:8080/RTSProject/rest/registration/checkusernameunique",
				type: "get",
				dataType: "text",
				data: {name: $("#jQName").val()},
				async: false,
				success: function(response) {
					var result = response.toString().trim();
					if (result=="false") {
						$("#userExist").show();
						$(this).prop("invalid", true);
						$("#jSubmit").hide();
						$( "#jQName" ).css( "border", "3px solid orange" );
						//$('input[type="submit"]').attr('disabled','disabled');
						//$("#jSubmit").attr("disabled", true);
						//this.disabled = true;
					}
					else{
						$(this).prop("invalid", false);
						$( "#jQName" ).css( "border", "3px solid green" );
						//$('input[type="submit"]').removeAttr('disabled');
						$("#jSubmit").show();
					}
				},
				error: function(msg) {
					//alert(msg);
				}
			});
		});
	});	
	
	</script>	
</head>

<body>
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
      <div class="container">

        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <a class="navbar-brand" href="http://zhengjunli.com">Railway Trading System</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
	        	
          <form class="navbar-form navbar-right" role="form" action="<c:url value='j_spring_security_check'/>" method="POST" id="login-form">

            <div class="form-group">
              <input type="text" name="j_username" id="j_username" placeholder="Username" class="form-control"/>
            </div>

            <div class="form-group">
              <input type="password" name="j_password" id="j_password" placeholder="Password" class="form-control"/>
            </div>
            
			<button id="signin" type="submit" class="btn btn-success">Sign In</button>
			
			<div class="form-group">
			  <label for="rememberme" style="color: white">Remember me:</label>
              <input type="checkbox" name="_spring_security_remember_me" id="rememberme"/>
            </div>
          </form>
        </div><!--/.navbar-collapse -->

      </div><!--container-->
    </nav>

	<!-- wrong info -->
	    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	      <font color="red">
	        Invalid Id or Password <br/><br/>
	      </font>
    	</c:if>
			
    <div class="jumbotron">
      <div class="container">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  			Sign up &raquo;
		</button>
        <!-- <p><a class="btn btn-primary btn-lg" href="http://localhost:8080/RTSProject/registration.html" role="button">Sign up &raquo;</a></p> -->
        <div ng-app="form-example1" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div ng-controller="appCtrl" class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Register:</h4>
		      </div>
		      <div class="modal-body">
		        
			      <form name="userForm" class="form-horizontal" ng-submit="submitData(user, 'ajaxResult')" method="post" novalidate ng-show="canShowForm">
				 <!-- username -->
			        <div class="control-group">
			          <label class="control-label"  for="username">Username</label>
			          <div class="controls">
				          <input type="text" class="form-control" ng-model="user.username" id="jQName" name="username" ng-minlength="3" ng-maxlength="10" placeholder="User ID" username required/>
				      <span class="alert" id="nameReq" style="display:none;" >User name required</span>
				      <span class="alert" id="nameLength" style="display:none;" >Username length is invalid</span>
				      <span class="alert" id="userExist" style="display:none;" >The user already exists</span>
			          </div>
			        </div>
			  
			        <div class="control-group">
				      <!-- E-mail -->
				      <label class="control-label" for="email">E-mail</label>
				      <div class="controls">
				          <input type="email"  class="form-control" ng-model="user.email" name="email" ng-pattern="/^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/"  placeholder="Email"  required />
				          <span class="custom-error" style="color:red" ng-show="userForm.email.$dirty && userForm.email.$error.required">Email is required.</span>
				          <span class="custom-error" style="color:red" ng-show="userForm.email.$dirty && userForm.email.$error.email">Email is invalid.</span>
			          </div>
			        </div>
			      
			        <div class="control-group">
				      <!-- Password-->
				      <label class="control-label" for="password">Password</label>
				      <div class="controls">
			      	  	<input type="password" class="form-control" ng-model="user.password" name="password" placeholder="Password" required>
			      	  	<span class="custom-error" style="color:red" ng-show="userForm.password.$dirty && userForm.password.$error.required">Password is required.</span>
			      	  </div>
			        </div>
			   
			      
			      <!-- Password Confirm-->
			      <div class="control-group">
				      <label class="control-label" for="passwordVerify">Password Confirmation</label>
				      <div class="controls">
					  	<input type="password" class="form-control" ng-model="user.passwordVerify" name="passwordVerify" password-verify="user.password" placeholder="Type Password Again" required />
					  	<span class="custom-error" style="color:red" ng-show="userForm.passwordVerify.$dirty && userForm.passwordVerify.$error.passwordVerify">Passwords don't match.</span>
					  </div>
				  </div>
			      
			      <!-- Firstname -->
			        <div class="control-group">
			      	  
			      	  <label class="control-label" for="fname">Firstname</label>
			      	  <div class="controls">
			      	  	<input type="text" class="form-control" ng-model="user.fname" name="fname" placeholder="First Name" required/>
			      	  	<span class"error" style="color:red" ng-show="userForm.fname.$dirty && userForm.fname.$error.required">First name is required.</span>
			      	  </div>
			        </div>
			      
			        <!-- Lastname -->
			        <div class="control-group">
			      	  
			      	  <label class="control-label" for="lname">Lastname</label>
			      	  <div class="controls">
			      	  	<input type="text" class="form-control" ng-model="user.lname" name="lname" placeholder="Last Name" required/>
			      	  	<span class"error" style="color:red" ng-show="userForm.lname.$dirty && userForm.lname.$error.required">Last name is required.</span>
			      	  </div>
			        </div>
			      
			      	<!-- datePicker -->
			        <div class="control-group" ng-controller="DatepickerDemoCtrl">
			          <label class="control-label" for="lname">Birthday</label>
			          <div class="controls">
			           <input type="text" ng-model="user.birthday" name="birthday" class="form-control" datepicker-popup="dd-MMMM-yy" is-open="opened" min-date="1990-01-01" max-date="maxDate" datepicker-options="dateOptions"  data-date-format="mm/dd/yyyy" placeholder="Date of Birthday" ng-required="true" close-text="Close" required/>
			                    <button type="button" class="btn btn-default" ng-click="open($event)">
			                      <i class="glyphicon glyphicon-calendar"></i>
			                    </button>
			                  <span class"custom-error" style="color:red" ng-show="userForm.birthday.$dirty && userForm.birthday.$error.required">Birthday is required.</span>
			           </div>       
			        </div>
			        <br/>
			      </form>


		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary btn-sm" ng-click="resetForm()" ng-disabled="!isUserChanged()">Reset</button>
				<button type="button" class="btn btn-primary btn-sm" ng-disabled="userForm.$invalid" ng-click="submitData(user, 'ajaxResult')" data-dismiss="modal">Submit</button>	
		      </div>
		    </div>
		  </div>
		</div>
      </div>
    </div>
    
	<footer>
        <p style="color:white">&copy; Jack, Andy, Charlie 2014</p>
    </footer>

	</div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/login.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	
	<!-- search js -->
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.js"></script>
    <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.0.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.1.2/angular-strap.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.1.2/angular-strap.tpl.min.js"></script>


</body>
</html>