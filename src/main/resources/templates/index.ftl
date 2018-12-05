<!DOCTYPE html>
<html>
  <head>
    <#include "head.ftl" />
    <style>
      .form
      {
        margin: 10px 0px;
      }
    </style>
  </head>
  <body>
    
    <#include "nav.ftl" />
    <div class="container-fluid">
      <iframe name="hiddenFrame" width="0" height="0" border="0" style="display: none;"></iframe>
       <form action="/demo/add" method="get" target="hiddenFrame" id = "song-input">
          <div class="form-group">
            <label for="song">Input Song Name:</label>
            <input type="text" class="form-control" name="song" id="song" placeholder="Enter song name...">
          </div>
          <div class="form-group">
            <label for="artist">Input Artist Name:</label>
            <input type="text" class="form-control" name="artist" id="artist" placeholder="Enter artist name...">
          </div>

          <div class="form-group">
          <label for="genre">Input Genre:</label>
            <select class="form-control" name="genre" id="genre">
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
          </div>
          <button type="submit" class="btn btn-outline-primary" value="ViewDB" onclick="clearFields()" data-toggle="modal" data-target="#exampleModal">Add Song</button>
          <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Successfully Added Song!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
       </form>

    </div>
  </body>
  <script type="text/javascript">
    function clearFields()
    {
      setTimeout(function(){document.getElementById('song-input').reset();}, 1000); //timeout gives server time to load song into db before resetting form
    } 

    $('#myModal').on('shown.bs.modal', function () {
      $('#myInput').trigger('focus')
    })
  </script>
</html>
