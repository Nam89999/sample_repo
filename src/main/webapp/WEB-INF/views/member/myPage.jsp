<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이 줍데이</title>

<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/resources/style/member/commons/default.css">
<link rel="stylesheet" href="/resources/style/member/commons/common.css">
<link rel="stylesheet" href="/resources/style/member/css/myPage.css">
</head>
<body>

	

	<div id="wrap">
		<div id="content">
			<div class="user-info">
			
				<div class=box-title>
					<p class="tit-small">민서네</p>
					<p class="tit-big">회원 정보</p>
				</div>
				
				<table class="info">
					<tr class="profile">
						<td>사진</td>
						<td class="profile-img">
									<img class="profile-img2" src="/resources/style/member/images/profile.png">
						</td>
						<td>
							<p>회원님을 알릴 수 있는 사진을 등록해 주세요.</p>
							<p>등록된 사진은 회원님의 게시물이나 댓글들에 사용됩니다.</p>
						</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td colspan="2">아이디</td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td colspan="2">닉네임</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td colspan="2">이메일</td>
					</tr>
					<tr>
						<td colspan="3"><button class="btn-m">
								<a href="/views/member/myPageModify.jsp">수정하기</a>
							</button></td>
					</tr>
				</table>
			</div>
			
			<div class="user-sec">
			<div>
				<p class="tit-big">보안</p>
			</div>
				<table class="sec">
					<tr>
						<td>비밀번호</td>
						<td>안전한 계정 사용을 위해 비밀번호는 주기적으로 변경해주세요.</td>
						<td><button class="btn-m">
								<a href="/views/member/myPagePasswordChange.jsp">비밀번호 변경</a>
							</button>
						</td>
					</tr>
				</table>
			</div>
			
			<div class="user-withdraw">
				<table class="withdraw">
					<tr>
						<td><p>탈퇴를 원하시면 회원탈퇴 버튼을 눌러주세요.</p></td>
						<td><button class="btn-withdraw">
								<a href="/views/member/myPageWithdraw.jsp">회원 탈퇴</a>
							</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>



</body>
</html>