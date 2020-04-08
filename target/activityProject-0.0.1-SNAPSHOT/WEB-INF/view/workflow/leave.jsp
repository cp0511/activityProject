<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <html>
    <head>
        <title>请假流程</title>
    </head>
    <style type="text/css">

    </style>
    <link rel="stylesheet" type="text/css" href="../ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../ui/themes/icon.css">
    <script type="text/javascript" src="../ui/jquery.min.js"></script>
    <script type="text/javascript" src="../ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../ui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src='../ui/jquery.serializejson.min.js'></script>
<body>

    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addApplicate()">新增请假流程</a>
    </div>

<!-- 数据表格区 -->
    <div data-options="region:'center',collapsible:true,split:true"style="width: 100%;height: 100%;">
        <table id="grid" toolbar="#toolbar"></table>
    </div>
    <!-- 添加、修改 -->
    <div id="editDlg" class="easyui-window" data-options="closed:true">
        <form id="editForm">
            <input id="leave_id" name="leaveId" type="hidden">
            <table>
                <tr>
                    <td>开始时间</td>
                    <td><input name="startTime" class="easyui-datebox" editable="false">
                    </td>
                </tr>
                <tr>
                    <td>结束时间</td>
                    <td><input name="endTime" class="easyui-datebox" editable="false"></td>
                </tr>
                <tr>
                    <td>请假类型：</td>
                    <td><input name="leaveType"></td>
                </tr>
                <tr>
                    <td>请假原因：</td>
                    <td>
                        <input name="leaveReason" class="easyui-textbox" style="height:150px">
                    </td>
                </tr>
            </table>
            <button id="btnSave" type="button">提交</button>
        </form>
    </div>



</body>

<script type="text/javascript">

    var title = '请假管理';
    var idField = 'leave_id';
    var height = 800;
    var width = 300;
    var columns = [[
        {
            field: 'processInstanceId',
            title: '流程实例ID',
            width: 200
        },
        {
            field: 'userName',
            title: '申请人',
            width: 200
        },
        {
            field: 'startTime',
            title: '开始时间',
            width: 300,
            formatter : function(value) {
                return new Date(value).Format("yyyy-MM-dd HH:mm:ss");
            }
        },
        {
            field: 'endTime',
            title: '结束时间',
            width: 300,
            formatter : function(value) {
                return new Date(value).Format("yyyy-MM-dd HH:mm:ss");
            }
        },{
            field: 'leaveType',
            title: '请假类型',
            width: 100
        },{
            field: 'leaveReason',
            title: '请假原因',
            width: 300
        },{
            field: 'leaveStatus',
            title: '请假状态',
            width: 300
        }]];

    $('#grid').datagrid({
        url:'<%=request.getContextPath()%>/leave/getApplicateList',
        method:'get',
        columns:columns
    });

    // 初始化编辑窗口
    $('#editDlg').dialog({
        title : '请假',// 窗口标题
        width : 400,// 窗口宽度
        height : 500,// 窗口高度
        closed : true,// 窗口是是否为关闭状态, true：表示关闭
        modal : true
        // 模式窗口
    });

    function addApplicate(){
        $('#editDlg').dialog('open');
    }
    // 点击保存按钮
    $('#btnSave').bind('click', function() {
        // 做表单字段验证，当所有字段都有效的时候返回true。该方法使用validatebox(验证框)插件。
        var isValid = $('#editForm').form('validate');
        if (isValid == false) {
            return;
        }
        var formData = $('#editForm').serializeJSON();
        console.log(JSON.stringify(formData));
        $.ajax({
            url : '<%=request.getContextPath()%>/leave/submitApplication',
            data : {formData : JSON.stringify(formData)},
            dataType : 'json',
            type : 'post',
            success : function(rtn) {
                $.messager.alert("提示", rtn.msg, 'info', function() {
                    if (rtn.status == 200) {
                        // 成功的话，我们要关闭窗口
                        $('#editDlg').dialog('close');
                        // 刷新表格数据
                        $('#grid').datagrid('reload');
                    }
                });
            }
        });

    });
</script>


</html>
