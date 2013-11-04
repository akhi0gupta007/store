var userid,token,name;
var counter1=0,counter=0,counter3=0; 
function check(){
	$('#add').hide();	
	
$.getJSON('/codebee/persistence/index', function(data) {
	  var items = [];
	
	  $.each(data, function(key, val) {
		console.log(val);
		if(key==="userid")
			userid=val
		if(key==="token")	
			token=val
		if(key=="login")
		 name = val
	  
	 	  	});
	})
	.error(function() { alert("error"); })
	.complete(function() { checkCookie(); });
	

}

function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
  {
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  if (x==c_name)
    {
    return unescape(y);
    }
  }
}

function setCookie(c_name,value,exdays)
{
var exdate=new Date();
exdate.setDate(exdate.getDate() + exdays);
var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
document.cookie=c_name + "=" + c_value;
}

function checkCookie()
{
	hello(userid); // makes the product table
	makeCollectionTable(userid); //make collection table
	$('#details').hide();
	$("#sub_category").append('<option value=0>Create New Catogory Instead</option>');
	$("#sub_category").append('<option value=0>--------</option>');
	
	makeComboBox(userid,"customCollection","sub_category");
	makeTypeBox(userid,"protype");
	
	$("#protype").append('<option value=0>Create New Type Instead</option>');
	$("#protype").append('<option value=0>--------</option>');
	
	makeVendorBox(userid,"sub_ven");
	
	$("#sub_ven").append('<option value=0>Create New Vendor Instead</option>');
	$("#sub_ven").append('<option value=0>--------</option>');
	
	console.log("Userid .."+userid+"Token.."+token);
	setCookie("userid",userid,365);
	setCookie("token",token,365);
	
	$("#wel").html("Welcome <em>"+name+" </em>thanks for login, <a href='/codebee/persistence/logout'>Logout</a>");

}

function makeVendorBox(id,attr){
	
	var uri = '/codebee/api/user/'+id
  $.getJSON(uri, function(data) {
	var items = [];
	var junk = 'select#'+attr;
	//$(junk+'  option').remove(); 
	//console.log(data.data.proType[0]);
	for(var i=0 ; i < data.data.vendor.length; i++){
		var go = '/codebee/api/'+'vendor'+'/'+data.data.vendor[i];
		
				$.getJSON(go,function(hello){
				//	console.log(hello.data.id+hello.data.type);
					var row = "<option value=\"" + hello.data.id + "\">" + hello.data.ven_name+ "</option>"; 
                    $(row).appendTo(junk); 	
							});
						
		}	
	})
	.error(function() { alert("error,login please"); })
	.complete(function() { });
	
}
function makeComboBox(id,what,attr)

{
	
  var uri = '/codebee/api/user/'+id
  $.getJSON(uri, function(data) {
	var items = [];
	var junk = 'select#'+attr;
	//$(junk+'  option').remove(); 
	console.log(data.data.collection[1]);
	for(var i=0 ; i < data.data.collection.length; i++){
		var go = '/codebee/api/'+what+'/'+data.data.collection[i];
		
				$.getJSON(go,function(hello){
					console.log(hello.data.id+hello.data.name+"......."+hello.data.parent);
                    if(hello.data.parent == null){
                        var row = "<option value=\"" + hello.data.id + "\">" + hello.data.name+ "</option>";
                        $(row).appendTo(junk);
                    }
							});
						
		}	
	})
	.error(function() { alert("error,login please"); })
	.complete(function() { });
	
	
}

function makeTypeBox(id,attr)

