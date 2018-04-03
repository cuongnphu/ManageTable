var checkNameTeam = false;
var teamScript = {
    teamFormValidate: function () {
        var nameTeam = $("#nameTeam");

        if(nameTeam.get(0).value == ""){
            nameTeam.get(0).style.borderColor = "red";
            return false;
        }else
            nameTeam.get(0).style.borderColor = "";

        if(checkNameTeam == false){
            nameTeam.get(0).style.borderColor = "red";
            return false;
        }else
            nameTeam.get(0).style.borderColor = "";

    },
    
    editTeamConfirmOut: function () {
        if (confirm("Bạn muốn thoát ??? ") == true)
            window.location.replace('/ManageTable/teams');
    },
    
    teamFormConfirmDelete: function (id) {
        if(confirm("BẠN thật sự muốn XÓA đội này ??? ") == true)
            window.location.replace("deleteteam/"+id);
    },
    
    teamFormConfirmEdit: function (id) {
        if(confirm("BẠN muốn CẬP NHẬT thông tin đội này ??? ") == true)
            window.location.replace("editteam/"+id);
    }
};

$(document).ready(function () {
    $("#nameTeam").focusout(function () {
        var txt = $("#nameTeam").val();
        $.post("/ManageTable/checkteam", {suggest: txt}, function(result){
            checkNameTeam = result;
        });
    });
})


