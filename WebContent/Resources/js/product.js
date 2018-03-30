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
    var div1 = document.createElement("div");
    div1.className = "col-sm-6 p-0";
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
    var div2 = document.createElement("div");
    div2.className = "col-sm-5 p-0";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "productList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "productList["+index+"].quantity";
    div1.appendChild(inputid);
    div1.appendChild(inputtableid);
    div1.appendChild(inputName);
    div1.innerHTML += '<br><br>';
    div2.appendChild(inputQuantity);
    var div3 = document.createElement("div");
    div3.className = "col-sm-1 p-0";
    var a = document.createElement("a");
    a.className = "btn-danger btn-xs";
    a.innerText = "-";
    a.onclick = function (ev) {
        a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
    };
    div3.appendChild(a);
    divrow.appendChild(div1);
    divrow.appendChild(div2);
    divrow.appendChild(div3);
    div.appendChild(divrow);
    prod_count++;
}

var productScript = {
    editTableValidateForm: function () {
        var nameProduct = $("#myProduct > div.row > div > input[id*=name]");
        var quantityProduct = $("#myProduct > div.row > div > input[id*=quantity]");
        if(typeof nameProduct.val() === "undefined")
            return true;
        else{
            for(var i=0;i<nameProduct.size();i++){
                if(nameProduct.get(i).value == ""){
                    nameProduct.get(i).style.borderColor = "red";
                    return false;
                }else
                    nameProduct.get(i).style.borderColor = "";

                if(isNaN(quantityProduct.get(i).value) || quantityProduct.get(i).value <= 0 ||  quantityProduct.get(i).value == "" ) {
                    quantityProduct.get(i).style.borderColor = "red";
                    return false;
                }else
                    quantityProduct.get(i).style.borderColor = "";
            }

        }
    }

};









