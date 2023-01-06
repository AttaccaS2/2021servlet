<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
		<div class="wrap">
				<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">거래명세서</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body">
						<div class="m-b-lg">
							<small>
								<!-- 설명 -->
							</small>
						</div>
						<form method="post" class="form-horizontal" action="">
						<label>공급 받는 자</label>
							<input type="text" name="tra_account" id="tra_account" class="form-control">
							<table class=table id="crew">
								<tr>
									<th>월일</th><th>품목</th><th>규격</th><th>수량</th><th>단가</th>
									<th>공급가액</th><th>세액</th><th>비고</th><th></th>
								</tr>
								<tr>
									<td><input type="date" id="tradingDate0" name="tradingDate" class="form-control"></td>
									<td><input type="text" id="subject0" name="subject" class="form-control"></td>
									<td><input type="text" id="standard0" name="standard" class="form-control"></td>
									<td><input type="text" id="quantity0" name="quantity" class="form-control"  onchange="assignment(0);"></td>
									<td><input type="text" id="unitPrice0" name="unitPrice" class="form-control" onchange="assignment(0);"></td>
									<td><input type="text" id="supplyPrice0" name="supplyPrice" class="form-control"></td>
									<td><input type="text" id="taxAmount0" name="taxAmount" class="form-control"></td>
									<td><input type="text" id="note0" name="note" class="form-control"></td>
									<td><button id="" type="button" class="btn btn-default" onclick="addItem(this)">+</button>
									<button id="" type="button" class="btn btn-default"  onclick="delItem(this)">-</button></td>									
								</tr>							
							</table>
							<button type="submit">거래명세서 등록</button>
						</form>
					</div><!-- .widget-body -->
				</div><!-- .widget -->
		</div><!-- END column -->
		
<script>

function delItem(t){
	let len = $('#crew tr').length;
	if(len > 2){ //맨 마지막 항은 못지우게
		$(t).parent().parent().remove();//tr 자기자신을 지우라
		let html = "";
		html += '<button id="" type="button" class="btn btn-default" onclick="addItem(this)">+</button>';
		html += '<button id="" type="button" class="btn btn-default" onclick="delItem(this)">-</button>';	
		console.log(len);
		$("#crew > tbody > tr:nth-child("+(len-1)+") > td:nth-child(4)").append(html);
		//tr은 계속 추가되기 때문에 변수고 td는 네번째가 버튼으로 정해져있어서 고정값
		
	}	
	
}

function addItem(t){		
	
	$(t).parent().empty(); //자기 자신 삭제
	
	let len = $('#crew tr').length; //시작점 0 , crew 안에 있는 모든 자손 요소 tr , crew > tr 은 자식 요소만 나와 계속 0임
	console.log(len);
	
	let html = "";
	html += '<tr>';
	html += '<td><input type="date" id="tradingDate'+len+'" name="tradingDate" class="form-control"></td>';
	html += '<td><input type="text" id="subject'+len+'" name="subject" class="form-control"></td>';
	html += '<td><input type="text" id="standard'+len+'" name="standard" class="form-control"></td>';
	html += '<td><input type="text" id="quantity'+len+'" name="quantity" class="form-control" onchange="assignment('+len+');"></td>';
	html += '<td><input type="text" id="unitPrice'+len+'" name="unitPrice" class="form-control" onchange="assignment('+len+');"></td>';
	html += '<td><input type="text" id="supplyPrice'+len+'" name="supplyPrice" class="form-control"></td>';
	html += '<td><input type="text" id="taxAmount'+len+'" name="taxAmount" class="form-control"></td>';
	html += '<td><input type="text" id="note'+len+'" name="note" class="form-control"></td>';
	html += '<td><button id="" type="button" class="btn btn-default" onclick="addItem(this)">+</button>';
	html += '<button id="" type="button" class="btn btn-default"  onclick="delItem(this)">-</button></td>';									
	html += '</tr>';
	
	$('#crew:last').append(html);
}


function assignment(target){
	$("#supplyPrice"+target).val($("#quantity"+target).val() * $("#unitPrice"+target).val());
	$("#taxAmount"+target).val($("#supplyPrice"+target).val()*0.1);
	console.log("수량: "+$("#quantity0").val());

}

$(document).ready(function(){
	
});
</script>
		
<%@ include file="includes/footer.jsp"%>
    