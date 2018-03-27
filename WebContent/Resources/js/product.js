function postProduct(tableId) {
    console.log("add product in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addproduct/"+tableId,
        success: function (data) {
            var redirect =  data;
            if(redirect){
                window.location.replace(redirect);
            }
            // window.location.reload(true);
        },
        error: function(e){
            alert('Error: ' +JSON.stringify(e));
        }
    });
}

var prod_count = 0;
var index = 0;
function addProduct(tabId,intIndex) {
    index = intIndex + prod_count;
    var div = document.getElementById("myProduct");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var divleft = document.createElement("div");
    divleft.className = "p-0";
    divleft.style = "float: left;width: 90%";
    var inputid = document.createElement("input");
    inputid.id = "productList"+index+".id";
    inputid.type = "text";
    inputid.name = "productList["+index+"].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.setAttribute('value',"0");
    var inputtableid = document.createElement("input");
    inputtableid.id = "productList"+index+".table_id";
    inputtableid.type = "text";
    inputtableid.name = "productList["+index+"].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.setAttribute('value',tabId.toString());
    var inputName = document.createElement("input");
    inputName.id = "productList"+index+".name";
    inputName.type = "text";
    inputName.name = "productList["+index+"].name";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "productList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "productList["+index+"].quantity";
    divleft.appendChild(inputid);
    divleft.appendChild(inputtableid);
    divleft.appendChild(inputName);
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
    prod_count++;
}

var productScript = {
    editTableValidateForm: function () {
        var nameProduct = $("#myProduct > div.row > div.p-0 > input[id*=name]");
        var quantityProduct = $("#myProduct > div.row > div.p-0 > input[id*=quantity]");
        if(typeof nameProduct.val() === "undefined")
            return true;
        else{
            if(nameProduct.val() == ""){
                nameProduct.css("borderColor","red");
                return false;
            }else
                nameProduct.css("borderColor","");

            if(isNaN(quantityProduct.val()) || quantityProduct.val() <= 0 ||  quantityProduct.val() == "" ) {
                quantityProduct.css("borderColor","red");
                return false;
            }else
                quantityProduct.css("borderColor","");
        }
    }

};









