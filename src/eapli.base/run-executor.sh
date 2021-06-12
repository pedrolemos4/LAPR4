#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=base.daemon.executor/target/base_daemon_executor-1.3.0-SNAPSHOT.jar:base.daemon.executor/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP base.daemon.executor.ExecutorTarefaAutomaticaDaemon
