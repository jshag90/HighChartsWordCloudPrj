<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/wordcloud.js"></script>
<html>
<head>
<title>Home</title>
</head>
<body>
	<div id="container"></div>
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
							obj.weight += 1;
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
				text : 'Wordcloud'
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
