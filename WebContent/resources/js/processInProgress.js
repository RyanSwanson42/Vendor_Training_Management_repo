$(document).ready(function () {

    $(function () {
        $("#startDate").datepicker();
    });

    $(function () {
        $("#endDate").datepicker();
    });

    function showClass() {
        $("#modeClassroom").show();
        $("#modeVirtual").hide();
    }

    function showVirtual() {
        $("#modeClassroom").hide();
        $("#modeVirtual").show();
    }
    
    $("#classroom").click(function() {
        showClass();
    });

    $("#virtual").click(function() {
        showVirtual();
    });
});
