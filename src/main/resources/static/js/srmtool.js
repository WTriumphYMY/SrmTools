$(function () {
    $('#motorcommon').addClass("active");
    $('#resultS').parent().parent().hide();
    $('#s1l').parent().hide();
    $('#s2l').parent().hide();
    $('#s3l').parent().hide();
    $('#s4l').parent().hide();
    $('#s5l').parent().hide();
    $('#s6l').parent().hide();
    $('#s7l').parent().hide();
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#s1').val('0.004');
    $('#s2').val('1541');
    $('#s3').val('10.8638');
    $('#s4').val('1');
    $('#s5').val('0.5');
    $('#s6').val('1750');
    $('#s7').val('33.8');
    $('#s8').val('434');
    $('#s9').val('3200');
})

function selectBtn(type) {
    $('#carouselShow').remove();
    $('#resultS').parent().parent().show();
    resetVisual();
    switch (type) {
        case 'pcBtn': changeToPc(); break;
        case 'cdBtn': changeToCd(); break;
        case 'abBtn': changeToAb(); break;
        case 'rtBtn': changeToRt(); break;
        case 'mbBtn': changeToMb(); break;
        case 'paBtn': changeToPa(); break;
        case 'peBtn': changeToPe(); break;
        case 'ispBtn': changeToIsp(); break;
        case 'fBtn': changeToF(); break;
        case 'rBtn': changeToR(); break;
        case 'epsBtn': changeToEps(); break;
    }
}

function calculate() {
    var form = new FormData($("#calForm")[0]);
    $.ajax({
        url:contextRoot+"srmtool",
        type:"post",
        data:form,
        cache: false,
        processData: false,
        contentType: false,
        success:function(rtn){
            $('#result').val(rtn);
        },
        error:function(){
            alert("网络错误，请重试！！");
        }
    });
}

function changeToPc() {
    $('#dropdownMenuButton').text('燃烧压强Pc');
    $('#s1l').text('燃速系数m/s');
    $('#s1').val('0.004');
    $('#s2l').text('特征速度m/s');
    $('#s2').val('1541');
    $('#s3l').text('燃烧面积m^2');
    $('#s3').val('1.1');
    $('#s4l').text('热损失系数');
    $('#s4').val('1');
    $('#s5l').text('压力指数');
    $('#s5').val('0.5');
    $('#s6l').text('推进剂密度kg/m^3');
    $('#s6').val('1750');
    $('#s7l').text('喉部半径mm');
    $('#s7').val('33.8');
    $('#s8l').text('燃气气体常数J/kg.K');
    $('#s8').val('434');
    $('#s9l').text('燃气温度K');
    $('#s9').val('3200');
    $('#resultS').text('燃烧室压力(MPa)');
    $('#type').val('pc');
}

