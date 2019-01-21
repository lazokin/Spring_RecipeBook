$("#addToShoppingListButton").click(function() {
	$("#ingredients-list-group > li").each(function(index) {
		var name = $( this ).text().split(" ")[0];
		var amount = $( this ).text().match("[0-9]")[0];
		var ingredient = { "name": name, "amount": parseInt(amount)};
		$.ajax({
		    url: "/shopping-list/ingredients",
			type: "post",
			data: JSON.stringify(ingredient),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		});
	});
});

$("#deleteShoppingListButton").click(function() {
	let selectedIndex = $("#selectedIndex").val();
	$.ajax({
	    url: "/shopping-list/" + selectedIndex + "/delete",
		type: "delete"
	}).always(function() {
		window.location.href = '/shopping-list'
	});
});

$("#clearShoppingListButton").click(function() {
	window.location.href = '/shopping-list'
});

$( ".form-control" ).change(function() {
	$("#clearShoppingListButton").prop('disabled', false);
});