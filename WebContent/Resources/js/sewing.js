var sew_count = 0;
var index = 0;
var listNameTeam ;

function postSewing(tableId) {
    console.log("add sewing in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addSewing/"+tableId,
        success: function (data) {
            var redirect =  data;
            if(redirect){
                window.location.replace(redirect);
            }
        },
        error: function(e){
            alert('Error: ' +JSON.stringify(e));
        }
    });
}

function addSewing(tabId,intIndex) {
    index = intIndex + sew_count;
    var div = document.getElementById("mySewing");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var div1 = document.createElement("div");
    div1.className = "col-sm-4 p-0";
    var div2 = document.createElement("div");
    div2.className = "col-sm-4 p-0";
    var div3 = document.createElement("div");
    div3.className = "col-sm-3 p-0";
    var div4 = document.createElement("div");
    div4.className = "col-sm-1 p-0";
    var inputid = document.createElement("input");
    inputid.id = "sewingList"+index+".id";
    inputid.type = "text";
    inputid.name = "sewingList["+index+"].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.setAttribute('value',"0");
    var inputtableid = document.createElement("input");
    inputtableid.id = "sewingList"+index+".table_id";
    inputtableid.type = "text";
    inputtableid.name = "sewingList["+index+"].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.setAttribute('value',tabId.toString());


    var selectName = document.createElement("select");
    selectName.id = "sewingList"+index+".name";
    selectName.name = "sewingList["+index+"].name";
    for (var i = 0; i < listNameTeam.length; i++) {
        if(listNameTeam[i].team_id == 3){
            var option = document.createElement("option");
            option.setAttribute('value', listNameTeam[i].name);
            option.innerHTML = listNameTeam[i].name;
            selectName.appendChild(option);
        }
    }


    var inputPrice = document.createElement("input");
    inputPrice.id = "sewingList"+index+".price";
    inputPrice.type = "text";
    inputPrice.name = "sewingList["+index+"].price";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "sewingList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "sewingList["+index+"].quantity";
    div1.appendChild(inputid);
    div1.appendChild(inputtableid);
    div1.appendChild(selectName);
    div1.innerHTML += '<br><br>';
    div2.appendChild(inputPrice);
    div3.appendChild(inputQuantity);
    var a = document.createElement("a");
    a.className = "btn-danger btn-xs";
    a.innerText = "-";
    a.onclick = function (ev) {
        a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
    };
    div4.appendChild(a);
    divrow.appendChild(div1);
    divrow.appendChild(div2);
    divrow.appendChild(div3);
    divrow.appendChild(div4);
    div.appendChild(divrow);
    sew_count++;
}

var sewingScript = {
    editTableValidateForm: function () {
        var nameSewing = $("#mySewing > div.row > div > select[id*=name]");
        var priceSewing = $("#mySewing > div.row > div > input[id*=price]");
        var quantitySewing= $("#mySewing > div.row > div > input[id*=quantity]");

        if(typeof nameSewing.val() === "undefined")
            return true;
        else{
            for(var i=0;i<nameSewing.size();i++){
                if(nameSewing.get(i).value == ""){
                    nameSewing.get(i).style.borderColor = "red";
                    return false;
                }else
                    nameSewing.get(i).style.borderColor = "";

                if(isNaN(priceSewing.get(i).value) || priceSewing.get(i).value <= 0 ||  priceSewing.get(i).value == "" ) {
                    priceSewing.get(i).style.borderColor = "red";
                    return false;
                }else
                    priceSewing.get(i).style.borderColor = "";

                if(isNaN(quantitySewing.get(i).value) || quantitySewing.get(i).value <= 0 ||  quantitySewing.get(i).value == "" ) {
                    quantitySewing.get(i).style.borderColor = "red";
                    return false;
                }else
                    quantitySewing.get(i).style.borderColor = "";
            }
        }
    }
};