
function calcTip() {
	var subtotalElem = document.getElementById('subtotal');
	var tipElem = document.getElementById('tip');
	
	var subtotal = parseInt(subtotalElem.value) ;
	var tip = parseInt(tipElem.value) 
    var total =subtotal+(subtotal*tip/100) ;
    var totalElem = document.getElementById('total').innerHTML = '$' + total;
}
