let data;
let user;
function setProblemList() {
    let list = $("#proList").empty();
    let language = $("#language").val()=="1";
    for(i = 0 ; i < data.length ; i++){
        let str=
            `<tr class="row ques-row row-double">
              <th class="ques-id col-2">${data[i].id}</th>
              <th class="ques-name col-6" href="${data[i].id}">${language?data[i].name_zh:data[i].name_en}</th>
              <th class="ques-solved col-2">${data[i].point}</th>
`
        ;
        if(data[i].level===1){
            str+="<th class=\"ques-level-easy col-2\">简单</th>\n</tr>";
        }else if(data[i].level===2){
            str+="<th class=\"ques-level-medium col-2\">中等</th>\n</tr>";
        }else {
            str+="<th class=\"ques-level-hard col-2\">困难</th>\n</tr>";
        }
        list.append(str);
    }
    data.sort(sortData);
    let hot_list = $(".m-hot-card");
    for(i = 0 ;i < Math.min(data.length,10) ;i++){
        let str = `<div class="fa hot-ques" href="${data[i].id}">\n`;
        if(language){
            str+=data[i].name_zh;
        }else {
            str+=data[i].name_en;
        }
        str+="\n</div>"
        hot_list.append(str);
    }
}

function sortData(a,b) {
    return a.point>b.point;
}

function setLinks() {
    let proList = $(".ques-name");
    proList.on("click",function(){
        window.location.href = "/problems/"+$(this).attr("href");
    })

    let hotList = $(".hot-ques");
    hotList.on("click",function(){
        window.location.href = "/problems/"+$(this).attr("href");
    })
}

function changeLanguage(val) {
    if(val===1){
        $("#language").text("中 ").val("1");
    }else{
        $("#language").text("英 ").val("2");
    }
    setProblemList();
    setLinks();
}

function drawCircle(data_arr, color_arr)
{
    let c = document.getElementById("cvs");
    c.width = parseInt($(".cvs-container").width())    ;
    c.height = c.width;
    var ctx = c.getContext("2d");

    var radius = c.height / 2 - 20; //半径
    var ox = radius + 20, oy = radius + 20; //圆心

    var width = 30, height = 10; //图例宽和高
    var posX = ox * 2 + 20, posY = 30;   //
    var textX = posX + width + 5, textY = posY + 10;

    var startAngle = -0.5*Math.PI; //起始弧度
    var endAngle = -0.5*Math.PI;   //结束弧度
    ctx.strokeStyle = "#fff"
    ctx.lineWidth = 2;
    for (var i = 0; i < data_arr.length; i++)
    {
        //绘制饼图
        endAngle = endAngle + data_arr[i] * Math.PI * 2; //结束弧度
        ctx.fillStyle = color_arr[i];
        ctx.save();
        ctx.globalAlpha = 0.2;
        ctx.beginPath();
        ctx.moveTo(ox,oy);
        ctx.arc(ox, oy, radius*1.1, startAngle, endAngle, false);
        ctx.fill();
        ctx.closePath();
        ctx.restore();
        ctx.beginPath();
        ctx.moveTo(ox, oy); //移动到到圆心
        ctx.arc(ox, oy, radius, startAngle, endAngle, false);
        ctx.closePath();
        ctx.fill();
        ctx.stroke();

        startAngle = endAngle; //设置起始弧度
    }
}


function setData(data){
    //TODO
    user = data.id;
    if(user==="000"){
        $("#login").append("<a href='/login'>登录</a>");
        $("#m-rate-block").hide();
    }else {
        $("#login").append("<img src=\"img/1.png\" alt=\"\" id=\"headImg\" class=\"head-link\">")

        $("#all_nums").text(data.all);
        $("#solved_nums").text(data.solved);
        $("#solved-easy-num").text(data.easy);
        $("#solved-medium-num").text(data.medium);
        $("#solved-hard-num").text(data.hard);
        $("#user_level").text(data.level);
        $("#point").text(data.point);
        var data_arr = [data.easy / data.solved, data.medium / data.solved, data.hard / data.solved];
        var color_arr = ["#28a745", "#ffc107", "#dc3545"];

        drawCircle(data_arr, color_arr);

        window.onresize = () => {
            drawCircle(data_arr, color_arr)
        }

    }
}

$(
    function () {
        $.get("/solved_info",function(data,status){
            if(status){
                setData(data);
            }
        });

        $.get("/problemListByID",{from:0,limit:10},function (d,status) {
            if(status){
                data = d;
                setProblemList();
                setLinks();
            }
        })
    }
)


