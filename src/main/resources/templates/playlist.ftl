<!DOCTYPE html>
<html>
<head>
    <#include "head.ftl" />
    <title>My Playlist</title>
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
        .form
        {
            margin: 10px;
        }
    </style>
</head>
<body>
    <#include "nav.ftl" />
    <iframe name="hiddenFrame" width="0" height="0" border="0" style="display: none;"></iframe>
    <div class="container-fluid">
        <p id="showData"></p>
        <form class = "form" action="/demo/clear" target="hiddenFrame">
            <button type="submit" class="btn btn-outline-primary" value="ClearDB">ClearDB</button>
        </form>
    </div>
    
</body>

<script>
$(document).ready(function() {
 // executes when HTML-Document is loaded and DOM is ready
 CreateTableFromJSON();
});
    function CreateTableFromJSON() {


	    var myBooks = ${arrObj!"null"};

        console.log(myBooks);

        if (myBooks===null)
        {
            console.log("no songs");
            var msg = document.createElement("h2");
            msg.innerHTML = "Oops! Go back to home to add more songs to your playlist."
            var divContainer = document.getElementById("showData");
            divContainer.innerHTML = "";
            divContainer.appendChild(msg);
            return;
        }

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

            for (var j = 0; j < col.length; j++) {
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML = myBooks[i][col[j]];
            }

        }

        // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
        var divContainer = document.getElementById("showData");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    }
</script>
</html>