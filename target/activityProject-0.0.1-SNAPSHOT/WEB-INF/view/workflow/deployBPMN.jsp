<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <html>
    <head>
        <title>待办列表</title>
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
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="uploadFile()">上传流程文件</a>
    </div>

<!-- 数据表格区 -->
    <div data-options="region:'center',collapsible:true,split:true"style="width: 100%;height: 100%;">
        <table id="grid" toolbar="#toolbar"></table>
    </div>
    <!-- 上传页面 -->
    <div id="editDlg" class="easyui-window" data-options="closed:true">
        <form action="<%= request.getContextPath()%>/bpmnDeploy/deploy" method="post" enctype="multipart/form-data">
            <input type="file" name="file" />
            <input type="submit" value="提交" class="button" />
        </form>
    </div>



</body>

<script type="text/javascript">

    var title = '流程部署管理';
    var idField = 'id';
    var height = 800;
    var width = 300;
    var columns = [[
        {
            field: 'id',
            title: '流程定义ID',
            width: 200
        },
        {
            field: 'deploymentId',
            title: '部署ID',
            width: 200
        },
        {
            field: 'name',
            title: '流程定义名称',
            width: 300
        },
        {
            field: 'key',
            title: '流程定义KEY',
            width: 100
        },{
            field: 'version',
            title: '版本号',
            width: 100
        },{
            field: 'resourceName',
            title: 'XML资源名称',
            width: 300
        },{
            field: 'diagramResourceName',
            title: '图片资源名称',
            width: 300
        }]];

    $('#grid').datagrid({
        url:'<%=request.getContextPath()%>/bpmnDeploy/getDeployList',
        method:'get',
        columns:columns
    });

    // 初始化编辑窗口
    $('#editDlg').dialog({
        title : '部署',// 窗口标题
        width : 500,// 窗口宽度
        height : 500,// 窗口高度
        closed : true,// 窗口是是否为关闭状态, true：表示关闭
        modal : true
        // 模式窗口
    });

    function uploadFile(){
        $('#editDlg').dialog('open');
    }

</script>


</html>
