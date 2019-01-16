$(document).ready(function () {
    $("select[id*=team_id]").change(function () {
        var team_id = $("select[id*=team_id]").val();
        window.location.replace('/ManageTable/statistics/'+team_id);
    });

    $("#statistic").click(function () {
        var txtName = $("select[id*=name]").val();
        var txtTeamId = $("select[id*=team_id]").val();
        $.post("/ManageTable/statistic", {name: txtName, team_id: txtTeamId}, function(result){
            var str = JSON.stringify(result);
            var json = JSON.parse(str);
            $("#report > tr > td > div[class=\"container-fluid\"]").empty();
            if(txtTeamId == 1){
                $("#report > .tb-row > #name").text(txtName);
                $("#report > .tb-row > #name").text(txtName);
                $("#report > .tb-row > #team_id").text("In");
                var totalall = 0;
                for(var i = 0; i < json.printerList.length; i++){
                    var index = i+1;
                    var nameTable = json.orderTableList[i].name;
                    var total = json.printerList[i].total;
                    var price = json.printerList[i].price;
                    var quantity = json.printerList[i].quantity;
                    totalall = totalall + total;
                    $("#report > tr > td > div[class=\"container-fluid\"]").append("<div class='row' style='border: 1px dashed darkgrey'>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "</div>");
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(1)").text(nameTable);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(2)").text(price);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(3)").text(quantity);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(4)").text(total.toLocaleString('en'));
                }
                $("#report > .tb-row > #totalall").text(totalall.toLocaleString('en'));
            }else if(txtTeamId == 2){
                $("#report > .tb-row > #name").text(txtName);
                $("#report > .tb-row > #team_id").text("Thêu");
                var totalall = 0;
                for(var i = 0; i < json.embroideryList.length; i++){
                    var index = i+1;
                    var nameTable = json.orderTableList[i].name;
                    var total = json.embroideryList[i].total;
                    var price = json.embroideryList[i].price;
                    var quantity = json.embroideryList[i].quantity;
                    totalall = totalall + total;
                    $("#report > tr > td > div[class=\"container-fluid\"]").append("<div class='row' style='border: 1px dashed darkgrey'>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "</div>");
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(1)").text(nameTable);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(2)").text(price);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(3)").text(quantity);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(4)").text(total.toLocaleString('en'));
                }
                $("#report > .tb-row > #totalall").text(totalall.toLocaleString('en'));
            }else if(txtTeamId == 3){
                $("#report > .tb-row > #name").text(txtName);
                $("#report > .tb-row > #team_id").text("May");
                var totalall = 0;
                for(var i = 0; i < json.sewingList.length; i++){
                    var index = i+1;
                    var nameTable = json.orderTableList[i].name;
                    var total = json.sewingList[i].total;
                    var price = json.sewingList[i].price;
                    var quantity = json.sewingList[i].quantity;
                    totalall = totalall + total;
                    $("#report > tr > td > div[class=\"container-fluid\"]").append("<div class='row' style='border: 1px dashed darkgrey'>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "<div class='col-sm-3'></div>" +
                        "</div>");
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(1)").text(nameTable);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(2)").text(price);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(3)").text(quantity);
                    $("#report > tr > td > div[class=\'container-fluid\'] > div:nth-of-type("+index+") > div:nth-of-type(4)").text(total.toLocaleString('en'));
                }
                $("#report > .tb-row > #totalall").text(totalall.toLocaleString('en'));
            }
        });
    })


})

