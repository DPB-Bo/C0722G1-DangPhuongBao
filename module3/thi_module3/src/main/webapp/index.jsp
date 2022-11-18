<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
    <script src="/jquery/jquery-3.5.1.min.js"></script>
    <script src="/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
    <link rel="stylesheet" href="bootstrap-5.2.2-dist/css/bootstrap.css">
    <script src="bootstrap-5.2.2-dist/js/bootstrap.js"></script>
    <script>
        $(document).ready(function() {
            $('#tableEx').dataTable( {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 3,
            } );
        } );
        function updateCustomer(sickTypeId,customerId,sickTypeName,customerName,dayIn,dayOut,description) {

        }
        function deleteCustomer(sickTypeId,customerId){

        }
    </script>
</head>
<body>
<c:redirect url="/customers"></c:redirect>
</body>
</html>