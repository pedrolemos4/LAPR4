REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=portal\target\Portal-1.3.0-SNAPSHOT.jar;portal\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% portal.login.login