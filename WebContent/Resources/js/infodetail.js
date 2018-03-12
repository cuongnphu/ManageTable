function addProduct(id) {
    console.log("add product in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addproduct/"+id,
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

function addPrinter(id) {
    console.log("add printer in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addprinter/"+id,
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


function addEmbroidery(id) {
    console.log("add embroidery in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addEmbroidery/"+id,
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

function addSewing(id) {
    console.log("add sewing in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addSewing/"+id,
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

function addMaterial(id) {
    console.log("add material in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addMaterial/"+id,
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
