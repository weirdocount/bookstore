<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	
	$(function(){
		$("a").each(function(){
			this.onclick = function(){
				var price = "minPrice=${param.minPrice}&maxPrice=${param.maxPrice}";
				var href = this.href + "&" + price;
				window.location.href = href;
				return false;
			};
		});
	});	
	
</script>
