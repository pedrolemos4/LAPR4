REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=portal/target/out/artifacts/portal_jar/portal.jar;base.app.backoffice.console\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% login.login