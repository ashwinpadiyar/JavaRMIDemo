# JavaRMIDemo
As a self-learning project, this will allow me to understand the basics of Java RMI

#### JAVA RMI

- There are Java APIs and underlying infrastructure for performing RMI [similar to RPC in procedural programming].

##### Setup for this project
- MySQL 5.7 version.
- Any code editor.

##### Project Purpose:
- A server-program that provides a method for retrieving a list of customers from a MySQL database.
- A client program that retrieves the customer list from the server-program and displays it.
> Assume server and client are unknown and cannot access one another's methods directly. (This is obvious since we're talking about RMI).

##### How does communication happen in such cases?
- On server side, If we need to access an object remotely from client, we must inform JVM that the object is remotely invoked and keep it in registry or memory.
    - Implement the Remote interface for the class containing the code to be accessed remotely.
    - Extend the same class with UnicastRemoteObject. It is used for exporting a remote object with Java Remote Method Protocol (JRMP) and obtaining a stub that communicates to the remote object.
    - Register/bind the stub using rmi.Naming class.
         ```
         Remote r = new BankImpl();
         Naming.rebind("rmi://localhost/BankImpl",r);
         ```
- On Client side, fetch the stub using rmi.Naming class using the key.
    ```
    Bank b = (Bank) Naming.lookup("rmi://localhost/BankImpl");
    ```

##### Commands to use for executing the project:
- Execute these commands from project workspace directory [Home-Dir\JavaRMIDemo] :
    ```
        > javac -d . src/my/java/example/rmi/BankImpl.java
    	> javac -d . src/my/java/example/rmi/Customer.java
    	> rmic my.java.example.rmi.BankImpl
    	> rmiregistry
    ```
- rmiregistry will be listening on default port [1099]
- ###### Start Server Program:
    ``` 
    javac -d . src/my/java/example/rmi/MyServer.java
    java my.java.example.rmi.MyServer
    ```
- ###### Start the client program:
    ```
    java -Djava.security.policy=no.policy my.java.example.rmi.client.MyClient
    ```
- The purpose of VM Arugment -Djava.security.policy=no.policy is to allow client code to connect to RMI Registry listening on that port and call methods there.
    - no.policy is a new file created and provide grant permission to port(uploaded).
