function yes(){
	
	var button = document.getElementById('btn');
	button.disabled = true;
	
	var rows = document.querySelector('table').rows;
	var rowsCount = rows.length;
	var cellsCount = rows[0].cells.length;
	var marks = [0,0,0,0];
	var cell = "";
	
	for (var row = 1; row < rowsCount; row++) {
	
		for (var cell = 1; cell < cellsCount; cell++) {
			
			table_cell = rows[row].cells[cell].innerHTML;
			
			if(table_cell.includes("2"))
				marks[0]++;
			
			if(table_cell.includes("3"))
				marks[1]++;
			
			if(table_cell.includes("4"))
				marks[2]++;
			
			if(table_cell.includes("5"))
				marks[3]++;
			
		}	
	}
	
	var data = [
	  {x: "5", value: marks[3]},
	  {x: "4", value: marks[2]},
	  {x: "3", value: marks[1]},
	  {x: "2", value: marks[0]}
	];

	chart = anychart.pie(data);

	chart.container("container");

	chart.draw();
}