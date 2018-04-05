var embro_count = 0;
var index = 0;
var listNameTeam ;

function postEmbroidery(tableId) {
    console.log("add embroidery in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addEmbroidery/"+tableId,
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

function addEmbroidery(tabId,intIndex) {
    index = intIndex + embro_count;
    var div = document.getElementById("myEmbroidery");
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
    inputid.id = "embroideryList"+index+".id";
    inputid.type = "text";
    inputid.name = "embroideryList["+index+"].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.setAttribute('value',"0");
    var inputtableid = document.createElement("input");
    inputtableid.id = "embroideryList"+index+".table_id";
    inputtableid.type = "text";
    inputtableid.name = "embroideryList["+index+"].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.setAttribute('value',tabId.toString());

    var selectName = document.createElement("select");
    selectName.id = "embroideryList"+index+".name";
    selectName.name = "embroideryList["+index+"].name";
    for (var i = 0; i < listNameTeam.length; i++) {
        if(listNameTeam[i].team_id == 2){
            var option = document.createElement("option");
            option.setAttribute('value', listNameTeam[i].name);
            option.innerHTML = listNameTeam[i].name;
            selectName.appendChild(option);
        }
    }

    var inputPrice = document.createElement("input");
    inputPrice.id = "embroideryList"+index+".price";
    inputPrice.type = "text";
    inputPrice.name = "embroideryList["+index+"].price";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "embroideryList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "embroideryList["+index+"].quantity";
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
    embro_count++;
}

var embroideryScript = {
    editTableValidateForm: function(){
        var nameEmbroid = $("#myEmbroidery > div.row > div > select[id*=name]");
        var priceEmbroid= $("#myEmbroidery > div.row > div > input[id*=price]");
        var quantityEmbroid = $("#myEmbroidery> div.row > div > input[id*=quantity]");

        if(typeof nameEmbroid.val() === "undefined")
            return true;
        else{
            for(var i=0;i<nameEmbroid.size();i++){
                if(nameEmbroid.get(i).value == ""){
                    nameEmbroid.get(i).style.borderColor = "red";
                    return false;
                }else
                    nameEmbroid.get(i).style.borderColor = "";

                if(isNaN(priceEmbroid.get(i).value) || priceEmbroid.get(i).value <= 0 ||  priceEmbroid.get(i).value == "" ){
                    priceEmbroid.get(i).style.borderColor = "red";
                    return false;
                }else
                    priceEmbroid.get(i).style.borderColor = "";

                if(isNaN(quantityEmbroid.get(i).value) || quantityEmbroid.get(i).value <= 0 ||  quantityEmbroid.get(i).value == "" ) {
                    quantityEmbroid.get(i).style.borderColor = "red";
                    return false;
                }else
                    quantityEmbroid.get(i).style.borderColor = "";
            }
        }
    }
};