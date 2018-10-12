#!/bin/sh
ARGV="$@"
JAVA_HOME=/usr/local/jdk1.8.0_45
BOT_HOME=/usr/local/telegram/mybot
JAR_FILE=TelegramBot-0.1.1.jar

# ===
JAVAEXE=$JAVA_HOME/bin/java
JARPATH=$BOT_HOME/$JAR_FILE
PIDFILE=$BOT_HOME/pid
export SPRING_CONFIG_LOCATION=$BOT_HOME/config/
export LOGGING_CONFIG=$SPRING_CONFIG_LOCATION/logback.xml


case $ARGV in
start)
        echo exec: nohup $JAVAEXE -jar $JARPATH
        nohup $JAVAEXE  -jar $JARPATH > /dev/null &
        echo $! > $PIDFILE
        ;;
stop)
        kill -9 `cat $PIDFILE`
        ps ax | grep TelegramBot
    ;;
esac

exit $ERROR