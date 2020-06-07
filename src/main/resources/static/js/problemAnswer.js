let s;
let editor;
let problemInfo;
let user = {id:1,name:"lzr"}
$(
    function () {

        $(".coding-tool").mouseenter(function(){
            $(this).children(".m-des-title").toggle();
        }).mouseleave(function () {
            $(this).children(".m-des-title").toggle();
        });

        $("#des-btn").on("click",function () {
            $("#solved_info_block").hide();
            $("#description_block").show();
        })

        $("#sol-btn").on("click",function () {
            $("#description_block").hide();
            $("#solved_info_block").show();
            $.get("/submit/getRecord",{uid:1,pid:problemInfo.id},function (data,status) {
                if(status){
                    console.log(data)
                    setAnswerLog(data);
                }
            })
        })

        $("#submit").on("click",submit);

        setClick();
        setEditor();
        problemInfo = JSON.parse($("#pro_info").val());
        setDescription();
    }
)

function setEditor() {
//根据DOM元素的id构造出一个编辑器
    editor = CodeMirror.fromTextArea(document.getElementById("code"), {
        mode: "text/x-java", //实现Java代码高亮
        lineNumbers: true,	//显示行号
        theme: "3024-day",	//设置主题
        indentUnit:4,
        tabIndex:4,
        tabSize:4,
        lineWrapping: true,	//代码折叠
        foldGutter: true,
        gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
        matchBrackets: true,	//括号匹配
        //readOnly: true,        //只读
    });
    editor.setSize('100%', '100%');     //设置代码框的长宽
}

function setDescription() {
    let language = $("#language").val();

    if(language==="1"){
        $(".pro-discrip").html(problemInfo.description_zh);
    }else{
        $(".pro-discrip").html(problemInfo.description_en);
    }


    if(language==="1"){
        $("#pro-title").html(problemInfo.id+" . "+problemInfo.name_zh);
    }else{
        $("#pro-title").html(problemInfo.id+" . "+problemInfo.name_en);
    }

    switch (problemInfo.level) {
        case 1:{
            $("#level-name").html("<span style=\"color: #28a745\">简单</span>")
            break;
        }
        case 2:{
            $("#level-name").html("<span style=\"color: #dc3545\">困难</span>")
            break;
        }
        case 3:{
            $("#level-name").html("<span style=\"color: #ffc107\">中等</span>")
            break;
        }
    }

    $(".point-text").text(problemInfo.point);

    getLatestSubmit();

}

function changeLanguage(val) {
    if(val===1){
        $("#language").text("中 ").val("1");
        $(".pro-discrip").html(problemInfo.description_zh);
        $("#pro-title").html(problemInfo.id+" . "+problemInfo.name_zh);
    }else{
        $("#language").text("英 ").val("2");
        $(".pro-discrip").html(problemInfo.description_en);
        $("#pro-title").html(problemInfo.id+" . "+problemInfo.name_en);
    }
}

function setClick() {
    $("#getLatestSubmit").on("click",getLatestSubmit);
    $("#saveToLocal").on("click",saveToLocal);
    $("#restoreFromLoacl").on("click",restoreFromLoacl);
    $("#getDefaultCode").on("click",getDefaultCode);
}

function submit() {
    $("#submit").toggle();
    $(".pending").toggle();
    let message = {pid:$("#proID").val(),
        code:editor.getValue(),uid:user.id};

    $.ajax({
        type:'POST',
        url:"/submit",
        dataType:'json',
        contentType : "application/json;charset=utf-8",
        data:
            JSON.stringify(message)
        ,
        success:(data,status)=> {
            $("#submit").toggle();
            $(".pending").toggle();
            if(status){
                $("#sol-btn").click();
            }
            else{
                alert("服务器内部出错");
            }
        }
    })

}


/*data:{
    time,space,state,sub-time
}
*/
function setAnswerLog(data) {
    let list = $(".record-container").empty();
    for(i in data){
        let str =
            `<div class="record row">
              <div class="submit-time col-4">${data[i].time}</div>
              <div class="submit-state col-2"><span style="color: var(--${data[i].state===0?"success":"danger"})">
              ${data[i].state===0?"通过":"错误"}
              </span></div>
              <div class="submit-used-time col-3">${data[i].used_time}ms</div>
              <div class="submit-used-space col-3">${data[i].used_space}mb</div>
            </div>`
        list.append(str);
    }
}

function saveToLocal() {
    localStorage.setItem("localCode",editor.getValue());
}
function restoreFromLoacl() {
    editor.setValue(localStorage.getItem("localCode"));
}
function getDefaultCode() {
    editor.setValue(problemInfo.default_code);
}
function getLatestSubmit() {
    editor.setValue(problemInfo.last_code);
}