
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        function sendAjax () {
            alert("bb")
            $.ajax({
                //请求方式
                type : "GET",
                dataType: "json",
                //请求地址
                url : "/gamedata",
                data:{platform:"Gamesamba",period:"today",type:"loginNum"},



                //请求成功
                success : function(res) {

                    alert((res.Result.platform));
                },
                //请求失败，包含具体的错误信息
                error : function(e){
                    alert("cc")
                }
            });

        }

    </script>


<head>




</head>
<body>
<input type="button" value="submit" onclick="sendAjax()">
</body>
</html>
