# attempt01

## Purpose

See the purpose of the `~/Documents/DevFiles/personal_projects/personal_dashboard_backend_heroku/README.md` file.

~~For the original files to be copied into each successive attempt directory.~~

## Status

**Tabling this for now.** Will attempt something slightly different by working on `attempt02/`.

See the status of the `~/Documents/DevFiles/personal_projects/personal_dashboard_backend_heroku/README.md` file.

~~Interrupting self to follow this: https://devcenter.heroku.com/articles/getting-started-with-java
in the `attempt00/` directory.~~ This is done. It worked.

## Procedure
First get it running via the `backend` directory.

(next, in attempt02/, get it running from the `attempt02/` directory)

navigate to `~/Documents/DevFiles/personal_projects/personal_dashboard_backend_heroku`
run `cp -r original/ attempt01/`

Now, following:
https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin

At [Adding the plugin](https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin#adding-the-plugin)
I added 

        <groupId>com.heroku.sdk</groupId>
            <artifactId>heroku-maven-plugin</artifactId>
            <version>3.0.3</version>
        </plugin>

to the `~/Documents/DevFiles/personal_projects/personal_dashboard_backend_heroku/attempt01/PersonalDashboard/backend/pom.xml` file:

        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>com.heroku.sdk</groupId>
                <artifactId>heroku-maven-plugin</artifactId>
                <version>3.0.3</version>
            </plugin>
        </plugins>
        
run `heroku create`

~~I omitted this (change `sushi` to the app name.):~~
I added this.

        <configuration>
            <appName>sushi</appName>
        </configuration>

~~This might be a mistake. Will revisit if so.~~

Following [this stack overflow advice](https://stackoverflow.com/a/65438626/8210460) here's what it looks like in my pom file now:

        <plugin>
            <groupId>com.heroku.sdk</groupId>
            <artifactId>heroku-maven-plugin</artifactId>
            <version>3.0.3</version>
            <configuration>
                <appName>ancient-ocean-17605</appName>
            </configuration>
        </plugin>



I omitted this as well:
        
        <processTypes>
            <web>java $JAVA_OPTS -cp target/classes:target/dependency/* Main</web>
        </processTypes>

I don't think there's a WAR file.
[Deploying with the plugin
](https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin#deploying-with-the-plugin)

I am leaving this alone as well.

run `mvn clean heroku:deploy`

(in a different terminal window (lets call it window 2))
run (in ~/Documents/DevFiles/personal_projects/personal_dashboard_backend_heroku/attempt01/PersonalDashboard/backend): `heroku logs --tail -a ancient-ocean-17605`

~~Window 2 Output~~:
>~~`.
.
.
[INFO]        - including: target/dependency/spring-boot-2.5.0.jar
[INFO] -----> Creating build...
[INFO]        - file: /var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/heroku-deploy14156417669283984322source-blob.tgz
[INFO]        - size: 29MB
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 54.685 s
[INFO] Finished at: 2021-06-26T17:54:13-04:00
[INFO] Final Memory: 37M/114M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal com.heroku.sdk:heroku-maven-plugin:3.0.3:deploy (default-cli) on project backend: Could not determine app name, please configure it explicitly! -> [Help 1]~~

Window 2 Output:
>2021-06-27T01:46:16.094575+00:00 heroku[router]: at=error code=H14 desc="No web processes running" method=GET path="/topics" host=ancient-ocean-17605.herokuapp.com request_id=bc842e52-a27b-4e09-89a3-cecf06b8c155 fwd="45.14.195.145" dyno= connect= service= status=503 bytes= protocol=https
2021-06-27T01:49:12.016765+00:00 heroku[router]: at=error code=H14 desc="No web processes running" method=GET path="/topics" host=ancient-ocean-17605.herokuapp.com request_id=631f20f3-6b7e-4e7a-b91f-c34fa5280e40 fwd="45.14.195.145" dyno= connect= service= status=503 bytes= protocol=https
2021-06-27T01:49:38.593932+00:00 heroku[router]: at=error code=H14 desc="No web processes running" method=GET path="/" host=ancient-ocean-17605.herokuapp.com request_id=a8556538-871f-4de8-b715-a1a401026ac5 fwd="45.14.195.145" dyno= connect= service= status=503 bytes= protocol=https
2021-06-27T01:49:39.293316+00:00 heroku[router]: at=error code=H14 desc="No web processes running" method=GET path="/favicon.ico" host=ancient-ocean-17605.herokuapp.com request_id=7be1bc44-57d0-440c-a1e5-ea641aaae423 fwd="45.14.195.145" dyno= connect= service= status=503 bytes= protocol=https

`code=H14` is indicative of [No web dynos running](https://devcenter.heroku.com/articles/error-codes#h14-no-web-dynos-running).

run (on ~/Documents/DevFiles/personal_projects/personal_dashboard_backend_heroku/attempt01/PersonalDashboard/backend in `window 1`): `heroku ps -a ancient-ocean-17605`

Window 1 Output:
>Free dyno hours quota remaining this month: 507h 13m (92%)
Free dyno usage for this app: 0h 0m (0%)
For more information on dyno sleeping and how to upgrade, see:
https://devcenter.heroku.com/articles/dyno-sleeping
No dynos on ⬢ ancient-ocean-17605

run (in `window 1`): `heroku ps:scale web=1 -a ancient-ocean-17605`

Window 1 Output:
>Scaling dynos... !

> ▸    Couldn't find that process type (web).

> So now looking into the Procfile....

running `/usr/bin/env /Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication` from 

here: `~/Documents/DevFiles/personal_projects/personal_dashboard_backend_heroku/attempt01/PersonalDashboard` 

and from here: `~/Documents/DevFiles/personal_projects/PersonalDashboard` 

both work.

Revisiting <process types again....> from above:
        
        <processTypes>
            <web>/usr/bin/env /Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication Main</web>
        </processTypes>

So now the <plugin> in the `pom.xml` looks like:


			<plugin>
        		<groupId>com.heroku.sdk</groupId>
        		<artifactId>heroku-maven-plugin</artifactId>
        		<version>3.0.3</version>
				<configuration>
					<appName>ancient-ocean-17605</appName>
					<processTypes>
            			<web>/usr/bin/env /Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication Main</web>
        			</processTypes>
				</configuration>
      		</plugin>

run in Window 1: `mvn clean heroku:deploy`

Window 1 Output:
>[INFO] -----> Uploading build...
[INFO]        - success
[INFO] -----> Deploying...
[INFO] remote: 
[INFO] remote: -----> Building on the Heroku-20 stack
[INFO] remote: -----> Using buildpack: heroku/jvm
[INFO] remote: -----> heroku-maven-plugin app detected
[INFO] remote: -----> Installing JDK 1.8... done
[INFO] remote: -----> Discovering process types
[INFO] remote:        Procfile declares types -> web
[INFO] remote: 
[INFO] remote: -----> Compressing...
[INFO] remote:        Done: 81.5M
[INFO] remote: -----> Launching...
[INFO] remote:        Released v4
[INFO] remote:        https://ancient-ocean-17605.herokuapp.com/ deployed to Heroku
[INFO] remote: 
[INFO] -----> Done
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 06:40 min
[INFO] Finished at: 2021-06-27T10:10:23-04:00
[INFO] Final Memory: 37M/104M
[INFO] ------------------------------------------------------------------------


run in Window 1: `heroku ps -a ancient-ocean-17605`

Window 1 Output:
>Free dyno hours quota remaining this month: 507h 13m (92%)
Free dyno usage for this app: 0h 0m (0%)
For more information on dyno sleeping and how to upgrade, see:
https://devcenter.heroku.com/articles/dyno-sleeping

>=== web (Free): /usr/bin/env /Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication Main (1)
web.1: crashed 2021/06/27 10:10:38 -0400 (~ 1m ago)

run in Window 2: `roku logs --tail -a ancient-ocean-17605`

Window 2 Output:
>2021-06-27T14:10:10.000000+00:00 app[api]: Build started by user jamiebort@gmail.com
2021-06-27T14:10:22.000000+00:00 app[api]: Build succeeded
2021-06-27T14:10:22.380402+00:00 app[api]: Release v4 created by user jamiebort@gmail.com
2021-06-27T14:10:22.380402+00:00 app[api]: Deploy 0.0.1-SNAPSHOT by user jamiebort@gmail.com
2021-06-27T14:10:22.392600+00:00 app[api]: Scaled to web@1:Free by user jamiebort@gmail.com
2021-06-27T14:10:27.003190+00:00 heroku[web.1]: Starting process with command `/usr/bin/env /Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication Main`
2021-06-27T14:10:30.344877+00:00 app[web.1]: Setting JAVA_TOOL_OPTIONS defaults based on dyno size. Custom settings will override them.
2021-06-27T14:10:30.347861+00:00 app[web.1]: /usr/bin/env: '/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java': No such file or directory
2021-06-27T14:10:30.408623+00:00 heroku[web.1]: Process exited with status 127
2021-06-27T14:10:30.504125+00:00 heroku[web.1]: State changed from starting to crashed
2021-06-27T14:10:30.507161+00:00 heroku[web.1]: State changed from crashed to starting
2021-06-27T14:10:35.070997+00:00 heroku[web.1]: Starting process with command `/usr/bin/env /Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication Main`
2021-06-27T14:10:38.436159+00:00 app[web.1]: Setting JAVA_TOOL_OPTIONS defaults based on dyno size. Custom settings will override them.
2021-06-27T14:10:38.437427+00:00 app[web.1]: /usr/bin/env: '/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java': No such file or directory
2021-06-27T14:10:38.508585+00:00 heroku[web.1]: Process exited with status 127
2021-06-27T14:10:38.580784+00:00 heroku[web.1]: State changed from starting to crashed

Changed <processTypes> again:

            <processTypes>
                <web>/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication Main</web>
            </processTypes>

To address the `No such file or directory` in the log.

run in Window 1: `mvn clean heroku:deploy`

run in Window 2: `roku logs --tail -a ancient-ocean-17605`

Window 2 Output:
>2021-06-27T14:41:28.426496+00:00 heroku[web.1]: State changed from crashed to starting
2021-06-27T14:41:31.971405+00:00 heroku[web.1]: Starting process with command `/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 @/var/folders/yl/ry72pgqn3pgg7d8mpbzvdczm0000gn/T/cp_e93awazm5sdxsprlyr96yzjfu.argfile personal_dashboard.backend.BackendApplication Main`
2021-06-27T14:41:34.843653+00:00 app[web.1]: Setting JAVA_TOOL_OPTIONS defaults based on dyno size. Custom settings will override them.
2021-06-27T14:41:34.843872+00:00 app[web.1]: bash: /Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home/bin/java: No such file or directory
2021-06-27T14:41:34.891447+00:00 heroku[web.1]: Process exited with status 127
2021-06-27T14:41:35.006996+00:00 heroku[web.1]: State changed from starting to crashed

## Resources

https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin