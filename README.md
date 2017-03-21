# pomodoro_dojo

El objetivo de esta PomodoroKata es desarrollar (haciendo TDD, por supuesto) un programa que reproduzca el comportamiento de un temporizador del pomodoro, es decir, un simple reloj de cocina.


Os proponemos los siguientes comportamientos:


CREAR UN POMODORO

Un pomodoro dura 25 minutos por defecto.

Puedo crear un pomodoro con cualquier duración.


PARAR UN POMODORO

Un pomodoro recién creado está parado.

Al arrancar un pomodoro comienza la cuenta atrás.

Un pomodoro no termina si no ha sido arrancado previamente.

Un pomodoro acaba cuando se agota su tiempo.

Un pomodoro no acaba mientras no se agote su tiempo.


INTERRUPCIONES

Un pomodoro se inicia sin interrupciones.
Si no está arrancado no se puede interrumpir.
El pomodoro cuenta las interrupciones (1, 2...).



REINICIAR

Un pomodoro ya arrancado se reinicia (empieza a contar el tiempo) al arrancarlo de nuevo.

Un pomodoro se reinicia sin interrupciones.


Como "bonus track" se propone crear la UI, que puede ser gráfica, linea de comandos o como desee cada cuál, pero ya sin la restricción de que dure un pomodoro todo el ejercicio.


Solutions


Please, perform a pull request over this repository to add your team solution:


Fork the repository to your github account.

Clone the forked repository:

$ git clone https://github.com/your_username/pomodoro-dojo.git

Access the repository

$ cd pomodoro-dojo

Create a new branch and move to it:

$ git checkout -b team_name-branch

Create a folder like "nameA-nameB" or just "nameA" if you are a solo developer in the root of this repository and add your solution:

$ mkdir team_name_java

$ cp -r ../MyKata ./team_name_java

Add changes to git and commit

$ git add -A

$ git commit -m "Added team_name solution in java"

Push your changes to your remote repository

$ git push --set-upstream origin team_name-branch

Create a pull-request from your forked and updated repository on github:

Select as "base fork" the "cmallorca/pomodoro-dojo" master branch

Select as "head fork" your "your_name/pomodoro-dojo" team_name branch
