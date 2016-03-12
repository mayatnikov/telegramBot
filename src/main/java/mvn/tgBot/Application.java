package mvn.tgBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan({"mvn.tgBot","mvn.soap","mvn.db"})
@EnableAutoConfiguration
@Configuration
@EnableScheduling
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


/*
команды для BOT-а:

help - этот список команд
start - вернуться в начало без сброса данных
cancel - прервать процесс и начать опрос с начала
info - отобразить состояние процесса и мои основные данные
refresh - обновить сообщение и меню

 */