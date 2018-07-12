### Чтобы скачать с гитхаба проект запускаем команду:
git clone https://github.com/gunson/greetSimpleProj.git

### Заходим в папку:
cd ./greetSimpleProj

### компилируем, билдим:
 mvn compile; 
 mvn clean install
 
### Далее запускаем команды:
 mvn derby:run

### derby блокирует ввод/вывод. Открываем новый терминал в той же директории greetSimpleProj и запускаем томкат:
mvn tomcat7:run

### Ждём когда запуститься сервер. После запуска сервера заходим в браузере по адресу:
http://127.0.0.1:8080/greetTestProj/ShowMessage.html
### И видим результат.

для проверки менять значение в базе можно со страницы 
http://127.0.0.1:8080/greetTestProj/EditMessage.html
 Значение сохранится в базе, только не запускайте повторно "mvn clean install" (иначе база будет пересоздана, файлы базы помещаются в target).
пароль к базе прописан в файле 
./greetSimpleProj/src/main/resources/dbConf.properties
