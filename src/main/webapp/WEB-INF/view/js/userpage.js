function addTable(rows, columns) {
    var body = document.getElementById("marks_table"),
        numRows = rows.value,
        numColumns = columns.value,
        tr = "",
        td = "";
    
    
/*    $.get("http://localhost:8080/course_1/lk", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $ul = $("<ul>").appendTo($("#marks_table")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
            $("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
        });
    });*/
    
    
    /*var response = fetch("http://localhost:8080/course_1/lk");
    var text = fetch.text;
    console.log(text);*/
    
    table = document.createElement("table"),
    
    table.setAttribute("border", "2px");
    
    table.setAttribute("width", 300);
    table.setAttribute("height", 200);
    
    for (var i = 0; i < rows; i++) {
      tr = document.createElement("tr");
      for (var j = 0; j < columns; j++) {
        td = document.createElement("td");
        text = document.createTextNode((i + 1) + "." + (j + 1));
        td.appendChild(text);
        tr.appendChild(td);
      }
      table.appendChild(tr);
    }

    
    
    return body.appendChild(table);
  }