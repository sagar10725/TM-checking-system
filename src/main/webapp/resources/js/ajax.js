/**
 * 
 */
function changeStudentStatus(id) {
	var statusType = $("#statusType").val();
	
	$.ajax({
		type : 'POST',
		url : '/tmsystem/admin/student/verify/' + id + '?status=' + statusType,
		dataType : 'json',
		contentType : 'application/json',

		success : function(student) {
			console.log('success');
			alert('Changed to' + statusType);
			//window.location.reload(true);
		},

		error : function(errorObject) {
			console.log('failed');
			console.log(errorObject);

		}

	});
}

function showRooms() {
	var selectedValue = $("#building").val();
	/* alert(selectedValue);*/

	$.ajax({
		type : 'GET',
		url : "/tmsystem/tmchecker/get_rooms/" + selectedValue,
		dataType : 'json',
		contentType : 'application/json',

		success : function(rooms) {

			$("#room").empty();
			$.each(rooms, function(i, room) {
				$("#room").append(
						"<option value=" + room.id + ">" + room.roomNumber
								+ "</option>")
			});
		},

		error : function(errorObject) {
			console.log(errorObject);

		}

	});

}

function showCheckingSeats() {
	var selectedValue = $("#checkingType").val();
	/* alert(selectedValue);*/

	$.ajax({
		type : 'GET',
		url : "/tmsystem/admin/checkingseats/get_seats/" + selectedValue,
		dataType : 'json',
		contentType : 'application/json',

		success : function(defaultCheckingSeats) {
			$('#numberOfSeats').val(defaultCheckingSeats.numberOfSeats);
		},

		error : function(errorObject) {
			console.log(errorObject);

		}

	});

}

toggle_visibility = function(id) {
	var element = document.getElementById(id);
	if (element.style.display == 'block')
		element.style.display = 'none';
	else
		element.style.display = 'block';
}

make_hidden = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'none';
}

make_visible = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'block';
}

resetForm = function(id) {
	var element = document.getElementById(id);
	$(element)[0].reset();

}

// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};

function signupForTM(checkingHourId) {
	$.ajax({
		type : 'POST',
		url : "/tmsystem/student/signupfortm/" + checkingHourId,
		dataType : 'json',
		contentType : 'application/json',

		success : function(data) {
			window.location.href = "/tmsystem/student/mysignups";
			
		},

		error : function(errorObject) {
			console.log(errorObject);
			if (errorObject.responseJSON.errorType == "BusinessError") {
	  			    var errorList = errorObject.responseJSON.errors;
	  			    var errorData = "";
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		errorData +=  error.message + "\n";
			    	});
	 	 	        alert(errorData);
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" BusinessError Error
			}

		}

	});
}
