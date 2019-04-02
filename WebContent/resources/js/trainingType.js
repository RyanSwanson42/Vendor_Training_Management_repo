$(document).ready(function () {

    $('.classRoomForm').hide();
    $('.onlineForm').hide();
   
    $('.classRoom').click(function() {
        $('.classRoomForm').show();
        $('.onlineForm').hide().prop('required', false);
    })
    
    $('.online').click(function() {
        $('.onlineForm').show();
        $('.classRoomForm').hide().prop('required', false);
    })
    
});