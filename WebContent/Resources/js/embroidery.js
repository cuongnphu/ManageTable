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

var embro_count = 0;
var index = 0;
function addEmbroidery(tabId,intIndex) {
    index = intIndex + embro_count;
    var div = document.getElementById("myEmbroidery");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var divleft = document.createElement("div");
    divleft.className = "p-0";
    divleft.style = "float: left;width: 90%";
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
    var inputName = document.createElement("input");
    inputName.id = "embroideryList"+index+".name";
    inputName.type = "text";
    inputName.name = "embroideryList["+index+"].name";
    var inputPrice = document.createElement("input");
    inputPrice.id = "embroideryList"+index+".price";
    inputPrice.type = "text";
    inputPrice.name = "embroideryList["+index+"].price";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "embroideryList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "embroideryList["+index+"].quantity";
    divleft.appendChild(inputid);
    divleft.appendChild(inputtableid);
    divleft.appendChild(inputName);
    divleft.innerHTML += '<br>';
    divleft.appendChild(inputPrice);
    divleft.innerHTML += '<br>';
    divleft.appendChild(inputQuantity);
    divleft.innerHTML += '<br><br>';
    var divright = document.createElement("div");
    divright.className = "p-1";
    divright.style = "float:right;width:8%";
    var a = document.createElement("a");
    a.className = "btn-primary btn-xs";
    a.innerText = "-";
    a.onclick = function (ev) {
        a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
    };
    divright.appendChild(a);
    divrow.appendChild(divleft);
    divrow.appendChild(divright);
    div.appendChild(divrow);
    embro_count++;
};

var embroideryScript = {
    editTableValidateForm: function(){
        var nameEmbroid = $("#myEmbroidery> div.row > div.p-0 > input[id*=name]");
        var priceEmbroid= $("#myEmbroidery> div.row > div.p-0 > input[id*=price]");
        var quantityEmbroid = $("#myEmbroidery> div.row > div.p-0 > input[id*=quantity]");

        if(typeof nameEmbroid.val() === "undefined")
            return true;
        else{
            if(nameEmbroid.val() == ""){
                nameEmbroid.css("borderColor","red");
                return false;
            }else
                nameEmbroid.css("borderColor","");

            if(isNaN(priceEmbroid.val()) || priceEmbroid.val() <= 0 ||  priceEmbroid.val() == "" ) {
                priceEmbroid.css("borderColor","red");
                return false;
            }else
                priceEmbroid.css("borderColor","");

            if(isNaN(quantityEmbroid.val()) || quantityEmbroid.val() <= 0 ||  quantityEmbroid.val() == "" ) {
                quantityEmbroid.css("borderColor","red");
                return false;
            }else
                quantityEmbroid.css("borderColor","");
        }
    }
};