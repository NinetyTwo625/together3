// (1) 회원정보 수정
function update(userId, event) {

	event.preventDefault(); // 폼태그 액션을 막기!!

	let data = $("#profileUpdate").serialize(); // key=value
	
	console.log(data);
	
	$.ajax({
		type: "put",
		url : `/api/user/${userId}`,
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"
	}).done(res=>{ //성공시
		console.log("성공", res)
		location.href = `/user/${userId}`;
	}).fail(error=>{ //실패시
		console.log(error);
		if(error.responseJSON.data == null) {
		alert(error.responseJSON.message);
		}
		else {
		alert(JSON.stringify(error.responseJSON.data));
		}
//		validCheck(error);
	});
}

//function validCheck(error){
//
//	valid_password.innerHTML = "";
//	valid_name.innerHTML="";
//	valid_email.innerHTML="";
//
//	for(var key in error.responseJSON) {eval(key).innerHTML = error.responseJSON[key];}
//
//}

