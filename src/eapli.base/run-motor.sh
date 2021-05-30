REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.daemon.motor\target\base.daemon.motor-1.3.0-SNAPSHOT.jar;base.daemon.motor\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% base.daemon.motor.MotorDaemon