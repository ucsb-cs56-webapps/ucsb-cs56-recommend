package com;

/**
 * Uses spotify API to send back recommended songs to client based on user's songs from client.
 *
 */
public class RecSongs
{

    SpotifyApi spotifyApi = new SpotifyApi.Builder()
        .setAccessToken("taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk")
        .build();

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
