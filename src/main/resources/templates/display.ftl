<!DOCTYPE html>
<html>
<head>
    <title>Convert JSON Data to HTML Table</title>
    <style>
        th, td, p, input {
            font:14px Verdana;
        }
        table, th, td 
        {
            border: solid 1px #DDD;
            border-collapse: collapse;
            padding: 2px 3px;
            text-align: center;
        }
        th {
            font-weight:bold;
        }
    </style>
</head>
<body>
    <input type="button" onclick="CreateTableFromJSON()" value="Display Recommendations" />
    <p id="showData"></p>
    <p>${data}</p>
</body>

<script>
    function loadJSON(path, success, error)
{
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                if (success)
                    success(JSON.parse(xhr.responseText));
            } else {
                if (error)
                    error(xhr);
            }
        }
    };
    xhr.open("GET", path, true);
    xhr.send();
}
    function CreateTableFromJSON() {
	/*loadJSON('my-file.json',
        	function(data) { console.log(data); },
        	function(xhr) { console.error(xhr); }
	);*/	
	//dynamically making jSON file stub
        //var string = ${user};
        
        
	    var myBooks = ${arrObj};

		/*  
		[
            {
                "Book ID": "1",
                "Book Name": "Computer Architecture",
                "Category": "Computers",
                "Price": "125.60"
            },
            {
                "Book ID": "2",
                "Book Name": "Asp.Net 4 Blue Book",
                "Category": "Programming",
                "Price": "56.00"
            },
            {
                "Book ID": "3",
                "Book Name": "Popular Science",
                "Category": "Science",
                "Price": "210.40"
            }
        ];
        */
        
	    

        // EXTRACT VALUE FOR HTML HEADER. 
        // ('Book ID', 'Book Name', 'Category' and 'Price')
        var col = [];
        for (var i = 0; i < myBooks.length; i++) {
            for (var key in myBooks[i]) {
                if (col.indexOf(key) === -1) {
                    col.push(key);
                }
            }
        }
        col.push("Add");


        // CREATE DYNAMIC TABLE.
        var table = document.createElement("table");

        // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

        var tr = table.insertRow(-1);                   // TABLE ROW.

        for (var i = 0; i < col.length; i++) {
            var th = document.createElement("th");      // TABLE HEADER.
            th.innerHTML = col[i];
            tr.appendChild(th);
        }

        // ADD JSON DATA TO THE TABLE AS ROWS.
        for (var i = 0; i < myBooks.length; i++) {

            tr = table.insertRow(-1);

            for (var j = 0; j < col.length-1; j++) {
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML = myBooks[i][col[j]];
            }
            var btn = document.createElement('input');
            btn.type = "button";
            btn.value = "Add to Playlist";
            btn.onclick = "addNewUser(myBooks[i][col[1]], myBooks[i][col[2]], myBooks[i][col[3]])";
            tr.appendChild(btn);

        }

        // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
        var divContainer = document.getElementById("showData");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    }

    function addNewUser(songName, songArtist, songGenre)
    {
        var xhr = new XMLHttpRequest();
        var path = "/demo/add?song="+songName+"&&artist="+songArtist+"&&genre="+songGenre;
        xhr.open("GET", path);
        xhr.send();
    }
</script>
</html>