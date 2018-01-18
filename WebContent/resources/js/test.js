$(function() {

	var current, next, previous;
	var left, opacity, scale;
	var isAnimating;

	$('.next').on('click', function() {
		if (isAnimating) return false;
		isAnimating = true;

		current = $(this).parent();
		next = $(this).parent().next();
		
		//activate next step on progressbar using the index of next_fs
		$("#progressbar li").eq($("fieldset").index(next)).addClass("active");
		
		next.show();
		
		current.animate({
			opacity : 0
		}, {
			step : function(now, mx) {
				scale = (1 - now) * 0.2;
				left = (now * 50) + "%";
				opacity = 1 - now;
				current.css({
					'transform' : 'scale(' + scale + ')'
				});
				next.css({
					'left' : left,
					'opacity' : opacity
				});
			},
			duration : 'fast',
			specialEasing : {
				width : "linear",
				height : "easeOutBounce"
			},
			complete : function() {
				current.hide();
				isAnimating = false;
			}
		});
	});

	$('.previous').on('click', function() {
		if (isAnimating) return false;
		isAnimating = true;

		current = $(this).parent();
		previous = $(this).parent().prev();
		
		//de-activate current step on progressbar
		$("#progressbar li").eq($("fieldset").index(current)).removeClass("active");
		
		previous.show();

		current.animate({
			opacity : 0
		}, {
			step : function(now, mx) {
				scale = 0.8 + (1 - now) * 0.2;
				left = ((1 - now) * 50) + "%";
				opacity = 1 - now;
				current.css({
					'left' : left
				});
				previous.css({
					'transform' : 'scale(' + scale + ')',
					'opacity' : opacity
				});
			},
			duration : 'fast',
			specialEasing : {
				width : "linear",
				height : "easeOutBounce"
			},
			complete : function() {
				current.hide();
				isAnimating = false;
			}
		});
	});

});