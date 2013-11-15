<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link href="<s:url value="/resources" />/css/tabtastic.css"
	rel="stylesheet" type="text/css" />


<script type="text/javascript"
	src="<s:url value="/resources" />/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript"
	src="<s:url value="/resources" />/js/jquery-ui-1.8.9.custom.min.js"></script>

<script type="text/javascript"
	src="<s:url value="/resources" />/js/menu.js"></script>

<script type="text/javascript" xml:space="preserve"
	src="<s:url value="/resources" />/js/gen_validatorv4.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						path = "${request.contextPath}"

						var userid = "${sessionScope.customer.id}";

						var t = getCookie("token");

						$('#details').hide();
						$('#qq').hide();
						$('#attr').hide();
						$("#sub_category")
								.append(
										'<option value=0>Create New Catogory Instead</option>');
						$("#sub_category").append(
								'<option value=0>--------</option>');

						makeComboBox(userid, "customCollection", "sub_category");

						$("#protype")
								.append(
										'<option value=0>Create New Type Instead</option>');
						$("#protype").append(
								'<option value=0>--------</option>');

						makeVendorBox(userid, "sub_ven");

						$("#sub_ven")
								.append(
										'<option value=0>Create New Vendor Instead</option>');
						$("#sub_ven").append(
								'<option value=0>--------</option>');

					});
</script>
<style type="text/css">
table {
	font: 11px/24px Verdana, Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

th {
	padding: 0 0.5em;
	text-align: left;
}

tr.yellow td {
	background: #FFC;
}

td {
	padding: 0 0.5em;
}

td.width {
	width: 100%;
}

td.adjacent {
	text-align: center;
}

.bold {
	font-weight: bold;
}
</style>
</head>
<body class="body">
	<div id="add">
		<ul id="sddm">
			<li><a href="#" onmouseover="mopen('m1')"
				onmouseout="mclosetime()">Add By Template</a>
				<div id="m1" onmouseover="mcancelclosetime()"
					onmouseout="mclosetime()">


					<a href="/store/addProduct">Add Product</a> <a
						href="/store/addProduct">Create New Template</a>

				</div></li>
		</ul>
		<div style="clear: both"></div>
		<form:form action="${request.contextPath}/store/product/newProduct"
			method="post" name="proform" commandName="product"
			enctype="multipart/form-data">
			<!--<p><g:link action="by">Add By Template</g:link> </p>    -->
			<table cellpadding="3">
				<tr>
					<td>${error }</td>
				</tr>
				<tr>
					<td><label for="product"> Product Title <span
							class="required-indicator">*</span>
					</label></td>
				</tr>
				<tr>
					<td><form:input path="name" id="proname" />

						<div id='titleerror' class="error_strings"></div></td>
				</tr>
				<tr>
					<td><label for="product"> Product ID <span
							class="required-indicator">*</span>
					</label></td>
				</tr>
				<tr>
					<td><form:input path="pro_id" id="proid" />

						<div id='iderror' class="error_strings"></div></td>
				</tr>
				<tr>
					<td>Tags (Use comma (,) as a delimiter for Multiple values)</td>
					<td><form:input path="tag" size="25" /></td>
				</tr>
				<tr>
					<td><label> Description </label>
				</tr>
				<tr>
					<td><form:textarea path="description" rows="5" cols="30" /></td>
				</tr>
				<tr>
					<td><u>Product Properties</u></td>
				</tr>
				<tr>
					<td>Select Product Vendor:</td>
				</tr>
				<tr>
					<td><form:select path="vendor" onchange="function3(this)"
							id="sub_ven">
							<form:option value="0">-- Select Your Vendor --</form:option>
						</form:select></td>
					<td><span id="fooBar12">&nbsp;</span></td>
				</tr>
				<tr>
					<td>Select Product Catogory:</td>
				</tr>
				<tr>
					<td><form:select path="category" onchange="function2(this)"
							id="sub_category">
							<form:option value="0">-- Select Your Catogory --</form:option>
						</form:select></td>
					<td><span id="fooBar1">&nbsp;</span></td>
				</tr>

				<tr>
					<td><label> Selling Price </label> <form:input
							path="sel_price" id="sp" size="5" />INR
				</tr>
				<tr>
					<td><label> Weight </label> <form:input path="weight" id="wt"
							size="5" />Kg</td>
				</tr>
				<tr>
					<td><INPUT TYPE="checkbox" id="tax" value="payTax">
						Charge Tax</td>
					<td><INPUT TYPE="checkbox" id="ship"> Require a
						Shipping Address</td>

				</tr>
				<tr>
					<td>Upload Picture : <input type="file" name="file" />
					</td>
				</tr>
				<tr>
					<td>Track Stock Level: <input type="checkbox" id="qu"
						onchange="quantity(this)"></td>
					<td><span id="qq">Specify Quantity:</span></td>
				</tr>
				<tr>
					<td>Define New Attributes: <input type="checkbox" id="new"
						onchange="attr(this)">
					</td>
				</tr>
				<tr>
					<td><span id="attr">Specify The Following or Create
							Your Own:
							<table align="center" cellpadding="5" cellspacing="3">
								<tr>
									<td>Variants Name:</td>
									<td><input type="text" name="var_title"
										value="Give it a Name"></td>
								</tr>
								<tr>
									<td>Size:</td>
									<td><input type="text" name="size" size="3" /></td>

								</tr>
								<tr>
									<td>Color:</td>
									<td><input type="text" name="color" size="6"></td>
								</tr>
								<tr>
									<td>Material:</td>
									<td><input type="text" name="mat" size="6"></td>
								</tr>
								<tr>
									<td>Style:</td>
									<td><input type="text" name="style" size="6"></td>
								</tr>
								<tr>
									<td><input type="button" id="newat"
										value="Create New Attribute"></td>
								</tr>
								<tr>
									<td><span id="div_attr"></span></td>
									<td><span id="div_value"></span></td>
								</tr>
							</table>
					</span></td>


				</tr>

				<tr>
					<td><input name="akhilesh" type="hidden" id="xyz" value="">
						<form:hidden path="coll" id="collc" /> <form:hidden
							path="vendors" id="venc" /> <input name="tax" type="hidden"
						id="tc" value=""> <input name="ship_addr" type="hidden"
						id="sc" value=""> <input name="quan" type="hidden" id="un"
						value=""> <input type="button" value="Create" id="z" /></td>
				</tr>


			</table>

		</form:form>

		<script type="text/javascript"
			src="<s:url value="/resources" />/js/script1.js"></script>

	</div>
	<script type="text/javascript">
		$('#win')
				.click(
						function(event) {
							event.preventDefault();
							var mywindow = window
									.open(
											"${request.contextPath}/proTemplates/index",
											"mywindow",
											"location=1,status=1,scrollbars=1, width=800,height=400");
							//   mywindow.moveTo(100, 100);
							// console.log("ahahhh");
						});
	</script>
</body>
</html>