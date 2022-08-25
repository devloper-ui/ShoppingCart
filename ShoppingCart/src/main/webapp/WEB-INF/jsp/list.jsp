<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<h1> All Products </h1>
<div class="container">
	<table class="table">
		<caption></caption>
		<thead>
			<tr>
				<th style="text-align: center; vertical-align: middle;">Item</th>
				<th></th>
				<th></th>
				<th></th>
				<th style="text-align: center; vertical-align: middle;">Price</th>   
			</tr>   
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product" varStatus="outerLoop">
				<tr height="100px">
					<td style="text-align: center; vertical-align: middle;">${product.name}</td> <!-- use in small case irrespective of model values-->
					<td style="text-align: center; vertical-align: middle;"><button onclick="increment(${product.id},${product.price})">+</button></td>
					<td style="text-align: center; vertical-align: middle;"><input id=demoInput${outerLoop.index+1} type=number min=0 max=10></td>
					<td style="text-align: center; vertical-align: middle;"><button onclick="decrement(${product.id},${product.price})">-</button></td>
					<td id="demo${outerLoop.index+1}" style="text-align: center; vertical-align: middle;"></td>
					<td style="text-align: center; vertical-align: middle;">${product.price}</td>
				</tr>
			</c:forEach> <!-- for(Expense expense: expenses) since its html it does
							not worry about first expense we can give any name in var -->
		</tbody>
	</table>
</div>
<script>
   var i = 0;
   function increment(val,price) {
      document.getElementById('demoInput'+val).stepUp();
      i++;
      document.getElementById("demo"+val).innerHTML = document.getElementById('demoInput'+val).value * price;
   }
   function decrement(val,price) {
	      document.getElementById('demoInput'+val).stepDown();
	      i--;
	      document.getElementById("demo"+val).innerHTML = document.getElementById('demoInput'+val).value * price;
   }
</script> 
</body>
</html>
