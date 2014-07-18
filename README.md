DarkRoom
========

Block social network and other things that may waste your time when you are working.

DarkRoom will add block list to hosts file of system. Some domains of social network, shopping web sites, online video, etc. will be forbidden.

This application is written in Java. Now it supports *Linux* and *Windows* platform.

Download & Run
------------------

Windows users need to [install Java here](http://java.com/).

Download the latest release:

* [Linux](http://guoyunhe.me/app/darkroom/darkroom-linux.tar.gz)
* [Windows](http://guoyunhe.me/app/darkroom/darkroom-windows.zip)

Unpack the package.

Run darkroom (Linux) or darkroom.exe (Windows).

How To Use
----------

When the program started, it will check the hosts file. 

If the black list is existing in your hosts files, the window will be black, (means locked status) click the button to unlock. Else the window will be white, (means unlocked status) click the button to lock.

When the program exit, the hosts file will stay in the last status. If you want to unlock, please click the button before quit program.

Difference between Linux and Windows versions
---------------------------------------------

They are mainly the same. Difference comes from:

1. The path of hosts file and file system information is different.
2. Online application and games depend on platform, so the black list is different.
3. Runnable scripts and the method to get root/admin permission are different.

Feedback
--------

Submit suggestions and problems by [Issues](https://github.com/guoyunhebrave/DarkRoom/issues).

We need you to:

1. Test the application on your system.
2. Supplement the black list of domains.
3. Point out if it fulfilled your need.

Use The Code and Contribute
---------------------------

We use Eclipse to manage projects. If you want to use the code:

1. Clone this repo with git.
2. In Eclipse, "Import > Git > Projects from Git", import projects from this git repo.
3. Manage projects in your Eclipse.

Contributors
------------

Designed by Guo Yunhe(@guoyunhebrave), 2014.07.15.

Idea comes from Wang Chen(@WaterSpeaker).

Black list contributed by Wang Chen(@WaterSpeaker).