{
	
  var uri = '/codebee/api/user/'+id
  $.getJSON(uri, function(data) {
	var items = [];
	var junk = 'select#'+attr;
	//$(junk+'  option').remove(); 
	console.log(data.data.proType[0]);
	for(var i=0 ; i < data.data.proType.length; i++){
		var go = '/codebee/api/'+'proType'+'/'+data.data.proType[i];
		
				$.getJSON(go,function(hello){
					console.log(hello.data.id+hello.data.type);
					var row = "<option value=\"" + hello.data.id + "\">" + hello.data.type+ "</option>"; 
                    $(row).appendTo(junk); 	
							});
						
		}	
	})
	.error(function() { alert("error,login please"); })
	.complete(function() { });
	
	
}


	  function function1(colors) {
		 
       var col = (colors.options[colors.selectedIndex].value);
              if (col == 0 && counter < 1) { 
		
			 var element = document.createElement("input");
			 element.setAttribute("type","text");
			 element.setAttribute("id","ptype");
			 var foo = document.getElementById("fooBar");
			 foo.appendChild(element);
			  ++counter;
        }else{
			$('#ptype').remove();
			counter = 0;
			}
		
     
    } 

  function function2(colors) {
		
       var col = (colors.options[colors.selectedIndex].value);
        if (col == 0 && counter1 < 1) { 
		
			 var element = document.createElement("input");
			 element.setAttribute("type","text");
			 element.setAttribute("id","ctype");
			 var foo = document.getElementById("fooBar1");
			 foo.appendChild(element);
			 ++counter1;
        }else{
			$('#ctype').remove();
			counter1 = 0;
			}
	
    } 
  
  function quantity(arg){


        var check = $('#qu').is(":checked");
        if(check){

            $('#qq').show()
            var element = document.createElement("input");
            element.setAttribute("type","text");

            element.setAttribute("id","ran");
            element.setAttribute("size","3")
            var foo = document.getElementById("qq");
            foo.appendChild(element);

        }else{
            console.log("wrong");
            $('#ran').remove()
            $('#qq').hide()

        }

	  }

    $('#newat').click(function(event){
        var element = document.createElement("input");
        element.setAttribute("type","text");
        element.setAttribute("id","attr_name");
        element.setAttribute("name","attr_name");
        var element1 = document.createElement("input");
        element1.setAttribute("type","text");
        element1.setAttribute("id","attr_value");
        element1.setAttribute("name","attr_value");
        var foo = document.getElementById("div_attr");
        var bar = document.getElementById("div_value");
        foo.appendChild(element);
        bar.appendChild(element1);
       // $('#proform').append(element);
        //$('#proform').append(element1);
    });


  

    function attr(argv){

        var check = $('#new').is(":checked");
        if(check){
            $('#attr').show();
        }else{
            $('#attr').hide();
        }
        //console.log("arrived here ");

    }
    
  function function3(colors) {
		
       var col = (colors.options[colors.selectedIndex].value);
        if (col == 0 && counter3 < 1) { 
		
			 var element = document.createElement("input");
			 element.setAttribute("type","text");
			 element.setAttribute("id","vtype");
			 var foo = document.getElementById("fooBar12");
			 foo.appendChild(element);
			 ++counter3;
        }else{
			$('#vtype').remove();
			counter3 = 0;
			}
	
    } 
     
      
      $("#z").click(function(event) {
/*
    var frmvalidator  = new Validator("proform");
    frmvalidator.EnableOnPageErrorDisplay();
    frmvalidator.EnableMsgsTogether();

    frmvalidator.addValidation("title","req","Please enter your First Name");
    frmvalidator.addValidation("title","maxlen=20",	"Max length for FirstName is 20");

   // frmvalidator.addValidation("Email","maxlen=50");
    //frmvalidator.addValidation("Email","req");
    //frmvalidator.addValidation("Email","email");

     // event.preventDefault();
     */
     event.preventDefault();
	  console.log("enter form");
	
	//  $('#add').hide(); 
	  $('#show').show(); 
		
	 
		var cat = '0';
		if($('#sub_category').val()=='0'){
			if($('#ctype').val()!= '' && $('#ctype').val()!=null)
				cat = $('#ctype').val()
				}else{
			cat = $('#sub_category').val()
		  // console.log("something"+$('#sub_category').val());
		}
		
		var type = '0';
		if($('#protype').val()=='0'){
			if($('#ptype').val()!= '' && $('#ptype').val()!=null)
				type = $('#ptype').val()
				}else{
			type = $('#protype').val()
		   console.log("something"+$('#protype').val());
		}
		
		var tv = '0';
		if($('#sub_ven').val()=='0'){
			if($('#vtype').val()!= '' && $('#vtype').val()!=null)
				tv = $('#vtype').val()
				}else{
			tv = $('#sub_ven').val()
		   console.log("something"+$('#sub_ven').val());
		}

      var no = $('#ran').val()
	  var t = $('#tax').is(":checked");
	  var s =  $('#ship').is(":checked");
      var tx = 0
      if(t){
          console.log("true") ;
          tx = 1;
      }else{
          tx = 0;
          console.log("false");
      }
     // var xc = $('#attr_name').val()
    //  console.log(xc);
	  $('#xyz').attr('value',"timepass");
	  $('#collc').attr('value',cat);
	  $('#ptc').attr('value',type);
	  $('#venc').attr('value',tv);
	  $('#tc').attr('value',tx);
	  $('#sc').attr('value',s);
      $('#un').attr('value',no);
      var doit = 'yes'
     // $('#attx').attr('value',s);
      console.log("Vendor...."+t) ;

     if($('#proname').val()==null || $('#proname').val()==''){
     	 $('#proname').focus();
     	 $('#titleerror').html("Title is Required.");
     	 doit = 'no'

     }

       if($('#proid').val()==null || $('#proid').val()==''){
		 $('#proid').focus();
     	 $('#iderror').html("ID is Required.");
     	 doit ='no'
	} 

 	 	 if(doit == 'yes')
 	 	 $('#proform').submit();
 	
	
	  

   // $("#proform")
    /*
	  
	  $.post("/codebee/product/added", { sel_price:$("#sp").val(),
	  title:$("#proname").val(),
	  pro_id:$("#proid").val(),
	  description: $("#description").val(),
	  coll:cat,weight:$("#wt").val(),ptype:type,
	  tax:t,ship_addr:s,vendors:tv},"json");
		
	//window.location.reload();
	 */
  });
    
    
 function hello(id){
	var uri = '/codebee/api/user/'+id
	$.getJSON(uri, function(data) {
	var items = [];
	var junk = 'table#protype1';
	//$(junk+'  option').remove(); 
	//console.log(data.data.proType[0]);
	for(var i=0 ; i < data.data.product.length; i++){
		var go = '/codebee/api/'+'product'+'/'+data.data.product[i];
		
				$.getJSON(go,function(hello){
						
						var gov = "/codebee/api/vendor/"+hello.data.vendor;
							$.getJSON(gov,function(ven_data){
					
						var row ="<tr><td><input type='checkbox' value='"+hello.data.id+"'/></td>"+
							"<td>"+hello.data.pro_id+ "</td><td>"+hello.data.title+"</td>"+
							"<td>"+hello.data.sel_price+"</td><td>"+hello.data.description+"</td>"+
							"<td>"+ven_data.data.ven_name+"</td></tr>";
						 $(row).appendTo(junk); 
					
						 });
				                  	
							});
						
		}	
	})
	.error(function() { alert("error,login please"); })
	.complete(function() { }); 
		
	 
	 }    
    
     function fetchProduct(id){
         var uri = '/codebee/product/service/'+id;

         var title,quantity;
         $.getJSON(uri, function(data) {

                 title = data;


         })
             .complete(function() {
                 var array = String(title).split(',');
                 console.log(array);
                 $('#product').html("<h3 align='center'>"+array[0]+"</h3>");
                 $('#product').append("<form action='/codebee/wareHouse/service' method='post'>Existing Quantity : <input type='text' size='3' name='existing' value='"+array[1]+"'/><br>" +
                     "<br>No.Of Units available here:<input type='text' size='3' value='' name='units'><input type='hidden' name='id' value="+id+"><br><br>" +
                     "<input type='submit' value='Add to WareHouse'></form>");
                 $('#product').append("");
             });


     }

    function makeCollectionTable(id){
		
	var uri = '/codebee/api/user/'+id;
	
	$.getJSON(uri, function(data) {
	var items = [];
	var junk = 'table#showc';
	
	for(var i=0 ; i < data.data.collection.length; i++){
		var go = '/codebee/api/'+'customCollection'+'/'+data.data.collection[i];
		
				$.getJSON(go,function(hello){
				//	console.log(hello.data.name+hello.data.description);
						
			var row = 
				"<td><em><a href='' onClick='linkAction("+hello.data.id+"); return false'>"+hello.data.name+ "</a></em></td>";
			 $(row).appendTo(junk); 
			 
			});
	
			}   	
							})
	.error(function() { alert("error,login please"); })
	.complete(function() { }); 	
		
		
		}

