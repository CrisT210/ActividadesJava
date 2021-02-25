$(document).ready(function(){

$('form.join').submit(function(){ 
	$(this).find('button[type=submit]').attr('disabled', 'disabled');
});

});