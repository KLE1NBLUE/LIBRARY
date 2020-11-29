
function add() {
    $("#myModal").modal('show');
    console.log($("#editForm :hidden"));
}

function edit(row) {
    row = row ? row : $("#dataTable").bootstrapTable('getSelections')[0];
    if (!row) {
        showMessage('请选择需要编辑的记录', 'warning');
        return;
    }
    $.get('/category/findById', {id: row.id}, function(resp){
        if (resp.flag) {
            $("#myModal").modal('show');
            json2Form('editForm', resp.data);
        } else {
            showMessage(resp.message, 'danger');
        }
    }, 'json');
}

function remove(row) {
    row = row ? row : $("#dataTable").bootstrapTable('getSelections')[0];
    if (!row) {
        showMessage('请选择需要删除的记录', 'warning');
        return;
    }
    // 弹出确认框
    $.confirm({
        title: '操作提示',
        content: '该操作无法恢复, 是否删除?',
        buttons: {
            confirm: {
                text: '确认',
                action: function(){
                    $.get('/category/deleteById', {id: row.id}, function(resp){
                        if (resp.flag) {
                            showMessage(resp.message, 'success');
                        } else {
                            showMessage(resp.message, 'danger');
                        }
                        $("#dataTable").bootstrapTable('refresh');
                    }, 'json');
                }
            },
            cancel: {
                text: '关闭'
            }
        }
    });
}

function saveOrUpdate() {
    $.post('/category/saveOrUpdate', $("#editForm").serialize(), function(resp) {
        if (resp.flag) {
            $("#myModal").modal('hide');
            showMessage(resp.message, 'success');
        } else {
            showMessage(resp.message, 'danger');
        }
        $("#dataTable").bootstrapTable('refresh');
    }, 'json');
}

function showMessage(message, type) {
    $.notify({
        title: '操作提示:',
        message: message
    }, {
        type: type,
        delay: 2000
    });
}

function json2Form(formId, data) {
    // 回显表单数据
    let formArr = $("#" + formId).serializeArray();
    for (let i = 0; i < formArr.length; i++) {
        $("#" + formId + " [name='"+ formArr[i].name +"']").val(data[formArr[i].name]);
    }
}
