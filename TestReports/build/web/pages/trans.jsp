<%-- 
    Document   : trans
    Created on : Jun 30, 2016, 10:49:12 AM
    Author     : mulikevs
--%>

<!DOCTYPE html>
<html>
<head>
<title>Pagination in Java Web Applications using jTable plugin</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet"
	type="text/css" />
<!-- Include jTable script file. -->
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#StudentTableContainer').jtable({
			title : 'Transaction',
            paging: true, //Enable paging
            pageSize: 3, //Set page size (default: 10)           
            actions: {
                listAction: 'Transaction?action=list',
               
            },
			fields : {
				ID : {
					title : 'uuid',
					sort :true,
					width : '10%',
					key : true,
					list : true,
					edit : false,
					create : true
				},
				TransactionID : {
					title : 'Transaction id',
					width : '20%',
					edit : true
				},
				amount : {
					title : 'Amount',
					width : '15%',
					edit : true
				},
				sourceNetwork : {
					title : 'Sender Network',
					width : '20%',
					edit : true
				},
				destinationNetwork : {
					title : 'Destination Network',
					width : '20%',
					edit : true
				}
                                ,
				TransactionStatus : {
					title : 'TransactionStatus',
					width : '30%',
					edit : true
				}
			}
		});
		$('#StudentTableContainer').jtable('load');
	});
</script>

</head>
<body>
	<div
		style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
		<h4>Pagination in Java Web Applications jTable</h4>
		<div id="StudentTableContainer"></div>
	</div>
</body>
</html>