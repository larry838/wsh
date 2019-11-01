 /*使用模块加载的方式 加载文件*/
layui.config({
    base : "/assets/js/modules/"
}).extend({
    "treetable" : "treetable/treetable",
    "common" : "common"
});
layui.use(['form', 'table', 'treetable', 'common'], function () {
    var form = layui.form;
    var $ = layui.jquery;
    var table = layui.table;
    var treetable = layui.treetable;
    var common = layui.common;

    // 渲染表格
    layer.load(2);
    treetable.render({
        treeColIndex: 1,//树形图标显示在第几列
        treeSpid: 0,//最上级的父级id
        treeIdName: 'menuId',//id字段的名称
        treePidName: 'parentId',//父级字段的名称
        //treeDefaultClose: false,//是否默认折叠
       // treeLinkage: true,//父级展开时是否自动展开所有子级
        elem: '#auth-table',//	指向容器选择器
        url: '/menu/list',
        page: false,
        id: 'permissionListTable',
        cols: [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'menuName', minWidth: 100, title: '权限名称'},
            {field: 'permissionCode', width: 200, title: '权限编码'},
            {field: 'url', minWidth: 100, title: '资源路径'},
            {
                field: 'menuType', width: 200, align: 'center', templet: function (d) {
                    if(d.menuType == "T"){
                        return '<span class="layui-badge layui-bg-blue">顶级目录</span>';
                    }else if (d.menuType == "D") {
                        return '<span class="layui-badge layui-bg-blue">目录</span>';
                    }else if (d.menuType == "M") {
                        return '<span class="layui-badge layui-badge-rim">菜单</span>';
                    } else if (d.menuType == "B")  {
                        return '<span class="layui-badge layui-bg-gray">按钮</span>';
                    }else{
                    	return '';
                    }
                }, title: '资源类型'
            },
            {
                field: 'visible', width: 200, align: 'center', templet: function (d) {
                    if (d.visible == 0) {
                        return '<span class="layui-badge layui-bg-green">启用</span>';
                    } else {
                        return '<span class="layui-badge layui-bg-cyan">禁用</span>';
                    }
                }, title: '权限状态'
            },
            {templet: complain, title: '操作'}
        ]],
        done: function () {
            layer.closeAll('loading');
        }
    });


	//触发三个button按钮
    $('#btn-expand').click(function () {
        treetable.expandAll('#auth-table');
    });
    $('#btn-fold').click(function () {
        treetable.foldAll('#auth-table');
    });

    $('#btn-refresh').click(function () {
        renderTable();
    });
    
    function complain(d){//操作中显示的内容
    	if(d.url!=null){
    		return [
                    '<a class="operation" lay-event="edit" href="javascript:void(0)" onclick="editDepartment(\''+ d.menuId + '\')" title="编辑">',
        	     	' <i class="layui-icon layui-icon-edit"></i>编辑<i class="iconfont"></i>',
        	     	'<a class="operation" lay-event="del" href="javascript:void(0)" onclick="delDepartment(\''+ d.menuId + '\')" title="删除">',
        	     	'<i class="layui-icon layui-icon-delete" ></i>删除</a>',
        	     	].join('');
    	}else{
    		return '';
    	}
    	
    }
    //监听工具条
    table.on('tool(auth-table)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
		if(data.menuName!=null){
			if (layEvent === 'del') {
                layer.msg('删除' + data.id);
            } else if (layEvent === 'edit') {
                layer.msg('修改' + data.id);
            }
		}
    });

    //添加权限
    function addPermission(edit){
        var title = edit===null?"添加权限":"编辑权限";
        layui.layer.open({
            title : title,
            type : 2,
            area : ["500px","450px"],
            content : "info.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find("#id").val(edit.id);
                    body.find(".permissionName").val(edit.permissionName);
                    body.find(".permissionCode").val(edit.permissionCode);
                    body.find("#url").val(edit.url);
                    body.find("#availableSelect").val(edit.available);
                    body.find("#resourceType").val(edit.resourceType);
                    body.find("#parentId").val(edit.parentId);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回权限列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
    }
    
    $(".add_btn").click(function(){
        addPermission(null);
    });

    $(".edit_btn").click(function(){
        var checkStatus = table.checkStatus('permissionListTable'),
            data = checkStatus.data;
        console.log(data);
        if(data.length > 0){
            addPermission(data[0]);
        }else{
            layer.msg("请选择需要修改的权限");
        }
    });

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('permissionListTable'),
            data = checkStatus.data,
            idArr = [];
        if(data.length > 0) {
            for (var i in data) {
                if(data.length>1&&data[i].resourceType!=="button"){
                    layer.msg("抱歉，只支持批量删除按钮！");
                    return;
                }
                idArr.push(data[i].id);
            }
            layer.confirm('确定删除选中的权限？', {icon: 3, title: '提示信息'}, function (index) {
                $.ajax({
                    url: "/permission/delBatch",
                    type: "post",
                    data: {idArr : idArr.toString()},
                    success: function(res){
                        layer.close(index);
                        if (res.data){
                            layer.msg("删除成功！");
                        } else {
                            layer.msg(res.msg);
                        }
                    },
                    error: function (xmlHttpRequest) {
                        layer.close(index);
                        common.outErrorMsg(xmlHttpRequest);
                    }
                });
                setTimeout(function(){
                    location.reload();//刷新页面
                },1500);
            });
        }else{
            layer.msg("请选择需要删除的权限");
        }
    });

});