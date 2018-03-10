function myFunction(id) {
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