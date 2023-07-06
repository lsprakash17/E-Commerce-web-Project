<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter new Password</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-success">${pass}</h1>
	<header>
		<!--Amazon Image Logo-->
		<div class="d-flex flex-row justify-content-center">
			<div class="row">
				<div class="col-md">
					<img class="img_1"
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7Uc6UsC7gxuxLzbVoESCDevNUeW4y0MarrA&usqp=CAU"
						alt="Amazon Logo" />
				</div>
				<!--Col 1 End-->
			</div>
			<!--Row 1 End-->
		</div>
		<!--Container End-->
		<!--Amazon Image Logo-->
	</header>
	<div class="d-flex flex-row justify-content-center">
		<div class="row">
			<div class="col-md">
			 <form action="/merchant/ResetPassword" method="post">
			  <div class="form-group">
						<input
							type="hidden" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp"  name="email"
							value="${merchant.getEmail()}"> <small id="emailHelp"
							class="form-text text-muted"></small>
					</div>
					<div class="form-group">
						<label id="words_2" for="exampleInputPassword1">Enter New Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="New Password" name="password"> <br>
						<div class="form-group">
							<button type="submit" class="btn btn-warning" id="sign-in"
								style="margin-right: 70px;">Submit</button>
							<button type="reset" class="btn btn-warning"
								style="margin-left: 110px;">Clear</button>
						</div>
					</div>
			 </form>
			</div>
		</div>
	</div>
</body>
</html>