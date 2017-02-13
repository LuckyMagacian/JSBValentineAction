$(function(){
	$params=getParam();//获取链接参数
	sendPhone($params.phone);
	
	
	$("#click").bind('click',function(){//点击拆,抽奖
		/*var uri='';
		ajaxPost(uri,{},function(){
			
		});*/
		location.href='prizeLevel.html';
	});
});

/* 验证手机号是否具有活动资格 */
function sendPhone(phone){
	if(valiPhone(phone)){
		var uri='';
		ajaxPost(uri,{},function(){//验证通过后绑定点击事件
			
		});
	}else{
		falseAlert('手机号错误','手机号格式有误,请退出页面后重试');
	}
}
