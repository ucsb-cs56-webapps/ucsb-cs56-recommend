package com;

/**
 * Uses spotify API to send back recommended songs to client based on user's songs from client.
 *
 */
public class RecSongs
{

    private static final String clientId = "a1836f665e904cb4869901a56eb1582b";
    private static final String clientSecret = "cfb9be2440aa427ca22fa07d583833d7";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setClientId(clientId)
          .setClientSecret(clientSecret)
          .build();
    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
          .build();

    public static void clientCredentials_Sync() {
        try {
        final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

        // Set access token for further "spotifyApi" object usage
        spotifyApi.setAccessToken(clientCredentials.getAccessToken());

        System.out.println("Expires in: " + clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException e) {
        System.out.println("Error: " + e.getMessage());
        }
    }

    public static void clientCredentials_Async() {
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
    RecSongs()
    {

    }

    /*
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    */
}
