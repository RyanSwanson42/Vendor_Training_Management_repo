$( document ).ready(function() {
	
    var newRequestQuantity = newIntRequests;
    var inProcessRequestQuantity = inProgIntRequests;
    var finalRequestQuantity = finalIntRequests;
	
    function showForm(offset) {
        document.getElementById('popup').style.display = "block";
    }
    
    function hideForm() {
        document.getElementById('popup').style.display = "none";
    }
    
    $("body").on('hover','.pull-right', function () {
        var buttonPosition = ($(this).offset().top);
        showForm(buttonPosition);
    },
    function() {
        hideForm();
    }
);

    
//    $(".pull-right").hover(function () {
//            var buttonPosition = ($(this).offset().top);
//            showForm(buttonPosition);
//        },
//        function() {
//            hideForm();
//        }
//    );

    var newRequest = 
    	"<div class='row'>"
        +	"<div class='col-md-12 box'>"
        +		"<div class='row'>"
        +    	"<label>Request #:</label> <span>54354624243</span>"
        +    	"<span class='spacer'></span>"
		+			"<div class='icon'>"
		+				"<img src='${icon}'>"
		+			"</div>"
        +		"</div>"
        +		"<hr class='hrblack' />"
        +		"<div class='row'>"
        +			"<label>Manger:</label> <span>John Doe</span>"
        +		"</div>"
        +		"<div class='row'>"
        +			"<label>Type:</label> <span>Java</span>"
        +		"</div>"
        +		"<div class='row'>"
        +			"<label>Start Date:</label> <span>4/4/2019</span>"
        +		"</div>"
        +		"<div class='row'>"
        +			"<label>Location:</label> <span>Phoenix</span>"
        +			"<button type='button' class='btn-small btn-info pull-right'>...</button>"
        +		"</div>"
        +	"</div>"
        +"</div>"



    for(i=0;i<newRequestQuantity;i++) { // loop through dummy box / new requests
        $("#new").append(newRequest);
	}

    for(i=0;i<inProcessRequestQuantity;i++) { // in process- if even, first, odd, second
		if(i%2 == 0) {
			$("#process1").append(newRequest);
		}
	}

	for(i=0;i<inProcessRequestQuantity;i++) {
		if(i%2 != 0) {
			$("#process2").append(newRequest);
		}
	}

	for(i=0;i<finalRequestQuantity;i++) { // final box
		$("#final").append(newRequest);
	}
    
});