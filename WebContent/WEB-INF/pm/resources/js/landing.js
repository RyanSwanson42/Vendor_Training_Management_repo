/**
 * 
 */
$(document).ready(function(){
					$("#message").text("View Processed Requests");
					$('.card-green').css('display','none');


			});

			$("form").submit(function() {
   				$(":submit", this).attr("disabled", "disabled");
			});
			
			function toggle(){
				if($("#message").text()=="View Pending Requests"){
					$('#mycheck').bootstrapToggle('on');
					$("#message").text("View Processed Requests");
					$('.card-green').css('display','none');
					$('.card-yellow').css('display','');
					$('.card-red').css('display','');
					}
					else{
					$('#mycheck').bootstrapToggle('off')
					$("#message").text("View Pending Requests");
					$('.card-green').css('display','');
					$('.card-yellow').css('display','none');
					$('.card-red').css('display','none');
				}
			};
			function test() {
				if($("#message").text()=="View Processed Requests"){
					$("#message").text("View Pending Requests");
					$('.card-green').css('display','');
					$('.card-yellow').css('display','none');
					$('.card-red').css('display','none');
				}
				else{
					$("#message").text("View Processed Requests");
					$('.card-green').css('display','none');
					$('.card-yellow').css('display','');
					$('.card-red').css('display','');
					
				}
			};
			function statpop(stat,id){
				var green = ['122','222','322','130','230','330' ];
				var yellow = ['104','105','106','107','108','109','204','205',
					'206','207','208','209','304','305','306','307','308','309',
					'103','203','303','100','120','220','320','121','221','321',];
				var red = ['110','210','310'];

				if(green.includes(stat.toString())){

					$('#'+id).addClass("card-green");
					$('.'+stat).popover({
						trigger: "hover",
						title:"Status",
						placement:"bottom",
						content:"Request in progress.",
					});
					
				}else if(yellow.includes(stat.toString())){
					$('#'+id).addClass("card-yellow");
					$('.'+stat).popover({
						trigger: "hover",
						title:"Status",
						placement:"bottom",
						content:"Waiting for Trainer Action.",
					});
					
				}else if(red.includes(stat.toString())){
					$('#'+id).addClass("card-red");
					$('.'+stat).popover({
						trigger: "hover",
						title:"Status",
						placement:"bottom",
						content:"Action Required.",
					});
				}
			}
			$(this).ready(function(){
			
				$('.btn').on('focusout', function () {
					$('.btn').popover('hide');
				});
				$('.moduleDetails').popover({
					title:"Module:",
				});
				$('.expandDetails').popover({
					title:"Details<br>",
					placement:"bottom",
					
				});
				$('.spocDetails').popover({
					title:"SPOC",
				});
				
						
			});