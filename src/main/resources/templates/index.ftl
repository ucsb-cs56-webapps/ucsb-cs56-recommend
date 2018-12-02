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
     <option value="pop">Pop</option>
     <option value="hiphop">Hip Hop</option>
     <option value="country">Country</option>
     <option value="chill">Chill</option>
     <option value="edm_dance">EDM</option>
     <option value="rock">Rock</option>
     <option value="soul">Soul</option>
     <option value="indie_alt">Indie</option>
     <option value="kpop">K-pop</option>
   </select>

   <input type="submit" value="Submit">
 </form>
 <form action="/demo/all">
   <input type="submit" value="ViewDB">
 </form>
</form>
<form action="/demo/request">
  <input type="submit" value="Recommend">
</form>
<form action="/demo/clear" target="hiddenFrame" method="get">
  <input type="submit" value="ClearDB">
</form>


</body>
</html>
