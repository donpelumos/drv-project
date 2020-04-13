$(document).ready(function(){
    $("#selector").change(function(){
        var selectedCountry = $(this).children("option:selected").val();
        //alert("You have selected the country - " + selectedCountry);
    });
});