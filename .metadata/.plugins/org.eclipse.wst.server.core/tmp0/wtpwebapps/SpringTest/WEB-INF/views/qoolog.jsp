<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/inc/qooasset.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=380, height=740, user-scalable=yes, initial-scale=1.0, maximum-scale=2.0"/>
<title>Insert title here</title>
<style>
		/* 넥슨 글씨체 */
        @font-face {
            font-family: 'NEXON Lv1 Gothic OTF';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        /* 로그인 이미지 */
        #qoo10login {
            /* border : 1px solid red; */
            margin: 0px auto;
            margin-top: 40px;
            height: 100px;
            width: 200px;
        }
        #qoo10login img {
            width:100%;
            height : 100%;
        }
        /* 전체적인 바디 */
        body {
            /* border : 1px solid red; */
            height : 740px;
            background-color : #F5F6F7;
        }
        /* 아이디 비밀번호 치는곳 */
        .inputform {
            /* border: 1px solid blue; */
            margin: 5px auto;
            width : 355px;
            height : 50px;
            padding: 10px;
        }
        .inputform input {
            width : 340px;
            height : 40px;
            border: 1px solid #E5E5E6;
        }

        #copyright {
            /* border : 1px solid blue; */
            width : 310px;
            margin: 20px auto;
            font-size: 0.9em;
            text-align: center;
        }

        #inputid:focus {
            outline: none;
        }
        
        #inputpw:focus {
            outline:none;
        }
        
        /* 광고관련 */
        #advertise {
            height: 200px;
        }

        #advertise:hover{
            cursor: pointer;
        }
        #etcinfo {
            margin: 5px auto;
            width : 260px;
            height : 30px;
            padding: 6px;
        }

        #etcinfo a,span {
            color: #8E8E8E;
            font-family: 'NEXON Lv1 Gothic OTF';
        }

         #etcinfo:hover {
             cursor : pointer;
         }
		
    </style>
</head>
<body>

    
    <div id = "qoo10login">
        <img src = "resources/images/Qoo10_Logo.png">    
    </div>
    
    <form action="loginVerification.action" method = "POST" id = "inputform"><!-- 여기도 변화를 줘야하는데 어떤식으로 주면 될까 -->
        <!-- 아이디 -->
        <div class = "inputform">
            <input type="text" name = "id" autocomplete="off" id = "inputid" placeholder = "아이디">
        </div>
        <!-- 비밀번호 -->
        <div class = "inputform">
            <input type="password" name = "pw" autocomplete="off" id = "inputpw" placeholder = "비밀번호">
        </div>
        <!-- 로그인 버튼 -->
        <div class = "inputform">
            <input id = "go" type="submit" value = "SIGN IN" style = "font-weight: bold; font-size: 1.3em; background-color: #EC2E3C; color:white;">
        </div>
    </form>
    
    <div id = "etcinfo">
        <a target="_blank" href = "">아이디 찾기</a>
        <span class = "bar">|</span>
        <a target="_blank" href = "">비밀번호 찾기</a>
        <span class = "bar">|</span>
        <a target="_blank" href = "/spring/signUp.action">회원 가입</a>
    </div>

    <div id = "copyright" style="font-family: 'NEXON Lv1 Gothic OTF'">
        Copyright &copy; <span style="font-weight: bold;">Qoo10 Corp.</span> All rights reserved.
    </div>
	
	<!-- 광고칸 -->
    <div id = "advertise" class = "inputform" style = "background: url('resources/images/adver/${picName}'); background-size: cover;"></div>



    <script>
        
        //광고 클릭했을 경우
        $("#advertise").click(function(){
            location.href = '${url}'
        });


    </script>

</body>
</html>