<!DOCTYPE html>
<html>
<head>
    <#include "head.ftl" />
    <title>Recommended Songs</title>
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
    <#include "nav.ftl" />
    <div class="container-fluid">
        <p id="showData"></p>
    </div>
</body>

<script>

    $(document).ready(function() {
        // executes when HTML-Document is loaded and DOM is ready
        CreateTableFromJSON();
    });

    function CreateTableFromJSON() {
        
    
	    var myBooks = ${arrObj};


	    

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
        table.classList.add("table")

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