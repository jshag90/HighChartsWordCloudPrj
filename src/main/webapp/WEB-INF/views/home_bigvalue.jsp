<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>프롭테크 기업 분석</title>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
  
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/wordcloud.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <img src="${LOGO}" style="height: 30px; padding-top: 10px;"/>
    </div>
    <ul class="nav navbar-nav">
     <li><a href="${URL}">원문기사</a></li>
      <li><a href="./bigvalue">빅밸류</a></li>
      <li><a href="./valuemap">밸류맵</a></li>
      <li><a href="./disco">디스코</a></li>
    </ul>
  </div>
</nav>

<div class="container">
	<div id="container"></div>
</div>
</body>
</html>

<script>
$(function(){
		var text = '${TEXT}'

			var lines = text.split(/[,\. ]+/g), data = Highcharts.reduce(lines,
					function(arr, word) {
						var obj = Highcharts.find(arr, function(obj) {
							return obj.name === word;
						});
						if (obj) {
							obj.weight += 10;
						} else {
							obj = {
								name : word,
								weight : 1
							};
							
							arr.push(obj);
						}
						return arr;
					}, []);
	 
		Highcharts.chart('container', {
			series : [ {
				type : 'wordcloud',
				data : data,
				name : '빈도수'
			} ],
			title : {
				 text: null
			},
			credits : { 
				enabled:false
			}
		});

	});
	
</script>

<style>
#container {
	min-width: 310px;
	max-width: 800px;
	margin: 0 auto
}

</style>