function linkAction(id){


	$('#showcol').hide();
	$('#details').show();
	var uri = "collect.html?id=2";
	
	console.log(uri);
	$("#details").load(uri);
	
	
	
	return false;
	}		


 $("#yahoo").click(function(event) {

     var cat = '0';
     if($('#sub_category').val()=='0'){
         if($('#ctype').val()!= '' && $('#ctype').val()!=null)
             cat = $('#ctype').val()
     }else{
         cat = $('#sub_category').val()
         // console.log("something"+$('#sub_category').val());
     }

     var type = '0';
     if($('#protype').val()=='0'){
         if($('#ptype').val()!= '' && $('#ptype').val()!=null)
             type = $('#ptype').val()
     }else{
         type = $('#protype').val()
      //   console.log("something"+$('#protype').val());
     }
     var no = $('#ran').val();

    // console.log("Type is "+cat);
     var t = $('#tax').is(":checked");
     $('#collc').attr('value',cat);
     $('#ptc').attr('value',type);
     $('#tc').attr('value',t);

     $('#un').attr('value',no);
    // console.log(no)
     $('#proform').submit();
	//alert('hi guysso what');

      });



  $('#popup').click(function(event){
       // console.log("ho gaay");
       	var junk = 'table#templates';

		var row ="<tr id= 'del'><td><input type='text' id='new' name='attx' placeholder='Define Attribute'/></td>"+
							"<td><input type='text' id='const' name='const' placeholder='Constraint'/></td><td><input type='button'"+
							 "value='Remove' onClick='some(this)'/></td>";
						
		$(row).appendTo(junk); 
		/*
        var element = document.createElement("input");
        element.setAttribute("type","text");
        element.setAttribute("id","new");
        element.setAttribute("name","attx");
        
        element.setAttribute("placeholder","Attributes")
        var foo = document.getElementById("new_attr");

        //$('#new_attr').html("Just Type the Name of Attributes for your Product")
        foo.appendChild(element);
*/
        // $('#proform').append(element);
        //$('#proform').append(element1);
    });

 function some(remove){
 	console.log("hihi");
 	$(remove).parent().parent().remove();
 }


$('#temp').click(function(event) {
   $("#dont").submit();
});

function addedCart(){
	
	alert('Added in Cart');
}