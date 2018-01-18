$(function () {

    $("#firstName").blur(validateAlphaInput);
    $("#firstName").keypress(formatNames);

    $("#lastName").blur(validateAlphaInput);
    $("#lastName").keypress(formatNames);

    $("#addressZipCode").blur(validateZipCode);
    $("#addressZipCode").keypress(formatZipCode);

    $(".register-form-radio").blur(removeErrorLabel);

    function removeErrorLabel() {
        var $radioDivs = $(this).parent().parent();
        $radioDivs.each(function() {
            var $errorLabel = "#errlbl_" + $(this)[0].id;
            $("label").remove($errorLabel);
        });
    }

    function validateAlphaInput() {
        $(this).removeClass("error");

        var regexp = /[Aa-zZ]/g;
        if (!regexp.test($(this).val())) {
            $(this).addClass("error");
        }
    }

    function formatNames(e) {
        var $input = $(this);
        var key = e.which || e.charCode || e.keyCode || 0;
        var keyStr = String.fromCharCode(key);
        var regexp = /[Aa-zZ]/g;

        if (regexp.test(keyStr) && $input.val().length === 0) {
            $input.val($input.val().toUpperCase());
        }
    }

    function validateZipCode() {
        $(this).removeClass("error");

        var $zipCode = $(this);
        var regexp = /[0-9]{5}-[0-9]{3}/g;
        if (!regexp.test($zipCode.val())) {
            $(this).addClass("error");
        } else {
            $(".autofill-enabled").attr("disabled", false);
        }
    }

    function formatZipCode(e) {
        var $zipCode = $(this);
        var key = e.which || e.charCode || e.keyCode || 0;

        if (key !== 8 && key !== 9) {
            if ($zipCode.val().length === 5) {
                $zipCode.val($zipCode.val() + '-');
            }
        }

        var regexp = /8|4[8-9]|5[0-7]/g;
        if (!regexp.test(key) || $zipCode.val().length > 9) {
            return false;
        }
    }

});