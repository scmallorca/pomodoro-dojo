Pomodoro Dojo
=========================

## Instrucciones (spanish)
El objetivo de esta kata es desarrollar mediante TDD, un programa que reproduzca el comportamiento de un temporizador que utiliza la técnica pomodoro, es decir, "un simple reloj de cocina".

Os proponemos los siguientes comportamientos:
1. Crear un pomodoro
  * Un pomodoro dura 25 minutos por defecto.
  * Puedo crear un pomodoro con cualquier duración.
2. Parar un pomodoro
  * Un pomodoro recién creado está parado.
  * Al arrancar un pomodoro comienza la cuenta atrás.
  * Un pomodoro no termina si no ha sido arrancado previamente.
  * Un pomodoro acaba cuando se agota su tiempo.
  * Un pomodoro no acaba mientras no se agote su tiempo.
3. Interrupciones
  * Un pomodoro se inicia sin interrupciones.
  * Si no está arrancado no se puede interrumpir.
  * El pomodoro cuenta las interrupciones (1, 2...).
4. Reiniciar
  * Un pomodoro ya arrancado se reinicia (empieza a contar el tiempo) al arrancarlo de nuevo.
  * Un pomodoro se reinicia sin interrupciones.

Como "bonus track" se propone crear la UI, que puede ser gráfica, linea de comandos o como desee cada cuál, pero ya sin la restricción de que dure un pomodoro todo el ejercicio.

## Instructions (english)
The objective of this kata is to develop through TDD, a program that reproduces the behavior of a pomodoro timer, ie a simple kitchen clock.

We propose you with the following behaviors:
1. Start a pomodoro
  * A pomodoro lasts for 25 minutes by default.
  * I can create a pomodoro with any duration.
2. Stop a pomodoro
  * A newly created pomodoro stands.
  * When starting a pomodoro begins the countdown.
  * A pomodoro does not end if it has not been started previously.
  * A pomodoro ends when its runs out.
  * A pomodoro not end until it runs out time.
3. Interruptions
  * A pomodoro starts without interruptions.
  * If it is not started it can not be interrupted.
  * The pomodoro counts the interruptions (1, 2 ...).
4. Restart
  * An already started pomodoro is restarted (begins to count the time) when starting it again.
  * A pomodoro restarts without interruptions.

As a bonus track, it is proposed to create the UI, which can be graphical, command line or whatever you want, but without the restriction that a pomodoro lasts the whole exercise.

## Solutions
Please, perform a pull request over this repository to add your team solution:
* Fork the repository to your github account.
* Clone the forked repository:
```
$ git clone https://github.com/your_username/pomodoro-dojo.git
```
* Access the repository
```
$ cd pomodoro-dojo
```
* Create a new branch and move to it:
```
$ git checkout -b team_name-branch
```
* Create a folder like "nameA-nameB" or just "nameA" if you are a solo developer in the root of this repository and add your solution:
```
$ mkdir team_name_java
$ cp -r ../MyKata ./team_name_java
```
* Add changes to git and commit
```
$ git add -A
$ git commit -m "Added team_name solution in java"
```
* Push your changes to your remote repository
```
$ git push --set-upstream origin team_name-branch
```
* Create a pull-request from your forked and updated repository on github:
* Select as "base fork" the "cmallorca/pomodoro-dojo" master branch
* Select as "head fork" your "your_name/pomodoro-dojo" team_name branch

## Extra challenges
* Use ReactiveExtensions to control timers with TestScheduler (available for any language)

## References 
* Original kata posted in solveet: [PomodoroKata](http://www.solveet.com/exercises/Pomodoro-Kata/68)
