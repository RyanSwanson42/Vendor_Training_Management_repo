
$(function () {
    $('[data-toggle=popover]').popover({
        html: true,
        content: function () {
            return $('#popover_content_wrapper').html();
        }
    }).click(function () {
        $(this).popover('show');
        $("#popover").popover({
            trigger: "hover"
        });
    });

    function openNav() {
        document.getElementById("mySidebar").style.width = "350px";
    }

    function closeNav() {
        document.getElementById("mySidebar").style.width = "0";
    }

    //Accordion

    // $('#intro').click(function () {
    //     $(this).siblings("#accordion-form1").toggle();
    // });
    var Accordion = function (el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;

        // Variables
        var links = this.el.find('.link');
        // Event
        links.on('click', {
            el: this.el,
            multiple: this.multiple
        }, this.dropdown)
    }

    Accordion.prototype.dropdown = function (e) {
        var $el = e.data.el;
        $this = $(this),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        };
    }

    var accordion = new Accordion($('#accordion'), false);
/*
    $(".datepicker").datepicker();

    $.extend($.datepicker, {
        _checkOffset: function (inst, offset, isFixed) {
            offset.top = 30;
            offset.left = 1075;
            return offset;
        }
    });*/

    $(".approval").change(function () {
        if ($(this).value == "approved") { // or this.value == 'volvo'

        }
    });

    const article = document.querySelector(".approval");

    if ((article.dataset.dec) == "approved") {
        $(".approval").css({"border": "5px solid #7FFF00" }) 
    } else {
        $(".approval").css({"border": "5px solid #FF0000" }) 
        $("input").prop('disabled', true);
    }
})


$(document).ready(function() {
	$(".navsearch").keyup(function(){
		$(".proc-card").show();
		var input=$(".navsearch").val();
		
		var type=$("#filterList").val();
		//console.log(type);
		$(".proc-card").each(function(){
			if(!$(this).find(type).text().includes(input) && input !=""){
				$(this).hide();
			}
			
		})
	})
});


// $(document).ready(function(){
//     $('.danger').popover({ 
//       html : true,
//       content: function() {
//         return $('#popover_content_wrapper').html();
//       }
//     });
//   });
