/*function validate_component1()
{
    var val1 = $("#component1").val();
    var numRGEX = /^[0-9]+$/;
    var result = numRGEX.test(val1);
    return result;
}
function validate_component2()
{
    var val1 = $("#component2").val();
    var numRGEX = /^[0-9]+$/;
    var result = numRGEX.test(val1);
    return result;
}*/
function callback(response) {
    $("#regex").text(response.regex);
}

function ajax_post() {
    var regexValue = $("#component1").val();
    if (regexValue.length > 0) {
        $("#component2").prop('disabled', false);

        $.post(
            "regex",
            {
                component1: $("#component1").val(),
                component2: $("#component2").val(),
            },
            callback,
            "json");
        
    } else {
        $("#component2").prop('disabled', true);
    }
}

function ajax_get() {
    $.get(
        "regex",
        {
            component1: $("#component1").val(),
            component2: $("#component2").val(),
        },
        callback,
        "json");
}
$("#component1").focusout(ajax_post);
$("#component2").focusout(ajax_get);