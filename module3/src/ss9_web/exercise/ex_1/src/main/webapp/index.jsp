<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
        <head>
            <title>JSP - Hello World</title>
        </head>
        <body>
            <form method="post"
                action="${pageContext.request.contextPath}/CalculateDiscountServlet">
                <label for="pro_de">Product Description:</label>
                <input type="text" name="proDes" id="pro_de">
                <br>
                <label for="list_pr">List Price:</label>
                <input type="text" name="listPr" id="list_pr">
                <br>
                <label for="dis_per">Discount Percent:</label>
                <input type="text" name="disPer" id="dis_per">
                <br>
                <input type="submit" value="Calculate Discount">
            </form>
        </body>
    </html>