//for single datepicker
$(document).ready(function () {
    $('.input-group.date').datepicker({
        keyboardNavigation: false,
        forceParse: false,
        format: 'dd-mm-yyyy'
    }).on('changeDate', function(e) {
    	 if($('.input-daterange').length > 0)
		 {
    		 $('.input-daterange').find('input[type="text"]').val("");
		 }
    });

    //for lined datepicker
    $('.input-daterange').datepicker({
        keyboardNavigation: false,
        forceParse: false,
        format: 'dd-mm-yyyy'
    }).on('changeDate', function(e) {
   	 if($('.input-group.date').length > 0)
	 {
		 $('.input-group.date').find('input[type="text"]').val("");
	 }
});


    //table check all
    $("#nurse-table #checkall").click(function () {
        if ($("#nurse-table #checkall").is(':checked')) {
            $("#nurse-table input[type=checkbox]").each(function () {
                $(this).prop("checked", true);
            });

        } else {
            $("#nurse-table input[type=checkbox]").each(function () {
                $(this).prop("checked", false);
            });
        }
    });

    $("[data-toggle=tooltip]").tooltip();
});

function equalize(sel)
{
    ht = 0;

    $(sel).each(function(k,v){
        if(ht < $(v).height())
            {
                ht = $(v).height();
            }
    });

    $(sel).height(ht);
}