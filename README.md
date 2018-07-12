### Чтобы скачать с гитхаба проект запускаем команду:
git clone https://github.com/gunson/greetSimpleProj.git

### Заходим в папку:
./greetSimpleProj

### Далее запускаем команды:
mvn compile
mvn clean install
mvn derby:run

### derby блокирует ввод/вывод. Открываем новый терминал в той же директории greetSimpleProjб запускаем томкат:
mvn tomcat7:run

### Ждём когда запуститься сервер. После запуска сервера заходим в браузере по адресу:
http://127.0.0.1:8080/greetTestProj/ShowMessage.html
### И видим результат.

### менять значение в базе можно со страницы 
http://127.0.0.1:8080/greetTestProj/EditMessage.html
