REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.daemon.executor\target\base.daemon.executor-1.3.0-SNAPSHOT.jar;base.daemon.executor\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% base.daemon.executor.ExecutorTarefaAutomaticaDaemon