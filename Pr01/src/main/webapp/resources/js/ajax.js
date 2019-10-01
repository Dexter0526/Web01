//이메일 유효성 체크
function check() {
	console.log("check....");

	$("#inputEmail").blur(function() {
		// id = "inputEmail" / name = "email"
		var email = $('#inputEmail').val();
		console.log('email : ' + email);
		$.ajax({
			url : '${pageContext.request.contextPath}/emailCheck?email='+ email,
			type : 'get',
			dataType : "json",
			success : function(data) {						
				console.log("data : " + data);
				if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#email_check").text("사용중인 아이디입니다. ");
					$("#email_check").css("color", "red");
					$("#frm_submit").attr("disabled", true);
				} else {

					if(user_id == ""){

						$('#email_check').text('아이디를 입력해주세요 :)');
						$('#email_check').css('color', 'red');
						$("#frm_submit").attr("disabled", true);				

					}else{
						$("#email_check").text("사용가능 아이디입니다.");
						$("#email_check").css("color", "blue");
						$("#frm_submit").attr("disabled", false);
					}

				}
			}, error : function() {
				console.log("실패");
			}
		});
	});
}




