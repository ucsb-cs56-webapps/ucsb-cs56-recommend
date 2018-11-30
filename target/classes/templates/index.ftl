<!DOCTYPE html>
<html>
 <head>
   <title>RECOMMEND</title>
 </head>
 <body>
   <h1>Recommend</h1>
  <p>This is a song recommender</p>

<iframe name="hiddenFrame" width="0" height="0" border="0" style="display: none;"></iframe>
 <form action="/demo/add" target="hiddenFrame" method="get">
   Input Song name:<br>
   <input type="text" name="song"><br>
   Input Artist name:<br>
   <input type="text" name="artist"><br>

   <select name= "genre">
     <option value="Pop">Pop</option>
     <option value="Rap">Rap</option>
     <option value="EDM">EDM</option>
     <option value="Hip Hop">Hip Hop</option>
     <option value="Trap">Trap</option>
     <option value="Rock">Rock</option>
     <option value="Soul">Soul</option>
     <option value="Classical">Classical</option>
     <option value="Jazz">Jazz</option>
     <option value="Funk">Funk</option>
   </select>

   <input type="submit" value="Submit">
 </form>
 <form action="/demo/all">
   <input type="submit" value="ViewDB">
 </form>

 <p>${name}</p>

</body>
</html>
