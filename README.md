# Fall 2018

Austin: austinquinn

Jennifer: jenniferlai43

Matthew: homatthew

Ryan: rx5842

Wei-Yee: WeiyeeGoh

Shirlyn: shirlyntang

Recommend Webapp: Moved from a broad, recommended activity feed to an entertainment-based feed.

Main Idea: Web app that recommends entertainment content based on what the user inputs in as their interests.

Link: https://cs56-recommend-project.herokuapp.com/

Instruction for setting up MySQL
1) Download MySQL running
2) Start up mysql console
    - start up command line
	- cd to mysql/bin folder
	- type mysql -u root -p
	- your password might be your computer's password????????
3) if you see >mysql instead of the usual path in cmd now, it means it worked
	- type this in
```	
mysql> create database db_example;

mysql> create user 'springuser'@'%' identified by 'ThePassword'; 

mysql> grant all on db_example.* to 'springuser'@'%'; 
```

Instructions for setting up spotify api locally
1) Go to this link: https://developer.spotify.com/dashboard/
2) Log in/create an account. Click "Create a Client ID"
3) Enter Application Name and Application Description and then click CREATE. Your application is registered, and the app view opens.
4) On the app view, click Edit Settings to view and update your app settings. Find your Client ID and Client Secret.
5) Create a ```localhost.json``` file in the config directory. Add the following to that file
```
{
    "spotify_client_id": "**INSERT CLIENT_ID HERE***",
    "spotify_client_secret": "***INSERT CLIENT_SECRET HERE***"
}

```
6) Create a ```heroku.json``` file in the config directory. The contents should be the same as above.
7) Execute ```source env.sh``` OR . env.sh
8) You can check your environment variables with the following command: ```echo $SPRING_APPLICATION_JSON```
9) You're all good to go.