function changeToCd() {
    $('#dropdownMenuButton').text('壳体壁厚cDelta');
    $('#s1l').text('壳体材料强度(MPa)');
    $('#s1').val('1079');
    $('#s2l').text('结构安全系数');
    $('#s2').val('1.25');
    $('#s3l').text('燃烧室压力(MPa)');
    $('#s3').val('10.8638');
    $('#s4l').text('燃烧室直径(mm)');
    $('#s4').val('400');
    $('#s5l').parent().hide();
    $('#s6l').parent().hide();
    $('#s7l').parent().hide();
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('燃烧室壁厚(mm)');
    $('#type').val('cd');
}
function changeToAb() {
    $('#dropdownMenuButton').text('燃烧面积Ab');
    $('#s1l').text('燃速系数(m/s)');
    $('#s2l').text('特征速度(m/s)');
    $('#s3l').text('燃烧室压力(MPa)');
    $('#s4l').text('热损失系数');
    $('#s5l').text('压力指数');
    $('#s6l').text('推进剂密度(kg/m^3)');
    $('#s7l').text('喉部半径(mm)');
    $('#s8l').text('燃气气体常数(J/kg.K)');
    $('#s9l').text('燃气温度(K)');
    $('#resultS').text('燃烧面积(m^2)');
    $('#s1').val('0.004');
    $('#s2').val('1541');
    $('#s3').val('10.8638');
    $('#s4').val('1');
    $('#s5').val('0.5');
    $('#s6').val('1750');
    $('#s7').val('33.8');
    $('#s8').val('434');
    $('#s9').val('3200');
    $('#type').val('ab');
}
function changeToRt() {
    $('#dropdownMenuButton').text('喉部半径Rt');
    $('#s1l').text('燃速系数(m/s)');
    $('#s2l').text('特征速度(m/s)');
    $('#s3l').text('燃烧面积m^2');
    $('#s4l').text('热损失系数');
    $('#s5l').text('压力指数');
    $('#s6l').text('推进剂密度(kg/m^3)');
    $('#s7l').text('燃烧室压力(MPa)');
    $('#s8l').text('燃气气体常数(J/kg.K)');
    $('#s9l').text('燃气温度(K)');
    $('#s1').val('0.004');
    $('#s2').val('1541');
    $('#s3').val('1.1');
    $('#s4').val('1');
    $('#s5').val('0.5');
    $('#s6').val('1750');
    $('#s7').val('10.8638');
    $('#s8').val('434');
    $('#s9').val('3200');
    $('#resultS').text('喉部半径(mm)');
    $('#type').val('rt');
}
function changeToMb() {
    $('#dropdownMenuButton').text('由质量流率计算喉部半径Rt');
    $('#s1l').text('特征速度(m/s)');
    $('#s2l').text('燃烧室压力(MPa)');
    $('#s3l').text('质量流率(kg/s)');
    $('#s1').val('1541');
    $('#s2').val('10.8638');
    $('#s3').val('4');
    $('#s4l').parent().hide();
    $('#s5l').parent().hide();
    $('#s6l').parent().hide();
    $('#s7l').parent().hide();
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('喉部半径(mm)');
    $('#type').val('mb');
}
function changeToPa() {
    $('#dropdownMenuButton').text('环境压强Pa');
    $('#s1l').text('发动机工作高度(m)');
    $('#s1').val('0');
    $('#s2l').parent().hide();
    $('#s3l').parent().hide();
    $('#s4l').parent().hide();
    $('#s5l').parent().hide();
    $('#s6l').parent().hide();
    $('#s7l').parent().hide();
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('环境压强(MPa)');
    $('#type').val('pa');
}
function changeToPe() {
    $('#dropdownMenuButton').text('出口压强Pe');
    $('#s1l').text('面积膨胀比');
    $('#s2l').text('燃烧室压力(MPa)');
    $('#s3l').text('燃气比热比');
    $('#s1').val('10');
    $('#s2').val('10.8638');
    $('#s3').val('1.25');
    $('#s4l').parent().hide();
    $('#s5l').parent().hide();
    $('#s6l').parent().hide();
    $('#s7l').parent().hide();
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('喷管出口压强(MPa)');
    $('#type').val('pe');
}
function changeToIsp() {
    $('#dropdownMenuButton').text('比冲Isp');
    $('#s1l').text('特征速度(m/s)');
    $('#s2l').text('发动机工作高度(m)');
    $('#s3l').text('面积膨胀比');
    $('#s4l').parent().hide();
    $('#s5l').text('燃烧室压力(MPa)');
    $('#s6l').parent().hide();
    $('#s7l').text('燃气比热比');
    $('#s1').val('1541');
    $('#s2').val('0');
    $('#s3').val('10');
    $('#s4').val('1.62089');
    $('#s5').val('10.8638');
    $('#s6').val('0.101325');
    $('#s7').val('1.25');
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('比冲(m/s)');
    $('#type').val('isp');
}
function changeToF() {
    $('#dropdownMenuButton').text('推力F');
    $('#s1l').text('发动机工作高度(m)');
    $('#s2l').text('面积膨胀比');
    $('#s1').val('0');
    $('#s2').val('10');
    $('#s3l').parent().hide();
    $('#s4l').text('喉部半径(mm)');
    $('#s5l').text('燃烧室压力(MPa)');
    $('#s4').val('33.8');
    $('#s5').val('10.8638');
    $('#s6l').parent().hide();
    $('#s7l').text('燃气比热比');
    $('#s7').val('1.25');
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('推力(kN)');
    $('#type').val('f');
}
function changeToR() {
    $('#dropdownMenuButton').text('燃速rate');
    $('#s1l').text('燃速系数(m/s)');
    $('#s2l').text('压力指数');
    $('#s3l').text('燃烧室压力(MPa)');
    $('#s1').val('0.004');
    $('#s2').val('0.5');
    $('#s3').val('10.8638');
    $('#s4l').parent().hide();
    $('#s5l').parent().hide();
    $('#s6l').parent().hide();
    $('#s7l').parent().hide();
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('燃速(m/s)');
    $('#type').val('r');
}
function changeToEps() {
    $('#dropdownMenuButton').text('喷管初始膨胀半角');
    $('#s1l').text('燃气比热比');
    $('#s2l').text('面积膨胀比');
    $('#s1').val('1.25');
    $('#s2').val('10');
    $('#s3l').parent().hide();
    $('#s4l').parent().hide();
    $('#s5l').parent().hide();
    $('#s6l').parent().hide();
    $('#s7l').parent().hide();
    $('#s8l').parent().hide();
    $('#s9l').parent().hide();
    $('#resultS').text('喷管初始膨胀半角');
    $('#type').val('eps');
}

function resetVisual() {
    $('#s1l').parent().show();
    $('#s2l').parent().show();
    $('#s3l').parent().show();
    $('#s4l').parent().show();
    $('#s5l').parent().show();
    $('#s6l').parent().show();
    $('#s7l').parent().show();
    $('#s8l').parent().show();
    $('#s9l').parent().show();
}
