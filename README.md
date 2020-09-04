# kubernetes2-2
##Volumenes
#Listar Volumenes

docker volume ls

docker volume create volume01  

docker volume inspect volume01

ocker volume rm volume01

docker image rm -f 0ae6a535cc59

docker rm -f d48f0036c15f

docker container rm -f 05f7d6d9bca8

sudo su # permisos de administrador

docker volume inspect volume02
docker run -d --name site02 -v volume02:/app nginx:latest

docker run -d --name site22 -v volume22:/app nginx:latest


docker volume inspect volume02 
docker container inspect site02

docker exec -it site02 bash
cd app
touch a
echo "hola peter" > a
cat a
mkdir peter
cd peter/
touch a
touch b
docker rm -f 032 a9d
docker run -d --name site33 -v volume02:/app nginx:latest
ocker exec -it ce0 bash
ls
cd app
cat a
hola peter


docker run -d --name=nginx-test-01 -v nginx:/usr/share/nginx/html nginx:latest
docker exec -it site33 bash
cd /usr/share/nginx/html/
cat index.html 
cat 50x.html 

docker container stop nginx-test-01
docker container start nginx-test-01

#RO read only solo se usa para solo leer y se sabe que no va ha ser cambiado solo archivos estaticos no en bd mysql,mongo etc
docker run -d --name=nginxv2 -v nginx02:/usr/share/nginx/html:ro nginx:latest

##REDES

docker rm -f cce 22b ce0
docker run -d --name=site-01 -p 8080:80 nginx
docker ps
curl http://localhost:80
curl http://localhost:8080
 docker run -d --name=site-02 -p 8081:80 nginx
curl http://localhost:8081                   
docker exec -it site-01 bash                 
echo site01 > /usr/share/nginx/html/index.html
docker exec -it site-02 bash
echo site02 > /usr/share/nginx/html/index.html
curl http://localhost:8081  
curl http://localhost:8080
dokcer logs -f 35c

docker inspect site-01
ping 172.17.0.3
curl http://172.17.0.3:8080

pedropecho288@kubernetes2020:~$ docker network ls
NETWORK ID          NAME                DRIVER              SCOPE
44b5fa09373d        bridge              bridge              local
7a817aa77c18        host                host                local
6b52ef2a6a75        none                null                local

#DNS de google
 ping 8.8.8.8


 0.0.0.0 es accesible desde cualquier interfaz de red

#busybox ya tienne los comando ping ifconfig
 docker run -d --net none busybox sleep 2000
 docker exec -it 054 sh

/ # ping 8.8.8.8
PING 8.8.8.8 (8.8.8.8): 56 data bytes
ping: sendto: Network is unreachable
/ # ifconfig
lo        Link encap:Local Loopback  
          inet addr:127.0.0.1  Mask:255.0.0.0
          UP LOOPBACK RUNNING  MTU:65536  Metric:1
          RX packets:0 errors:0 dropped:0 overruns:0 frame:0
          TX packets:0 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000 
          RX bytes:0 (0.0 B)  TX bytes:0 (0.0 B)
/ # ping 127.0.0.1
PING 127.0.0.1 (127.0.0.1): 56 data bytes
64 bytes from 127.0.0.1: seq=0 ttl=64 time=0.043 ms


#por defecto se crea en bridge
docker network inspect bridge
docker network create mired
docker run -d --name box01 busybox sleep 2000

pedropecho288@kubernetes2020:~$ docker exec -it box01 sh
/ # ping 8.8.8.8
PING 8.8.8.8 (8.8.8.8): 56 data bytes
64 bytes from 8.8.8.8: seq=0 ttl=114 time=1.037 ms

docker run -d --name box02 busybox

docker container inspect box02 sleep 02

#red Host no tiene IP dentor del contenedor por lo cual el hots no podria llegar a contenedor pero si este a los demas
docker run -d --name box03 --net host  busybox sleep 2000

#Solo puede haber una red que use drivers del tipo host y null, pero si varios bridge

docker network create red02 --driver host
Error response from daemon: only one instance of "host" network is allowed
docker network create red02 --driver null
Error response from daemon: only one instance of "null" network is allowed
 docker network create red01
3391db77f56d384d3ffa43dd72d785af231a70981d20e2790c917fc5d6c084bb
docker network ls
NETWORK ID          NAME                DRIVER              SCOPE
da9d9f495064        bridge              bridge              local
7a817aa77c18        host                host                local
ce81ba7de8b6        mired               bridge              local
6b52ef2a6a75        none                null                local
3391db77f56d        red01               bridge              local

###Comando avanzados

docker ps -a --help
docker rm $(docker ps -a -q)
docker rm -f $(docker ps -a -q)
docker stop $(docker ps -a -q)
docker start $(docker ps -a -q)


docker images -a -q
docker rmi $(docker images -a -q)
docker rmi -f $(docker images -a -q)

##Varibales de entorno
env
DATABASE_PORT=3306
echo $DATABASE_PORT
export DATABASE_PORT=3306
unset DATABASE_PORT

docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=database -p 3309:3306 mysql

telnet 127.0.0.1 3309
