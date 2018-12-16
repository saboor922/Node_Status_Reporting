# Node Status Reporting

Node Status Reporting is a console Java application created for BT's Code Evaluation exercise. 

## Evaluation Requirements:
A monitoring system receives status notifications from a number of nodes on a network. They arrive in
a stream of data like this:
```
1508405807242 1508405807141 vader HELLO
1508405807340 1508405807350 luke HELLO
1508405807378 1508405807387 luke LOST vader
1508405807467 1508405807479 luke FOUND r2d2
1508405807468 1508405807480 luke LOST leia
1508405807512 1508405807400 vader LOST luke
1508405807560 1508405807504 vader HELLO
```
Each line represents a separate notification, of which there are three kinds: HELLO, LOST and
FOUND. Each notification has a pair of millisecond-resolution time-stamps (representing the time
since midnight on 1/1/1970). The first time-stamp is the time at which the notification was received by
the monitoring system. The second time-stamp is time on the node at which it was generated. So, the
line:
```
1508405807242 1508405807141 vader HELLO
```
is a message from the node vader saying that it is alive. It was sent at a time 1508405807141 (local
to the node), and received at 1508405807242 (local to the monitoring system). Similarly the lines:
```
1508405807378 1508405807387 luke LOST vader
1508405807467 1508405807479 luke FOUND r2d2
```
are notifications from the node luke that it has detected that vader appears to be dead, but
that r2d2 is alive. Also, implicitly, luke must be alive in order to send the notification!
Your task is to write a program to generate a report on the latest status of all of the nodes that appear
in the data. Your program will be run with a single command line argument, which will be the name of
a file of these notification records, one per line, as shown above.
For every node you must print out a line, in the format shown below, indicating whether it is dead or
alive, followed by the monitoring system’s time-stamp of the event that it most recently received that
indicates that status, and the details of what the event was. So the output for the input file above
would look like this:
```
vader ALIVE 1508405807560 vader HELLO
luke ALIVE 1508405807468 luke LOST leia
r2d2 ALIVE 1508405807467 luke FOUND r2d2
leia DEAD 1508405807468 luke LOST leia
```
Do not output any other information unless you detect that the input data is malformed in some way,
in which case your program should exit with an appropriate error message.
And one last thing …
The times on the nodes in the network are all synchronised to within less than 50 milliseconds of each
other. Unfortunately, they are not synchronised with the monitoring system, and although they are
sent in strict sequence from the nodes, there is no guarantee that the notifications from any node will
arrive at the monitoring system in the same sequence. So, it may be that the result from processing
the notifications is ambiguous and you can’t be sure if a node is alive or dead. In such cases, you
should show the status as UNKNOWN rather than DEAD or ALIVE and output a separate UNKNOWN
line for each of the ambiguous notification

## How To:
This section describes how to compile and run this application.

#### Prerequisites
 - JRE or JDK 8 (I used JDK_8u191)

### Compiling the Applicatoin

First, from root directory (name of this repository), go to the java directory.
``` ssh
cd src/main/java
```

Now, run the following command to compile all the Java files within the package:

```ssh
javac com/bt/evaluation/Application/NodeStatusApplication.java 
javac com/bt/evaluation/Domain/Node.java 
javac com/bt/evaluation/Domain/NodeState.java 
javac com/bt/evaluation/Domain/NotificationType.java
```

or run them all in a single-line using:

```ssh
javac com/bt/evaluation/Application/NodeStatusApplication.java com/bt/evaluation/Domain/Node.java com/bt/evaluation/Domain/NodeState.java com/bt/evaluation/Domain/NotificationType.java
```

### Run the Application

To run the application:

``` ssh
java com/bt/evaluation/Application/NodeStatusApplication <ABSOLUTE_PATH_OF_INPUT_FIILE>
```
Where,
__NodeStatusApplication__ is the name of the application

There is a sample __SampleNotificationRecord__ file that can be used to run this java application. It is located in:

```
<root>\src\main\resources\
```
## Built With

* [IntelliJ IDE](https://www.jetbrains.com/idea) - A Java Integrated Development Environment

## Authors

* **Abdus Saboor Suhail** - *Evaluation Test Solution*
