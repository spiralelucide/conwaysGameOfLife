$(document).ready(function(){
	
	var interval;
	var generation = 1;
	$('#blowsMind').on('click', start);
	$('#stops').on('click', stop);
	$('.mutable').on('click', function(){
		$(this).toggleClass('alive');
	});
	
	function start(){
		 clearInterval(interval);
		 interval = setInterval(animate,500);
	}
	function stop(){
		clearInterval(interval);
	}
	function animate(){
		generation++;
		var height = $('#height').text();
		var width = $('#width').text();
		var $rows = $('#board>.row');
		var $matrix = [];
		for(var i = 0; i < $rows.length; i++){
			$currentRow = $rows.eq(i);
			$rowBlocks = $currentRow.children();
			$matrix[i] = [];
			for(var j = 0; j < $rowBlocks.length; j++){
				$matrix[i][j] = $rowBlocks.eq(j);	
			}
		}
		var x = 0;
		var y = 0;
		observeCell($matrix, x,y);
		$('#currentGeneration').text('Generation '+ generation);
		
		//helper functions
		function observeCell($matrix,x,y){
			if(x == height){
				return;
			}
			var neighborsAlive = observeNeighbors($matrix,x, y);
			if(y == width - 1){
				observeCell($matrix, x+1, 0);
			}else {
				observeCell($matrix, x, y+1);
			}
			if(neighborsAlive == 3) $matrix[x][y].addClass('alive');
			if(neighborsAlive < 2 || neighborsAlive > 3) $matrix[x][y].removeClass('alive');
			return;
		}
		function observeNeighbors($matrix,x,y){
			var count = 0;
			if(x-1 >= 0)
				if($matrix[x-1][y].hasClass('alive')) count++;
			if(x+1 < height)
				if($matrix[x+1][y].hasClass('alive')) count++;
			if(y-1 >= 0)
				if($matrix[x][y-1].hasClass('alive')) count++;
			if(y+1 < width)
				if($matrix[x][y+1].hasClass('alive')) count++;
			if(x-1 >= 0 && y-1 >= 0)
				if($matrix[x-1][y-1].hasClass('alive')) count++;
			if(x-1 >= 0 && y+1 < width)
				if($matrix[x-1][y+1].hasClass('alive')) count++;
			if(x+1 < height && y-1 >= 0)
				if($matrix[x+1][y-1].hasClass('alive')) count++;
			if(x+1 < height && y+1 < width)
				if($matrix[x+1][y+1].hasClass('alive')) count++;
			return count;
		}
	}
});