layui.config({
    base : "/assets/js/modules/"
}).extend({
    "common" : "common"
})
layui.use(['form','layer','jquery','common'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        common = layui.common;

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    });

    $("#imgCode img").click(function() {
    	this.src = "/captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
    });

    //登录按钮
    form.on("submit(login)",function(data){
        $("#login").text("正在验证登录，请稍后...").attr("disabled","disabled").addClass("layui-disabled");
    	var username = $("input[name='username']").val();
        var password = $("input[name='password']").val();
        var validateCode = $("input[name='validateCode']").val();
        var rememberMe = $("input[name='rememberMe']").is(':checked');
        $.ajax({
        	url: ctx + "login",
            type: "post",
            data: {
                "username": username,
                "password": password,
                "validateCode" : validateCode,
                "rememberMe": rememberMe
            },
            success: function(r){
                if (r.code == 0) {
                	location.href = ctx + 'index';
                } else {
                	$('.imgcode').click();
                	$(".code").val("");
                	layer.msg(r.msg);
                	$("#login").text("登录").removeAttr("disabled").removeClass("layui-disabled");
                }
            },
            error: function (xmlHttpRequest) {
                $("#login").text("登录").removeAttr("disabled").removeClass("layui-disabled");
                common.outErrorMsg(xmlHttpRequest);
            }
        });
        return false;
    });
    
    $(function(){
        var srcBgArray = ["/assets/images/chun.jpg",
                          "/assets/images/xia.jpg",
                          "/assets/images/qiu.jpg",
                          "/assets/images/dong.jpg"];
                      $('#bg-body').bcatBGSwitcher({
                          timeout:5000,
                          urls: srcBgArray,
                          alt: 'Full screen background image'
                      });
                  });
})