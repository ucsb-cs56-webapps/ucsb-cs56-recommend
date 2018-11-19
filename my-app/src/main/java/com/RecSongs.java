package com;


package authorization.client_credentials;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.requests.data.browse.GetCategorysPlaylistsRequest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Uses spotify API to send back recommended songs to client based on user's songs from client.
 *
 */
public class RecSongs
{

    //instance variables 


    private final String clientId = "a1836f665e904cb4869901a56eb1582b";
    private final String clientSecret = "cfb9be2440aa427ca22fa07d583833d7";

    //authentification
    private final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setClientId(clientId)
          .setClientSecret(clientSecret)
          .build();
    private final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
          .build();

    public void clientCredentials_Sync() {
        try {
        final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

        // Set access token for further "spotifyApi" object usage
        spotifyApi.setAccessToken(clientCredentials.getAccessToken());

        System.out.println("Expires in: " + clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException e) {
        System.out.println("Error: " + e.getMessage());
        }
    }

    public void clientCredentials_Async() {
        try {
        final Future<ClientCredentials> clientCredentialsFuture = clientCredentialsRequest.executeAsync();

        // ...

        final ClientCredentials clientCredentials = clientCredentialsFuture.get();

        // Set access token for further "spotifyApi" object usage
        spotifyApi.setAccessToken(clientCredentials.getAccessToken());

        System.out.println("Expires in: " + clientCredentials.getExpiresIn());
        } catch (InterruptedException | ExecutionException e) {
        System.out.println("Error: " + e.getCause().getMessage());
        }
    }

    //Constructor
    RecSongs()
    {

    }

    public String getSongs(String categoryId)
    {

    } 

    //Get category playlist
    public void getCategoryPlaylist(String categoryId)
    {
        GetCategorysPlaylistsRequest getCategoryRequest = spotifyApi.getCategorysPlaylists(categoryId)
          .country(CountryCode.SE)
          .limit(1)
          .offset(0)
          .build();
        /* Do something with getCategoryRequest here? */
        /*https://github.com/thelinmichael/spotify-web-api-java/blob/master/examples/data/browse/GetCategorysPlaylistsExample.java*/

    }



    /*    
    /*
    public void getCategorysPlaylists_Sync(GetCategorysPlaylistsRequest g) {
        try {
        final Paging<PlaylistSimplified> playlistSimplifiedPaging = g.execute();

        System.out.println("Total: " + playlistSimplifiedPaging.getTotal());
        } catch (IOException | SpotifyWebApiException e) {
        System.out.println("Error: " + e.getMessage());
        }
    }
    */

    /*
    public void getCategorysPlaylists_Async(GetCategorysPlaylistsRequest g) {
        try {
        final Future<Paging<PlaylistSimplified>> pagingFuture = g.executeAsync();

        // ...

        final Paging<PlaylistSimplified> playlistSimplifiedPaging = pagingFuture.get();

        System.out.println("Total: " + playlistSimplifiedPaging.getTotal());
        } catch (InterruptedException | ExecutionException e) {
        System.out.println("Error: " + e.getCause().getMessage());
        }
    }
    */
    public void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    */
}
