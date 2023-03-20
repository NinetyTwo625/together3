// (1) 스토리 로드하기
function storyLoad() {
	$.ajax({
		// get type은 default라서 안 적어도 된다.
		url:`/api/image`,
		dataType:"json"
	}).done(res=>{
		console.log(res);
	}).fail(error=>{
		console.log("오류", error);
	});
}