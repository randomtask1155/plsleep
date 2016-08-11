# Purpose

Create GPDB pljava test class for debugging purposes 

## Build

```mvn package```

## create functions in database

```
CREATE FUNCTION gotosleep(integer)
        RETURNS integer
        AS 'io.pivotal.support.plsleep.GoToSleep(java.lang.Integer)'
        LANGUAGE java;
   
CREATE FUNCTION gospin(integer)
        RETURNS integer
        AS 'io.pivotal.support.plsleep.GoSpin(java.lang.Integer)'
        LANGUAGE java;
     
CREATE FUNCTION gotosleepfail(integer)
        RETURNS integer
        AS 'io.pivotal.support.plsleep.GoToSleepFail(java.lang.Integer)'
        LANGUAGE java;
```

## test run plseep process for 60 seconds

```
gpadmin=# select gotosleep(300);
 gotosleep
-----------
         1
(1 row)
```

