$(function () {
    $('#gasdynamic').addClass("active");
    resetVisual();
})

function chooseFun(type) {
    resetVisual();
    switch (type) {
        case 'lambda': $('#gasLabel').text('气流马赫数'); break;
        case 'zjb': changeToZjb(); break;
        case 'xjb': changeToXjb(); break;
        default :$('#gasLabel').text('气流λ'); break
    }
}

function calculate() {
    var form = new FormData($("#calForm")[0]);
    $.ajax({
        url:contextRoot+"gasdynamic",
        type:"post",
        data:form,
        cache: false,
        processData: false,
        contentType: false,
        async: false,
        success:function(rtn){
            if (Object.getOwnPropertyNames(rtn).length == 1){
                $('#result').val(rtn.lambda);
            }else if (Object.getOwnPropertyNames(rtn).length == 3){
                $('#zSuduxishu').val(rtn.vCoe);
                $('#zJingyabi').val(rtn.pressureRatio);
                $('#zZongyaxishu').val(rtn.sigma);
            } else {
                $('#xSuduxishu').val(rtn.vCoe);
                $('#xJingyabi').val(rtn.pressureRatio);
                $('#xZongyaxishu').val(rtn.sigma);
                $('#xMach').val(rtn.delta);
            };
        },
        error:function(){
            alert("网络错误，请重试！！");
        }
    });
}

function changeToZjb() {
    $('#result').parent().hide();
    $('#zSuduxishu').parent().show();
    $('#zJingyabi').parent().show();
    $('#zZongyaxishu').parent().show();
    $('#xSuduxishu').parent().hide();
    $('#xJingyabi').parent().hide();
    $('#xZongyaxishu').parent().hide();
    $('#xMach').parent().hide();
}

function changeToXjb() {
    $('#result').parent().hide();
    $('#zSuduxishu').parent().hide();
    $('#zJingyabi').parent().hide();
    $('#zZongyaxishu').parent().hide();
    $('#xSuduxishu').parent().show();
    $('#xJingyabi').parent().show();
    $('#xZongyaxishu').parent().show();
    $('#xMach').parent().show();
    $('#xAngle').show()
}

function resetVisual() {
    $('#gasLabel').text('气流λ')
    $('#result').parent().show();
    $('#zSuduxishu').parent().hide();
    $('#zJingyabi').parent().hide();
    $('#zZongyaxishu').parent().hide();
    $('#xSuduxishu').parent().hide();
    $('#xJingyabi').parent().hide();
    $('#xZongyaxishu').parent().hide();
    $('#xMach').parent().hide();
    $('#xAngle').hide();
}
