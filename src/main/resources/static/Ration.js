$(document).ready(function(){
	 $('.select2bs4').select2({
		theme: 'bootstrap4'
	});
	
	
	$('.select2bs4').on('change',function(){
		regtntable(this);
	});
	
   });





function regtntable(selecter){
	if (selecter.value == "0") {
		return false;
		}
		var office_id = selecter.value;
		var office = selecter.id;
		
		$.ajax({
	method : "POST",
	url : "/registrationdetails/regtntable",	
	data : {
		"office_id" : office_id,
		"office" :office,
		"_csrf": $('#tkn').val(),
	},
	dataType : "json",
	success: function(ulb) {
			if(ulb.status){
				var item =ulb.data[0];
				
					$('#gen_male').html(item.count1);
						$('#gen_female').html(item.count1);
						$('#sc_male').html(item.count1);
						$('#sc_female').html(item.count1);
						$('#st_male').html(item.count1);
						$('#st_female').html(item.count1);
						$('#total').html(item.count2);
				}				
			else{
				swal.fire("Info","Error to fetching!","info");	
				return false;	
			}
	},
		
});
	
}


function getulb(value) {
	if (value == "0") {
		return false;
	}
	$("#ulb").empty();
	$('#ulb').select2({
					theme: 'bootstrap4',
					data: [{id:'0', text:'---Select Municipality/Corporation ---'}],
				});
	
	$.ajax({
	method : "POST",
	url : "/mis/registrationdetails/getulb",	
	data : {
		"district_code" : value,
		"_csrf": $('#tkn').val(),
	},
	dataType : "json",
	success: function(ulb) {
			if(ulb.status){
				var res = $.map(ulb.data,function(item){
								return{id: item.ulb, text: item.ulb }
							})
				$('#ulb').select2({
					theme: 'bootstrap4',
					data: res,
				});
			}
			else{
				swal.fire("Info","Error to fetching Municipality/Corporation !","info");	
				return false;	
			}
	},
		
});
	
}

function getward(value) {
	if (value == "0") {
		return false;
	}
	$("#ward").empty();
	$('#ward').select2({
					theme: 'bootstrap4',
					data: [{id:'0', text:'---Select Ward ---'}],
				});
	
	$.ajax({
	method : "POST",
	url : "/registrationdetails/getward",	
	data : {
		"ulb_code" : value,
		"_csrf": $('#tkn').val(),
	},
	dataType : "json",
	success: function(ulb) {
			if(ulb.status){
				var res = $.map(ulb.data,function(item){
								return{id: item.ward, text: item.ward }
							})
				$('#ward').select2({
					theme: 'bootstrap4',
					data: res,
				});
			}
			else{
				swal.fire("Info","Error to fetching Ward !","info");	
				return false;	
			}
	},
		
});
	
}






// get ulb
		$('#dist').on('change',function(){
		getulb($(this).val());
	
	});
	$('#dist_reg').on('change',function(){
		getulb_reg($(this).val());
	
	});
	$('#dist_wrk').on('change',function(){
		getulb_wrk($(this).val());
	
	});
	$('#dist_wrkct').on('change',function(){
		getulb_wrkct($(this).val());
	
	});
	
	
// get ward
		$('#ulb').on('change',function(){
		getward($(this).val());
	
	});
	$('#ulb_reg').on('change',function(){
		getward_reg($(this).val());
	
	});
	$('#ulb_wrk').on('change',function(){
		getward_wrk($(this).val());
	
	});
	$('#ulb_wrkct').on('change',function(){
		getward_wrkct($(this).val());
	
	});